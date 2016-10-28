package com.sjtc.tcmall;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sjtc.tcmall.my.AddressListActivity;


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

        View bFav = mView.findViewById(R.id.my_bFav);
        View bHistory = mView.findViewById(R.id.my_bHistory);

        //订单列表
        View bOrder = mView.findViewById(R.id.my_bOrder);
        View bUnpay = mView.findViewById(R.id.my_bUnpay);
        View bUnshop = mView.findViewById(R.id.my_bUnshop);
        View bReceiving = mView.findViewById(R.id.my_bReceiving);
        View bOrderBack = mView.findViewById(R.id.my_bOrderBack);

        //功能列表
        View bUpgrade = mView.findViewById(R.id.my_bUpgrade);
        View bUserInfo = mView.findViewById(R.id.my_bUserInfo);
        View bSetting = mView.findViewById(R.id.my_bSetting);
        View bPassword = mView.findViewById(R.id.my_bPassword);
        View bAddress = mView.findViewById(R.id.my_bAddress);
        View bFeed = mView.findViewById(R.id.my_bFeed);
        View bTel = mView.findViewById(R.id.my_bTel);

        //点击绑定
        bFav.setOnClickListener(this);
        bHistory.setOnClickListener(this);

        bOrder.setOnClickListener(this);
        bUnpay.setOnClickListener(this);
        bUnshop.setOnClickListener(this);
        bReceiving.setOnClickListener(this);
        bOrderBack.setOnClickListener(this);

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
            case R.id.my_bFav:
                Toast.makeText(context,"我的收藏被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bHistory:
                Toast.makeText(context,"浏览记录被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bOrder:
                Toast.makeText(context,"查看全部订单被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bUnpay:
                Toast.makeText(context,"待付款被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bUnshop:
                Toast.makeText(context,"待发货被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bReceiving:
                Toast.makeText(context,"待收货被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_bOrderBack:
                Toast.makeText(context,"退换货/款被点击",Toast.LENGTH_SHORT).show();
                break;
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
                startActivity(new Intent(context, AddressListActivity.class));
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
