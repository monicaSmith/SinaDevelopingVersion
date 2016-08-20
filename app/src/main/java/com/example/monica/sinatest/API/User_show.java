package com.example.monica.sinatest.API;
//user's basic info::url::http://open.weibo.com/wiki/2/users/show
//json url:https://api.weibo.com/2/users/show.json?access_token=2.009R7bUFprlCCCd292ebe5d2uo8KnD&uid=5032873402
/**
 * Created by monica on 8/11/16.
 */
public class User_show {
    long id	;
    String idstr	;
    String screen_name	;
    String name	;
    int province	;
    int city	;
    String location	;
    String description	;
    String url	;
    String profile_image_url	;
    String profile_url	;
    String domain	;
    String weihao	;
    String gender	;
    int followers_count	;
    int friends_count	;
    int statuses_count	;
    int favourites_count	;
    String created_at	;
    boolean following	;
    boolean allow_all_act_msg	;
    boolean geo_enabled	;
    boolean verified	;
    int verified_type	;
    String remark	;
    Object status	;//////////最近一条微博status
    boolean allow_all_comment	;
    String avatar_large	;
    String avatar_hd	;
    String	verified_reason	;
    boolean	follow_me	;
    int online_status;
    int bi_followers_count;
    String lang;

    public String getLang() {
        return lang;
    }

    public int getBi_followers_count() {
        return bi_followers_count;
    }

    public int getOnline_status() {
        return online_status;
    }

    public boolean isFollow_me() {
        return follow_me;
    }

    public String getVerified_reason() {
        return verified_reason;
    }

    public String getAvatar_hd() {
        return avatar_hd;
    }

    public String getAvatar_large() {
        return avatar_large;
    }

    public boolean isAllow_all_comment() {
        return allow_all_comment;
    }

    public Object getStatus() {
        return status;
    }

    public String getRemark() {
        return remark;
    }

    public int getVerified_type() {
        return verified_type;
    }

    public boolean isVerified() {
        return verified;
    }

    public boolean isGeo_enabled() {
        return geo_enabled;
    }

    public boolean isAllow_all_act_msg() {
        return allow_all_act_msg;
    }

    public boolean isFollowing() {
        return following;
    }

    public String getCreated_at() {
        return created_at;
    }

    public int getFavourites_count() {
        return favourites_count;
    }

    public int getStatuses_count() {
        return statuses_count;
    }

    public int getFriends_count() {
        return friends_count;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public String getGender() {
        return gender;
    }

    public String getWeihao() {
        return weihao;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public String getDomain() {
        return domain;
    }

    public long getId() {
        return id;
    }

    public String getIdstr() {
        return idstr;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public String getName() {
        return name;
    }

    public int getProvince() {
        return province;
    }

    public int getCity() {
        return city;
    }
}
class Status{
    String created_at;
    long id;
    long mid;
    String idstr;
    String text;
    // "textLength":35,
    // "source_allowclick":0,
    // "source_type":1,
    String source;
    boolean favorited;
    boolean truncated;
    String in_reply_to_status_id;
    String in_reply_to_user_id;
    String in_reply_to_screen_name;
    int reposts_count;
    int comments_count;
    int attitudes_count;
    //boolean isLongText;
    //"mlevel":0,
    Object visible;
    //"type":0,
    // "list_id":0
}


