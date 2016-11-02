package com.santa.courseexercise.setting.accountsetting.adress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.santa.courseexercise.R;

public class AdressListActivity extends Activity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adresslist);
        btn = (Button) findViewById(R.id.Add_adress_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdressListActivity.this,AddAdressActivity.class);
                startActivity(i);
            }
        });
    }
}
