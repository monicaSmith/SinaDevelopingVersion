package com.example.monica.sinatest;

/**
 * Created by monica on 8/24/16.
 */

import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

public class TabhostActivity extends ActivityGroup{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AccessTokenKeeper.init(this);//init sharedPreference

        setContentView(R.layout.tabhost_activity);
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup(getLocalActivityManager());
        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        //spec.setContent(R.id.tab1);
        spec.setIndicator("首页");
        LayoutInflater.from(this).inflate(R.layout.test,null);
        if(AccessTokenKeeper.getKeyAccessToken().equals("")||AccessTokenKeeper.getKeyAccessToken()=="null")
            spec.setContent(new Intent(this,MainActivity.class));
        else
            spec.setContent(new Intent(this,HomelineActivity.class));
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("消息");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("+");
        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab4);
        spec.setIndicator("发现");
        host.addTab(spec);
        //Tab 5
        spec = host.newTabSpec("Tab Three");
        spec.setContent(new Intent(this,WeiboUserInfo.class));
        spec.setIndicator("我");
        host.addTab(spec);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            toast(getApplicationContext(),"text<<help");
        }

        return super.onOptionsItemSelected(item);
    }
    public void toast(Context context, String s){
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }
}
