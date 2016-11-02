package com.santa.courseexercise.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;

import com.santa.courseexercise.R;
import com.santa.courseexercise.setting.about.AboutActivity;
import com.santa.courseexercise.setting.accountsetting.AccountSetActivity;

public class SettingActivity extends Activity {
    private TableRow account;
    private TableRow about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        account = (TableRow) findViewById(R.id.Account_set);
        about = (TableRow) findViewById(R.id.About);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SettingActivity.this, AccountSetActivity.class);
                startActivity(i);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(SettingActivity.this, AboutActivity.class);
                startActivity(l);
            }
        });
    }
}
