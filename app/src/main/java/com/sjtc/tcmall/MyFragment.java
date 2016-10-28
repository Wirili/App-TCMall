package com.sjtc.tcmall;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment implements View.OnClickListener{

    private Context context;
    private View mView;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_my, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context=getContext();
        initView();
    }

    private void initView(){
        View bUpgrade = mView.findViewById(R.id.my_bUpgrade);
        View bUserInfo = mView.findViewById(R.id.my_bUserInfo);
        View bSetting = mView.findViewById(R.id.my_bSetting);
        View bPassword = mView.findViewById(R.id.my_bPassword);
        View bAddress = mView.findViewById(R.id.my_bAddress);
        View bFeed = mView.findViewById(R.id.my_bFeed);
        View bTel = mView.findViewById(R.id.my_bTel);
        bUpgrade.setOnClickListener(this);
        bUserInfo.setOnClickListener(this);
        bSetting.setOnClickListener(this);
        bPassword.setOnClickListener(this);
        bAddress.setOnClickListener(this);
        bFeed.setOnClickListener(this);
        bTel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_bUpgrade:
                Toast.makeText(context,"职业晋级赛被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bUserInfo:
                Toast.makeText(context,"个人资料被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bSetting:
                Toast.makeText(context,"功能设置被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bPassword:
                Toast.makeText(context,"修改密码被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bAddress:
                Toast.makeText(context,"收货地址被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bFeed:
                Toast.makeText(context,"意见反馈被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bTel:
                Toast.makeText(context,"服务热线被点击",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
