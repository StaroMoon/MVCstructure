package com.acd21.staromoon.mvcstructure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acd21.staromoon.mvcstructure.R;

import org.w3c.dom.Text;

public class MainFragment extends Fragment{

    int someVar;
    TextView tvName;
    public static MainFragment newInstance(int someVar){        //สร้างargumentขึ้นมาเก็บค่าใช้แค่ตอนค่าเริ่มต้น bundle ใช้ตอนทำงานไปแล้ว แต่ทั้งคู่เหมือนและใช้แทนกันได้
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("someVar", someVar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {       //ใช้เพื่อ get ค่า
        super.onCreate(savedInstanceState);
        someVar = getArguments().getInt("someVar");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstaces(rootView);
        return rootView;    //มี view หลังจาก return แล้ว
    }

    private void initInstaces(View rootView) {
        tvName = (TextView) rootView.findViewById(R.id.tvName);
    }

    public void setNameText(String text){
        tvName.setText(text);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {        //รอบแรกจะเป็น null ต้องระวัง
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            // Restore Instance State Here
        }
    }
}
