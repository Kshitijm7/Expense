package com.example.kshitijmittal.expense;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.util.ArrayList;
import java.util.List;


public class CategoryActivity extends AppCompatActivity {
    final int size=12,columns=3;
    int i;
    Textstyle title;
    Toolbar toolbar;
    RecyclerView Categorys;
    Context mcontext;
    Data data=new Data();
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

        Categorys=(RecyclerView) findViewById(R.id.gridlayout);
        Categorys.setLayoutManager(new GridLayoutManager(this, columns));

        CategoryList=data.returnDataList();

        mcontext=this;
        categoryAdapter= new CategoryAdapter(mcontext,CategoryList);
        Categorys.setAdapter(categoryAdapter);

    }


/*
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
        String json = shareddata.getString(mypreferencekey, "");
        Type type = new TypeToken<ArrayList<Budget>>() {}.getType();
        if(gson.fromJson(json, type)!=null)
            budgets = gson.fromJson(json, type);
    }
*/
    public void onCancel(View view){
        Intent i = new Intent(CategoryActivity.this, MainActivity.class);
        startActivity(i);
    }

}
