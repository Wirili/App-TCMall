package com.sjtc.tcmall;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private FragmentManager fMgr;
    private RadioGroup rg;
    private RadioButton rbHome;

    @Override
    public void onBackPressed() {
        if (fMgr.findFragmentByTag("fragment_home") != null
                && !fMgr.findFragmentByTag("fragment_home").isResumed()) {
            rbHome.toggle();
        } else {
            this.finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg= (RadioGroup) findViewById(R.id.main_group);
        rbHome= (RadioButton) findViewById(R.id.main_radio_home);
        rg.setOnCheckedChangeListener(this);
        fMgr = getSupportFragmentManager();
        initFragment();
    }

    private void initFragment(){
        FragmentTransaction ft = fMgr.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        ft.add(R.id.fragmentRoot,homeFragment,"fragment_home");
        ft.addToBackStack("fragment_home");
        ft.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction ft = fMgr.beginTransaction();
        switch (checkedId){
            case R.id.main_radio_home:
                if(fMgr.findFragmentByTag("fragment_home")!=null){
                    ft.replace(R.id.fragmentRoot,fMgr.findFragmentByTag("fragment_home"),"fragment_home");
                    ft.commitAllowingStateLoss();
                }else{
                    HomeFragment homeFragment = new HomeFragment();
                    ft.replace(R.id.fragmentRoot,homeFragment,"fragment_home");
                    ft.addToBackStack("fragment_home");
                    ft.commit();
                }
                break;
            case R.id.main_radio_category:
                if(fMgr.findFragmentByTag("fragment_category")!=null){
                    ft.replace(R.id.fragmentRoot,fMgr.findFragmentByTag("fragment_category"),"fragment_category");
                    ft.commitAllowingStateLoss();
                }else{
                    CategroyFragment categroyFragment = new CategroyFragment();
                    ft.replace(R.id.fragmentRoot,categroyFragment,"fragment_category");
                    ft.addToBackStack("fragment_category");
                    ft.commit();
                }
                break;
            case R.id.main_radio_cart:
                if(fMgr.findFragmentByTag("fragment_cart")!=null){
                    ft.replace(R.id.fragmentRoot,fMgr.findFragmentByTag("fragment_cart"),"fragment_cart");
                    ft.commitAllowingStateLoss();
                }else{
                    CartFragment cartFragment = new CartFragment();
                    ft.replace(R.id.fragmentRoot,cartFragment,"fragment_cart");
                    ft.addToBackStack("fragment_cart");
                    ft.commit();
                }
                break;
            case R.id.main_radio_search:
                if(fMgr.findFragmentByTag("fragment_search")!=null){
                    ft.replace(R.id.fragmentRoot,fMgr.findFragmentByTag("fragment_search"),"fragment_search");
                    ft.commitAllowingStateLoss();
                }else{
                    SearchFragment searchFragment = new SearchFragment();
                    ft.replace(R.id.fragmentRoot,searchFragment,"fragment_search");
                    ft.addToBackStack("fragment_search");
                    ft.commit();
                }
                break;
            case R.id.main_radio_my:
                if(fMgr.findFragmentByTag("fragment_my")!=null){
                    ft.replace(R.id.fragmentRoot,fMgr.findFragmentByTag("fragment_my"),"fragment_my");
                    ft.commitAllowingStateLoss();
                }else{
                    MyFragment myFragment = new MyFragment();
                    ft.replace(R.id.fragmentRoot,myFragment,"fragment_my");
                    ft.addToBackStack("fragment_my");
                    ft.commit();
                }
                break;
        }
    }
}
