package com.example.springbootdemo.utils;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.DAY_OF_MONTH;

/**
 * @author wb
 * @desc 时间处理
 */
public class TimeHandleUtils implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // 用来全局控制 上一周,本周,下一周的周数变化
    private int weeks = 0;
    private int MaxDate; // 一月最大天数
    private int MaxYear; // 一年最大天数
    public static final String FORMAT_YMDHMS_STRING = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YM_STRING = "yyyy-MM";
    public static final String FORMAT_YMD_STRING = "yyyy-MM-dd";
    public static final String FORMAT_YMD_STRINGSTR = "yyyy年MM月dd日";
    public static final String FORMAT_YMDHMS_STRINGSTR = "yyyy年MM月dd日 HH:mm:ss";
    public static final String FORMAT_Y_STRING = "yyyy";
    public static final String FORMAT_YMD_STRING_XIEGANG = "yyyy/MM/dd";
    public static final String FORMAT_MD_CN_STRING = "MM月dd日";
    public static final String FORMAT_DH_CN_STRING = "d天HH时";
    public static final String FORMAT_HM_STRING = "HH:mm";
    public static final String FORMAT_HMS_STRING = "HH:mm:ss";
    public static final String FORMAT_YMDHS_STRING = "yyyy-MM-dd HH:ss";
    public static final long TIME_MILLIS_HOUR = 3600000L;
    public static final long TIME_MILLIS_MINUTE = 60000L;
    public static final long TIME_MILLIS_DAY = 86400000L;
    public static final String FORMAT_HH_STRING = "HH";
    public static final String FORMAT_SS_STRING = "ss";

    //当前时间增加指定年限
    public static String currtimeAndYear(int ynum) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);// 设置起时间
        cal.add(Calendar.YEAR, ynum);// 增加一年
        if (ynum > 0) {
            cal.add(Calendar.DATE, -1);//减1天
        }
        return TimeHandleUtils.dateToStr(cal.getTime(), TimeHandleUtils.FORMAT_YMD_STRINGSTR);
    }

    // 返回當前时间戳转成 sql.timestamp
    public static Timestamp result_currenttime_timestamp() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);
        return time;
    }

    // 返回當前时间戳转成 sql.timestamp  精确到天
    public static Timestamp result_currenttime_timestampDay() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);
        return time;
    }

    // 传递指定参数，当前时间叠加
    public static Timestamp result_currenttime_addtimestamp(Integer day) {
        // 要加上的天数转换成毫秒数
        Long dy = TimeHandleUtils.TIME_MILLIS_DAY * day;
        Timestamp time = new Timestamp((System.currentTimeMillis()) + dy);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);
        return time;
    }


    // 再时间上加月
    public static Date resultMonthDay(Date date, Integer month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static Date toDate(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.getTime();
    }

    public static Date toDate(String time, String format) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }

        try {
            DateFormat df = new SimpleDateFormat(format);

            return df.parse(time);

        } catch (Exception pe) {
            return null;
        }

    }

    public static long toLong(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        return calendar.getTimeInMillis();
    }

    public static long toLong(String time, String format) {
        return toLong(toDate(time, format));
    }

    public static String toString(Date time) {
        return toString(time, FORMAT_YMDHMS_STRING);
    }

    public static String toYMDString(Date time) {
        return toString(time, FORMAT_YMD_STRING);
    }

    public static String toHMSString(Date time) {

        return toString(time, FORMAT_HMS_STRING);
    }

    public static String toString(long time) {
        return toString(toDate(time), FORMAT_YMDHMS_STRING);
    }

    public static String toString(long time, String format) {
        return toString(toDate(time), format);
    }

    public static String toYMDString(long time) {
        return toString(toDate(time), FORMAT_YMD_STRING);
    }

    public static String toHMSString(long time) {
        return toString(toDate(time), FORMAT_HMS_STRING);
    }

    public static String toString(Date date, String format) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat DATA_FORMAT = new SimpleDateFormat(format);
            return DATA_FORMAT.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    // //过时
    public static long dateToStrStart(int amount) {

        return dateStrToLong(dateToStr(getPreDate(amount), FORMAT_YMD_STRING) + " 00:00:00", FORMAT_YMDHMS_STRING);
    }

    public static long dateToStrStart() {
        return dateStrToLong(dateToStr(FORMAT_YMD_STRING) + " 00:00:00", FORMAT_YMD_STRING);
    }

    public static long dateToStrEnd() {
        return dateStrToLong(dateToStr(getNextDate(1), FORMAT_YMD_STRING) + " 00:00:00", FORMAT_YMD_STRING);
    }

    public static long dateStrToLong(String dateStr, String format) {

        return dateToLong(strToDate(dateStr, format), format);

    }

    public static long strToLong(String dateString, String dateFormt) {

        return dateToLong(strToDate(dateString, dateFormt));

    }

    /**
     * 把long型时间转为date
     * <p>
     * Title: longToDate
     * </p>
     * <p>
     * Description:
     * </p>
     * DateUtil
     *
     * @param longDate
     * @return Date
     */
    public static Date longToDate(long longDate) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(longDate);
        return calendar.getTime();

    }

    /**
     * 把 long string型时间转为 Format_YMDHMS_String格式的Date
     * <p>
     * Title: longStrToDate
     * </p>
     * <p>
     * Description:
     * </p>
     * DateUtil
     *
     * @param longDateStr
     * @return Date
     */
    public static Date longStrToDate(String longDateStr) {
        return longToDate(Long.parseLong(longDateStr));

    }

    public static long longToLong(long longDate, String format) {
        return dateToLong(longToDate(longDate), format);

    }

    public static String longToDateStr(long dateString, String format) {
        return dateToStr(longToDate(dateString), format);

    }

    public static String dateToStr(Date date, String format) {
        return formatDate(date, format);

    }

    public static String dateToStr(String format) {
        return dateToStr(new Date(), format);

    }


    public static String convertErpTime(String time) {
        Date date = TimeHandleUtils.strToDate(time, "yyyy-MM-dd'T'HH:mm:ss.SS");
        String dateToStr = TimeHandleUtils.dateToStr(date, TimeHandleUtils.FORMAT_YMDHMS_STRING);
        return dateToStr;
    }


    /**
     * 把 date转换成LONG
     *
     * @param date
     * @return long
     */
    /****/
    public static long dateToLong(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        long l = calendar.getTimeInMillis();
        return l;

    }

    public static Date getPreDate(int amount) {
        Calendar calendar = Calendar.getInstance();
        if (amount != 0) {
            calendar.add(Calendar.DATE, -amount);
        }

        return calendar.getTime();
    }

    public static Date getPreWeek(int amount) {
        Calendar calendar = Calendar.getInstance();
        if (amount != 0) {
            calendar.add(Calendar.WEEK_OF_YEAR, -amount);
        }

        return calendar.getTime();
    }

    /**
     * <p>
     * Title: getWeek,本周每几天的时间
     * </p>
     * <p>
     * 每周的第一天是周日:
     * </p>
     *
     * @param amount 0,1,2,3,4,5,6
     * @return Date
     */
    public static Date getWeek(int amount) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + amount);
        return cal.getTime();
    }

    /**
     * <p>
     * Title: getWeek
     * </p>
     * <p>
     * 每周的第一天是周日:
     * </p>
     *
     * @param amount 0,1,2,3,4,5,6
     * @return Date
     */
    public static Date getLastWeek(int amount) {
        Calendar cal = Calendar.getInstance();
        int i = (cal.get(Calendar.DAY_OF_WEEK));
        System.out.println(i);
        if (i <= 2) {
            return (TimeHandleUtils.getWeek(-1, 2));
        } else {
            cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + amount);
            return cal.getTime();
        }
    }

    /**
     * 以某天为周的起点。
     *
     * @param preWeekTimes 起始周,上周：1，上上周：2。以此类推
     * @param weekDay      周一：1，周二：2，周三：3，周四：4，周五：5，周六：6，周日：7
     * @return
     */
    public static Date getPreWeek(int preWeekTimes, int weekDay) {
        Calendar cal = Calendar.getInstance();
        int curWeek = (cal.get(Calendar.DAY_OF_WEEK));
        if (curWeek <= weekDay) {
            cal.add(Calendar.DATE, -preWeekTimes * 7);
        }
        cal.set(Calendar.DAY_OF_WEEK, weekDay + 1);
        return cal.getTime();
    }

    /**
     * <p>
     * Title: getWeek
     * </p>
     * <p>
     * Description:
     * </p>
     * DateUtils
     *
     * @param field  那一周,0表示当前周
     * @param amount
     * @return Date
     */
    public static Date getWeek(int field, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, field * 7);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + amount);
        return cal.getTime();
    }

    public static Date getPreMONTH(int amount) {
        Calendar calendar = Calendar.getInstance();
        if (amount != 0)
            calendar.add(Calendar.MONTH, -amount);
        return calendar.getTime();
    }

    public static Date getNextDate(int amount) {
        Calendar calendar = Calendar.getInstance();
        if (amount != 0)
            calendar.add(Calendar.DATE, amount);
        return calendar.getTime();
    }

    public static Date getNext(int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        if (amount != 0)
            calendar.add(field, amount);
        return calendar.getTime();
    }

    public static Date getNext(String time, int field, int amount) {
        return getNext(strToLong(time, "yyyy-MM-dd HH:mm:ss"), field, amount);
    }

    public static Date getNext(Date time, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        if (amount != 0)
            calendar.add(field, amount);
        return calendar.getTime();
    }

    public static Date getNext(long time, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        if (amount != 0) {
            calendar.add(field, amount);
        }
        return calendar.getTime();
    }

    public static Date getNextWeek(int amount) {
        Calendar calendar = Calendar.getInstance();
        if (amount != 0) {
            calendar.add(Calendar.WEEK_OF_YEAR, amount);
        }

        return calendar.getTime();
    }

    public static Date getNextMONTH(int amount) {
        Calendar calendar = Calendar.getInstance();
        if (amount != 0) {
            calendar.add(Calendar.MONTH, amount);
        }
        return calendar.getTime();
    }

    /**
     * 将日期format成指定格式字符串
     *
     * @param dt
     *            日期
     * @param format
     *            格式
     * @return String
     */
    /****/
    public static String formatDate(Date dt, String format) {
        if ((dt == null) || format == null) {
            return "";
        }
        try {
            SimpleDateFormat DATA_FORMAT = new SimpleDateFormat(format);
            return DATA_FORMAT.format(dt);
        } catch (Exception e) {
            return "";
        }

    }

    public static String formatDate(String format) {

        return formatDate(new Date(), format);
    }

    /**
     * 把date 转换为指定格式的long
     * <p>
     * Title: DateToLong
     * </p>
     * <p>
     * Description:
     * </p>
     * DateUtil
     *
     * @param date
     * @param format
     * @return long
     */
    public static long dateToLong(Date date, String format) {

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateString = sdf.format(date);

        Date formatDate = null;
        try {
            formatDate = sdf.parse(dateString);
        } catch (ParseException e) {
        }
        return dateToLong(formatDate);

    }

    /**
     * 把当前时间格式化成dateStr后转换成LONG形
     *
     * @param dateStr
     * @return long
     */
    /****/
    public static long dateToLong(String format) {
        return dateToLong(new Date(), format);
    }

    /**
     * 将日值字符串转换成Date类型
     *
     * @param dateString
     *            参数字符串
     * @param dateFormt
     *            格式
     * @return Date
     */
    /****/
    public static Date strToDate(String dateString, String dateFormt) {
        if (dateString == null) {
            return null;
        }
        Date dt = null;
        try {
            DateFormat df = new SimpleDateFormat(dateFormt);
            dt = df.parse(dateString);

        } catch (Exception pe) {
            return null;
        }

        return dt;
    }

    /**
     * 得到二个日期间的间隔天数
     *
     * @param sj1
     * @param sj2
     * @return 二个日期间的间隔天数
     */
    public static String getTwoDay(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {
            Date date = myFormatter.parse(sj1);
            Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return "";
        }
        return day + "";
    }

    public static int getDaysBetween(Date dtBegin, Date dtEnd) {
        return Math.toIntExact(((dtBegin.getTime() - dtEnd.getTime()) / 86400000));
    }

    /**
     * 获取两个时间间隔的小时数
     *
     * @param dtBegin
     * @param dtEnd
     * @return
     */
    public static int getHoursBetween(Date dtBegin, Date dtEnd) {
        return Math.toIntExact(((dtBegin.getTime() - dtEnd.getTime()) / TimeHandleUtils.TIME_MILLIS_HOUR));
    }

    /**
     * 根据一个日期,返回是星期几的字符串
     *
     * @param sdate 日期
     * @return 星期几的字符串
     */
    public static String getWeek(String sdate) {
        // 再转换为时间
        Date date = TimeHandleUtils.strToDate(sdate, FORMAT_YMD_STRING);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了,其范围 1~7
        // 1=星期日 7=星期六,其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    public static String longStrToStr(String strDate, String format) {
        Date date = longStrToDate(strDate);

        return dateToStr(date, format);
    }

    /**
     * 把long String的时间格式化后转为long型时间
     * <p>
     * Title: longStrToLong
     * </p>
     * <p>
     * Description:
     * </p>
     * DateUtil
     *
     * @param longDateStr
     * @param format
     * @return long
     */
    public static long longStrToLong(String longDateStr, String format) {

        Date date = longStrToDate(longDateStr);
        return dateToLong(date, format);
    }

    public static String longStrToStr(String longDateStr) {

        Date date = longStrToDate(longDateStr);

        return dateToStr(date, FORMAT_YMDHMS_STRING);
    }

    /**
     * 两个时间之间的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(String date1, String date2) {
        long day = 0L;
        if (date1 == null || date1.equals("")) {
            return day;
        }

        if (date2 == null || date2.equals("")) {
            return day;
        }

        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = myFormatter.parse(date1);
            Date mydate = myFormatter.parse(date2);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
        }
        return day;
    }

    /**
     * 计算当月最后一天,返回字符串
     *
     * @return
     */
    public static String getDefaultDay() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, 1);// 加一个月,变为下月的1号
        lastDate.add(Calendar.DATE, -1);// 减去一天,变为当月最后一天

        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 上月第一天
     *
     * @return
     */
    public static String getPreviousMonthFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, -1);// 减一个月,变为下月的1号
        // lastDate.add(Calendar.DATE,-1);//减去一天,变为当月最后一天

        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 上月第一天
     *
     * @return
     */
    public static String getPreviousMonthFirstFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, -2);// 减一个月,变为下月的1号
        // lastDate.add(Calendar.DATE,-1);//减去一天,变为当月最后一天

        str = sdf.format(lastDate.getTime());
        return str;
    }


    /**
     * 获取当月第一天
     *
     * @return
     */
    public static String getFirstDayOfMonth() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 获取指定时间的 月份月末时间
     *
     * @param time
     * @return
     */
    public static String getMonthTime(String time) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.setTime(TimeHandleUtils.strToDate(time, TimeHandleUtils.FORMAT_YMD_STRING));
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, 1);// 加一个月,变为下月的1号
        lastDate.add(Calendar.DATE, -1);// 减去一天,变为当月最后一天
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 获取两个时间的间隔
     *
     * @param endDate
     * @param nowDate
     * @return
     */
    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60L;
        long nh = 1000 * 60 * 60L;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        return day + "天" + hour + "小时";
    }


    /**
     * 获得本周星期日的日期
     *
     * @return
     */
    public String getCurrentWeekday() {
        weeks = 0;
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = currentDate.getTime();

        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    /**
     * 获取当天时间
     *
     * @return
     */
    public String getNowTime(String dateformat) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
        String hehe = dateFormat.format(now);
        return hehe;
    }

    /**
     * 获得当前日期与本周日相差的天数
     *
     * @return
     */
    private int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天,星期日是第一天,星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    /**
     * 获得本周一的日期
     *
     * @return
     */
    public String getMondayOFWeek() {
        weeks = 0;
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();

        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    /**
     * 获得相应周的周六的日期
     *
     * @return
     */
    public String getSaturday() {
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    /**
     * 获得上周星期日的日期
     *
     * @return
     */
    public String getPreviousWeekSunday() {
        weeks = 0;
        weeks--;
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + weeks);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    /**
     * 获得上周星期一的日期
     *
     * @return
     */
    public String getPreviousWeekday() {
        weeks--;
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    /**
     * 获得下周星期一的日期
     *
     * @return
     */
    public String getNextMonday() {
        weeks++;
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    /**
     * 获得下周星期日的日期
     *
     * @return
     */
    public String getNextSunday() {

        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    public int getMonthPlus() {
        Calendar cd = Calendar.getInstance();
        int monthOfNumber = cd.get(Calendar.DAY_OF_MONTH);
        cd.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        cd.roll(Calendar.DATE, -1);// 日期回滚一天,也就是最后一天
        MaxDate = cd.get(Calendar.DATE);
        if (monthOfNumber == 1) {
            return -MaxDate;
        } else {
            return 1 - monthOfNumber;
        }
    }

    /**
     * 获得上月最后一天的日期
     *
     * @return
     */
    public static String getPreviousMonthEnd() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, -1);// 减一个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        lastDate.roll(Calendar.DATE, -1);// 日期回滚一天,也就是本月最后一天
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 获得下个月第一天的日期
     *
     * @return
     */
    public String getNextMonthFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, 1);// 减一个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 获得下个月最后一天的日期
     *
     * @return
     */
    public String getNextMonthEnd() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, 1);// 加一个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        lastDate.roll(Calendar.DATE, -1);// 日期回滚一天,也就是本月最后一天
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 获得明年最后一天的日期
     *
     * @return
     */
    public String getNextYearEnd() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.YEAR, 1);// 加一个年
        lastDate.set(Calendar.DAY_OF_YEAR, 1);
        lastDate.roll(Calendar.DAY_OF_YEAR, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 获得明年第一天的日期
     *
     * @return
     */
    public String getNextYearFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.YEAR, 1);// 加一个年
        lastDate.set(Calendar.DAY_OF_YEAR, 1);
        str = sdf.format(lastDate.getTime());
        return str;

    }

    /**
     * 获得本年有多少天
     *
     * @return
     */

    public int getMaxYear() {
        Calendar cd = Calendar.getInstance();
        cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
        cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天.
        int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
        return MaxYear;
    }

    private int getYearPlus() {
        Calendar cd = Calendar.getInstance();
        int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);// 获得当天是一年中的第几天
        cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
        cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天.
        int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
        if (yearOfNumber == 1) {
            return -MaxYear;
        } else {
            return 1 - yearOfNumber;
        }
    }

    /**
     * 获得本年第一天的日期
     *
     * @return
     */
    public String getCurrentYearFirst() {
        int yearPlus = this.getYearPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, yearPlus);
        Date yearDay = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preYearDay = df.format(yearDay);
        return preYearDay;
    }

    /**
     * 获得本年最后一天的日期
     *
     * @return
     */
    public String getCurrentYearEnd() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
        String years = dateFormat.format(date);
        return years + "-12-31";
    }

    /**
     * 获得上年第一天的日期
     *
     * @return
     */
    public String getPreviousYearFirst() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
        String years = dateFormat.format(date);
        int years_value = Integer.parseInt(years);
        years_value--;
        return years_value + "-1-1";
    }

    public static Integer getIntervalMonths(Date str1, Date str2) {
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(str1);
        aft.setTime(str2);
        int surplus = aft.get(Calendar.DATE) - bef.get(Calendar.DATE);
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        System.out.println(surplus);
        surplus = surplus <= 0 ? 1 : 0;
        System.out.println(surplus);
        System.out.println("相差月份：" + (Math.abs(month + result) + surplus));
        return surplus;
    }


    /**
     * 获得上年最后一天的日期
     *
     * @return
     */
    public String getPreviousYearEnd() {
        weeks--;
        int yearPlus = this.getYearPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, yearPlus + MaxYear * weeks + (MaxYear - 1));
        Date yearDay = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preYearDay = df.format(yearDay);
        getThisSeasonTime(11);
        return preYearDay;
    }

    /**
     * 获得本季度
     *
     * @return
     */
    public String getThisSeasonTime(int month) {
        int array[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int season = 1;
        if (month >= 1 && month <= 3) {
            season = 1;
        }
        if (month >= 4 && month <= 6) {
            season = 2;
        }
        if (month >= 7 && month <= 9) {
            season = 3;
        }
        if (month >= 10 && month <= 12) {
            season = 4;
        }
        int start_month = array[season - 1][0];
        int end_month = array[season - 1][2];

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
        String years = dateFormat.format(date);
        int years_value = Integer.parseInt(years);

        int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
        int end_days = getLastDayOfMonth(years_value, end_month);
        String seasonDate = years_value + "-" + start_month + "-" + start_days + ";" + years_value + "-" + end_month
                + "-" + end_days;
        return seasonDate;

    }

    /*
     * 计算日期的上一个月
     */
    public static String getPrevMonthDate(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - n);
        return new SimpleDateFormat("yyyy-MM").format(calendar.getTime());

    }


    /**
     * 获取某年某月的最后一天
     *
     * @param year  年
     * @param month 月
     * @return 最后一天
     */
    private int getLastDayOfMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
        return 0;
    }

    /**
     * 是否闰年
     *
     * @param year 年
     * @return
     */
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static Calendar parseDateTime(String baseDate) {
        Calendar cal = null;
        cal = new GregorianCalendar();
        int yy = Integer.parseInt(baseDate.substring(0, 4));
        int mm = Integer.parseInt(baseDate.substring(5, 7)) - 1;
        int dd = Integer.parseInt(baseDate.substring(8, 10));
        int hh = 0;
        int mi = 0;
        int ss = 0;
        if (baseDate.length() > 12) {
            hh = Integer.parseInt(baseDate.substring(11, 13));
            mi = Integer.parseInt(baseDate.substring(14, 16));
            ss = Integer.parseInt(baseDate.substring(17, 19));
        }
        cal.set(yy, mm, dd, hh, mi, ss);
        return cal;
    }

    public int DateDiff(String strDateBegin, String strDateEnd, int iType) {
        Calendar calBegin = parseDateTime(strDateBegin);
        Calendar calEnd = parseDateTime(strDateEnd);
        long lBegin = calBegin.getTimeInMillis();
        long lEnd = calEnd.getTimeInMillis();
        int ss = (int) ((lBegin - lEnd) / 1000L);
        int min = ss / 60;
        int hour = min / 60;
        int day = hour / 24;
        if (iType == 0)
            return hour;
        if (iType == 1)
            return min;
        if (iType == 2)
            return day;
        else
            return -1;
    }

    public static Date getMonthFirst() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // calendar.setTime(new Date());// 设置当前日期
        int day = calendar.getMinimum(Calendar.DAY_OF_MONTH);// 取得当前月的最小日期(天)
        calendar.set(Calendar.DAY_OF_MONTH, day);// 设置天
        return calendar.getTime();
    }

    public static Date getMonthEnd() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // calendar.setTime(new Date());// 设置当前日期
        int day = calendar.getMaximum(Calendar.DAY_OF_MONTH);// 取得当前月的最小日期(天)
        calendar.set(Calendar.DAY_OF_MONTH, day);// 设置天
        return calendar.getTime();
    }

    /**
     * 获取当前时间天数最后时间点
     *
     * @return
     */
    public static Date getCrrDayEndTime() {
        Long crrTime = System.currentTimeMillis();
        String crrStr = TimeHandleUtils.longToDateStr(crrTime, TimeHandleUtils.FORMAT_YMD_STRING) + " 23:59:59";
        return TimeHandleUtils.strToDate(crrStr, TimeHandleUtils.FORMAT_YMDHMS_STRING);
    }

    /**
     * 获取当前时间前一天最后时间点
     *
     * @return
     */
    public static Date getYesDayEndTime() {
        Long crrTime = System.currentTimeMillis() - TimeHandleUtils.TIME_MILLIS_DAY;
        String crrStr = TimeHandleUtils.longToDateStr(crrTime, TimeHandleUtils.FORMAT_YMD_STRING) + " 23:59:59";
        return TimeHandleUtils.strToDate(crrStr, TimeHandleUtils.FORMAT_YMDHMS_STRING);
    }

    /**
     * 获取某一时间前一天最后时间点
     *
     * @return
     */
    public static Date getDateYesDayEndTime(Date date) {
        Long crrTime = date.getTime() - TimeHandleUtils.TIME_MILLIS_DAY;
        String crrStr = TimeHandleUtils.longToDateStr(crrTime, TimeHandleUtils.FORMAT_YMD_STRING) + " 23:59:59";
        return TimeHandleUtils.strToDate(crrStr, TimeHandleUtils.FORMAT_YMDHMS_STRING);
    }

    /**
     * 获取某一天最后时间点
     *
     * @return
     */
    public static Date getDayEndTime(Date date) {
        Long crrTime = date.getTime();
        String crrStr = TimeHandleUtils.longToDateStr(crrTime, TimeHandleUtils.FORMAT_YMD_STRING) + " 23:59:59";
        return TimeHandleUtils.strToDate(crrStr, TimeHandleUtils.FORMAT_YMDHMS_STRING);
    }

    /**
     * 获取某一天开始时间点
     *
     * @return
     */
    public static Date getDayStartTime(Date date) {
        Long crrTime = date.getTime();
        String crrStr = TimeHandleUtils.longToDateStr(crrTime, TimeHandleUtils.FORMAT_YMD_STRING) + " 00:00:00";
        return TimeHandleUtils.strToDate(crrStr, TimeHandleUtils.FORMAT_YMDHMS_STRING);
    }


    /**
     * 获取当天的天数
     *
     * @return
     */
    public static Integer getDays(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //获取当天的日
        int day = calendar.get(DAY_OF_MONTH);
        System.out.println(day);
        return day;
    }

    /**
     * 判断日期是不是月末
     *
     * @param date
     * @return
     */
    public static boolean isMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DATE) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 传递当前时间 把日期往前减少N天
     *
     * @param date
     * @return
     */
    public static Date getDate(Date date, Integer day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -day);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return TimeHandleUtils.strToDate(dateString, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 传递当天数 如果是月初 返回上一个月一号
     * 如果不是月初返回当前月初一号
     * <p>
     * 如果不过传递  根据当前月份返回  上上个月月初   或者上月月初
     *
     * @param crrDay
     * @return
     */
    public static String resultStartTime(Integer crrDay) {
        String startTime = "";
        if (crrDay == null) {
            Calendar now = Calendar.getInstance();
            //计算出当前日
            Integer dayNum = now.get(Calendar.DAY_OF_MONTH);

            //如果是月初
            if (dayNum.intValue() == 1) {
                //取上上个月 第一天
                startTime = TimeHandleUtils.getPreviousMonthFirstFirst();
            } else {
                //取上个月 第一天
                startTime = TimeHandleUtils.getPreviousMonthFirst();
            }
        } else {
            //如果是月初
            if (crrDay.intValue() == 1) {
                //取上个月 第一天
                startTime = TimeHandleUtils.getPreviousMonthFirst();
            } else {
                //否则取当前月份第一天
                startTime = TimeHandleUtils.getFirstDayOfMonth();
            }
        }
        return startTime;
    }


    /**
     * 返回两个时间间隔内的所有日期
     *
     * @param dateStart eg：2017-1-1
     * @param dateEnd   eg:2019-9-25
     * @return java.util.List<java.lang.String>
     * @Title: getTwoDaysDay
     */

    public static List<String> getTwoDaysDay(String dateStart, String dateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<String> dateList = new ArrayList<String>();

        try {
            Date dateOne = sdf.parse(dateStart);
            Date dateTwo = sdf.parse(dateEnd);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateOne);

            dateList.add(sdf.format(dateOne));
            while (calendar.getTime().before(dateTwo)) {
                calendar.add(Calendar.DAY_OF_MONTH, +1);
                dateList.add(sdf.format(calendar.getTime()));
            }
        } catch (Exception e) {
        }
        return dateList;
    }


    /**
     * 获取两个日期之间的日期
     *
     * @param dateOne
     * @param dateTwo
     * @return
     */
    public static List<Date> getBetweenTwoDaysDay(Date dateOne, Date dateTwo) {
        List<Date> dateList = new ArrayList<>();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateOne);
            dateList.add(dateOne);
            while (calendar.getTime().before(dateTwo)) {
                calendar.add(Calendar.DAY_OF_MONTH, +1);
                dateList.add(calendar.getTime());
            }
        } catch (Exception e) {
        }
        return dateList;
    }

    /**
     * 获取月开始时间
     *
     * @param time
     * @return
     */
    public static Date getMonthBegin(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        //设置为1号,当前日期既为本月第一天
        cal.set(Calendar.DAY_OF_MONTH, 1);
        //将小时置为0
        cal.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟置为0
        cal.set(Calendar.MINUTE, 0);
        //将秒置为0
        cal.set(Calendar.SECOND, 0);
        //将毫秒置为0
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getMonthEnd(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        //设置为当月最后一天
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时置为23
        cal.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟置为59
        cal.set(Calendar.MINUTE, 59);
        //将秒置为59
        cal.set(Calendar.SECOND, 59);
        //将毫秒置为999
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }


    /**
     *      * 获取两个日期之间的所有日期(字符串格式, 按天计算)
     *      *
     *      * @param startTime String 开始时间 yyyy-MM-dd
     *      * @param endTime  String 结束时间 yyyy-MM-dd
     *      * @return
     *      
     */
    public static List<String> getBetweenDates(String start, String end) {
        List<String> result = new ArrayList<String>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start_date = sdf.parse(start);
            Date end_date = sdf.parse(end);
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start_date);
            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end_date);
            while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
                result.add(sdf.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *      * 获取两个日期之间的所有日期(字符串格式, 按天计算)
     *      *
     *      * @param startTime String 开始时间 yyyy-MM-dd
     *      * @param endTime  String 结束时间 yyyy-MM-dd
     *      * @return
     *      
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) {
        List<String> result = new ArrayList<String>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();

            min.setTime(sdf.parse(minDate));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(maxDate));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

}
