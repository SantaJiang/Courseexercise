package com.santa.courseexercise;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DetailsActivity extends Activity {
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private ImageView img7;


    private void FindView(){
        img1 = (ImageView) findViewById(R.id.introduction1);
        img2 = (ImageView) findViewById(R.id.introduction2);
        img3 = (ImageView) findViewById(R.id.introduction3);
        img4 = (ImageView) findViewById(R.id.introduction4);
        img5 = (ImageView) findViewById(R.id.introduction5);
        img6 = (ImageView) findViewById(R.id.introduction6);
        img7 = (ImageView) findViewById(R.id.introduction7);

    }
    private void LoadIntroduction(){
        new Thread() {
            public void run() {
                img1.setImageResource(R.drawable.introduction1);
                img2.setImageResource(R.drawable.introduction2);
                img3.setImageResource(R.drawable.introduction3);
                img4.setImageResource(R.drawable.introduction4);
                img5.setImageResource(R.drawable.introduction5);
                img6.setImageResource(R.drawable.introduction6);
                img7.setImageResource(R.drawable.introduction7);
            }
        }.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        FindView();
        LoadIntroduction();

    }
}
