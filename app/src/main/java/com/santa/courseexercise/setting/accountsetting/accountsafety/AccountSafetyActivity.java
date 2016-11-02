package com.santa.courseexercise.setting.accountsetting.accountsafety;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.santa.courseexercise.R;
import com.santa.courseexercise.setting.accountsetting.AccountSetActivity;

public class AccountSafetyActivity extends Activity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_safety);
        btn = (Button) findViewById(R.id.Account_change_passwd_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountSafetyActivity.this,PasswdManagerActivity.class);
                startActivity(i);
            }
        });
    }
}
