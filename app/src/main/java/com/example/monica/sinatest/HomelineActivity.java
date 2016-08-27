package com.example.monica.sinatest;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.monica.sinatest.API.Timeline_home;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by monica on 8/20/16.
 */
public class HomelineActivity extends Activity{
    int mWeiboCount=20;
    ListView mList;
    public void onCreate(Bundle savedInstanceState){
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        super.onCreate(savedInstanceState);
        AccessTokenKeeper.init(this);
        setContentView(R.layout.timeline_home_listview);
        mList=(ListView)findViewById(R.id.list);

        String url=
                "https://api.weibo.com/2/statuses/home_timeline.json?access_token="+AccessTokenKeeper.getKeyAccessToken()+"&since_id=0&max_id=0&count="+
                        mWeiboCount+"&page=1&base_app=0&feature=0&trim_user=0";
        new set_homeline_weibo().execute(url);
//        set_homeline_weibo();
    }
    public class set_homeline_weibo extends AsyncTask<String,Void,HashMap<String,Timeline_home.Status>>{
        public HashMap<String,Timeline_home.Status> doInBackground(String...urls){
            try{
//                String url=
//                        "https://api.weibo.com/2/statuses/home_timeline.json?access_token="+AccessTokenKeeper.getKeyAccessToken()+"&since_id=0&max_id=0&count="+
//                                mWeiboCount+"&page=1&base_app=0&feature=0&trim_user=0";
                Gson gson1 = new Gson();
                Timeline_home item=gson1.fromJson(WeiboUserInfo.readUrl(urls[0]),Timeline_home.class);
                List<Timeline_home.Status> statu=item.getStatuses();
                HashMap<String,Timeline_home.Status> home_info=new HashMap<>();
                int i=0;
                for(Timeline_home.Status b:statu){
                    home_info.put("status"+i++,b);
                }
                return home_info;
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        public void onPostExecute(HashMap<String,Timeline_home.Status> home_info){
            mList.setAdapter(new HomelineAdapter(home_info,getApplicationContext()));
        }
    }
//    public void set_homeline_weibo(){
//        try{
//            String url=
//                    "https://api.weibo.com/2/statuses/home_timeline.json?access_token="+AccessTokenKeeper.getKeyAccessToken()+"&since_id=0&max_id=0&count="+
//                            mWeiboCount+"&page=1&base_app=0&feature=0&trim_user=0";
//            Gson gson1 = new Gson();
//            Timeline_home item=gson1.fromJson(WeiboUserInfo.readUrl(url),Timeline_home.class);
//            List<Timeline_home.Status> statu=item.getStatuses();
//            HashMap<String,Timeline_home.Status> home_info=new HashMap<>();
//            int i=0;
//            for(Timeline_home.Status b:statu){
//                home_info.put("status"+i++,b);
//            }
//            mList.setAdapter(new HomelineAdapter(home_info,getApplicationContext()));
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    public class HomelineAdapter extends BaseAdapter {
        HashMap<String,Timeline_home.Status> weibos;
        Context context;
        public HomelineAdapter(HashMap<String,Timeline_home.Status> weibos,Context context){
            this.weibos=weibos;
            this.context=context;
        }
        public int getCount(){
            return weibos.size();
        }

        public Object getItem(int var1){
            return null;
        }

        public long getItemId(int var1){
            return 0;
        }

        public View getView(int var1, View var2, ViewGroup var3){
            ViewHolder viewHolder;
            View view=var2;
            if(view==null){
                LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view=inflater.inflate(R.layout.timeline_home,null);
                viewHolder=new ViewHolder();
                viewHolder.name=(TextView)view.findViewById(R.id.user_name_home);
                viewHolder.sent_time=(TextView)view.findViewById(R.id.sent_weibo_time);
                viewHolder.source=(TextView)view.findViewById(R.id.sources);
                viewHolder.weibo_text=(TextView)view.findViewById(R.id.weibo_text);
                viewHolder.repost_count=(TextView)view.findViewById(R.id.reposts);
                viewHolder.comment_count=(TextView)view.findViewById(R.id.comments_text);
                viewHolder.pic=(ImageView)view.findViewById(R.id.user_pic);
                //(reposts_pic=(ImageView)findViewById(R.id.reposts_pic));
                viewHolder.attitudes_count=(TextView)view.findViewById(R.id.likes_text);
                view.setTag(viewHolder);
            }
            Timeline_home.Status weibo=weibos.get("status"+var1);
            viewHolder=(ViewHolder)view.getTag();
            viewHolder.name.setText(""+weibo.getUser().getName());
            viewHolder.sent_time.setText(""+getFormatedDate(weibo));
            viewHolder.source.setText("来自"+getSource(weibo));
            viewHolder.weibo_text.setText(weibo.getText());
            viewHolder.repost_count.setText(""+weibo.getReposts_count()+"人");
            viewHolder.comment_count.setText(""+weibo.getComments_count()+"人");
            viewHolder.pic.setImageBitmap(WeiboUserInfo.getImageBitmap(weibo.getUser().getProfile_image_url()));
//            viewHolder.pic.setImageBitmap(new WeiboUserInfo.GetImageBitmap(viewHolder,viewHolder.pic).execute(weibo.getUser().getProfile_image_url()));
            //(reposts_pic=(ImageView)findViewById(R.id.reposts_pic));
            viewHolder.attitudes_count.setText(""+weibo.getAttitudes_count()+"人");
            return view;
        }
    }
    class ViewHolder{
        TextView name;
        TextView source;
        TextView sent_time;
        TextView weibo_text;
        TextView repost_count;
        TextView comment_count;
        ImageView pic;
        TextView attitudes_count;
    }
    public String getFormatedDate(Timeline_home.Status weibo){
        //format time url:http://stackoverflow.com/questions/36309255/parseexception-unparseable-date-wed-mar-30-000000-gmt0530-2016-at-offse
        SimpleDateFormat readFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        SimpleDateFormat writeFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date date=null;
        try {
            date=readFormat.parse(weibo.getCreated_at());
        } catch ( ParseException e ) {
            e.printStackTrace();
        }
        String formattedDate="";
        if(date!= null){
            formattedDate = writeFormat.format(date);
        }
        return formattedDate;
    }
    public String getSource(Timeline_home.Status weibo){
        //sources url:http://stackoverflow.com/questions/4628715/java-regex-to-get-the-text-from-html-anchor-a-a-tags
        String html=weibo.getSource();
        Pattern p = Pattern.compile("<a[^>]*>([^<]*)</a>");
        Matcher m = p.matcher(html);
        String source=null;
        // if we find a match, get the group
        if (m.find()) {
            // get the matching group
            String codeGroup = m.group(1);
            source=codeGroup;
            // print the group
            System.out.format("'%s'\n", codeGroup);
        }
        return source;
    }
    public void print(String name,String value){
        System.out.println(name+">>>>>>>>>>"+value);
    }


}
