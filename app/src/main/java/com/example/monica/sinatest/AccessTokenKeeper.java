package com.example.monica.sinatest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
/**
 * Created by monica on 8/9/16.
 */
public class AccessTokenKeeper extends Activity{
    public static final String PREFERENCES_NAME = "com_weibo_sdk_android";
    public static final String KEY_UID           = "uid";
    public static final String KEY_ACCESS_TOKEN  = "access_token";
    public static final String KEY_EXPIRES_IN    = "expires_in";
    public static final String KEY_REFRESH_TOKEN    = "refresh_token";
    static String key_id,key_accessToken;
    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    public static void  writeToken(Context context,Oauth2AccessToken accessToken){
        if (null == context || null == accessToken) {
            return;
        }
            sharedPreferences=context.getSharedPreferences(PREFERENCES_NAME,MODE_APPEND);
            editor=sharedPreferences.edit();
            editor.putString(KEY_UID,accessToken.getUid());
            editor.putLong(KEY_EXPIRES_IN,accessToken.getExpiresTime());
            editor.putString(KEY_ACCESS_TOKEN,accessToken.getToken());
            editor.putString(KEY_REFRESH_TOKEN,accessToken.getRefreshToken());
            editor.commit();
        }
    public static void init(Context context)
    {
        sharedPreferences=context.getSharedPreferences(PREFERENCES_NAME,MODE_APPEND);
    }

    public static String getKeyUid() {
//        return sharedPreferences.getString(KEY_UID,"null");
        return key_id=sharedPreferences.getString(KEY_UID,"null");
    }

    public static String getKeyAccessToken() {
//        System.out.print("access>>>>>>>>>>>>>>>>>>>>>>>>>>"+sharedPreferences.getString(KEY_ACCESS_TOKEN,"null"));
//        return sharedPreferences.getString(KEY_ACCESS_TOKEN,"null");
        return key_accessToken=sharedPreferences.getString(KEY_ACCESS_TOKEN,"null");

    }

    public static Long getKeyExpiresIn() {
        return sharedPreferences.getLong(KEY_EXPIRES_IN,0);
    }

    public static String getKeyRefreshToken() {
        return sharedPreferences.getString(KEY_REFRESH_TOKEN,"null");
    }

    public static Oauth2AccessToken readToken(Context context){
        if (null == context) {
            return null;
        }
        Oauth2AccessToken tokenInfo=new Oauth2AccessToken();
        sharedPreferences.getString(KEY_UID,"null");
        sharedPreferences.getString(KEY_EXPIRES_IN,"null");
        sharedPreferences.getString(KEY_ACCESS_TOKEN,"null");
        sharedPreferences.getString(KEY_REFRESH_TOKEN,"null");
        tokenInfo.setUid(sharedPreferences.getString(KEY_UID,"default"));
        tokenInfo.setToken(sharedPreferences.getString(KEY_ACCESS_TOKEN,"default"));
        tokenInfo.setExpiresTime(sharedPreferences.getLong(KEY_EXPIRES_IN,0));
        tokenInfo.setRefreshToken(sharedPreferences.getString(KEY_REFRESH_TOKEN,"default"));
        return tokenInfo;
    }

}
