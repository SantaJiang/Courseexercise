package com.santa.courseexercise.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.santa.courseexercise.orders.OrdersActivity;
import com.santa.courseexercise.R;
import com.santa.courseexercise.setting.SettingActivity;

public class MeFragment extends Fragment {
    private TableLayout tl;
    private TableLayout set;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_me, container, false);
        tl = (TableLayout) v.findViewById(R.id.Orders_banner);
        set = (TableLayout) v.findViewById(R.id.Setting);
        tl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrdersActivity.class);
                startActivity(intent);
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent2);
            }
        });
        return v;
    }
}