package com.example.in_appbehaviorreport;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@SuppressLint("ValidFragment")
class MainFragment extends Fragment implements View.OnClickListener {
    private View view;
    //for get names
    private String pageName;
    private String btn1Name;
    private String btn2Name;
    private String btn3Name;

    private TextView textView1;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private int stat = 1;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ListView listView;
    private ArrayAdapter<String>  valuesFromArrToLV;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        getNames();

        return view;
    }

    private void getNames() {
        pageName = getClass().getSimpleName();
        btn1Name = btn1.getText().toString();
        btn2Name = btn2.getText().toString();
        btn3Name = btn3.getText().toString();
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

        listView = view.findViewById(R.id.lv_main_fragment);

    }

    private int countClickInt(int click) {
        return stat = click + 1;
    }


    private String countClickInfo(int NP, String PN, String BN, Date TD) {
        countClickInt(stat);
        String res = "N - " + NP + " PN - " + PN + " BN - " + BN + " TD - " + TD;
        arrayList.add(res);
        Log.d("clickInfo", res);
        valuesFromArrToLV=new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(valuesFromArrToLV);
        return res;
    }

    private Date getCurrentTime() {
        Date currentTime = Calendar.getInstance().getTime();
        return currentTime;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_n1_main_fragment:
                //   countClick(stat,);
                textView1.setText(countClickInfo(stat, pageName, btn1Name, getCurrentTime()));
                break;
            case R.id.btn_n2_main_fragment:
                textView1.setText(countClickInfo(stat, pageName, btn2Name, getCurrentTime()));
                /* SecondFragment secondFragment = new SecondFragment();
                FragmentManager fragmentManager2 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.flMainActivity, secondFragment, "clickThirdBtn");
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
                */
                break;
            case R.id.btn_n3_main_fragment:
                textView1.setText(countClickInfo(stat, pageName, btn3Name, getCurrentTime()));
                /* ThirdFragment thirdFragment = new ThirdFragment();
                FragmentManager fragmentManager3 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                fragmentTransaction3.replace(R.id.flMainActivity, thirdFragment, "clickThirdBtn");
                fragmentTransaction3.addToBackStack(null);
                fragmentTransaction3.commit();
                */
                break;
        }
    }
}