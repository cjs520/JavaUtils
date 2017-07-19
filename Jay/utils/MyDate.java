package com.Jay.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Jay on 17/7/18-11:01.
 *
 * @version 1.0
 */

public class MyDate {

    private SimpleDateFormat dfYYYYsMMsDD = null;

    private SimpleDateFormat dfYYsMMsDD = null;

    private SimpleDateFormat dfYYYYMMDD = null;

    private SimpleDateFormat dfYYMMDD = null;

    private SimpleDateFormat dfYYYYhMMhDD = null;

    private SimpleDateFormat dfYYhMMhDD = null;

    private SimpleDateFormat dfYYYYMMDDHHMMSS = null;

    private SimpleDateFormat dfYYYYsMMsDDsHHcMMcSS = null;

    private SimpleDateFormat dfYYYYsMMsDDsHHcMMcSSpSSS = null;

    private SimpleDateFormat dfHHcMMcSS = null;

    private SimpleDateFormat dfHHMMSS = null;

    private SimpleDateFormat dfMMsDD = null;
    private SimpleDateFormat dfYYYYMMDDHHMMSSSSS = null;
    private Date    date;
    private GregorianCalendar calendar =
            (GregorianCalendar) Calendar.getInstance();

    /**
     * 获取当前时间
     */
    public MyDate() {
        date=new Date();
        calendar.setTime(date);
    }

    /**
     * 生成指定的时间的MyDate
     * @param source 指定的时间
     */
    public MyDate(MyDate source) {
        this.date = source.date;
        calendar.setTime(this.date);
    }

    /**
     *分析指定的字符串，并生成的MyDate。
     *它对应于以下字符串。
     * 2001/02/03<br>
     * 01/02/03<br>
     * 20010203<br>
     * 010203<br>
     * 2001-02-03<br>
     * 01-02-03<br>
     * 20010203151617<br>
     * 2001/02/03 15:16:17<br><br>
     *
     * 指定的字符串中有“/”。 <br>
     *     1. 11 个数字或更多  --->  [2001/02/03 15:16:17]<br>
     *     2. 9-10 个数字         --->  [2001/02/03]<br>
     *     3. 8 个数字或更少  --->  [01/02/03]<br><br>
     * 指定字符串中的“ - ”不包括上述内容。<br>
     *     1.  9 个数字或更多   --->  [2001-02-03]<br>
     *     2.  8 个数字或更少   --->  [01-02-03]<br><br>
     * 不包括上述内容<br>
     *     1.  9 个数字或更多   --->  [20010203151617]<br>
     *     2.  7-8 个数字          --->  [20010203]<br>
     *     3.  6 个数字   --->  [010203]<br><br>
     * @param dateStr  指定的字符串
     * @throws ParseException
     */
    public MyDate(String dateStr) throws ParseException {
        int length = dateStr.length();
        if (0 <= dateStr.indexOf('/')) {
            if (19 < length) {
                dfYYYYsMMsDDsHHcMMcSSpSSS = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
                date = dfYYYYsMMsDDsHHcMMcSSpSSS.parse(dateStr);
            }else if (10 < length) {
                dfYYYYsMMsDDsHHcMMcSS = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                date = dfYYYYsMMsDDsHHcMMcSS.parse(dateStr);
            } else if (8 < length) {
                dfYYYYsMMsDD =	new SimpleDateFormat("yyyy/MM/dd");
                date = dfYYYYsMMsDD.parse(dateStr);
            } else {
                dfYYsMMsDD = new SimpleDateFormat("yy/MM/dd");
                date = dfYYsMMsDD.parse(dateStr);
            }
        } else if (0 <= dateStr.indexOf('-')) {
            if (8 < length) {
                dfYYYYhMMhDD = new SimpleDateFormat("yyyy-MM-dd");
                date = dfYYYYhMMhDD.parse(dateStr);
            } else {
                dfYYhMMhDD = new SimpleDateFormat("yy-MM-dd");
                date = dfYYhMMhDD.parse(dateStr);
            }
        } else {
            if (8 < length) {
                dfYYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
                date = dfYYYYMMDDHHMMSS.parse(dateStr);
            } else if (6 < length) {
                dfYYYYMMDD = new SimpleDateFormat("yyyyMMdd");
                date = dfYYYYMMDD.parse(dateStr);
            } else {
                dfYYMMDD = new SimpleDateFormat("yyMMdd");
                date = dfYYMMDD.parse(dateStr);
            }
        }
        calendar.setTime(date);
    }

    /**
     *生成指定的日期的MyDate
     * @param date 日期
     */
    public MyDate(Date date) {
        this.date = date;
        calendar.setTime(date);
    }

    /**
     * 生成从1970/1/1 00:00:00 GMT起的时间毫秒时间显示的MyDate。
     * @param time Millisecond from epoch
     */
    public MyDate(long time) {
        date = new Date(time);
        calendar.setTime(date);
    }

    /**
     * 以默认格式（2001/01/01）获取字符串的方法。
     * @return 格式化后的字符串
     */
    public String toString() {
        return toYYYYsMMsDD();
    }

    /**
     * 获得2001/01/01形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYYYsMMsDD() {
        if(dfYYYYsMMsDD == null){
            dfYYYYsMMsDD =	new SimpleDateFormat("yyyy/MM/dd");
        }
        return dfYYYYsMMsDD.format(date);
    }

    /**
     * 获得01/01/01形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYsMMsDD() {
        if(dfYYsMMsDD == null){
            dfYYsMMsDD =	new SimpleDateFormat("yy/MM/dd");
        }
        return dfYYsMMsDD.format(date);
    }

    /**
     *  获得20010101形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYYYMMDD() {
        if(dfYYYYMMDD == null){
            dfYYYYMMDD =	new SimpleDateFormat("yyyyMMdd");
        }
        return dfYYYYMMDD.format(date);
    }

    /**
     * 获得010101 形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYMMDD() {
        if(dfYYMMDD == null){
            dfYYMMDD = new SimpleDateFormat("yyMMdd");
        }
        return dfYYMMDD.format(date);
    }

    /**
     * 获得2001-01-01 形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYYYhMMhDD() {
        if(dfYYYYhMMhDD == null){
            dfYYYYhMMhDD = new SimpleDateFormat("yyyy-MM-dd");
        }
        return dfYYYYhMMhDD.format(date);
    }

    /**
     * 获得01-01-01 形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYhMMhDD() {
        if(dfYYhMMhDD == null){
            dfYYhMMhDD = new SimpleDateFormat("yy-MM-dd");
        }
        return dfYYhMMhDD.format(date);
    }

    /**
     * 获得20010101000000 形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYYYMMDDHHMMSS() {
        if(dfYYYYMMDDHHMMSS == null){
            dfYYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
        }
        return dfYYYYMMDDHHMMSS.format(date);
    }

    /**
     * 获得2001/01/01 00:00:00 形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYYYsMMsDDsHHcMMcSS() {
        if(dfYYYYsMMsDDsHHcMMcSS == null){
            dfYYYYsMMsDDsHHcMMcSS = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        }
        return dfYYYYsMMsDDsHHcMMcSS.format(date);
    }

    /**
     * The character string of the form is acquired at 00:00:00.
     * @return 格式化后的字符串
     */
    public String toHHcMMcSS() {
        if(dfHHcMMcSS == null){
            dfHHcMMcSS = new SimpleDateFormat("HH:mm:ss");
        }
        return dfHHcMMcSS.format(date);
    }

    /**
     * The character string of 000000 forms (second of the season) is acquired.
     * @return 格式化后的字符串
     */
    public String toHHMMSS() {
        if(dfHHMMSS == null){
            dfHHMMSS = new SimpleDateFormat("HHmmss");
        }
        return dfHHMMSS.format(date);
    }

    /**
     * 获得01/01 形式的字符串。
     * @return 格式化后的字符串
     */
    public String toMMsDD() {
        if(dfMMsDD == null){
            dfMMsDD = new SimpleDateFormat("MM/dd");
        }
        return dfMMsDD.format(date);
    }

    /**
     * 判断自指定日期起是否存在该日期。
     * @param when 日期
     * @return 当不是早于指定时间时，返回false
     */
    public boolean before(MyDate when) {
        return date.before(when.date);
    }

    /**
     * 判断自指定日期起是否存在该日期
     * @param when 日期
     * @return 当不是晚于指定时间时，返回false
     */
    public boolean after(MyDate when) {

        return date.after(when.date);
    }

    /**
     * 获取年份
     * 显示的年份返回四位数的方法
     * @return 四位数的年份
     */
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 判断闰年
     * 判断显示的年份是否闰年的方法
     * @return 是闰年返回TRUE，反之FALSE
     */
    public boolean isLeapYear() {
        return calendar.isLeapYear(getYear());
    }

    /**
     * 判断闰天
     * 判断显示的日子是否闰年的二月二十九日。
     * @return 是闰天返回true，反之false
     */
    public boolean isLeapDay() {

        return calendar.isLeapYear(getYear()) && getMonth()==2 && getDate()==29;
    }

    /**
     * 获取月份
     * 返回哪一个月的方法
     * @return 月份
     */
    public int getMonth() {
        return calendar.get(Calendar.MONTH)+1;
    }

    /**
     * 获取天数
     * 返回显示月份的哪一天的方法
     * @return 一个月的哪一天
     */
    public int getDate() {
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取星期几
     * 判断是星期几的方法。
     * 它由Calendar类的字段的值返回。
     * @return A day of the week（以星期天为第一天）
     * @see Calendar#SUNDAY 1
     * @see Calendar#MONDAY 2
     * @see Calendar#TUESDAY 3
     * @see Calendar#WEDNESDAY 4
     * @see Calendar#THURSDAY 5
     * @see Calendar#FRIDAY 6
     * @see Calendar#SATURDAY 7
     */
    public int getDayOfWeek() {
        return calendar.get(Calendar.DAY_OF_WEEK)-1;
    }

    /**
     * 获取时
     * 显示的时间点由24小时系统的值返回的方法
     * @return 24小时 （0-23）
     */
    public int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取分钟
     * 显示的时间点返回分钟的方法
     * @return 分钟
     */
    public int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取秒
     * 显示的时间点返回秒的方法
     * @return 秒
     */
    public int getSecond() {
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 获取毫秒
     * 显示的时间点返回毫秒的方法
     * @return 毫秒
     */
    public int getMilliSecond() {
        return calendar.get(Calendar.MILLISECOND);
    }

    /**
     * 加年
     * The year is advanced to the extent that specified. 
     * 当参数为负值时，年份返回。
     * @param value 加几年 如果是负值，返回年份.
     */
    public void addYear(int value) {
        calendar.add(Calendar.YEAR, value);
        date = calendar.getTime();
    }

    /**
     * 加月
     * The month is advanced to the extent that specified. 
     * 当参数为负值时，月份返回。
     * @param value 加几月。 如果为负值，则返回月数。
     */
    public void addMonth(int value) {
        calendar.add(Calendar.MONTH, value);
        date = calendar.getTime();
    }

    /**
     * 加天
     * The day is advanced to the extent that specified. 
     * 当参数为负值时，该日期返回。
     * The result will advance after next month when this object shows the end of the month.
     * @param value 加几天。 如果为负值，则返回天数
     */
    public void addDate(int value) {
        calendar.add(Calendar.DATE, value);
        date = calendar.getTime();
    }

    /**
     * 获取时间
     * @return Date data Date对象
     */
    public Date toDate() {
        return date;
    }

    /**
     * 返回1970/1/1在00:00:00 GMT的毫秒数。
     * @return Millisecond
     */
    public long getTime() {
        return date.getTime();
    }



    /**
     * 获得2001 形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYYY() {
        if(dfYYYYMMDD == null){
            dfYYYYMMDD = new SimpleDateFormat("yyyyMMdd");
        }
        return dfYYYYMMDD.format(date).substring(0,4);
    }

    /**
     * 获取月份
     * @return 格式化后的字符串
     */
    public String toMM() {
        if(dfYYYYMMDD == null){
            dfYYYYMMDD =	new SimpleDateFormat("yyyyMMdd");
        }
        return dfYYYYMMDD.format(date).substring(4,6);
    }
    /**
     * 获取天数
     * @return 格式化后的字符串
     */
    public String toDD() {
        if(dfYYYYMMDD == null){
            dfYYYYMMDD =	new SimpleDateFormat("yyyyMMdd");
        }
        return dfYYYYMMDD.format(date).substring(6,8);
    }

    /**
     * 获得20010101000000000 形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYYYMMDDHHMMSSSSS() {
        if(dfYYYYMMDDHHMMSSSSS == null){
            dfYYYYMMDDHHMMSSSSS =	new SimpleDateFormat("yyyyMMddHHmmssSSS");
        }
        return dfYYYYMMDDHHMMSSSSS.format(date);
    }

    /**
     * 获得2001/01/01/ 00:00:00.000 形式的字符串。
     * @return 格式化后的字符串
     */
    public String toYYYYsMMsDDbHHcMMcSSpSSS() {
        if(dfYYYYMMDDHHMMSSSSS == null){
            dfYYYYMMDDHHMMSSSSS =	new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        }
        return dfYYYYMMDDHHMMSSSSS.format(date);
    }

    /**
     *返回日期是这一年的第几个星期的方法
     * @return 当前日期是一年的第几个星期
     */
    public int countweek(){
        Calendar cal = Calendar.getInstance();
        //取当前日期的年份里面的周数
        int currentWeekOfYear = cal.get(Calendar.WEEK_OF_YEAR);

       return currentWeekOfYear;
    }








}
