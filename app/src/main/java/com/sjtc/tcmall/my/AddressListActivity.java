package com.sjtc.tcmall.my;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.sjtc.tcmall.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.Inflater;

public class AddressListActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView lvAddressList;
    private List<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        initView();
    }

    private void initView() {
        TextView tTitle = (TextView) findViewById(R.id.t_tTitle);
        tTitle.setText("收货地址");
        lvAddressList = (ListView) findViewById(R.id.lv_AddressList);
        lvAddressList.setEmptyView(findViewById(R.id.t_lvAddressListEmpty));
        View bLeft = findViewById(R.id.t_bLeft);
        list = new ArrayList<Map<String, Object>>();
        for (int i = 1; i <= 20; i++) {
            Map m = new HashMap();
            m.put("address", "address" + i);
            m.put("tel", "tel" + i);
            m.put("name", "name" + i);
            m.put("checked", false);
            list.add(m);
        }
        MyAdapter adapter = new MyAdapter();
//        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.address_list_item, new String[]{"address", "tel", "name"},
//                new int[]{R.id.t_addressList_address, R.id.t_addressList_tel, R.id.t_addressList_truename});
        lvAddressList.setAdapter(adapter);
        bLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.t_bLeft:
                this.finish();
                break;
        }
    }

    class MyAdapter extends BaseAdapter {
        class ViewHolder{
            TextView tAddress;
            TextView tTel;
            TextView tUser;
            CheckBox cbDefault;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if(convertView==null) {
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.address_list_item, null);
                holder = new ViewHolder();
                holder.tAddress = (TextView) convertView.findViewById(R.id.t_addressList_address);
                holder.tTel = (TextView) convertView.findViewById(R.id.t_addressList_tel);
                holder.tUser = (TextView) convertView.findViewById(R.id.t_addressList_truename);
                holder.cbDefault = (CheckBox) convertView.findViewById(R.id.cb_addressList_default);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }

            holder.tAddress.setText((String) list.get(position).get("address"));
            holder.tTel.setText((String) list.get(position).get("tel"));
            holder.tAddress.setText((String) list.get(position).get("address"));
            holder.tUser.setText((String) list.get(position).get("name"));
            holder.cbDefault.setChecked((Boolean) list.get(position).get("checked"));
            holder.cbDefault.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.get(position).put("checked",!(Boolean) list.get(position).get("checked"));
                    MyAdapter.this.notifyDataSetChanged();
                }
            });
            return convertView;
        }
    }
}
