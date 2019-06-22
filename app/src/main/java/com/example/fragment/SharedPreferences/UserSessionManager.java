package com.example.fragment.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.ContactsContract;

import java.util.HashMap;

import static android.accounts.AccountManager.KEY_PASSWORD;

public class UserSessionManager {

    //String

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "MMS";

    // All Shared Preferences Keys
    //private static final String KEY_IS_WAITING_FOR_SMS = "IsWaitingForSms";
    private static final String KEY_ID="UserId";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    //private static final String KEY_PASSWORD = "password";
     private static final String KEY_NUMBER = "number";
//    private static final String KEY_MOBILE = "mobile";


    public UserSessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setMobileNumber(String email) {
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }

    public String getMobileNumber() {
        return pref.getString(KEY_EMAIL, null);
    }



    public void createLogin(String UserId, String email,String name, String number) {
        editor.putString(KEY_ID, UserId);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_NUMBER, number);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
    }


    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> profile = new HashMap<>();
        profile.put("UserId", pref.getString(KEY_ID, null));
        profile.put("email", pref.getString(KEY_EMAIL, null));
        profile.put("name", pref.getString(KEY_NAME, null));
        profile.put("number", pref.getString(KEY_NUMBER, null));


        return profile;
    }

}