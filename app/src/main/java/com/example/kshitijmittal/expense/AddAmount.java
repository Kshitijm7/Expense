package com.example.kshitijmittal.expense;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddAmount extends AppCompatActivity {
    public static final String mypreference = "mypref";

    Button set;
    EditText value;
    int val;

    SharedPreferences shareddata;
   SharedPreferences.Editor editor;
    Data data=new Data();
    Budget budget;
    List<Budget> budgets;
    int i=-1,s=-1,j;
    String carddetail[]=new String[]{"#3F51B5","#FFC107","#64B5F6",
                                       "#607D8B","#AD1457","#8BC34A",
                                          "#00BCD4","#FF3D00","#D32F2F",
                                              "#2196F3","#FFC107","#FF8F00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent x = getIntent();
        setContentView(R.layout.activity_add_amount);
        set=(Button)findViewById(R.id.set);
        value=(EditText)findViewById(R.id.value);
        val=Integer.parseInt(value.getText().toString());
        budgets=new ArrayList<>();
        i=x.getIntExtra("positionS",-1);
        if(i==-1){
            s=x.getIntExtra("positionC",-1);
        }else if(i!=-1) {
           sharedData();
            value.setText(String.valueOf(budgets.get(i).getValue()));
            val=budgets.get(i).getValue();
            s = data.compareData(budgets.get(i).getTitle());
        }
            budget = data.returnData(s);
        Textstyle title=(Textstyle)findViewById(R.id.toolbar_title);
        title.setText(budget.getTitle());
        title.setTypeface(null, Typeface.BOLD);



        int color= Color.parseColor(carddetail[s]);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar1);
        EditText value=(EditText)findViewById(R.id.value);
        Textstyle plus=(Textstyle)findViewById(R.id.plus),
                minus=(Textstyle)findViewById(R.id.minus),
                currency=(Textstyle)findViewById(R.id.currency);
        Button set=(Button)findViewById(R.id.set);
        ImageView icon=(ImageView)findViewById(R.id.imageView);

        toolbar.setBackgroundColor(color);
        plus.setTextColor(color);
        minus.setTextColor(color);
        currency.setTextColor(color);
        value.setTextColor(color);
        set.setTextColor(color);
        icon.setImageResource(budget.getIcon());

        set.setOnClickListener(pressSet);

    }

    public void onPlus(View view){
        val=val+500;
        if(val>10000000)val=10000000;
        if(val>0){ set.setAlpha(1f);
            set.setOnClickListener(pressSet);
        }
        value.setText(String.valueOf(val));
    }

    public void onMinus(View view){
        val=val-500;
        if(val==0){ set.setAlpha(0.6f);
            set.setOnClickListener(null);
        }
        else if(val<0)val=0;
        value.setText(String.valueOf(val));
    }

    final OnClickListener pressSet = new OnClickListener() {
        public void onClick( View v) {
            if(i==-1) {
                sharedData();
                budget.setValue(val);
                budgets.add(budget);
            }
            if(i>-1) {
                budgets.get(i).setValue(val);
            }

            setBudget("card",budgets);
            Intent intent = new Intent(AddAmount.this, MainActivity.class);
            startActivity(intent);
        }
    };

    public <Budget> void setBudget(String key, List<Budget> Budgets) {
        Gson gson = new Gson();
        String json = gson.toJson(Budgets);
        set(key, json);
    }

    public void set(String key, String value) {
        editor =shareddata.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void sharedData(){
        shareddata = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = shareddata.getString("card", "");
        Type type = new TypeToken<ArrayList<Budget>>() {}.getType();
        if(gson.fromJson(json, type)!=null)
        budgets = gson.fromJson(json, type);
    }

    public void onCancel(View view){
        if(i==-1) {
            Intent i = new Intent(AddAmount.this, CategoryActivity.class);
            startActivity(i);
        }else{
            Intent i = new Intent(AddAmount.this, MainActivity.class);
            startActivity(i);
        }
    }
}
