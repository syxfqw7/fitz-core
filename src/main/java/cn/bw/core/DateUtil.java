/**
 * FileName: DateUtil
 * Author:   jack.xue
 * Date:     2018/12/4 17:29
 * Description: 日期工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * jack.xue           2018/12/4           1.0.0              描述
 */
package cn.bw.core;

import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 〈TODO〉<br> 
 *
 * @author jack.xue
 * @create 2018/12/4
 * @since 1.0.0
 */
public class DateUtil {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String ALIGN_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final double[] LIMITS = { 0, 1, 2 };

    private static final String[] MINUTES_PART = { "", "1 minute ", "{0,number} minutes " };

    private static final String[] SECONDS_PART = { "0 seconds", "1 second", "{1,number} seconds" };

    private static final ChoiceFormat MINUTES_FORMAT = new ChoiceFormat(LIMITS, MINUTES_PART);

    private static final ChoiceFormat SECONDS_FORMAT = new ChoiceFormat(LIMITS, SECONDS_PART);

    private static final MessageFormat MINUTE_SECONDS = new MessageFormat("{0}{1}");

    static {
        MINUTE_SECONDS.setFormat(0, MINUTES_FORMAT);
        MINUTE_SECONDS.setFormat(1, SECONDS_FORMAT);
    }

    public static final long  ONE_SECOND = 1000;
    public static final long  ONE_MINUTE = 60*ONE_SECOND;
    public static final long  ONE_HOUR   = 60*ONE_MINUTE;
    public static final long  ONE_DAY    = 24*ONE_HOUR;
    public static final long  ONE_WEEK   = 7*ONE_DAY;


    public static final SimpleDateFormat _defDateTimeFmt = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);

    public static final SimpleDateFormat _defDateFmt = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

    public static String toString(Date date, String format) {

        SimpleDateFormat formatter;

        if ((date == null) || (format == null) || (format.length() == 0)) {
            return null;
        }
        formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static Date toDate(String str, String format) {
        if ((str == null)
                || (str.length() == 0)
                || (format == null)
                || (format.length() == 0)) {
            return null;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setLenient(false);
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(str, pos);
    }

    public static boolean compare(Date date1, Date date2) {
        if (date1 == null && date2 == null) {
            return true;
        }
        if (date1 == null || date2 == null)
            return false;
        else
            return date1.getTime() == date2.getTime();
    }

    public static Date toDate(String str) {
        try {
            if (str.indexOf(':') > 0) {
                return  toDate(str, DEFAULT_DATETIME_FORMAT);
            } else {
                return  toDate(str, DEFAULT_DATE_FORMAT);
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getCurrentDateTimeStr(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(date);
    }

    public static String getCurrentDateStr(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(date);
    }

    public static String currentDateToString(String format) {
        Date date = new Date();
        return toString(date, format);
    }

    public static String curDateStr() {
        return _defDateFmt.format(new Date());
    }

    public static String curDateTimeStr() {
        return _defDateTimeFmt.format(new Date());
    }

    public static String formatElapsedTime(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        Object[] args = { new Long(minutes), new Long(seconds % 60)};
        return MINUTE_SECONDS.format(args);
    }

    public static String format(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(date == null)return "";
        String buyDateStr = sdf.format(date);
        return buyDateStr;
    }

    public static String formatToyyyyMMdd(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if(date == null)return "";
        String buyDateStr = sdf.format(date);
        return buyDateStr;
    }
    /**
     * 比较2个日期相差几天
     * */
    public static long compareDays(String date1,String date2){
        long nd = 1000*24*60*60;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Date d1 = formatter.parse(date1);
            Date d2 =formatter.parse(date2);
            long s1 = d1.getTime();
            long s2 = d2.getTime();
            long s3 = s1-s2;
            if(s3<0){
                s3 = (-1)*s3;
            }
            long day = Math.round((double)s3/nd);
            return day;
        } catch (ParseException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    /**
     *
     * @作者 js
     * @方法名 getQuartzAfterNow
     * @功能 TODO 获取现在时间若干毫米前后的时间
     * @param millis
     * @return
     */
    public static String getQuartzAfterNow(int millis) {
        long now=new Date().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("s m H d M ? y");
        return sdf.format(new Date(now+millis));
    }

    public static String getQuartzAfterNowDay(int days,int hourOfDay,int minute,int second) {
        Calendar calendar=Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), hourOfDay, minute, second);
        calendar.add(Calendar.DAY_OF_MONTH,days);
        SimpleDateFormat sdf = new SimpleDateFormat("s m H d M ? y");
        return sdf.format(calendar.getTime());
    }
    public static String formatToQuartzDate(String date) {
        long now=toDate(date, "yyyy-MM-dd HH:mm:ss").getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("s m H d M ? y");
        return sdf.format(new Date(now));
    }
}