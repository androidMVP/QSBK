package com.mvp.comm.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * JSON解析工具类
 *
 * @author wangdeyun
 */
public class JsonUtils {

    private final static Gson gson = new Gson();

    public static boolean isGoodJson(String json) {
        if (StringUtils.isEmpty(json)) {
            return false;
        }
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonParseException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * @param json
     * @param clazz
     * @return 解析错误返回null
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        T obj = null;
        try {
            obj = gson.fromJson(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * Map和ArrayList转换
     *
     * @param json
     * @param typeToken Map or ArrayList
     * @return 解析错误返回null
     */
    public static <T> T fromJson(String json, TypeToken<T> typeToken) {
        T obj = null;
        try {
            obj = gson.fromJson(json, typeToken.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 获取泛型类型
     * @param raw
     * @param args
     * @return
     */
    public static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }


    public static String getJsonStringValIgnoreNotExist(JSONObject obj, String key) throws JSONException {
        if (obj.has(key)) {
            return obj.getString(key);
        } else {
            return "";
        }
    }

    /**
     * 读取jsonObject中的值，没有则返回默认值
     *
     * @param obj
     * @param key
     * @param dltVal
     * @return
     * @throws Exception
     */
    public static String getJsonStringValIgnoreNotExist(JSONObject obj, String key, String dltVal) throws Exception {
        if (obj.has(key)) {
            return obj.getString(key);
        } else {
            return dltVal;
        }
    }

    public static Long getJsonLongValIgnoreNotExist(JSONObject obj, String key) throws Exception {
        if (obj.has(key)) {
            return obj.getLong(key);
        }
        return null;
    }

    public static Long getJsonLongValIgnoreNotExist(JSONObject obj, String key, long dltVal) throws Exception {
        if (obj.has(key)) {
            return obj.getLong(key);
        }
        return dltVal;
    }

    public static int getJsonIntegerValIgnoreNotExist(JSONObject obj, String key) throws Exception {
        if (obj.has(key)) {
            return obj.getInt(key);
        }
        return 0;
    }

    public static int getJsonIntegerValIgnoreNotExist(JSONObject obj, String key, int dltVal) throws Exception {
        if (obj.has(key)) {
            return obj.getInt(key);
        }
        return dltVal;
    }

    public static Double getJsonDoubleValIgnoreNotExist(JSONObject obj, String key) throws JSONException {
        if (obj.has(key)) {
            return obj.getDouble(key);
        }
        return null;
    }


    public static boolean getJsonBooleanValIgnoreNotExist(JSONObject obj, String key, boolean defaultVal) throws JSONException {
        if (obj.has(key)) {
            return obj.getBoolean(key);
        }
        return defaultVal;
    }

    public static Double getJsonDoubleValIgnoreNotExist(JSONObject obj, String key, Double defaultVal) throws Exception {
        if (obj.has(key)) {
            return obj.getDouble(key);
        }
        return defaultVal;
    }

    public static JSONObject getJsonObjValIgnoreNotExist(JSONObject obj, String key) throws Exception {
        if (obj.has(key)) {
            return obj.getJSONObject(key);
        } else {
            return null;
        }
    }

    /**
     * 对象转json字符串	add by ljp 20160414
     *
     * @param obj
     * @return
     */
    public static String toJsonStr(Object obj) {
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 转换为json忽略某些属性
     * @param obj
     * @param props
     * @return
     */
    public static String toJsonWithIgnoreProps(Object obj, final String[]props){
        Gson gsonNew=new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                //过滤掉字段名包含"id","address"的字段
                if(props!=null) {
                    for (String prop : props) {
                        if (f.getName().equals(prop)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                //过滤掉 类名包含 Bean的类
                return false;
            }
        }).create();
        return gsonNew.toJson(obj);
    }

    /**
     *
     * @param obj
     * @return
     */
    public static String toJsonArray(Object obj) {
        try {
            JSONArray jsonArray = new JSONArray(gson.toJson(obj));
            return jsonArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


}
