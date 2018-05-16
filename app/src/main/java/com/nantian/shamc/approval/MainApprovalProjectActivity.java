package com.nantian.shamc.approval;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by huang on 2018/5/10.
 */

public class MainApprovalProjectActivity extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_approval_main);
        Intent intent = getIntent();
        String busiflowno =  intent.getStringExtra("busiflowno");
        String flowno =  intent.getStringExtra("flowno");

        Toast.makeText(MainApprovalProjectActivity.this,"busiflowno="+busiflowno+"  flowno="+flowno,Toast.LENGTH_SHORT).show();
    }
}
