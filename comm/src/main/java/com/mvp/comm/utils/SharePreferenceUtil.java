package com.mvp.comm.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.mvp.comm.base.AppUtil;

import java.util.Set;

/**
 * SharePreference工具类
 *
 * @author wangdeyun
 */
public class SharePreferenceUtil {

    private static SharedPreferences sp;
    private static SharedPreferences second_cachd_sp;//二级缓存数据存放
    private final static String SharePreferncesName = "SP_CUSTOMER_APP";
    public final static String SECOND_CACHE_NAME = "second_cache";
    static {
        sp = AppUtil.applicaion.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        second_cachd_sp = AppUtil.applicaion.getSharedPreferences(SECOND_CACHE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * @param context
     * @param key
     * @param value
     * @return 是否保存成功
     */
    public static boolean setValue(Context context, String key, Object value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        Editor edit = sp.edit();
        if (value instanceof String) {
            return edit.putString(key, (String) value).commit();
        } else if (value instanceof Boolean) {
            return edit.putBoolean(key, (Boolean) value).commit();
        } else if (value instanceof Float) {
            return edit.putFloat(key, (Float) value).commit();
        }
        /*
        else if (value instanceof Integer) {
            return edit.putInt(key, (Integer) value).commit();
        } else if (value instanceof Long) {
            return edit.putLong(key, (Long) value).commit();
        }
        */
        else if (value instanceof Set) {
            new IllegalArgumentException("Value can not be Set object!");
            return false;
        }
        return false;
    }
    public static boolean setValue(Context context, String key, long value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        Editor edit = sp.edit();
        return edit.putLong(key, value).commit();
    }
    public static boolean setValue(Context context, String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        Editor edit = sp.edit();
        return edit.putInt(key, value).commit();
    }


    public static boolean getBoolean(Context context, String key) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, false);
    }

    public static String getString(Context context, String key) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        return sp.getString(key, "");
    }

    public static String getString(Context context, String key, String defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    public static Float getFloat(Context context, String key) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        return sp.getFloat(key, 0f);
    }

    public static int getInt(Context context, String key) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, 0);
    }

    public static long getLong(Context context, String key) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        return sp.getLong(key, 0);

    }

    public static void remove(Context context, String... key) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        for (int i = 0; i < key.length; i++) {
            sp.edit().remove(key[i]).commit();
        }
    }

    public static void remove(Context context, String key) {
        if (sp == null) {
            sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
        }
        sp.edit().remove(key).commit();
    }

    /**
     * @param key
     * @param value
     * @return 是否保存成功
     */
    public static void setCacheValue(String key, String value) {
        Editor edit = second_cachd_sp.edit();
        edit.putString(key, value).apply();
    }

    /**
     * 获取缓存值
     * @param key
     * @return
     */
    public static String getCacheValue(String key) {
        return second_cachd_sp.getString(key,"");
    }

    /**
     * 清除缓存
     * @param key
     */
    public static void removeCache(String key) {
        second_cachd_sp.edit().remove(key).apply();
    }
}
