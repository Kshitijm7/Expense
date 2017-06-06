package com.example.kshitijmittal.expense;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends ArrayAdapter {
    public static final String mypreference = "mypref";
    int pos,post;
    Context contextt;
    SharedPreferences shareddata;
    List<Budget> budgets;
    Data data=new Data();
    List<Budget> BudgetList = new ArrayList<>();

    public CategoryAdapter(Context context, int textViewResourceId, List<Budget> objects) {
        super(context, textViewResourceId, objects);
        contextt =context;
        BudgetList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CardView card;
        View v = convertView;
        pos=position;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.categorycard, null);
        card=(CardView) v.findViewById(R.id.card);
        TextView textView = (TextView) v.findViewById(R.id.cardtext);
        ImageView imageView = (ImageView) v.findViewById(R.id.cardicon);
        textView.setText(BudgetList.get(position).getTitle());
        imageView.setImageResource(BudgetList.get(position).getIcon());
        sharedData();
      try{
        for(int i=0;i<budgets.size();i++) {
            post = data.compareData(budgets.get(i).getTitle());
            if (post==-1) {
                card.setAlpha(1f);
                card.setOnClickListener(clickon);
            } else {
                card.setAlpha(0.6f);
                card.setOnClickListener(clickon);
            }
        }}catch (Exception e){
          card.setAlpha(1f);
          card.setOnClickListener(clickon);
      }
        return v;

    }
    public void sharedData(){
        shareddata = contextt.getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = shareddata.getString("card", "");
        Type type = new TypeToken<ArrayList<Budget>>() {}.getType();
        if(gson.fromJson(json, type)!=null)
            budgets = gson.fromJson(json, type);
    }
View.OnClickListener clickon=new View.OnClickListener() {
    @Override
        public void onClick(View v) {
             Intent i = new Intent(contextt, AddAmount.class);
             i.putExtra("positionC", pos);
                contextt.startActivity(i);
         }
    };
}