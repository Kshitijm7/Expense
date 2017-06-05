package com.example.kshitijmittal.expense;

public class Category {
    private String title;
    private int icon;

    public Category(String title,int icon){
        this.title=title;
        this.icon=icon;
    }

    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }

    public void setIcon(int icon){
        this.icon=icon;
    }
    public int getIcon(){
        return icon;
    }
}
