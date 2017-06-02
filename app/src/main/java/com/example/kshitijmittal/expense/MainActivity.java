package com.example.kshitijmittal.expense;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
  String titlev[]=new String[12],leftoverv[]=new String[12];
    int imagev[]=new int[12],valuev[]=new int[12];

    String title[]=new String[]{"Bills","Cash","Eating out",
                                  "General","Groceries","Housing",
                                    "Leisure","Personal Care","Shopping",
                                        "Transfer","Transport","Travel"};
    String[] leftover= new String[]{"₹ 20 left to spend","₹ 20 left to spend","₹ 20 left to spend",
                                    "₹ 20 left to spend","₹ 20 left to spend","₹ 20 left to spend",
                                    "₹ 20 left to spend","₹ 20 left to spend","₹ 20 left to spend",
                                    "₹ 20 left to spend","₹ 20 left to spend","₹ 20 left to spend"};
    Integer[] image= {R.drawable.icon_bills, R.drawable.icon_cash, R.drawable.icon_eating,
                        R.drawable.icon_general,R.drawable.icon_groceries,R.drawable.icon_housing,
                         R.drawable.icon_leisure,R.drawable.icon_personal,R.drawable.icon_shopping,
                          R.drawable.icon_transfer,R.drawable.icon_transport,R.drawable.icon_travel};
    int i=0,j=0,n=0;
    public static final int REQUEST_CODE = 1;
    private List<Budget> budgetList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Budgetadapter mAdapter;
    Textstyle editText;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        editText = (Textstyle) findViewById(R.id.toolbar_title);
        editText.setTypeface(null, Typeface.BOLD);
        editText.setText("Set & track your budgets");
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        mAdapter = new Budgetadapter(budgetList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

    }

    private void prepareData() {
        recyclerView.setAdapter(mAdapter);
        Budget budget;
        budgetList.clear();
        for (j = 0; j < n; j++) {
            budget = new Budget(imagev[j], titlev[j], leftoverv[j],valuev[j]);
            budgetList.add(budget);
        }
    }


    public void onAdd(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode,Intent data) {

            if(resultCode == RESULT_OK){
                String category=data.getStringExtra("category");
                int value=data.getIntExtra("value",-1);
                for(i=0;i<n;i++){
                    if(titlev[i].equals(category)){
                        valuev[i]+=value;
                        break;
                    }
                }
                if (i==n){
                    for(i=0;i<12;i++){
                        if(category.equals(title[i])){
                            titlev[n]=title[i];
                            imagev[n]=image[i];
                            leftoverv[n]=leftover[i];
                            valuev[n]=value;
                            n++;
                            break;
                        }
                    }
                }
            prepareData();
            }
            if (resultCode == RESULT_CANCELED) {

            }

    }

}
