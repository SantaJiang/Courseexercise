package com.santa.courseexercise.setting.accountsetting;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;

import com.santa.courseexercise.R;
import com.santa.courseexercise.setting.accountsetting.accountsafety.AccountSafetyActivity;
import com.santa.courseexercise.setting.accountsetting.adress.AdressListActivity;

public class AccountSetActivity extends Activity {
    private TableRow mAdress;
    private TableRow btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_set);
        btn = (TableRow) findViewById(R.id.Account_change_btn);
        mAdress = (TableRow) findViewById(R.id.My_address);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountSetActivity.this, AccountSafetyActivity.class);
                startActivity(i);
            }
        });
        mAdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(AccountSetActivity.this, AdressListActivity.class);
                startActivity(l);
            }
        });
    }
}
