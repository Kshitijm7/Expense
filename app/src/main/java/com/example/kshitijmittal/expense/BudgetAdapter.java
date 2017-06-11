package com.example.kshitijmittal.expense;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.MyViewHolder> {


    Context context;
    private List<Budget> Budgetlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, leftover, value;
        public ImageView icon;
        public ProgressBar bar;
        public CardView container;


        public MyViewHolder(View view) {
            super(view);
            container=(CardView)view.findViewById(R.id.container);
            title = (TextView) view.findViewById(R.id.title);
            leftover = (TextView) view.findViewById(R.id.leftover);
            value = (TextView) view.findViewById(R.id.value);
            icon = (ImageView) view.findViewById(R.id.icon);
            bar=(ProgressBar)view.findViewById(R.id.progressBar);

        }
    }


    public BudgetAdapter(Context context,List<Budget> Budgetlist) {
        this.Budgetlist = Budgetlist;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.budgetcard, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Budget budget = Budgetlist.get(position);
        holder.title.setText(budget.getTitle());
        holder.leftover.setText(budget.getLeftover());
        holder.value.setText(String.valueOf(budget.getValue()));
        holder.icon.setImageResource(budget.getIcon());
        holder.bar.setProgress(budget.getProgress());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddAmount.class);
                i.putExtra("positionS", holder.getAdapterPosition());
                context.startActivity(i);
                ((MainActivity)context).finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return Budgetlist.size();
    }
}
