package com.example.in_appbehaviorreport;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

@SuppressLint("ValidFragment")
class MainFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView textView1;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private int stat = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        return view;
    }

    private void initView() {
        textView1 = (TextView) view.findViewById(R.id.tv_stat);
        btn1 = (Button) view.findViewById(R.id.btn_n1_main_fragment);
        btn2 = (Button) view.findViewById(R.id.btn_n2_main_fragment);
        btn3 = (Button) view.findViewById(R.id.btn_n3_main_fragment);

        textView1.setText("dsfsdf");
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    private int countClick(int click) {
        return stat=click+1;
    }


    private String getCurrentTime(){
        Date currentTime = Calendar.getInstance().getTime();
        return currentTime+"";
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_n1_main_fragment:
                textView1.setText("" + countClick(stat)+" Last click was at - "+getCurrentTime());
                break;
            case R.id.btn_n2_main_fragment:

                break;
            case R.id.btn_n3_main_fragment:

                break;
        }
    }
}