package com.nantian.shamc.approval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nantian.shamc.approval.dto.LoginDto;
import com.nantian.shamc.approval.utils.Constant;
import com.nantian.shamc.approval.utils.Fvalue;
import com.nantian.shamc.approval.utils.LogUtil;
import com.nantian.shamc.approval.utils.OKHttpUtils;
import com.nantian.shamc.approval.utils.ToolsUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn;
    private String username;
    private String password;
    private EditText usernameET;
    private EditText passwordET;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.usernameET = ((EditText) findViewById(R.id.username));
        this.passwordET = ((EditText) findViewById(R.id.password));
    }

    public void onClickBtn(View v) {
        this.username = this.usernameET.getText().toString();
        this.password = this.passwordET.getText().toString();
        Log.d("OK", "username=" + this.username + " password=" + this.password);
        if ((this.username.trim().isEmpty()) || (this.password.trim().isEmpty())) {
            Toast.makeText(this, "用户名或者密码为空", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean isConnect = ToolsUtils.isConnect(this);
        if (isConnect) {
            String url = this.getString(R.string.shamc_url);
            //组装登录报文
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constant.F, Fvalue.LOGIN_TO_HOME);
            map.put(Constant.FOO, Constant.FOO_A);
            map.put(Constant.USER_NAME, username);
            map.put(Constant.PASSWORD, password);
            //发送报文验证登录信息
            OKHttpUtils.doPostAsyn("LOGIN_BACK_MESSAGE",url, map, new okhttp3.Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Toast.makeText(MainActivity.this, "登录连接失败", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String respMessage = response.body().string();
                            LogUtil.e("LOGIN_BACK_MESSAGE", "respMessage=" + respMessage);
                            LoginDto loginDto = new Gson().fromJson(respMessage, LoginDto.class);
                            if ("SUCCESS".equals(loginDto.getStatus())) {
//                              判断是否真正的登录成功
                                Intent intent = new Intent(MainActivity.this, MainFrameActivity.class);
                                intent.putExtra(Constant.USER_NAME, username);
//                              intent.putExtra("password", password);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
            );

        }
    }
}
