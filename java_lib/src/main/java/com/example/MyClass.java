//package com.example;
//import com.google.gson.Gson;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class MyClass {
//    public class EnumTest {
//
//        Day day;
//
//        public EnumTest(Day day) {
//            this.day = day;
//        }
//
//        public void tellItLikeItIs() {
//            switch (day) {
//                case MONDAY:
//                    System.out.println("Mondays are bad.");
//                    break;
//
//                case FRIDAY:
//                    System.out.println("Fridays are better.");
//                    break;
//
//                case SATURDAY: case SUNDAY:
//                    System.out.println("Weekends are best.");
//                    break;
//
//                default:
//                    System.out.println("Midweek days are so-so.");
//                    break;
//            }
//        }
//
//        public static void main(String[] args) {
//            EnumTest firstDay = new EnumTest(Day.MONDAY);
//            firstDay.tellItLikeItIs();
//            EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
//            thirdDay.tellItLikeItIs();
//            EnumTest fifthDay = new EnumTest(Day.FRIDAY);
//            fifthDay.tellItLikeItIs();
//            EnumTest sixthDay = new EnumTest(Day.SATURDAY);
//            sixthDay.tellItLikeItIs();
//            EnumTest seventhDay = new EnumTest(Day.SUNDAY);
//
//            seventhDay.tellItLikeItIs();
//        }
////        HashMap<String,Timeline_home.Status> hashMap=new HashMap();
////        int i=1;//第几条微博 共20条
////        Gson gson = new Gson();
////        String url=
////                "https://api.weibo.com/2/statuses/home_timeline.json?access_token=2.009R7bUFprlCCCd292ebe5d2uo8KnD&since_id=0&max_id=0&count=20&page=1&base_app=0&feature=0&trim_user=0";
////        //String url = "https://api.weibo.com/2/users/show.json?access_token=2.009R7bUFprlCCCd292ebe5d2uo8KnD&uid=5032873402";
////        try {
////            Timeline_home item1 = gson.fromJson(readUrl(url), Timeline_home.class);
////            List<Timeline_home.Status> statuses=item1.getStatuses();
////            for(Timeline_home.Status a:statuses){
////                hashMap.put("status"+i++,a);
////            }
////            Timeline_home.Status a=hashMap.get("status1");
////            print("test"+a.getPic_ids().toString());
////
//
////            SimpleDateFormat readFormat = new SimpleDateFormat( "E MMM dd HH:mm:ss Z yyyy");
////            SimpleDateFormat writeFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
////            Date date=null;
////            try {
////                date=readFormat.parse(a.getCreated_at());
////                print(a.getCreated_at());
////                print(date.toString());
////            } catch ( ParseException e ) {
////                e.printStackTrace();
////            }
////            String formattedDate = "";
////            if(date!= null ){
////                formattedDate = writeFormat.format(date);
////            }
////            print(formattedDate);
////            Calendar c=Calendar.getInstance();
////            int currentHour=c.get(Calendar.HOUR_OF_DAY);
////
//
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
////    private static String readUrl(String urlString) throws Exception {
////        BufferedReader reader = null;
////        try {
////            URL url = new URL(urlString);
////            reader = new BufferedReader(new InputStreamReader(url.openStream()));
////            StringBuffer buffer = new StringBuffer();
////            int read;
////            char[] chars = new char[1024];
////            while ((read = reader.read(chars)) != -1)
////                buffer.append(chars, 0, read);
////
////            return buffer.toString();
////        } finally {
////            if (reader != null)
////                reader.close();
////        }
////    }
//
//        public static void print (String s){
//            System.out.println("s>>>>>>>>>>>>" + s);
//        }
//    }
