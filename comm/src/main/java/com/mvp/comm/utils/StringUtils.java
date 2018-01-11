package com.mvp.comm.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/9/21.
 */
public class StringUtils {

    /**
     * 判断字符串是否为null或全为空格
     *
     * @param s 待校验字符串
     * @return {@code true}: null或全空格<br> {@code false}: 不为null且不全空格
     */
    public static boolean isSpace(String s) {
        return (s == null || s.trim().length() == 0);
    }
    private static final String MOBILE_REG = "(1[0-9][0-9])[0-9]{9}";

    /**
     * 手机号码格式验证
     *
     * @param mobile
     */
    public static Boolean validMobileStr(String mobile) {
        return Pattern.compile(MOBILE_REG).matcher(mobile).matches();
    }

    public static boolean isBlank(String paramDate) {
        return TextUtils.isEmpty(paramDate);
    }

    // 输入为空返回默认值
    public static String nullToDefault(String input, String defaultStr) {
        return isBlank(input) ? defaultStr : input;
    }

    public static boolean isEmpty(String paramDate) {
        if (paramDate == null || "".equals(paramDate)) {
            return true;
        }
        if ("null".equals(paramDate)) {
            return true;
        }
        return false;
    }

    /**
     * 如果int为null，返回"",否则返回str
     *
     * @param intValue 输入
     * @return
     */
    public static String getStringByDefault(Long intValue, int defaultValue) {
        if (intValue == null) return String.valueOf(defaultValue);
        if (intValue < 0) return "";
        return String.valueOf(intValue.longValue());
    }

    /**
     * 如果str为null，返回"",否则返回str
     *
     * @param str 输入字符串
     * @return
     */
    public static String getStringByDefault(String str) {
        return getStringByDefault(str, "");
    }

    /**
     * 如果str为null，返回defaultValue,否则返回str
     *
     * @param str          输入字符串
     * @param defaultValue 默认值
     * @return
     */
    public static String getStringByDefault(String str, String defaultValue) {
        if (str == null) return defaultValue;
        return str;
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }


    public static String convertNullString(Object param) {
        if (param == null) {
            return "0";
        }
        return param + "";
    }

    /**
     * 处理字符串不为null
     *
     * @param src
     * @param defaut
     * @return
     */
    public static String getNotNullString(String src, String defaut) {
        if (src == null || "".equals(src)) {
            return defaut;
        }
        return src;
    }

    /**
     * 判断字符串的长度：一个汉字或日韩文长度为2,英文字符长度为1
     *
     * @param s
     * @return
     */
    public static int length(String s) {
        if (s == null)
            return 0;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }

    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }

    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    public static Double toDouble(String str) {
        return toDouble(str, null);
    }

    public static Double toDouble(String str, Double defaultValue) {
        try {
            return Double.valueOf(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Boolean toBoolean(String str) {
        return toBoolean(str, null);
    }

    public static Boolean toBoolean(String str, Boolean defaultValue) {
        try {
            return Boolean.valueOf(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Long toLong(String str) {
        return toLong(str, null);
    }

    public static Long toLong(String str, Long defaultValue) {
        try {
            return Long.valueOf(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Float toFloat(String str) {
        return toFloat(str, null);
    }

    public static Float toFloat(String str, Float defaultValue) {
        try {
            return Float.valueOf(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Byte toByte(String str) {
        return toByte(str, null);
    }

    public static Byte toByte(String str, Byte defaultValue) {
        try {
            return Byte.valueOf(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Integer toInteger(String str) {
        return toInteger(str, null);
    }

    public static Integer toInteger(String str, Integer defaultValue) {
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }


    /**
     * 首字母小写
     *
     * @param content
     * @return
     */
    public static String toLowerCaseFirstOne(String content) {
        if (Character.isLowerCase(content.charAt(0)))
            return content;
        else
            return (new StringBuilder()).append(Character.toLowerCase(content.charAt(0))).append(content.substring(1)).toString();
    }

    public static List<Long> str2LongList(String seatIds) {
        if (TextUtils.isEmpty(seatIds)) {
            return null;
        }
        List<Long> seatIdList;
        seatIdList = new ArrayList<>();
        String[] ids = seatIds.split(",");
        for (String id : ids) {
            if (!TextUtils.isEmpty(id) && NumberUtil.isNumeric(id)) {
                seatIdList.add(Long.valueOf(id));
            }
        }
        return seatIdList;
    }

    /**
     * 验证字符串是否手机号位数
     *
     * @param phone
     * @return
     */
    public static boolean isPhoneCodeBit(String phone) {
        return null != phone && phone.length() == 11;
    }

    /**
     * 设置商品打印机编号
     *
     * @param dbPrinterIds
     * @param reqPrinterId
     * @param opeType      操作类型：0-添加 1-取消
     * @return
     */
    public static String printerIdExists(String dbPrinterIds, Long reqPrinterId, int opeType) {
        if (StringUtils.isEmpty(dbPrinterIds)) {
            if (opeType == 0) {
                //添加
                return reqPrinterId + "";
            } else if (opeType == 1) {
                //删除
                return null;
            }
        }

        String[] strings = dbPrinterIds.split(",");
        int len = strings.length;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < len; i++) {
            Long tempId = NumberUtil.getLong(strings[i]);
            if (!(tempId.longValue() == reqPrinterId.longValue())) {
                sb.append("" + tempId).append(",");
            }
        }
        if (opeType == 0) {
            //添加
            sb.append(reqPrinterId + "");
        }
        return sb.toString();
    }

    public static String trim(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        str = str.trim();
        int length = str.length();
        char start = str.charAt(0);
        char end = str.charAt(length - 1);
        if (start == ',' && end == ',') {
            return str.substring(1, length - 2);
        } else if (start == ',') {
            return str.substring(1, length - 1);
        } else if (end == ',') {
            return str.substring(0, length - 2);
        } else {
            return str;
        }
    }

    public static String listToString(List list, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i));
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    /**
     * 获取字符串后几位 有效防止溢出
     *
     * @param str
     * @param num
     * @return
     */
    public static String getLastNumStr(String str, int num) {
        StringBuffer sb = new StringBuffer(num);
        if (!isEmpty(str)) {
            char[] chars = str.toCharArray();
            int index = -1;
            for (int i = chars.length; i > 0; i--) {
                index++;
                if (index < num) {
                    char c = chars[i - 1];
                    sb.append(c);
                    continue;
                }
                break;
            }

        }
        return sb.reverse().toString();
    }

    /**
     * 获取前几位
     *
     * @param str
     * @param num
     * @return
     */
    public static String getFirstNumStr(String str, int num) {
        if (isEmpty(str)) return "";
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i >= num) {
                break;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    /**
     * 将数组转换为List
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T> List<T> convertArrayToList(T array[]) {
        List<T> list = new ArrayList<T>();
        for (T t : array) {
            list.add(t);
        }
        return list;
    }

    /**
     * 处理手机号码
     * <p>例：15899773751 -> 158****3751</p>
     *
     * @param mobile
     * @return
     */
    public static String dealMobile(String mobile) {
        if (isEmpty(mobile)) return "";
        return new StringBuffer().append(getFirstNumStr(mobile, 3)).append("****").append(getLastNumStr(mobile, 4)).toString();
    }

    public static void main(String[] args) {
        /*String str = "15899773751";
        System.out.println(str = insertSpaceMobile(str));
        System.out.println(placeMobileSpace(str));


        str = "15899773";
        System.out.println(str = insertSpaceMobile(str));
        System.out.println(placeMobileSpace(str));

        str = "1589";
        System.out.println(str = insertSpaceMobile(str));
        System.out.println(placeMobileSpace(str));

        str = "158";
        System.out.println(str = insertSpaceMobile(str));
        System.out.println(placeMobileSpace(str));*/

        /*PushMessage message = new PushMessage();
        message.setAction("beMaker");
        message.setMoney(new BigDecimal(100));
        System.out.println(message.getContent());*/


        String str = "的副驾驶的、似懂非懂";
        System.out.println(str.substring(0,str.indexOf("、")));
    }


    /**
     * 匹配字母加数字
     */
    public static boolean isPwd(String str) {
        Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,32}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static String showMaxLenght(String content, int length) {
        return content.substring(0, content.length() > length ? length : content.length());
    }

    public static String showMaxLenghtShoEnd(String content, int length) {
        if (content.length() > length) {
            return content.substring(0, length) + "...";
        } else {
            return content;
        }
    }


    /**
     * 修改手机号码为158 9977 3751格式
     *
     * @param mobile
     * @return
     */
    public static String insertSpaceMobile(String mobile) {
        if (!StringUtils.isEmpty(mobile)) {
            StringBuilder sb = new StringBuilder(mobile.trim().replaceAll(" ", ""));
            if (sb.length() >= 4) {
                sb.insert(3, " ");
            }
            if (sb.length() >= 8) {
                sb.insert(8, " ");
            }
            return sb.toString().trim();
        }
        return mobile;
    }

    /**
     * 去除手机号码中的空格，如：将158 9977 3751 修改为15899773751
     *
     * @param mobile
     * @return
     */
    public static String placeMobileSpace(String mobile) {
        if (!StringUtils.isEmpty(mobile)) {
            return mobile.replace(" ", "");
        }
        return mobile;
    }

    /**
     * 提取出城市或者县
     * @param city
     * @param district
     * @return
     */
    public static String extractLocation(final String city, final String district){

        return district.contains("县") ? district.substring(0, district.length() - 1) : city.substring(0, city.length() - 1);
    }
}
