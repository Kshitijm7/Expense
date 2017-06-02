package com.example.kshitijmittal.expense;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class Textstyle extends android.support.v7.widget.AppCompatTextView{
    public Textstyle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Textstyle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Textstyle(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/RobotoRegular.ttf");
            this.setTypeface(tf);
        }
    }

}

