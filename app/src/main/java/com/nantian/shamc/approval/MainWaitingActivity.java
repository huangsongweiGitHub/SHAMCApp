package com.nantian.shamc.approval;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting_main);

        contentWaiting = ((ListView)findViewById(R.id.content_waiting));

        String[] from = { "title", "time", "sponsor", "newpic" };
        int[] to = { R.id.title_message, R.id.time_message, R.id.sponsor, R.id.new_pic };
        getData();
        listMessageSimpleAdapter = new SimpleAdapter(this, this.data, R.layout.frame_main_listview_item, from, to);
        contentWaiting.setAdapter(this.listMessageSimpleAdapter);




        waitingWorkBtn = ((Button)findViewById(R.id.waiting_work));
        waitingMeetingBtn = ((Button)findViewById(R.id.waiting_meeting));

        waitingWorkBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                MainWaitingActivity.this.waitingWorkBtn.setBackgroundResource(R.drawable.button_blue_underline);
                MainWaitingActivity.this.waitingMeetingBtn.setBackgroundResource(R.drawable.button_no_blue_underline);
            }
        });
        waitingMeetingBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                MainWaitingActivity.this.waitingWorkBtn.setBackgroundResource(R.drawable.button_no_blue_underline);
                MainWaitingActivity.this.waitingMeetingBtn.setBackgroundResource(R.drawable.button_blue_underline);
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
