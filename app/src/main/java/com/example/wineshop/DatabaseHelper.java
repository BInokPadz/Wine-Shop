package com.example.wineshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "wineshop";

    public static String TABLE_NAME = "sales";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "items";
    public static final String COL_4 = "amount";
    public static final String COL_5 = "date";



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +"(" +
                "id integer primary key autoincrement," +
                "name varchar NOT NULL," +
                "items varchar NOT NULL," +
                "amount varchar NOT NULL," +
                "date varchar NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int ii) {
        sqLiteDatabase.execSQL("drop table if exists " + DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name , String items , String amount , String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, items);
        contentValues.put(COL_4, amount);
        contentValues.put(COL_5, date);
        Long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null );
        return res;
    }

}
