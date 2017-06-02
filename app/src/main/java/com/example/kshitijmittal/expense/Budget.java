package com.example.kshitijmittal.expense;

public class Budget {
    private String title, leftover;
    double value;
    int icon;

    public Budget(int icon, String title, String leftover, double value) {
        this.title = title;
        this.icon= icon;
        this.leftover = leftover;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getLeftover() {
        return leftover;
    }

    public void setLeftover(String leftover) {
        this.leftover = leftover;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}