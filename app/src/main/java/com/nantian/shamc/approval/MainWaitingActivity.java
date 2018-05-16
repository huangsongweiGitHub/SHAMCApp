package com.nantian.shamc.approval;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.nantian.shamc.approval.httpcallable.MainFrameCallable;
import com.nantian.shamc.approval.utils.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by huang on 2018/5/10.
 */

public class MainWaitingActivity extends AppCompatActivity
{
    private Button waitingWorkBtn;
    private Button waitingMeetingBtn;
    private ImageView wainting_back_view;
    private ListView contentWaiting;
    private SimpleAdapter listMessageSimpleAdapter;
    private List<Map<String, Object>> data;
    private ExecutorService threadPool = Executors.newFixedThreadPool(5);
    private String url;
    private String username ;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting_main);
        contentWaiting = ((ListView)findViewById(R.id.content_waiting));
        url = this.getString(R.string.shamc_url);
        Intent intent = getIntent();
        username = intent.getStringExtra(Constant.USER_NAME);
        agencyWorkFun(url);

        waitingWorkBtn = ((Button)findViewById(R.id.waiting_work));
        waitingMeetingBtn = ((Button)findViewById(R.id.waiting_meeting));
        waitingWorkBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                MainWaitingActivity.this.waitingWorkBtn.setBackgroundResource(R.drawable.button_blue_underline);
                MainWaitingActivity.this.waitingMeetingBtn.setBackgroundResource(R.drawable.button_no_blue_underline);
                agencyWorkFun(url);
            }
        });
        waitingMeetingBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                MainWaitingActivity.this.waitingWorkBtn.setBackgroundResource(R.drawable.button_no_blue_underline);
                MainWaitingActivity.this.waitingMeetingBtn.setBackgroundResource(R.drawable.button_blue_underline);
                agencyMeetingFun(url);
            }
        });
        wainting_back_view = ((ImageView)findViewById(R.id.wainting_back_view));
        wainting_back_view.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                MainWaitingActivity.this.finish();
            }
        });
    }
    void agencyMeetingFun(String url){
        data = new ArrayList<Map<String, Object>>();
        Future<List<Map<String, Object>>> agencyMeeting = threadPool.submit(new MainFrameCallable(Constant.MAIN_FRAME_CALLABLE_QUERYAGENCYWORK, username, url));
        List<Map<String, Object>> meetingMap = null;
        try {
            meetingMap = agencyMeeting.get();
            data.addAll(meetingMap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String[] from = {"busiflowno","flowno","flowtype","title", "time", "sponsor", "newpic"};
        int[] to = {R.id.busiflowno,R.id.flowno,R.id.flowtype,R.id.title_message, R.id.time_message, R.id.sponsor, R.id.new_pic};
        listMessageSimpleAdapter = new SimpleAdapter(this, data, R.layout.frame_main_listview_item, from, to);
        contentWaiting.setAdapter(listMessageSimpleAdapter);
    }
    void agencyWorkFun(String url){
        data = new ArrayList<Map<String, Object>>();
        Future<List<Map<String, Object>>> agencyWork = threadPool.submit(new MainFrameCallable(Constant.MAIN_FRAME_CALLABLE_QUERYALLAGENCYWORK, username, url));
        List<Map<String, Object>> workList = null;
        try {
            workList = agencyWork.get();
            data.addAll(workList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String[] from = {"busiflowno","flowno","flowtype","title", "time", "sponsor", "newpic"};
        int[] to = {R.id.busiflowno,R.id.flowno,R.id.flowtype,R.id.title_message, R.id.time_message, R.id.sponsor, R.id.new_pic};
        listMessageSimpleAdapter = new SimpleAdapter(this, data, R.layout.frame_main_listview_item, from, to);
        contentWaiting.setAdapter(listMessageSimpleAdapter);
    }

}
