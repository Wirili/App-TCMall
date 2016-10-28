package com.sjtc.tcmall.my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.sjtc.tcmall.R;

public class AddressListActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView lvAddressList;
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
