package com.example.kshitijmittal.expense;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddAmount extends AppCompatActivity {

    Button set;
    EditText value;
    int val;
    String TEMP="",INPUT="";
    private SharedPref pref;
    Data data=new Data();
    Budget budget;
    List<Budget> budgets;
    int i=-1,s=-1,j;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent x = getIntent();
        setContentView(R.layout.activity_add_amount);
        set=(Button)findViewById(R.id.set);
        value=(EditText)findViewById(R.id.value);
        pref = new SharedPref(this);
        budgets=pref.getPref();
        try{budgets.isEmpty();}catch (Exception e){budgets=new ArrayList<>();}
        val=Integer.parseInt(value.getText().toString());

        i=x.getIntExtra("positionS",-1);
        if(i==-1){
            s=x.getIntExtra("positionC",-1);
        }else if(i!=-1) {
            Textstyle delete=(Textstyle)findViewById(R.id.delete_action);
            delete.setText("Delete");
            value.setText(String.valueOf(budgets.get(i).getValue()));
            val=budgets.get(i).getValue();
            s = data.compareId(budgets.get(i).getId());

        }
            budget = data.returnData(s);


        Textstyle title=(Textstyle)findViewById(R.id.toolbar_title);
        title.setText(budget.getTitle());
        title.setTypeface(null, Typeface.BOLD);



        int color= Color.parseColor(budget.getColor());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar1);
        Textstyle plus=(Textstyle)findViewById(R.id.plus),
                minus=(Textstyle)findViewById(R.id.minus),
                currency=(Textstyle)findViewById(R.id.currency);
        final Button set=(Button)findViewById(R.id.set);
        ImageView icon=(ImageView)findViewById(R.id.imageView);
        value.setSelection(value.getText().length());

        toolbar.setBackgroundColor(color);
        plus.setTextColor(color);
        minus.setTextColor(color);
        currency.setTextColor(color);
        value.setTextColor(color);
        set.setTextColor(color);
        icon.setImageResource(budget.getIcon());

        set.setOnClickListener(pressSet);


        /* value.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                set.setAlpha(0.6f);
                set.setOnClickListener(null);
            }
        });
        value.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    set.setAlpha(1f);
                    set.setOnClickListener(pressSet);
                    Toast.makeText(AddAmount.this, value.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
        value.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) {}

            @Override
            public void afterTextChanged(Editable Token)
            {
            }
        });*/

        value.setFilters(new InputFilter[] {
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence input, int arg1,
                                               int arg2, Spanned arg3, int arg4, int arg5)
                    {
                        CharSequence returned = validate(input.toString());
                        return returned;
                    }
                }
        });
    }

    public void Constrait()
    {
        if(val>10000000)val=10000000;
        else if(val<0)val=0;
        if(val>0){ set.setAlpha(1f);
            set.setOnClickListener(pressSet);
        }
        if(val==0){ set.setAlpha(0.6f);
            set.setOnClickListener(null);
        }
        value.setText(String.valueOf(val));
    }

    public void onPlus(View view){

        val=val+500;
        value.setText(String.valueOf(val));
        //Constrait();
    }

    public void onMinus(View view){
        val=val-500;
        value.setText(String.valueOf(val));
        //Constrait();
    }

    final OnClickListener pressSet = new OnClickListener() {
        public void onClick( View v) {
            val=Integer.parseInt( value.getText().toString() );
            if(i==-1) {
                budget.setValue(val);
                budgets.add(budget);
            }
            if(i>-1) {
                budgets.get(i).setValue(val);
            }
            setProgress();
            pref.setPref(budgets);
            Intent intent = new Intent(AddAmount.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };




    public void onCancel(View view){
        if(i==-1) {
            Intent i = new Intent(AddAmount.this, CategoryActivity.class);
            startActivity(i);
            finish();
        }else{
            Intent i = new Intent(AddAmount.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }

    public void onDelete(View view){
        budgets.remove(i);
        setProgress();
        pref.setPref(budgets);
        Intent i = new Intent(AddAmount.this, MainActivity.class);
        startActivity(i);
        finish();
    }



    public void setProgress() {
        double value = 0;
        try {
            for (int i = 0; i < budgets.size(); i++)
                value += budgets.get(i).getValue();

            for (int i = 0; i < budgets.size(); i++)
                budgets.get(i).setProgress((int)((budgets.get(i).getValue()*100)/value));

        }catch (Exception e){}
    }

    OnClickListener onClickEdittext=new OnClickListener() {
        @Override
        public void onClick(View v) {
            set.setAlpha(0.6f);
            set.setOnClickListener(null);
        }
    };

    private CharSequence validate(String Token) {
        int v;

        try{
            v=Integer.valueOf(value.getText().toString())+Integer.valueOf(Token);
        }catch (Exception e){
            v=0;}

        if ((v==0)||(v>10000000)) {
                return "";
            } else {
                return Token;
            }
    }


}
