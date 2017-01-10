package com.supremeit.sqlitedatabaseexample.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.supremeit.sqlitedatabaseexample.database.DbOpenHelper;
import com.supremeit.sqlitedatabaseexample.database.DbText;
import com.supremeit.sqlitedatabaseexample.models.StudentItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RuShma on 8/17/2016.
 */
public class StudentDAO {

    private Context context;
    private DbOpenHelper dbOpenHelper;
    private SQLiteDatabase database;

    public StudentDAO(Context context) {
        dbOpenHelper = new DbOpenHelper(context);
    }

    public void insertStudentDetails(StudentItem studentItem) {

        database = dbOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DbText.COLUMN_NAME, studentItem.getName());
        values.put(DbText.COLUMN_ADDRESS, studentItem.getAddress());
        values.put(DbText.COLUMN_AGE, studentItem.getAge());

        Log.d(getClass().getName()+"/inserted name", studentItem.getName());
        
        try {
            database.insert(DbText.TABLE_STUDENT_DETAILS, null, values);
        } finally {
            dbOpenHelper.close();
            database.close();
        }
    }

    public List<StudentItem> getAllStudents() {
        List<StudentItem> studentItemList = new ArrayList<>();
        database = dbOpenHelper.getReadableDatabase();
        Cursor cursor = database.query(DbText.TABLE_STUDENT_DETAILS,
                new String[]{DbText.COLUMN_ID, DbText.COLUMN_NAME, DbText.COLUMN_ADDRESS, DbText.COLUMN_AGE}
                , null, null, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndex(DbText.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(DbText.COLUMN_NAME));
            String address = cursor.getString(cursor.getColumnIndex(DbText.COLUMN_ADDRESS));
            String age = cursor.getString(cursor.getColumnIndex(DbText.COLUMN_AGE));

            Log.d(getClass().getName()+"/name", name);
            studentItemList.add(new StudentItem(name, address, age));
            cursor.moveToNext();
        }

        cursor.close();
        database.close();
        dbOpenHelper.close();
        return studentItemList;
    }

    public void DeleteStudent(String name){

        database = dbOpenHelper.getWritableDatabase();

        try {
            database.delete(DbText.TABLE_STUDENT_DETAILS, DbText.COLUMN_NAME+"='"+name+"'" , null);
        }
        finally {
            database.close();
            dbOpenHelper.close();
        }
    }
}
