package com.example.kshitijmittal.expense;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CategoryActivity extends AppCompatActivity {
    int i,size=12;
    public static final String mypreference = "mypref";
    public SharedPreferences shareddata;
    Textstyle title;
    Toolbar toolbar;
    GridView Categorys;
    Data data=new Data();
    Budget budget;
    List<Budget> CategoryList=new ArrayList<>();
    List<Budget> budgets=new ArrayList<>();
    CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle("");
        title=(Textstyle)findViewById(R.id.toolbar_title);
        title.setTypeface(null, Typeface.BOLD);
        title.setText("Category");
        Categorys=(GridView)findViewById(R.id.gridview);
        categoryAdapter=new CategoryAdapter(this,R.layout.categorycard,CategoryList);
        prepareData();
        Categorys.setOnItemClickListener(clickon);
    }


    private void prepareData(){
        Categorys.setAdapter(categoryAdapter);
        Budget budget;
        for(i=0;i<size;i++){
        budget=data.returnData(i);
            CategoryList.add(budget);
        }
    }

    OnItemClickListener clickon=new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            int flag=0;
            sharedData();
            try {
                for (int j = 0; j < budgets.size(); j++) {
                    if (data.returnData(position).getTitle().equals(budgets.get(j).getTitle())) {
                        flag=1;
                    }
                }
            } catch (Exception e) {
               flag=0;
            }

            if(flag==1){}
            else {
                        Intent i = new Intent(CategoryActivity.this, AddAmount.class);
                        i.putExtra("positionC", position);
                        startActivity(i);
                    }

        }
    };

    public void sharedData(){
        shareddata =getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = shareddata.getString("card", "");
        Type type = new TypeToken<ArrayList<Budget>>() {}.getType();
        if(gson.fromJson(json, type)!=null)
            budgets = gson.fromJson(json, type);
    }

    public void onCancel(View view){
        Intent i = new Intent(CategoryActivity.this, MainActivity.class);
        startActivity(i);
    }

}
