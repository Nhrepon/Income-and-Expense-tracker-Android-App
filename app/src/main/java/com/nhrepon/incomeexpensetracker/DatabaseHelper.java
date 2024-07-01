package com.nhrepon.incomeexpensetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "iet", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table expense (id integer primary key autoincrement, amount Double, description TEXT, timestamp)");
    db.execSQL("create table income (id integer primary key autoincrement, amount Double, description TEXT, timestamp)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists expense");
    db.execSQL("drop table if exists income");
    }

////////////////////////////////////////////////////////////////////////
    public void addExpense(double amount, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("amount", amount);
        contentValues.put("description", description);

        db.insert("expense", null, contentValues);

    }

////////////////////////////////////////////////////////////////









}










