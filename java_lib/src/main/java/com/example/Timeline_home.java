package com.example;
//url::http://open.weibo.com/wiki/2/statuses/home_timeline
//https://api.weibo.com/2/statuses/home_timeline.json?access_token=2.009R7bUFprlCCCd292ebe5d2uo8KnD&since_id=0&max_id=0&count=20&page=1&base_app=0&feature=0&trim_user=0
import java.util.List;
///see[]-List<> and {}-Object class  // more object ??is difficult//////gson parse multiple nested object  json
//http://www.javacreed.com/simple-gson-example/
/**
 * Created by monica on 8/11/16.
 */
// Timeline_home extends ArrayList<Timeline_home.Statuses> ?????????????
public class Timeline_home{

    public List<Timeline_home.Status> getStatuses() {
        return statuses;
    }
    List<Timeline_home.Status> statuses;//statuses is List<> cause it contains[] ,and it consists of twenty Objects
    // List<Object>  advertises;
    // List<Object>  ad;
    boolean hasvisible;
    int previous_cursor;
    long next_cursor;
    int total_number;
    int  interval;
    int  uve_blank;
    long since_id;
    long  max_id;
    int has_unread;
    public class Statuses{
        String created_at;
        long id;
        String idstr;
        String text;
        String source;
        boolean favorited;
        boolean truncated;
        String in_reply_to_status_id;
        String in_reply_to_user_id;
        String in_reply_to_screen_name;
        int reposts_count;
        int comments_count;
        int attitudes_count;
        long mid;
        User_show user;//Object user

        public String getCreated_at() {
            return created_at;
        }

        public long getId() {
            return id;
        }

        public String getIdstr() {
            return idstr;
        }

        public String getText() {
            return text;
        }

        public String getSource() {
            return source;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public boolean isTruncated() {
            return truncated;
        }

        public String getIn_reply_to_status_id() {
            return in_reply_to_status_id;
        }

        public String getIn_reply_to_user_id() {
            return in_reply_to_user_id;
        }

        public String getIn_reply_to_screen_name() {
            return in_reply_to_screen_name;
        }

        public int getReposts_count() {
            return reposts_count;
        }

        public int getComments_count() {
            return comments_count;
        }

        public int getAttitudes_count() {
            return attitudes_count;
        }

        public long getMid() {
            return mid;
        }

        public User_show getUser() {
            return user;
        }
        //class Status {} inside a [] List statuses

        }
    public class Status{
        String created_at;
        long id	;
        long mid;
        String idstr;
        String text;
        String source;
        boolean favorited;
        boolean truncated;
        String in_reply_to_status_id;
        String in_reply_to_user_id;
        String in_reply_to_screen_name;
        String thumbnail_pic;
        String bmiddle_pic;
        String original_pic;
        Object geo	;
        User_show user	;///User_show object
        Object retweeted_status;
        int reposts_count	;
        int comments_count	;
        int attitudes_count	;
        int mlevel	;
        Object visible	;
        Object pic_ids;/////////?
        Object[] ad;

        public String getCreated_at() {
            return created_at;
        }

        public long getId() {
            return id;
        }

        public long getMid() {
            return mid;
        }

        public String getIdstr() {
            return idstr;
        }

        public String getText() {
            return text;
        }

        public String getSource() {
            return source;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public boolean isTruncated() {
            return truncated;
        }

        public String getIn_reply_to_status_id() {
            return in_reply_to_status_id;
        }

        public String getIn_reply_to_user_id() {
            return in_reply_to_user_id;
        }

        public String getIn_reply_to_screen_name() {
            return in_reply_to_screen_name;
        }

        public String getThumbnail_pic() {
            return thumbnail_pic;
        }

        public String getBmiddle_pic() {
            return bmiddle_pic;
        }

        public String getOriginal_pic() {
            return original_pic;
        }

        public Object getGeo() {
            return geo;
        }

        public User_show getUser() {
            return user;
        }

        public Object getRetweeted_status() {
            return retweeted_status;
        }

        public int getReposts_count() {
            return reposts_count;
        }

        public int getComments_count() {
            return comments_count;
        }

        public int getAttitudes_count() {
            return attitudes_count;
        }

        public int getMlevel() {
            return mlevel;
        }

        public Object getVisible() {
            return visible;
        }

        public Object getPic_ids() {
            return pic_ids;
        }

        public Object[] getAd() {
            return ad;
        }
    }
}
