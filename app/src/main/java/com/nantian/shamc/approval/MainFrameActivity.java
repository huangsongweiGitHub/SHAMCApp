package com.nantian.shamc.approval;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.nantian.shamc.approval.httpcallable.MainFrameCallable;
import com.nantian.shamc.approval.utils.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * Created by huang on 2018/5/10.
 */

public class MainFrameActivity extends AppCompatActivity {
    private ListView contentView;
    private SimpleAdapter listMessageSimpleAdapter;
    private Button waitingBtn;
    private Button alreadyBtn;
    private List<Map<String, Object>> data;
    private String username  ;
    private ExecutorService threadPool = Executors.newFixedThreadPool(5);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_main);
        contentView = ((ListView) findViewById(R.id.content_view));
        Intent intent = getIntent();
        username = intent.getStringExtra(Constant.USER_NAME);
        String url = this.getString(R.string.shamc_url);


        initView(url);

        contentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainFrameActivity.this, MainApprovalProjectActivity.class);
                MainFrameActivity.this.startActivity(intent);
            }
        });
        waitingBtn = ((Button) findViewById(R.id.waiting));
        waitingBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainFrameActivity.this, MainWaitingActivity.class);
                intent.putExtra(Constant.USER_NAME, username);
                MainFrameActivity.this.startActivity(intent);
            }
        });
        alreadyBtn = ((Button) findViewById(R.id.already));
        alreadyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainFrameActivity.this, MainAlreadyActivity.class);
                MainFrameActivity.this.startActivity(intent);
            }
        });
    }


    void initView(String url){
        data = new ArrayList<Map<String, Object>>();
        Future<List<Map<String, Object>>> agencyMeeting = threadPool.submit(new MainFrameCallable(Constant.MAIN_FRAME_CALLABLE_QUERYAGENCYWORK, username, url));
        Future<List<Map<String, Object>>> agencyWork = threadPool.submit(new MainFrameCallable(Constant.MAIN_FRAME_CALLABLE_QUERYALLAGENCYWORK, username, url));
        List<Map<String, Object>> meetingMap = null;
        List<Map<String, Object>> workList = null;
        try {
            meetingMap = agencyMeeting.get();
            workList = agencyWork.get();
            data.addAll(meetingMap);
            data.addAll(workList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String[] from = {"title", "time", "sponsor", "newpic"};
        int[] to = {R.id.title_message, R.id.time_message, R.id.sponsor, R.id.new_pic};
        listMessageSimpleAdapter = new SimpleAdapter(this, data, R.layout.frame_main_listview_item, from, to);
        contentView.setAdapter(listMessageSimpleAdapter);
    }
}