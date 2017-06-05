package com.example.kshitijmittal.expense;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.w3c.dom.Text;

public class AddAmount extends AppCompatActivity {
    Toolbar toolbar;
    Data data=new Data();
    Budget budget;
    int s;
    String carddetail[]=new String[]{"#3F51B5","#FFC107","#64B5F6", "#607D8B","#AD1457","#8BC34A","#00BCD4","#FF3D00","#D32F2F","#2196F3","#FFC107","#FF8F00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amount);
        s=getIntent().getIntExtra("position",0);
        budget=data.returnData(s);

        Textstyle title=(Textstyle)findViewById(R.id.toolbar_title);
        title.setText(budget.getTitle());
        title.setTypeface(null, Typeface.BOLD);

        int color= Color.parseColor(carddetail[s]);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
        toolbar=(Toolbar)findViewById(R.id.toolbar1);
        toolbar.setBackgroundColor(color);
        EditText value=(EditText)findViewById(R.id.value);
        Textstyle plus=(Textstyle)findViewById(R.id.plus),
                minus=(Textstyle)findViewById(R.id.minus),
                currency=(Textstyle)findViewById(R.id.currency);
        Button set=(Button)findViewById(R.id.set);
        ImageView icon=(ImageView)findViewById(R.id.imageView);
        plus.setTextColor(color);
        minus.setTextColor(color);
        currency.setTextColor(color);
        value.setTextColor(color);
        set.setTextColor(color);
        icon.setImageResource(budget.getIcon());


    }
    public void onPlus(View view){
        EditText value=(EditText)findViewById(R.id.value);
        int val=Integer.parseInt(value.getText().toString());
        val=val+500;
        if(val>10000000)val=10000000;
        value.setText(String.valueOf(val));
    }

    public void onMinus(View view){
        EditText value=(EditText)findViewById(R.id.value);
        int val=Integer.parseInt(value.getText().toString());
        val=val-500;
        if(val<0)val=0;
        value.setText(String.valueOf(val));
    }

    public void onSet(View view){
        EditText value=(EditText)findViewById(R.id.value);
        int val=Integer.parseInt(value.getText().toString());
        Intent output = new Intent();
        output.putExtra("position",s);
        output.putExtra("value",val);
        setResult(RESULT_OK, output);
        finish();

    }
}
