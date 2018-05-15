package com.nantian.shamc.approval.utils;

import android.content.Context;
import android.util.Log;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by huang on 2018/5/12.
 */

public class OKHttpUtils {

    public static String url_app = "http://demo.ntclouds.cn/SHAMC/a";


    public static OkHttpClient okHttpClient ;

    public static void doGet(final String url, Callback callback) {
        Request request = new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(callback);
    }


    public static void doPostAsyn(String tag, final String url, final Map<String, Object> map, Context context,Callback callback) {

        okHttpClient = new OkHttpClient.Builder().cookieJar(new PersistentCookieJar(new SetCookieCache(),new SharedPrefsCookiePersistor(context))).build();

        //FormBody formBody =  new FormBody.Builder().add("password","123456").add("username","zhaoji").add("f","loginToHome").add("foo","a").build();
        String json = new Gson().toJson(map);
        Log.d(tag, "请求报文为：" + json);
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public static String doPost(String tag, String url, String jsonMessage) {

        //FormBody formBody =  new FormBody.Builder().add("password","123456").add("username","zhaoji").add("f","loginToHome").add("foo","a").build();
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), jsonMessage);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            Response respose = okHttpClient.newCall(request).execute();
            if (respose.isSuccessful()) {
                return respose.body().string();
            } else {
                Log.d("MESSAGE", "Post请求发送失败,请求数据为" + jsonMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
