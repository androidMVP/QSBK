package com.mvp.comm.utils;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * 张鹏程
 * Created by Administrator on 2015/10/9.
 */
public class NumberUtil {

    /**
     * 数字和两位小数点
     *
     * @param str
     * @return
     */
    public static boolean isNumericAndDigdats(String str) {
        Pattern pattern = Pattern
                .compile("[1-9]\\d+\\.[0-9]{1,2}|0\\.[0-9]{1,2}|[1-9]\\d+|0$");
        return pattern.matcher(str).matches();
    }

    public static double sub(double d1, double d2) {        // 进行减法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 取小数点后两位
     *
     * @param doubleValue
     * @return
     */
    public static double getPriceDouble(double doubleValue) {
        return ((long) (doubleValue * 100)) / 100d;
    }

    /**
     * 格式化两个斜杠符号
     * @return
     */
    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

    public static double div(double d1,
                             double d2, int len) {// 进行除法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.divide(b2, len, BigDecimal.
                ROUND_HALF_UP).doubleValue();
    }

    /**
     * 返回价格 默认小数精度为 2
     *
     * @param doubleValue
     * @return
     */
    public static BigDecimal getPriceDecimal(double doubleValue) {
        return getPriceDecimal(doubleValue, 2);
    }

    /**
     * 返回价格 默认小数精度为 2
     *
     * @param doubleValue 值
     * @param scale       精度
     * @return
     */
    public static BigDecimal getPriceDecimal(double doubleValue, int scale) {
        BigDecimal bigDecimal = new BigDecimal(doubleValue);
        return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 返回价格 默认小数精度为 2
     *
     * @param priceValue 值
     * @param scale      精度
     * @return
     */
    public static BigDecimal getPriceDecimal(String priceValue, int scale) {
        BigDecimal bigDecimal = new BigDecimal(priceValue);
        return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 如果为空，返回0
     *
     * @param d1
     * @return
     */
    public static long getValue(Long d1) {
        return getValue(d1, 0);
    }

    public static long getValue(Long d1, long defaultValue) {
        if (d1 == null) return defaultValue;
        return d1;
    }

    /**
     * 如果为空，返回0
     *
     * @param d1
     * @return
     */
    public static double getValue(Double d1) {
        return getValue(d1, 0);
    }

    /**
     * 返回值
     *
     * @param d1
     * @param defaultValue 如果为空返回默认值
     * @return
     */
    public static double getValue(Double d1, double defaultValue) {
        if (d1 == null) return defaultValue;
        return d1;
    }

    public static Double add(double d1, double d2) {        // 进行加法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.add(b2).doubleValue();
    }

    public static double formatDouble(double num) {
        DecimalFormat df = new DecimalFormat("#.000");
        double result = getDouble(df.format(num));
        return result;
    }

    /**
     * 格式化double数据，保留len长度小数，自动四舍五入
     *
     * @param num
     * @param len
     * @return
     */
    public static double formatDouble(double num, int len) {
        BigDecimal bd = new BigDecimal(num + "");
        bd = bd.setScale(len, BigDecimal.ROUND_DOWN);
        double result = bd.doubleValue();
        return result;
    }

    /**
     * 按给定位数截取浮点数
     *
     * @param num
     * @param len
     * @return
     */
    public static double cutDouble(double num, int len) {
        StringBuilder fm = new StringBuilder("#.");
        for (int i = 0; i < len; i++) {
            fm.append("0");
        }
        DecimalFormat df = new DecimalFormat(fm.toString());
        double result = NumberUtil.getDouble(df.format(num));
        return result;
    }

    /**
     * 按给定位数截取浮点数
     *
     * @param num
     * @param len
     * @return
     */
    public static double cutDouble(String num, int len) {
        StringBuilder fm = new StringBuilder("#.");
        for (int i = 0; i < len; i++) {
            fm.append("0");
        }
        DecimalFormat df = new DecimalFormat(fm.toString());
        double result = NumberUtil.getDouble(df.format(Double.valueOf(num)));
        return result;
    }

    /**
     * 截取两位小数
     *
     * @param num
     * @return
     */
    public static String cut2DoubleStr(double num) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(num);
    }

    /**
     * 截取两位小数
     *
     * @param numStr
     * @return
     */
    public static String cut2DoubleStr(String numStr) {
        if (TextUtils.isEmpty(numStr)) {
            numStr = "0";
        }
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(numStr);
    }

    /**
     * 格式化double数据，保留2位小数，自动四舍五入并放回字符串
     *
     * @param num
     * @return
     */
    public static String format2DoubleStr(String num) {
        if (TextUtils.isEmpty(num)) {
            num = "0";
        }
        BigDecimal bigDecimal = new BigDecimal(num + "");
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.toString();
    }

    /**
     * 格式化double数据，保留2位小数，自动四舍五入并放回字符串
     *
     * @param num
     * @return
     */
    public static String format2DoubleStr(double num) {
        BigDecimal bigDecimal = new BigDecimal(num + "");
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.toString();
    }

    /**
     * 格式化double数据，保留2位小数，自动四舍五入并返回double
     *
     * @param num
     * @return
     */
    public static double format2Double(double num) {
        BigDecimal bigDecimal = new BigDecimal(num + "");
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

    /**
     * 截掉小数点取整
     *
     * @param num
     * @return
     */
    public static String formatDoubleToInt(double num) {
        String numStr = num + "";
        if (numStr.indexOf(".") > -1) {
            numStr = numStr.substring(0, numStr.indexOf("."));
        }
        return numStr;
    }

    /**
     * 截掉小数点取整
     *
     * @param num
     * @return
     */
    public static int doublieToInt(double num) {
        return NumberUtil.getInteger(formatDoubleToInt(num));
    }


    /**
     * 转换
     *
     * @param longStr
     * @param defaultLong
     * @return
     */
    public static long parseLong(String longStr, long defaultLong) {
        try {
            if (!TextUtils.isEmpty(longStr)) {
                return NumberUtil.getLong(longStr);
            } else {
                return defaultLong;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return defaultLong;
        }

    }

    /**
     * 格式化double数据保留len小数
     *
     * @param @param  num
     * @param @param  len
     * @param @return
     * @return double 返回类型
     * @throws
     * @Title: formatFloat
     */
    public static double fmtDouble(double num, int len) {
        String fmt = "";
        for (int i = 0; i < len; i++) {
            fmt += "0";
        }
        DecimalFormat df = new DecimalFormat("#." + fmt);
        double result = NumberUtil.getDouble(df.format(num));
        return result;
    }

    /**
     * 判断字符串是否能转换成double
     *
     * @param numStr
     * @return
     */
    public static boolean isDouble(String numStr) {
        boolean isDouble = false;
        try {
            NumberUtil.getDouble(numStr);
            isDouble = true;
        } catch (Exception e) {
            isDouble = false;
        }
        return isDouble;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static boolean isPositInt(Integer num) {
        if (num == null || num <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 是否正整数
     *
     * @param num 不等于空并且大于0为正整数
     * @return
     */
    public static boolean isPositLong(Long num) {
        if (num == null || num <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 计算数字字符串有效的小数位数
     *
     * @param digit 数字字符串
     * @return 有效的小数位数
     */
    public static int getValidDecimals(String digit) {
        boolean flag = false;
        do {
            if (!digit.contains(".")) {
                return 0;
            }
            int len = digit.length() - 1;
            String lastChar = digit.charAt(len) + "";
            if (lastChar.equals("0")) {
                digit = digit.substring(0, len);
                flag = true;
            } else {
                if (".".equals(lastChar)) {
                    digit = digit.substring(0, len);
                }
                flag = false;
            }
            // System.out.println(digit);
        }
        while (flag);
        BigDecimal bigD = new BigDecimal(digit);
        return bigD.scale();
    }

    /**
     * 去除double型数据小数点后的位数
     * 如果小数点后的位数全部为0，则删除
     * 否则，返回自己
     *
     * @param num
     * @return
     */
    public static String delPointAfterZero(Double num) {
        try {
            String numStr = num + "";
            int index = numStr.indexOf(".");
            String pointNumStr = numStr.substring(index + 1);
            Integer pointNum = NumberUtil.getInteger(pointNumStr);
            if (pointNum > 0) {
                return numStr;
            } else {
                return numStr.substring(0, index);
            }
        } catch (Exception e) {
            return "0";
        }
    }


    /**
     * 去除double型数据小数点后的位数
     * 如果小数点后的位数全部为0，则删除
     * 否则，返回自己
     *
     * @param num
     * @return
     */
    public static String delPointAfterZero(BigDecimal num) {
        if (null == num) return "0";
        String result = num.toString();
        try {
            if (result.indexOf(".") > 0) {
                result = result.replaceAll("0+?$","");
                result = result.replaceAll("[.]$", "");
            }
        } catch (Exception e) {
            return "0";
        }
        return result;
    }

    /**
     * 去除double型数据小数点后的位数
     * 如果小数点后的位数全部为0，则删除
     * 否则，返回自己
     *
     * @param result
     * @return
     */
    public static String delPointAfterZero(String result) {
        if (StringUtils.isEmpty(result)) return "0";
        try {
            if (result.indexOf(".") > 0) {
                result = result.replaceAll("0+?$","");
                result = result.replaceAll("[.]$", "");
            }
        } catch (Exception e) {
            return "0";
        }
        return result;
    }

    /**
     * 比较两个双精度包装类型值的大小
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean compareDouble(Double d1, Double d2) {
        try {
            if (null == d1) {
                return d2 == null;
            }
            if (null == d2) {
                return false;
            }
            BigDecimal bd1 = new BigDecimal(d1 + "");
            BigDecimal bd2 = new BigDecimal(d2 + "");
            int re = bd1.compareTo(bd2);
            return (re == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * BigDecimal转Double
     * <p>规则：
     * <p>当num为null时返回0
     *
     * @param num
     * @return
     */
    public static double bigDec2DoubleWithDefVal(BigDecimal num) {
        double val = 0;
        if (num == null) {
            return 0;
        }
        val = num.doubleValue();
        return val;
    }

    /**
     * BigDecimal转Double
     * <p>规则：
     * <p>当num为null时返回0;
     * <p>四舍五入保留2位小数;
     *
     * @param num
     * @return
     */
    public static double bigDec2DoubleWithDefValScale(BigDecimal num) {
        double val = 0;
        if (num == null) {
            return 0;
        }
        val = NumberUtil.format2Double(num.doubleValue());
        return val;
    }

    /**
     * 默認0
     *
     * @param number
     * @return
     */
    public static Integer getInteger(String number) {
        return getInteger(number, 0);
    }

    /**
     * @param number
     * @param defaultValue
     * @return
     */
    public static Integer getInteger(String number, Integer defaultValue) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defaultValue;
        }

    }

    /**
     * 默認0
     *
     * @param number
     * @return
     */
    public static Double getDouble(String number) {
        return getDouble(number, 0D);
    }


    public static Boolean getBoolean(String number) {
        return getBoolean(number, false);
    }

    /**
     * @param number
     * @param defaultValue
     * @return
     */
    public static Double getDouble(String number, Double defaultValue) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static Boolean getBoolean(String valuse, boolean defaultValue) {
        try {
            return Boolean.parseBoolean(valuse);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    /**
     * 默認0
     *
     * @param number
     * @return
     */
    public static Long getLong(String number) {
        return getLong(number, 0L);
    }

    /**
     * @param number
     * @param defaultValue
     * @return
     */
    public static Long getLong(String number, Long defaultValue) {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    /**
     * 获取BigDecimal的值，如果为空，则返回默认值dltVal
     * @param bigDecimal
     * @param dltVal
     * @return
     */
    public static BigDecimal getBigDecimal(BigDecimal bigDecimal,BigDecimal dltVal) {
        if (null == bigDecimal) {
            return dltVal;
        }
        return bigDecimal;
    }

    /**
     * 获取BigDecimal的值，如果为空，则返回默认值dltVal
     * @param bigDecimal
     * @return
     */
    public static BigDecimal getBigDecimalDltZero(BigDecimal bigDecimal) {
        if (null == bigDecimal) {
            return new BigDecimal("0.00");
        }
        return bigDecimal;
    }

    /**
     * 比较当前值是否大于0 大于返回true 小于等于返回false
     * @param bigDecimal
     * @return
     */
    public static boolean compareZero(BigDecimal bigDecimal) {
        return bigDecimal.compareTo(new BigDecimal(0)) > 0;
    }


    /**
     * 比较两个值 大于返回true 小于等于返回false
     * @param bigDecimal
     * @return
     */
    public static boolean compareGt(BigDecimal bigDecimal,BigDecimal bg2) {
        return bigDecimal.compareTo(bg2) > 0;
    }

    /**
     * 比较两个值是否相等
     * @param b1
     * @param b2
     * @return
     */
    public static boolean compareEq(BigDecimal b1,BigDecimal b2) {
        return b1.compareTo(b2) == 0;
    }

    /**
     * 比较两个值 大于等于返回true 小于等于返回false
     * @param bigDecimal
     * @return
     */
    public static boolean compareGtAndEq(BigDecimal bigDecimal,BigDecimal bg2) {
        return bigDecimal.compareTo(bg2) >= 0;
    }

    private static final  double EARTH_RADIUS = 6378137;//赤道半径
    private static double rad(double d){
        return d * Math.PI / 180.0;
    }
    public static double getDistance(double lon1,double lat1,double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 *Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        return s;//单位米
    }


    /**
     * 多个数相加
     * @param bigDecimals
     * @return
     */
    public static BigDecimal add(BigDecimal ...bigDecimals) {
        BigDecimal result = new BigDecimal(0);
        if (null == bigDecimals || bigDecimals.length <= 0) {
            return result;
        }
        for (int i = 0; i < bigDecimals.length; i++) {
            BigDecimal b = bigDecimals[i];
            if (null != b) {
                result = result.add(b);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        BigDecimal d = new BigDecimal("125.0320");
        System.out.println(d + "-" + delPointAfterZero(d));

        d = new BigDecimal("125.030");
        System.out.println(d + "-" + delPointAfterZero(d));

        d = new BigDecimal("125.0032");
        System.out.println(d + "-" + delPointAfterZero(d));

        d = new BigDecimal("125.0");
        System.out.println(d + "-" + delPointAfterZero(d));

        String re = "14,125.0";
        System.out.println(re + "-" + delPointAfterZero(re));

        re = "14,125.0320";
        System.out.println(re + "-" + delPointAfterZero(re));

        re = "14,125.0201";
        System.out.println(re + "-" + delPointAfterZero(re));
    }

}
