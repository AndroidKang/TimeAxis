package com.admin.recyclerview.util;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Info {
    /**
     * 比较日期date是否超过datee
     * date    2017-02-07
     * datee    2017    -02-07
     *
     * @return 0未超过 1当天  2 超过
     */
    public static int compareDate(String date, String datee) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = sdf.parse(datee);//当前日期
            Date date2 = sdf.parse(date);//需要比较的日期
            long lTime1 = date1.getTime() / 1000;
            long lTime2 = date2.getTime() / 1000;
            if (lTime1 < lTime2) {
                return 2;
            } else if (lTime1 == lTime2) {
                return 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 取得结果为年、月、日、星期； 类似：2013年3月17日星期三；
     *
     * @return
     */
    public static String getDateAndWeek() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int w = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        String mDate = c.get(Calendar.YEAR) + "年";
        if ((c.get(Calendar.MONTH) + 1) < 10) {
            mDate = mDate + "0" + (c.get(Calendar.MONTH) + 1) + "月";
        } else {
            mDate = mDate + (c.get(Calendar.MONTH) + 1) + "月";
        }
        if (c.get(Calendar.DATE) < 10) {
            mDate = mDate + "0" + c.get(Calendar.DATE) + "日";
        } else {
            mDate = mDate + c.get(Calendar.DATE) + "日";
        }
        mDate = mDate + weekDays[w];
        return mDate;
    }

    /**
     * 获取系统时间和日期；
     */
    public static String getDateAndTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDateAndTime = sDateFormat.format(new Date());
        return nowDateAndTime;
    }

    public static String getDateAndHourAndMin() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String nowDateAndTime = sDateFormat.format(new Date());
        return nowDateAndTime;
    }

    public static String getTheDateAndHourAndMin() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String nowDateAndTime = sDateFormat.format(new Date());
        return nowDateAndTime;
    }

    public static String getDatee() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDateAndTime = sDateFormat.format(new Date());
        return nowDateAndTime;
    }

    /**
     * 获取系统日期；
     */
    public static String getDate() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String mDate = c.get(Calendar.YEAR) + "年";
        if ((c.get(Calendar.MONTH) + 1) < 10) {
            mDate = mDate + "0" + (c.get(Calendar.MONTH) + 1) + "月";
        } else {
            mDate = mDate + (c.get(Calendar.MONTH) + 1) + "月";
        }
        if (c.get(Calendar.DATE) < 10) {
            mDate = mDate + "0" + c.get(Calendar.DATE) + "日";
        } else {
            mDate = mDate + c.get(Calendar.DATE) + "日";
        }
        return mDate;
    }

    public static String getDate(String link) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String mDate = c.get(Calendar.YEAR) + link;
        if ((c.get(Calendar.MONTH) + 1) < 10) {
            mDate = mDate + "0" + (c.get(Calendar.MONTH) + 1) + link;
        } else {
            mDate = mDate + (c.get(Calendar.MONTH) + 1) + link;
        }
        if (c.get(Calendar.DATE) < 10) {
            mDate = mDate + "0" + c.get(Calendar.DATE);
        } else {
            mDate = mDate + c.get(Calendar.DATE);
        }
        return mDate;
    }

    /**
     * 获取系统时间；
     */
    public static String getTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("HH:mm:ss");
        String nowTime = sDateFormat.format(new Date());
        return nowTime;
    }

    /**
     * 将分钟转化为小时
     *
     * @param mim 要转化的分钟
     * @return 返回 小时：分钟 格式
     */
    public static String formatDuring(long mim) {
        String result;
        long hours = (mim % (60 * 24)) / (60);
        long minutes = (mim % (60)) / (1);
        if (hours < 10) {
            result = "0" + hours;
        } else {
            result = hours + "";
        }
        if (minutes < 10) {
            result = result + ":0" + minutes;
        } else {
            result = result + ":" + minutes;
        }
        return result;
    }

    /**
     * dip转换px；
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 分割字符串
     *
     * @param str       String 原始字符串
     * @param splitsign String 分隔符
     * @return String[] 分割后的字符串数组
     */
    public static String[] split(String str, String splitsign) {
        int index;
        if (str == null || splitsign == null)
            return null;
        ArrayList al = new ArrayList();
        while ((index = str.indexOf(splitsign)) != -1) {
            al.add(str.substring(0, index));
            str = str.substring(index + splitsign.length());
        }
        al.add(str);
        return (String[]) al.toArray(new String[0]);
    }

    /**
     * 替换字符串
     *
     * @param from   String 原始字符串
     * @param to     String 目标字符串
     * @param source String 母字符串
     * @return String 替换后的字符串
     */
    public static String replace(String from, String to, String source) {
        if (source == null || from == null || to == null)
            return null;
        StringBuffer bf = new StringBuffer("");
        int index = -1;
        while ((index = source.indexOf(from)) != -1) {
            bf.append(source.substring(0, index) + to);
            source = source.substring(index + from.length());
            index = source.indexOf(from);
        }
        bf.append(source);
        return bf.toString();
    }

    /**
     * 将字符串转化为int数组
     *
     * @param from String 原始字符串
     * @param to   String 分割字符串
     * @return String[] 转化后的String数组
     */
    public static int[] tranInt(String from, String to) {
        if (from == null || to == null) {
            return null;
        }
        String str[] = from.split(to);
        int ret[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            ret[i] = Integer.parseInt(str[i]);
        }
        return ret;
    }

    /**
     * 将字符串转化为String数组
     *
     * @param from String 原始字符串
     * @param to   String 分割字符串
     * @return String[] 转化后的String数组
     */
    public static String[] tranString(String from, String to) {
        if (from == null || to == null) {
            return null;
        }
        String ret[] = from.split(to);
        return ret;
    }

    /**
     * 判断GPS是否开启，GPS都AGPS开启一个就认为是开启的
     *
     * @param context 上下文菜单
     * @return true 表示开启
     */
    public static boolean isGPSOpen(Context context) {
        LocationManager locationManager
                = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        return gps && network;
    }

    /**
     * 判断是不是身份证号码
     *
     * @param numberCode 身份证号
     * @return 是否格式正确
     */
    public static boolean isNumberCode(String numberCode) {
        Pattern p = Pattern
                .compile("^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$");
        //^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$
        //^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[X])$");
        //^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$
        Matcher m = p.matcher(numberCode);

        return m.matches();
    }

    /**
     * 判断是不是车牌号
     *
     * @param plateNumber 车牌号
     * @return 判断是否是车牌号
     */
    public static boolean isPlateNumber(String plateNumber) {
        String str = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(plateNumber);

        return m.matches();
    }

    /**
     * 判断是否是手机号码；
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8]))\\d{8}$");
        //"^((13|15|18|14)\\d{9})|(0\\d{3}-\\d{8})|(0\\d{3}-\\d{7})$"
        // ^(13|15|18|14)\d{9}$ // 手机号码正则表达式
        // ^(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$ // 全国电话号码判断
        // ^((13|15|18|14)\\d{9})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$ //
        // 手机号以及全国电话号码判断
        Matcher m = p.matcher(mobiles);

        return m.matches();
    }

    /**
     * 判断是否是电话号码；
     *
     * @param tel
     * @return
     */
    public static boolean isTelNO(String tel) {
        Pattern p = Pattern.compile("^((0\\d{2}-\\d{8})|(0\\d{3}-\\d{8})|(\\d{8})|(\\d{7})|(0\\d{3}-\\d{7}))$");
        // ^(13|15|18|14)\d{9}$ // 手机号码正则表达式
        // ^(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$ // 全国电话号码判断
        // ^((13|15|18|14)\\d{9})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$ //
        // 手机号以及全国电话号码判断
        Matcher m = p.matcher(tel);

        return m.matches();
    }

    /**
     * 判断是否是邮箱地址；
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    /**
     * 判断是否是邮政编码；
     *
     * @param postcode
     * @return
     */
    public static boolean isPostcode(String postcode) {
        String str = "^[1-9]\\d{5}(?!\\d)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(postcode);

        return m.matches();
    }

    /**
     * 判断密码是不是满足6-20位英文字母
     *
     * @param psw
     * @return
     */
    public static boolean isPassword(String psw) {
        String str = "^[\\w.]{6,20}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(psw);

        return m.matches();
    }

    /**
     * 判断字符串是不是HTML
     *
     * @return
     */
    public static boolean isHTML(String psw) {
        if (psw.indexOf("<") != -1) {
            return true;
        } else {
            System.out.println("不包含");
            return false;
        }
    }

    /**
     * 判断是否为空或者为Null
     */
    public static boolean isEmptyOrNullString(String str_res) {
        return (str_res == null) || (str_res.trim().length() == 0);
    }

    /**
     * 调用系统打电话界面
     */
    public static void callTelActivity(Context context, String phoneNum) {

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    /**
     * 判断edittext是否null
     */
    public static String checkEditText(EditText editText) {
        if (editText != null && editText.getText() != null
                && !(editText.getText().toString().trim().equals(""))) {
            return editText.getText().toString().trim();
        } else {
            return "";
        }
    }
}