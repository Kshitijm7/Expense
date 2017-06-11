package com.example.kshitijmittal.expense;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;



public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<Budget> categoryList;
    private List<Budget> budgets;
    Context context;
    private SharedPref pref;

    public CategoryAdapter(Context context,List<Budget> categoryList) {
        this.context=context;
        this.categoryList = categoryList;
        pref = new SharedPref(context);
        budgets=pref.getPref();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView card;
        public Textstyle title;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            card=(CardView) view.findViewById(R.id.card);
            title = (Textstyle) view.findViewById(R.id.cardtext);
            icon = (ImageView) view.findViewById(R.id.cardicon);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = categoryList.get(getAdapterPosition()).getId();
                    boolean flag=true;
                    for (int j = 0; j < getbudgetcount(); j++) {
                        if (id==budgets.get(j).getId()) {flag=false;break;}
                    }
                    if(flag==true) {
                        Intent i = new Intent(context, AddAmount.class);
                        i.putExtra("positionC", getAdapterPosition());
                        context.startActivity(i);
                        ((CategoryActivity)context).finish();
                    }
                }
            });
        }


        public int getbudgetcount(){
            try{return budgets.size();}
            catch (Exception e){return 0;}
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categorycard, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Budget budget = categoryList.get(position);
        holder.title.setText(budget.getTitle());
        holder.icon.setImageResource(budget.getIcon());
       try {
            for (int j = 0; j < budgets.size(); j++) {
                if (budget.getTitle().equals(budgets.get(j).getTitle())) {
                    holder.card.setAlpha(0.6f);
                    break;
                }
            }
        }
        catch (Exception e) {}

    }


  /*  View.OnClickListener onclickcat=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, AddAmount.class);

            i.putExtra("positionC",holder.getAdapterPosition());
            context.startActivity(i);
        }
    };*/
    @Override
    public int getItemCount() {
        return categoryList.size();
    }

}
