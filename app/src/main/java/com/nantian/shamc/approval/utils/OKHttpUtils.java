package com.nantian.shamc.approval.utils;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by huang on 2018/5/12.
 */

public class OKHttpUtils {

    private static OkHttpClient okHttpClient = new OkHttpClient();

    public static void doGet(final String url, Callback callback) {
        Request request = new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(callback);
    }


    public static void doPost(final String url, final Map<String, Object> map, Callback callback) {
        //FormBody formBody =  new FormBody.Builder().add("password","123456").add("username","zhaoji").add("f","loginToHome").add("foo","a").build();
        String json = new Gson().toJson(map);
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

//  调用get实例
//    OKHttpUtils.doGet(url2, new Callback() {
//        @Override
//        public void onFailure(Call call, IOException e) {
//
//        }
//        @Override
//        public void onResponse(Call call, Response response) throws IOException {
//
//            String respMessage = response.body().string();
//            Log.d("LOGIN_BACK_MESSAGE", "respMessage=" + respMessage);
//
//        }
//    });

}
