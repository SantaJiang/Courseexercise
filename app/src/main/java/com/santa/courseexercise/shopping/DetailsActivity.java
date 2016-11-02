package com.santa.courseexercise.shopping;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.santa.courseexercise.R;

import java.io.InputStream;

public class DetailsActivity extends Activity {
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private ImageView img7;


    private void FindView() {
        img1 = (ImageView) findViewById(R.id.introduction1);
        img2 = (ImageView) findViewById(R.id.introduction2);
        img3 = (ImageView) findViewById(R.id.introduction3);
        img4 = (ImageView) findViewById(R.id.introduction4);
        img5 = (ImageView) findViewById(R.id.introduction5);
        img6 = (ImageView) findViewById(R.id.introduction6);
        img7 = (ImageView) findViewById(R.id.introduction7);

    }

    private void LoadIntroduction() {
        img1.setImageBitmap(readBitMap(this, R.drawable.introduction1));
        img2.setImageBitmap(readBitMap(this, R.drawable.introduction2));
        img3.setImageBitmap(readBitMap(this, R.drawable.introduction3));
        img4.setImageBitmap(readBitMap(this, R.drawable.introduction4));
        img5.setImageBitmap(readBitMap(this, R.drawable.introduction5));
        img6.setImageBitmap(readBitMap(this, R.drawable.introduction6));
        img7.setImageBitmap(readBitMap(this, R.drawable.introduction7));
    }

    //为了解决加载大量图片OOM问题
    public Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        //获取图片资源
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        FindView();
        LoadIntroduction();

    }
}
