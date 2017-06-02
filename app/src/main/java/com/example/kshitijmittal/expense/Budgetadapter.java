package com.example.kshitijmittal.expense;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Budgetadapter extends RecyclerView.Adapter<Budgetadapter.MyViewHolder> {

    private List<Budget> Budgetlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, leftover, value;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            leftover = (TextView) view.findViewById(R.id.leftover);
            value = (TextView) view.findViewById(R.id.value);
            icon = (ImageView) view.findViewById(R.id.icon);
        }
    }


    public Budgetadapter(List<Budget> Budgetlist) {
        this.Budgetlist = Budgetlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.budgetcard, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Budget budget = Budgetlist.get(position);
        holder.title.setText(budget.getTitle());
        holder.leftover.setText(budget.getLeftover());
        holder.value.setText(String.valueOf(budget.getValue()));
        holder.icon.setImageResource(budget.getIcon());
    }

    @Override
    public int getItemCount() {
        return Budgetlist.size();
    }
}
