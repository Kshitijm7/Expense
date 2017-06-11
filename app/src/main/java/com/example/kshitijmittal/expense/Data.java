package com.example.kshitijmittal.expense;

import java.util.ArrayList;
import java.util.List;

public class Data {
    static int size=12;
    Budget budget;
    List<Budget> budgets=new ArrayList<>();

    public Data(){
        budget=new Budget(1,R.drawable.icon_bills,"Bills","₹ 10 left to spend",0,"#3F51B5");
        budgets.add(budget);
        budget=new Budget(2,R.drawable.icon_cash,"Cash","₹ 20 left to spend",0,"#FFC107");
        budgets.add(budget);
        budget=new Budget(3,R.drawable.icon_eating,"Eating out","₹ 30 left to spend",0,"#64B5F6");
        budgets.add(budget);
        budget=new Budget(4,R.drawable.icon_general,"General","₹ 40 left to spend",0,"#607D8B");
        budgets.add(budget);
        budget=new Budget(5,R.drawable.icon_groceries,"Groceries","₹ 50 left to spend",0,"#AD1457");
        budgets.add(budget);
        budget=new Budget(6,R.drawable.icon_housing,"Housing","₹ 60 left to spend",0,"#8BC34A");
        budgets.add(budget);
        budget=new Budget(7,R.drawable.icon_leisure,"Leisure","₹ 70 left to spend",0,"#00BCD4");
        budgets.add(budget);
        budget=new Budget(8,R.drawable.icon_personal,"Personal Care","₹ 80 left to spend",0,"#FF3D00");
        budgets.add(budget);
        budget=new Budget(9,R.drawable.icon_shopping,"Shopping","₹ 90 left to spend",0,"#D32F2F");
        budgets.add(budget);
        budget=new Budget(10,R.drawable.icon_transfer,"Transfer","₹ 100 left to spend",0,"#2196F3");
        budgets.add(budget);
        budget=new Budget(11,R.drawable.icon_transport,"Transport","₹ 110 left to spend",0,"#FFC107");
        budgets.add(budget);
        budget=new Budget(12,R.drawable.icon_travel,"Travel","₹ 120 left to spend",0,"#FF8F00");
        budgets.add(budget);

    }


    public int compareId(int id){
        int i;
              for (i=0;i<size;i++){
                  if(id==budgets.get(i).getId())
                      break;
              }
        if (i==size)i=-1;
        return i;
    }

    public Budget returnData(int i){
    return budgets.get(i);
    }

    public List<Budget> returnDataList(){
        return budgets;
    }

    public int compareData(String search){
        int i;
        for (i=0;i<size;i++){
            if(search.equals(budgets.get(i).getTitle()))
            break;
        }
        if (i==size)i=-1;
        return i;
    }
}
