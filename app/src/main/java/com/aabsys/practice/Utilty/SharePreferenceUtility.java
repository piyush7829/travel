package com.aabsys.practice.Utilty;

import android.content.Context;
import android.content.SharedPreferences;

import com.aabsys.practice.MyApp;

public class SharePreferenceUtility  {

    private static String PREFERNCE_NAME = "Utility Activity";
    private static SharePreferenceUtility sharePreferenceUtility;
    private SharedPreferences sharedPreference;

    private SharePreferenceUtility(Context context){
        PREFERNCE_NAME = PREFERNCE_NAME + context.getPackageName();
        this.sharedPreference = context.getSharedPreferences(PREFERNCE_NAME, Context.MODE_PRIVATE);
    }

    public static SharePreferenceUtility getInstance(){
        if(sharePreferenceUtility == null){
            sharePreferenceUtility = new SharePreferenceUtility(MyApp.getContext());
        }
        return sharePreferenceUtility;
    }

    public void saveString(String key, String val){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString(key, val);
        editor.commit();
    }

    public String getString(String key, String defVal){
        return  sharedPreference.getString(key, defVal);
    }

    public String getString(String key){
        return  sharedPreference.getString(key, "");
    }

}
