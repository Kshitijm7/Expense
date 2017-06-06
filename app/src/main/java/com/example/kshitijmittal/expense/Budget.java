package com.example.kshitijmittal.expense;

public class Budget {
    private String title, leftover;
    int value;
    int icon,progress;

    public Budget(int icon, String title, String leftover, int value,int progress) {
        this.title = title;
        this.icon= icon;
        this.leftover = leftover;
        this.value = value;
        this.progress=progress;
    }

    public String getTitle() {return title;}
    public void setTitle(String name) {
        this.title = name;
    }

    public String getLeftover() {return leftover;}
    public void setLeftover(String leftover) {
        this.leftover = leftover;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public int getIcon() {
        return icon;
    }
    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getProgress(){return progress;}
}