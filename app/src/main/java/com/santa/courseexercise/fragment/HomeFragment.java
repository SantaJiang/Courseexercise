package com.santa.courseexercise.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.santa.courseexercise.R;
import com.santa.courseexercise.listview.Goods;
import com.santa.courseexercise.listview.GoodsAdapter;
import com.santa.courseexercise.listview.ListViewForScrollView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    //ListView
    private ArrayList<Goods> ls = new ArrayList<Goods>();
    private ListViewForScrollView lv;
    private GoodsAdapter mAdapter;
    private ArrayAdapter<String> adapter;
    //解决ListViewForScrollView而进行的操作
    private ScrollView sv;

    private void getData(){
        ls.add(new Goods((long) 1,"商品名称","商品参数","价格",R.drawable.product_default_1));
        ls.add(new Goods((long) 1,"商品名称","商品参数","价格",R.drawable.product_default_1));
        ls.add(new Goods((long) 1,"商品名称","商品参数","价格",R.drawable.product_default_1));
        ls.add(new Goods((long) 1,"商品名称","商品参数","价格",R.drawable.product_default_1));
        ls.add(new Goods((long) 1,"商品名称","商品参数","价格",R.drawable.product_default_1));
        ls.add(new Goods((long) 1,"商品名称","商品参数","价格",R.drawable.product_default_1));
        ls.add(new Goods((long) 1,"商品名称","商品参数","价格",R.drawable.product_default_1));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_home, null);

        getData();

        mAdapter = new GoodsAdapter(getContext(),ls);

        //解决ListViewForScrollView而进行的操作
        sv = (ScrollView) v.findViewById(R.id.Sv);
        sv.smoothScrollTo(0, 0);

        lv = (ListViewForScrollView) v.findViewById(R.id.Lv);
        lv.setAdapter(mAdapter);
        return v;
    }
}