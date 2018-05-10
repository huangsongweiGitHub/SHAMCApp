package com.nantian.shamc.approval;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by huang on 2018/5/10.
 */

public class MainAlreadyActivity extends AppCompatActivity
{
    private Button alreadyWorkBtn;
    private Button alreadyMeetingBtn;
    private ListView contentAlready;
    private SimpleAdapter listMessageSimpleAdapter;
    private List<Map<String, Object>> data;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.already_main);

        this.contentAlready = ((ListView)findViewById(R.id.content_already));

        String[] from = { "title", "time", "sponsor", "newpic" };
        int[] to = { R.id.title_message, R.id.time_message, R.id.sponsor, R.id.new_pic };
        getData();
        this.listMessageSimpleAdapter = new SimpleAdapter(this, this.data, R.layout.frame_main_listview_item, from, to);
        this.contentAlready.setAdapter(this.listMessageSimpleAdapter);




        this.alreadyWorkBtn = ((Button)findViewById(R.id.already_work));
        this.alreadyMeetingBtn = ((Button)findViewById(R.id.already_meeting));

        this.alreadyWorkBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                MainAlreadyActivity.this.alreadyWorkBtn.setBackgroundResource(R.drawable.button_blue_underline);
                MainAlreadyActivity.this.alreadyMeetingBtn.setBackgroundResource(R.drawable.button_no_blue_underline);
            }
        });
        this.alreadyMeetingBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                MainAlreadyActivity.this.alreadyWorkBtn.setBackgroundResource(R.drawable.button_no_blue_underline);
                MainAlreadyActivity.this.alreadyMeetingBtn.setBackgroundResource(R.drawable.button_blue_underline);
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
