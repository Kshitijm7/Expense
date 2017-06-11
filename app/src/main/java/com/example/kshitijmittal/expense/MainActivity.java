package com.example.kshitijmittal.expense;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Budget> budgetList = new ArrayList<>();
    private SharedPref pref;
    Context context;
    private RecyclerView recyclerView;
    private BudgetAdapter mAdapter;
    Textstyle title;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        title = (Textstyle) findViewById(R.id.toolbar_title);
        title.setText(R.string.settrack);
        title.setTypeface(null, Typeface.BOLD);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        context=this;
        pref=new SharedPref(context);
        budgetList.clear();
        budgetList=pref.getPref();
        try {
                if(budgetList.isEmpty()){throw new Exception("");}
                mAdapter = new BudgetAdapter(context, budgetList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(mAdapter);
            }catch (Exception e){
                Textstyle nobudegt=(Textstyle)findViewById(R.id.nobudget);
                nobudegt.setText(R.string.nobuget);
        }
    }


        public void onAdd(View v) {
             Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
             startActivity(intent);
            finish();
        }

}
