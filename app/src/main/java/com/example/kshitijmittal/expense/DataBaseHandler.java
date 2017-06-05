package com.example.kshitijmittal.expense;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Expense";
    private static final String TABLE_CATEGORY = "Category";
    private static final String TABLE_SELECT = "Category Selected";
    private static final String KEY_ID = "id";
    private static final String KEY_TYPE = "type";
    private static final String KEY_COLOR = "color";
    private static final String KEY_ICON = "icon";


    public DataBaseHandler(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE "+TABLE_CATEGORY+
                        "(" +KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                              KEY_TYPE+"TEXT NOT NULL"+
                               KEY_COLOR+"TEXT NOT NULL"+
                               KEY_ICON+"INTEGER NOT NULL"
        );
        db.execSQL(
                "CREATE TABLE "+TABLE_SELECT+
                        "(" +KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        KEY_TYPE+"TEXT NOT NULL"+
                        KEY_COLOR+"TEXT NOT NULL"+
                        KEY_ICON+"INTEGER NOT NULL"
        );

    }

    public void onDelete(SQLiteDatabase db){
        db.execSQL(
                "CREATE TABLE "+TABLE_SELECT+
                        "(" +KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        KEY_TYPE+"TEXT NOT NULL"+
                        KEY_COLOR+"TEXT NOT NULL"+
                        KEY_ICON+"INTEGER NOT NULL"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SELECT);
        onDelete(db);
    }
}
