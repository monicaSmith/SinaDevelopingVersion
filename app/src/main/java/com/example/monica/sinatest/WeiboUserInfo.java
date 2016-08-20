package com.example.monica.sinatest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.monica.sinatest.API.User_show;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/**
 * Created by monica on 8/10/16.
 */
public class WeiboUserInfo extends Activity{
    TextView user_description,user_sex,user_name,value_follower,value_follow,value_weibo;
    ImageView user_picture;
    public void onCreate(Bundle savedInstanceState) {
        //in case appear errro:network on main thread exception
        // url:http://stackoverflow.com/questions/22169592/android-os-networkonmainthreadexception-while-posting-data-to-url
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weibo_user_info);
        //find view
        user_picture=(ImageView)findViewById(R.id.user_picture);
        user_description = (TextView) findViewById(R.id.user_description);
        user_name = (TextView) findViewById(R.id.user_name);
        value_follow=(TextView)findViewById(R.id.value_follow);
        value_follower=(TextView)findViewById(R.id.value_follower);
        value_weibo=(TextView)findViewById(R.id.value_weibo);
        Button send_weibo,home_page;
        setUserInfo();
        home_page=(Button)findViewById(R.id.home_page);
        //set home_page
        home_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WeiboUserInfo.this,HomelineActivity.class));
            }
        });
    }
    public void setUserInfo(){
        String url="https://api.weibo.com/2/users/show.json?access_token="+AccessTokenKeeper.getKeyAccessToken()+"&uid="+AccessTokenKeeper.getKeyUid();
        try {
            Gson gson = new Gson();
            User_show userInfo=gson.fromJson(readUrl(url),User_show.class);
            user_picture.setImageBitmap(getImageBitmap(userInfo.getProfile_image_url()));
            print("user_pic"+userInfo.getProfile_image_url());
            user_name.setText(userInfo.getScreen_name());
            print("name"+userInfo.getScreen_name());
            String description="";
            if(userInfo.getDescription().equals("")){
                description="no introduction";
            }
            user_description.setText(userInfo.getDescription()+description);
            value_weibo.setText(""+userInfo.getStatuses_count());
            value_follower.setText(""+userInfo.getFollowers_count());
            value_follow.setText(""+userInfo.getFriends_count());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void print(String s){
        System.out.println("s>>>>>>>>>>>>"+s);
    }

    //get online picture
    public static Bitmap getImageBitmap(String url) {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bm;
    }

    //get url string to json format to let gson recognize
    public static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

}
