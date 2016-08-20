//package com.example.monica.sinatest;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import com.sina.weibo.sdk.api.TextObject;
//import com.sina.weibo.sdk.api.WeiboMultiMessage;
//import com.sina.weibo.sdk.api.share.BaseResponse;
//import com.sina.weibo.sdk.api.share.IWeiboHandler;
//import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
//import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
//import com.sina.weibo.sdk.api.share.WeiboShareSDK;
//import com.sina.weibo.sdk.auth.AuthInfo;
//import com.sina.weibo.sdk.auth.Oauth2AccessToken;
//import com.sina.weibo.sdk.auth.WeiboAuthListener;
//import com.sina.weibo.sdk.constant.WBConstants;
//import com.sina.weibo.sdk.exception.WeiboException;
//
//
///**
// * Created by monica on 8/9/16.
// */
//public class SendWeibo extends Activity implements IWeiboHandler.Response{
//    IWeiboShareAPI weiboShareSDK;//register app and so on
//    String weiboMessage;
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.weibo_user_info);
//        //receive messages from MainActivity
//        Bundle bundle=getIntent().getBundleExtra("message");
//        weiboMessage=bundle.getString("message","null");
//        weiboShareSDK=WeiboShareSDK.createWeiboAPI(SendWeibo.this,Constants.APP_KEY);
//        //register
//        weiboShareSDK.registerApp();
//        // 当 Activity 被重新初始化时（该 Activity 处于后台时，可能会由于内存不足被杀掉了），
//        // 需要调用 {@link IWeiboShareAPI#handleWeiboResponse} 来接收微博客户端返回的数据。
//        // 执行成功，返回 true，并调用 {@link IWeiboHandler.Response#onResponse}；
//        // 失败返回 false，不调用上述回调
//        if (savedInstanceState != null) {
//            weiboShareSDK.handleWeiboResponse(getIntent(), this);
//        }
//        sendMultiMessage(true);
//
//    }
//    public TextObject getTextObj(){
//        TextObject message=new TextObject();
//        message.text=weiboMessage;
//        return message;
//    }
//    private void sendMultiMessage(boolean hasText) {
//
//        // 1. 初始化微博的分享消息
//        WeiboMultiMessage weiboMessage = new WeiboMultiMessage();
//        if (hasText) {
//            weiboMessage.textObject = getTextObj();
//        }
//        // 2. 初始化从第三方到微博的消息请求
//        SendMultiMessageToWeiboRequest request = new SendMultiMessageToWeiboRequest();
//        // 用transaction唯一标识一个请求
//        request.transaction = String.valueOf(System.currentTimeMillis());
//        request.multiMessage = weiboMessage;
//
//        // 3. 发送请求消息到微博，唤起微博分享界面
//
//
//        AuthInfo authInfo = new AuthInfo(this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE);
//        Oauth2AccessToken accessToken = AccessTokenKeeper.readToken(getApplicationContext());
//        String token = "";
//        if (accessToken != null) {
//            token = accessToken.getToken();
//        }
//        weiboShareSDK.sendRequest(this, request, authInfo, token, new WeiboAuthListener() {
//
//            @Override
//            public void onWeiboException( WeiboException arg0 ) {
//            }
//
//            @Override
//            public void onComplete( Bundle bundle ) {
//                // TODO Auto-generated method stub
//                Oauth2AccessToken newToken = Oauth2AccessToken.parseAccessToken(bundle);
//                AccessTokenKeeper.writeToken(getApplicationContext(), newToken);
//                Toast.makeText(getApplicationContext(), "onAuthorizeComplete token = " + newToken.getToken(), 0).show();
//            }
//
//            @Override
//            public void onCancel() {
//            }
//        });
//    }
//
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//
//        // 从当前应用唤起微博并进行分享后，返回到当前应用时，需要在此处调用该函数
//        // 来接收微博客户端返回的数据；执行成功，返回 true，并调用
//        // {@link IWeiboHandler.Response#onResponse}；失败返回 false，不调用上述回调
//        weiboShareSDK.handleWeiboResponse(intent, this);
////        MainActivity mainActivity=new MainActivity();  怎么回到MainActivity呢
////        mainActivity.startActivity(SendWeibo.this,MainActivity.class,"");
//    }
//    public void onResponse(BaseResponse baseResp) {
//        if(baseResp!= null){
//            switch (baseResp.errCode) {
//                case WBConstants.ErrorCode.ERR_OK:
//                    Toast.makeText(this, R.string.weibosdk_demo_toast_share_success, Toast.LENGTH_LONG).show();
//                    break;
//                case WBConstants.ErrorCode.ERR_CANCEL:
//                    Toast.makeText(this, R.string.weibosdk_demo_toast_share_canceled, Toast.LENGTH_LONG).show();
//                    break;
//                case WBConstants.ErrorCode.ERR_FAIL:
//                    Toast.makeText(this,
//                            getString(R.string.weibosdk_demo_toast_share_failed) + "Error Message: " + baseResp.errMsg,
//                            Toast.LENGTH_LONG).show();
//                    break;
//            }
//        }
//    }
//
//}
