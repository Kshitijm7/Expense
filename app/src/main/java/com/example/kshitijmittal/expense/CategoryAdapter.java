package com.example.kshitijmittal.expense;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends ArrayAdapter {

    List<Budget> BudgetList = new ArrayList<>();

    public CategoryAdapter(Context context, int textViewResourceId, List<Budget> objects) {
        super(context, textViewResourceId, objects);
        BudgetList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.categorycard, null);
        TextView textView = (TextView) v.findViewById(R.id.cardtext);
        ImageView imageView = (ImageView) v.findViewById(R.id.cardicon);
        textView.setText(BudgetList.get(position).getTitle());
        imageView.setImageResource(BudgetList.get(position).getIcon());
        return v;

    }

}