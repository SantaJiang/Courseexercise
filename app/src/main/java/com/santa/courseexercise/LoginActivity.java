package com.santa.courseexercise;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    private EditText Uname;
    private EditText Upwd;
    private Button Login;
    private CheckBox Rme;
    private ProgressDialog pd;
    private int count;
    //初始化String，不然会报空指针异常
    String strName = "";
    String strPwd = "";

    View.OnClickListener mylistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Login:
                    strName = Uname.getText().toString();  //toString,forced into a string
                    strPwd = Upwd.getText().toString();
                    if (strName.length() > 8) {
                        Toast.makeText(LoginActivity.this, R.string.user_too_long, Toast.LENGTH_SHORT).show();
                    } else {
                        if ("123".equals(strPwd)) {
                            //ProgressDialog进度对话框
                            LoginActivity.this.ProgressDialog();
                            LoginActivity.this.RememberTheLoginMessage();
                        } else {
                            Toast.makeText(LoginActivity.this, R.string.login_fail, Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
            }
        }
    };

    private void RememberTheLoginMessage() {
        //记住用户名和密码
        if (Rme.isChecked()) {
            SharedPreferences preferences = getSharedPreferences("MYAPP", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("NAME", strName);
            editor.commit();
        }
    }

    private void PageSwitch() {
        //结束LoginActivity
        LoginActivity.this.finish();
        //Activity的跳转
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        i.putExtra("NAME", strName);  //跳转页面的同时传递数据，通过key来识别，后边传递values
        startActivity(i);

        Toast.makeText(LoginActivity.this, R.string.login_success, Toast.LENGTH_SHORT).show();
    }

    private void ProgressDialog() {
        // 创建ProgressDialog对象
        pd = new ProgressDialog(LoginActivity.this);
        // 设置进度条风格，风格为圆形，旋转的
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // 设置ProgressDialog 标题
        //pd.setTitle("提示");
        /* 设置ProgressDialog显示的内容
         * setmessage()这个方法的参数是charesequence msg,但是有时候希望使用定义在string里的字符串
         * 但是setmessage()这个方法无法直接以资源ID作为参数
         * 所以用到了this.getString()方法，该方法参数为int
         */
        pd.setMessage(this.getString(R.string.progressdialog_logging));
        //设置ProgressDialog的进度条是否显示进度
        pd.setIndeterminate(false);
        // 设置ProgressDialog 是否可以按退回键取消
        pd.setCancelable(true);
        // 设置ProgressDialog进度条进度
        pd.setProgress(100);
        // 让ProgressDialog显示
        pd.show();
        //线程部分
        count = 0;
        new Thread() {
            public void run() {
                try {
                    while (count <= 100) {
                        // 由线程来控制进度
                        pd.setProgress(count++);
                        Thread.sleep(5);
                    }
                    pd.cancel();
                    LoginActivity.this.PageSwitch();
                } catch (Exception e) {
                    pd.cancel();
                }
            }
        }.start();
    }

    private void findView() {
        Uname = (EditText) findViewById(R.id.Uname);
        Rme = (CheckBox) findViewById(R.id.Rme_the_name);
        Upwd = (EditText) findViewById(R.id.Upwd);
        Login = (Button) findViewById(R.id.Login);
    }

    private void setListener() {
        Login.setOnClickListener(mylistener);
    }

    private void setData() {
        SharedPreferences preferences = getSharedPreferences("MYAPP", Context.MODE_PRIVATE);
        String name = preferences.getString("NAME", null);
        Uname.setText(name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        setData();
        setListener();
    }
}
