package com.sjtc.tcmall.my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sjtc.tcmall.R;

import java.util.ArrayList;
import java.util.List;

public class AddressListActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView lvAddressList;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        initView();
    }

    private void initView() {
        TextView tTitle= (TextView) findViewById(R.id.t_tTitle);
        tTitle.setText("收货地址");
        lvAddressList= (ListView) findViewById(R.id.lv_AddressList);
        lvAddressList.setEmptyView(findViewById(R.id.t_lvAddressListEmpty));
        View bLeft = findViewById(R.id.t_bLeft);
        list=new ArrayList<String>();
        for (int i=1;i<=20;i++){
            list.add("item "+i);
        }
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.address_list_item, list);
        lvAddressList.setAdapter(adapter);
        bLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.t_bLeft:
                this.finish();
                break;
        }
    }
}
