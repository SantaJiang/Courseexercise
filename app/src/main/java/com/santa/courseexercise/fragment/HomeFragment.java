package com.santa.courseexercise.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.santa.courseexercise.R;
import com.santa.courseexercise.listview.Goods;
import com.santa.courseexercise.listview.GoodsAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    //ListView
    private ArrayList<Goods> ls = new ArrayList<Goods>();
    private ListView lv;
    private GoodsAdapter mAdapter;
    private ArrayAdapter<String> adapter;

    private void getData(){
        ls.add(new Goods((long) 1,"商品名称","商品参数","价格",R.drawable.product_default_1));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_home, null);

        getData();

        mAdapter = new GoodsAdapter(getContext(),ls);
        lv = (ListView)v.findViewById(R.id.Lv);
        lv.setAdapter(mAdapter);
        return v;
    }
}