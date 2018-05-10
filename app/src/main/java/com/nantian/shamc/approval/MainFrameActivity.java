package com.nantian.shamc.approval;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
        this.contentView = ((ListView)findViewById(R.id.content_view));
        getData();
        String[] from = { "title", "time", "sponsor", "newpic" };
        int[] to = { R.id.title_message, R.id.time_message, R.id.sponsor, R.id.new_pic };
        this.listMessageSimpleAdapter = new SimpleAdapter(this, this.data, R.layout.frame_main_listview_item, from, to);
        this.contentView.setAdapter(this.listMessageSimpleAdapter);


        this.contentView.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
