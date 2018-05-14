package com.nantian.shamc.approval;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.nantian.shamc.approval.utils.Constant;
import com.nantian.shamc.approval.utils.Fvalue;
import com.nantian.shamc.approval.utils.OKHttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by huang on 2018/5/10.
 */

public class MainFrameActivity extends AppCompatActivity
{
    private ListView contentView;
    private SimpleAdapter listMessageSimpleAdapter;
    private Button waitingBtn;
    private Button alreadyBtn;
    private List<Map<String, Object>> data;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_main);
        contentView = ((ListView)findViewById(R.id.content_view));
        Intent intent=getIntent();
        String username=intent.getStringExtra(Constant.USER_NAME);
        initView(username);



        contentView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainFrameActivity.this, MainApprovalProjectActivity.class);
                MainFrameActivity.this.startActivity(intent);
            }
        });
        this.waitingBtn = ((Button)findViewById(R.id.waiting));
        this.waitingBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainFrameActivity.this, MainWaitingActivity.class);
                MainFrameActivity.this.startActivity(intent);
            }
        });
        this.alreadyBtn = ((Button)findViewById(R.id.already));
        this.alreadyBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainFrameActivity.this, MainAlreadyActivity.class);
                MainFrameActivity.this.startActivity(intent);
            }
        });
    }
    //调用两个接口
     public void initView(String username){
         String url = this.getString(R.string.shamc_url);

         //调用接口实现查询代办会议
         Map<String,Object> map = new HashMap<String,Object>();
         map.put(Constant.F, Fvalue.QUERY_AGENCY_WORK);
         map.put(Constant.FOO,Constant.FOO_A);
         map.put(Constant.APPLICANT,username);
         
         OKHttpUtils.doPost(url,map, new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {
                 Log.d(Fvalue.QUERY_AGENCY_WORK,"获取待办会议失败");
             }
             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 String returnMessage = response.body().string();
                 Log.d(Fvalue.QUERY_AGENCY_WORK,"待办会议返回数据:"+returnMessage);
             }
         });

         //调用接口实现查询代办工作
         map.put(Constant.F, Fvalue.QUERY_ALL_AGENCY_WORK);
         map.put(Constant.FOO,Constant.FOO_A);
         map.put(Constant.APPLICANT,username);
         OKHttpUtils.doPost(url,map, new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {
                 Log.d(Fvalue.QUERY_ALL_AGENCY_WORK,"获取待办工作失败");
             }
             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 String returnMessage = response.body().string();
                 Log.d(Fvalue.QUERY_ALL_AGENCY_WORK,"待办工作返回数据:"+returnMessage);
             }
         });
//        为listView 填充数据
         String[] from = { "title", "time", "sponsor", "newpic" };
         int[] to = { R.id.title_message, R.id.time_message, R.id.sponsor, R.id.new_pic };
         this.listMessageSimpleAdapter = new SimpleAdapter(this, this.data, R.layout.frame_main_listview_item, from, to);
         this.contentView.setAdapter(this.listMessageSimpleAdapter);
    }

    public void getData()
    {
        this.data = new ArrayList();
        for (int i = 0; i < 40; i++)
        {
            Map<String, Object> map = new HashMap();
            map.put("title", "titlemessage" + i);
            map.put("time", "2018-01-03 14:23:26");
            map.put("sponsor", "黄松伟");
            if (i < 3) {
                map.put("newpic", R.drawable.newpic);
            }
            this.data.add(map);
        }
    }
}
