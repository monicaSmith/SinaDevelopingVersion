package com.example.monica.sinatest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
public class MainActivity extends Activity{
    SsoHandler ssoHandler;
    AuthInfo authInfo;
    TextView textView_tokenInfo;
    Oauth2AccessToken oauth2AccessToken;
    //send weibo
    Button button_sendWeibo;
    //auth
    HashMap<String,String> token_info;//save token_info
    Button auth;
    Button showInfo;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //auth and pass necessary values such as access_token
        textView_tokenInfo=(TextView)findViewById(R.id.textView_tokenInfo);
        authInfo=new AuthInfo(MainActivity.this,Constants.APP_KEY,Constants.REDIRECT_URL,Constants.SCOPE);
        ssoHandler=new SsoHandler(MainActivity.this,authInfo);
        //authorize here ,,start intent and pass values in OnActivityResult()
        ((Button)findViewById(R.id.auth)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ssoHandler.authorize(new WeiboAuth());
            }
        });

    }
    public class WeiboAuth implements WeiboAuthListener{
        @Override
        public void onComplete(Bundle bundle) {
            oauth2AccessToken=Oauth2AccessToken.parseAccessToken(bundle);
            if(oauth2AccessToken.isSessionValid()){
               // AccessTokenKeeper accessTokenKeeper=new AccessTokenKeeper();
                AccessTokenKeeper.writeToken(getApplicationContext(),oauth2AccessToken);
                toast("auth success");
                updateTokenView(false);
            }
            else{
                String message="auth failed";
                String code=bundle.getString("code");
                if(!TextUtils.isEmpty(code)){
                    message=message+"code>>>>>>>>>>"+code;
                }
                toast(message);
            }
            startActivity(new Intent(MainActivity.this,HomelineActivity.class));;
        }
        @Override
        public void onWeiboException(WeiboException e) {
            toast("exception>>>>>>>>>>>>>>>>>>>>>>>"+e.getMessage());
        }
        @Override
        public void onCancel() {
            toast("weibo cancelled");
        }
    }
    public void print(String name,String value){
        System.out.println(name+">>>>>>>>>>"+value);
    }
    private void updateTokenView(boolean hasExisted) {
        print("token",oauth2AccessToken.getToken());
        print("uid",oauth2AccessToken.getUid());
        if(oauth2AccessToken.equals(null)||oauth2AccessToken.equals(""))
            toast("null access token ");
        else {
            //get token end up time
            String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date(oauth2AccessToken.getExpiresTime()));
            String format = getString(R.string.token);
            textView_tokenInfo.setText(String.format(format, oauth2AccessToken.getToken(), date));
            String message = String.format(format, oauth2AccessToken.getToken(), date);
            if (hasExisted) {
                message = getString(R.string.if_token_exit) + "\n" + message;
            }
            textView_tokenInfo.setText(message);
        }
    }
    public void toast(String info){
        Toast.makeText(MainActivity.this,info,Toast.LENGTH_SHORT).show();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // SSO 授权回调
        // 重要：发起 SSO 登陆的 Activity 必须重写 onActivityResults
        if (ssoHandler != null) {
            ssoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
        else{
            toast("ss handler is null");
        }
    }
}
