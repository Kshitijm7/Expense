package com.example.kshitijmittal.expense;

public class Budget {
    private String title, leftover,color;
        int value;
        int icon,progress,Id;
    boolean mPinned;

public Budget(int Id,int icon, String title, String leftover, int value,String color) {
                    this.Id=Id;
                    this.title = title;
                    this.icon= icon;
                    this.leftover = leftover;
                    this.value = value;
                    this.color=color;
                 }

    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
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
    public void setProgress(int progress) {this.progress = progress;}

    public String getColor(){return color;}
    public void setColor(String color) {this.color = color;}

    public boolean isPinned() {return mPinned;}
    public void setPinned(boolean pinned) {
        mPinned = pinned;
    }

}