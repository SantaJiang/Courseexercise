package com.santa.courseexercise.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.santa.courseexercise.R;

import java.util.ArrayList;
import java.util.List;

public class GoodsAdapter extends BaseAdapter {
    private Context context;
    private List<Goods> lgoods = new ArrayList<>();

    public GoodsAdapter(Context c,ArrayList<Goods> ls){
        context = c;
        lgoods = ls;
    }

    @Override
    public int getCount(){
        return lgoods.size();
    }
    @Override
    public Object getItem(int i){
        return lgoods.get(i);
    }
    @Override
    public long getItemId(int i){
        return lgoods.get(i).getId();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        if (null == view){
            view = LayoutInflater.from(context).inflate(R.layout.list_goods,null);
        }
        TextView TvName = (TextView) view.findViewById(R.id.TvName);
        TvName.setText(lgoods.get(i).getName());
        TextView TvNotice = (TextView) view.findViewById(R.id.TvNotice);
        TvNotice.setText(lgoods.get(i).getName());
        TextView TvPrice = (TextView) view.findViewById(R.id.TvPrice);
        TvPrice.setText(lgoods.get(i).getName());
        ImageView ListImg = (ImageView) view.findViewById(R.id.ListImg);
        ListImg.setImageResource(lgoods.get(i).getSrc());
        return view;
    }

}
