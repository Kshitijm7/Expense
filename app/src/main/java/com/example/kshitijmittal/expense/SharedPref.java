package com.example.kshitijmittal.expense;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class SharedPref {
    public static final String mypreference = "mypref";
    public static final String mypreferencekey = "card";
    Context context;
    public SharedPreferences shareddata;
    public Editor editor;
    public List<Budget> input;

    public SharedPref(Context context) {
        this.context=context;
    }

    public List<Budget> getPref(){

        shareddata =context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = shareddata.getString(mypreferencekey, "");
        Type type = new TypeToken<ArrayList<Budget>>() {}.getType();
        if(gson.fromJson(json, type)!=null)
            input = gson.fromJson(json, type);
    return input;}

    public void setPref(List<Budget> output) {
        Gson gson=new Gson();
        String json = gson.toJson(output);
        editor =shareddata.edit();
        editor.putString(mypreferencekey, json);
        editor.commit();
    }

}
