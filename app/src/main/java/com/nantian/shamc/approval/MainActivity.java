package com.nantian.shamc.approval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.nantian.shamc.approval.utils.ToolsUtils;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//import java.io.IOException;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.StatusLine;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;

public class MainActivity    extends AppCompatActivity
{
    private Button loginBtn;
    private String username;
    private String password;
    private EditText usernameET;
    private EditText passwordET;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.usernameET = ((EditText)findViewById(R.id.username));
        this.passwordET = ((EditText)findViewById(R.id.password));
    }

    public void onClickBtn(View v)
    {
        this.username = this.usernameET.getText().toString();
        this.password = this.passwordET.getText().toString();
        Log.d("OK", "username=" + this.username + " password= " + this.password);
        if ((this.username.trim().isEmpty()) || (this.password.trim().isEmpty()))
        {
            Toast.makeText(this, "用户名或者密码为空", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean isConnect = ToolsUtils.isConnect(this);
        if (isConnect)
        {
//            String url = this.getString(R.string.shamc_url) + "&f=loginToHome&username=" + this.username + "&password=" + this.password ;
//            HttpClient httpCient = new DefaultHttpClient();
//            HttpGet httpGet = new HttpGet(url);
//            try
//            {
//                HttpResponse httpResponse = httpCient.execute(httpGet);
//                if (httpResponse.getStatusLine().getStatusCode() == 200)
//                {
//                    HttpEntity entity = httpResponse.getEntity();
//                    String response = EntityUtils.toString(entity, "utf-8");
//
//                    Log.d("登录报文", response.toString());
//                }
//                else
//                {
//                    Toast.makeText(this, "服务器连接失败，请稍后再试", 0).show();
//                }
//            }
//            catch (IOException e)
//            {
//                Log.d("登录异常", "服务器登录出现异常" + e);
//                Toast.makeText(this, "服务器连接失败，请稍后再试", 0).show();
//            }
            Intent intent = new Intent(this, MainFrameActivity.class);
            intent.putExtra("username", this.username);
            intent.putExtra("password", this.password);
            startActivity(intent);
        }
    }
}
