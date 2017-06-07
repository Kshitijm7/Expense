package com.example.kshitijmittal.expense;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    SharedPreferences shareddata;
    public static final String mypreference = "mypref";
    int i=0,j=0,n=0;
    private List<Budget> budgetList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Budgetadapter mAdapter;
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
        mAdapter = new Budgetadapter(budgetList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        prepareData();

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(MainActivity.this, AddAmount.class);
                        i.putExtra("positionS", position);
                        startActivity(i);
                    }

                })
        );

    }

    private void prepareData(){
        shareddata =getSharedPreferences(mypreference,Context.MODE_PRIVATE);
        Gson gson =new Gson();
        List<Budget> budgets;
        String json = shareddata.getString("card", "");
        Type type = new TypeToken<ArrayList<Budget>>() {}.getType();
        budgets=gson.fromJson(json,type);
        recyclerView.setAdapter(mAdapter);
        budgetList.clear();
        try{
        for (j = 0; j < budgets.size(); j++) {
            budgetList.add(budgets.get(j));
        }}catch (Exception e){
            Textstyle nobudget=(Textstyle)findViewById(R.id.nobudget);
            nobudget.setText("No Budget yet");
        }
    }


        public void onAdd(View v) {
             Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
             startActivity(intent);
        }

}
