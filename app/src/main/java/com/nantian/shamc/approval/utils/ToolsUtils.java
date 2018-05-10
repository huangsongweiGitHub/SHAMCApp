package com.nantian.shamc.approval.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by huang on 2018/5/10.
 */


public class ToolsUtils
{
    public static boolean isConnect(AppCompatActivity activity)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo.State grpsState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        NetworkInfo.State wifiState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        if ((!NetworkInfo.State.CONNECTED.equals(grpsState)) && (!NetworkInfo.State.CONNECTED.equals(wifiState)))
        {
            Log.d("OK", "网络已经断开");
            Toast.makeText(activity, "请连接网络", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

