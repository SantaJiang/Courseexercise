package com.santa.courseexercise;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.santa.courseexercise.fragment.HomeFragment;
import com.santa.courseexercise.fragment.MeFragment;
import com.santa.courseexercise.fragment.ShoppingFragment;

public class MainActivity extends Activity {

    private LinearLayout ll;
    private RelativeLayout tab1;
    private RelativeLayout tab2;
    private RelativeLayout tab3;
    //声明Fragment属性
    private HomeFragment mHome;
    private ShoppingFragment mShopping;
    private MeFragment mMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.获取界面的控件
        getViews();
        //2.注册事件监听器
        setListener();
        //3.设置默认页面
        setDefaultPage();
    }

    private void getViews(){
        ll = (LinearLayout)findViewById(R.id.ll);
        tab1 = (RelativeLayout) findViewById(R.id.Tab1);
        tab2 = (RelativeLayout) findViewById(R.id.Tab2);
        tab3 = (RelativeLayout) findViewById(R.id.Tab3);
    }
    private void setListener(){
        MyListener listener = new MyListener();
        tab1.setOnClickListener(new MyListener());
        tab2.setOnClickListener(new MyListener());
        tab3.setOnClickListener(new MyListener());

    }

    //设置默认界面
    private void setDefaultPage(){
        //1.获取一个FragmentManager的对象
        android.app.FragmentManager fm= getFragmentManager();
        //2.获取FragementTransaction对象
        android.app.FragmentTransaction transaction = fm.beginTransaction();
        mHome = new HomeFragment();
        //3.设置页面
        transaction.replace(R.id.cont,mHome);
        //4.执行更改
        transaction.commit();
    }

    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            //1.获取一个FragmentManager的对象
            android.app.FragmentManager fm= getFragmentManager();
            //2.获取FragementTransaction对象
            android.app.FragmentTransaction transaction = fm.beginTransaction();
            switch (v.getId()){
                case R.id.Tab1:
                    transaction.replace(R.id.cont,mHome);
                    break;
                case R.id.Tab2:
                    if(mShopping==null){
                        mShopping = new ShoppingFragment();
                    }
                    transaction.replace(R.id.cont,mShopping);
                    break;
                case R.id.Tab3:
                    if(mMe==null){
                        mMe = new MeFragment();
                    }
                    transaction.replace(R.id.cont,mMe);
                    break;
            }
            //4.执行更改
            transaction.commit();
            ll.invalidate();
        }
    }
}
