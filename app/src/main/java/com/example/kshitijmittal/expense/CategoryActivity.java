package com.example.kshitijmittal.expense;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class CategoryActivity extends AppCompatActivity {
    int i,size=12;
    public static final int REQUEST_CODE = 2;
    Textstyle title;
    Toolbar toolbar;
    GridView Categorys;
    Data data=new Data();
    Budget budget;
    List<Budget> CategoryList=new ArrayList<>();
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

    }


    private void prepareData(){
        Categorys.setAdapter(categoryAdapter);
        Budget budget;
        for(i=0;i<size;i++){
        budget=data.returnData(i);
            CategoryList.add(budget);
        }
    }


    public void onCancel(View view){
        Intent i = new Intent(CategoryActivity.this, MainActivity.class);
        startActivity(i);
    }

}
