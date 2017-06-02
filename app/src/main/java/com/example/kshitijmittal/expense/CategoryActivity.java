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
import android.widget.Toast;


public class CategoryActivity extends AppCompatActivity {

    int card[]=new int[]{R.id.card11,R.id.card12,R.id.card13,
                          R.id.card21,R.id.card22,R.id.card23,
                           R.id.card31,R.id.card32,R.id.card33,
                            R.id.card41,R.id.card42,R.id.card43,};
    String carddetail[]=new String[]{"#3F51B5","#FFC107","#64B5F6", "#607D8B","#AD1457","#8BC34A","#00BCD4","#FF3D00","#D32F2F","#2196F3","#FFC107","#FF8F00"};
            String cardname[]=new String[]{"Bills","Cash","Eating out","General","Groceries","Housing","Leisure","Personal Care","Shopping","Transfer","Transport","Travel"};
    Integer[] image= {R.drawable.icon_bills, R.drawable.icon_cash, R.drawable.icon_eating,
                      R.drawable.icon_general,R.drawable.icon_groceries,R.drawable.icon_housing,
                      R.drawable.icon_leisure,R.drawable.icon_personal,R.drawable.icon_shopping,
                      R.drawable.icon_transfer,R.drawable.icon_transport,R.drawable.icon_travel};
    int i;
    Textstyle title;
   Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle("");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#79CA7B"));
        }
        title=(Textstyle)findViewById(R.id.toolbar_title);
        title.setTypeface(null, Typeface.BOLD);
        title.setText("Category");
    }


   public void onClick(View view) {
        setContentView(R.layout.addamount);
        title=(Textstyle)findViewById(R.id.toolbar_title);
        title.setText("");
        for(i=0;i<12;i++){
            if(card[i]==view.getId())
                break;}
        int color=Color.parseColor(carddetail[i]);
            Window window = getWindow();
            window.setStatusBarColor(color);
        toolbar=(Toolbar)findViewById(R.id.toolbar1);
        toolbar.setBackgroundColor(color);
        title=(Textstyle)findViewById(R.id.toolbar_title);
        title.setText(cardname[i]);
       title.setTypeface(null, Typeface.BOLD);
       EditText value=(EditText)findViewById(R.id.value);
       Textstyle plus=(Textstyle)findViewById(R.id.plus),minus=(Textstyle)findViewById(R.id.minus),currency=(Textstyle)findViewById(R.id.currency);
       Button set=(Button)findViewById(R.id.set);
       ImageView icon=(ImageView)findViewById(R.id.imageView);
        plus.setTextColor(color);
        minus.setTextColor(color);
        currency.setTextColor(color);
        value.setTextColor(color);
        set.setTextColor(color);
        icon.setImageResource(image[i]);
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
        title=(Textstyle)findViewById(R.id.toolbar_title);
        int val=Integer.parseInt(value.getText().toString());
        Intent output = new Intent();
        output.putExtra("category",cardname[i]);
        output.putExtra("value",val);
        setResult(RESULT_OK, output);
        finish();

    }
    public void onCancel(View view){
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();

    }
}
