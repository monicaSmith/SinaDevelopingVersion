//package com.example.monica.sinatest;
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.TabHost;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.monica.sinatest.R;
//
//public class Test extends AppCompatActivity {
//    SharedPreferences sharedPreferences;
//    String PREFERENCE_NAME="preference";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test);
//        sharedPreferences=this.getSharedPreferences(PREFERENCE_NAME,MODE_APPEND);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("time","wednesday");
//        editor.putString("name","monica");
//        editor.commit();
//
//    }
//
//}
