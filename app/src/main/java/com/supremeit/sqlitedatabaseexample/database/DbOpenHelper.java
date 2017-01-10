package com.supremeit.sqlitedatabaseexample.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RuShma on 2/5/15.
 */
public class DbOpenHelper extends SQLiteOpenHelper {
    public DbOpenHelper(Context context) {
        super(context, DbText.DATABASE_NAME, null, DbText.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DbText.TABLE_STUDENT_DETAILS + "(" +
                DbText.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DbText.COLUMN_AGE + " INTEGER, " +
                DbText.COLUMN_NAME + " TEXT, " +
                DbText.COLUMN_ADDRESS + " TEXT );");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbText.TABLE_STUDENT_DETAILS);
        onCreate(db);
    }
}
