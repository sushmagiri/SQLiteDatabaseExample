package com.supremeit.sqlitedatabaseexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import com.supremeit.sqlitedatabaseexample.R;
import com.supremeit.sqlitedatabaseexample.adapters.StudentListAdapter;
import com.supremeit.sqlitedatabaseexample.database.dao.StudentDAO;
import com.supremeit.sqlitedatabaseexample.models.StudentItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RuShma on 8/17/2016.
 */
public class StudentsActivity extends AppCompatActivity {

    List<StudentItem> studentItemList;
    ListView listView;
    StudentListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        listView = (ListView) findViewById(R.id.listStudents);

        studentItemList = new ArrayList<>();
        studentItemList = new StudentDAO(this).getAllStudents();

//        studentItemList.add(new StudentItem("Rushma", "Kupondole", "22"));
//        studentItemList.add(new StudentItem("Rushma", "Kupondole", "22"));

        Log.d("Students number", String.valueOf(studentItemList.size()));
        for (int i =0; i < studentItemList.size(); i++){
            Log.d("Name", studentItemList.get(i).getName());
        }

        adapter = new StudentListAdapter(this, studentItemList);

        listView.setAdapter(adapter);

   }

}
