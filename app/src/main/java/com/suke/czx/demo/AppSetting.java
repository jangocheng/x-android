package com.suke.czx.demo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by czx on 2017/7/13.
 */

public class AppSetting {

    private static Context context;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static AppSetting instance;

    public static AppSetting Initial(Context inContext) {
        context = inContext;
        sharedPreferences = context.getSharedPreferences(AppConstant.SETTING_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (instance == null) {
            synchronized (AppSetting.class) {
                if (instance == null) {
                    instance = new AppSetting();
                }
            }
        }
        return instance;
    }

    public void setStringPreferences(String key,String value){
        editor.putString(key, value);
        editor.apply();
        editor.commit(); //提交修改
    }

    public String getStringPreferences(String key){
        return sharedPreferences.getString(key, null);
    }

    public void setIntPreferences(String key,int value){
        editor.putInt(key, value);
        editor.apply();
        editor.commit(); //提交修改
    }

    public int getIntPreferences(String key){
        return sharedPreferences.getInt(key, 0);
    }


    public void removePreferences(String key){
        editor.remove(key);
        editor.commit(); //提交修改
    }

    public void setBooleanPreferences(String key,Boolean value){
        editor.putBoolean(key, value);
        editor.apply();
        editor.commit(); //提交修改
    }

    public Boolean getBooleanPreferences(String key){
        return sharedPreferences.getBoolean(key, false);
    }
}
