package com.example.kshitijmittal.expense;

import android.content.Intent;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Data {
    Budget budget;
    List<Budget> budgets=new ArrayList<>();


    public void preparedata(){
        budget=new Budget(R.drawable.icon_bills,"Bills","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_cash,"Cash","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_eating,"Eating out","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_general,"General","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_groceries,"Groceries","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_housing,"Housing","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_leisure,"Leisure","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_personal,"Personal Care","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_shopping,"Shopping","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_transfer,"Transfer","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_transport,"Transport","₹ 20 left to spend",0);
        budgets.add(budget);
        budget=new Budget(R.drawable.icon_travel,"Travel","₹ 20 left to spend",0);
        budgets.add(budget);

    }


    public Budget returnData(int i){
    return budgets.get(i);
    }

}
