package com.supremeit.sqlitedatabaseexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.supremeit.sqlitedatabaseexample.R;
import com.supremeit.sqlitedatabaseexample.database.dao.StudentDAO;
import com.supremeit.sqlitedatabaseexample.models.StudentItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    EditText etName, etAddress, etAge, etDelName;
    Button btnAdd, btnShowAll, btnDelete;
    StudentItem studentItem;
    List<StudentItem> studentItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etName = (EditText) findViewById(R.id.etName);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etAge = (EditText) findViewById(R.id.etAge);
        etDelName = (EditText) findViewById(R.id.etDelName);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnShowAll = (Button) findViewById(R.id.btnShowAll);
        btnShowAll.setOnClickListener(this);

        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.btnAdd:
                studentItem = new StudentItem(etName.getText().toString(), etAddress.getText().toString(), etAge.getText().toString());
                new StudentDAO(this).insertStudentDetails(studentItem);
                Toast.makeText(MainActivity.this, "Student added successfully!!", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etAddress.setText("");
                etAge.setText("");
                break;

            case R.id.btnShowAll:
                startActivity(new Intent(MainActivity.this, StudentsActivity.class));
                break;

            case R.id.btnDelete:
                studentItemList = new StudentDAO(this).getAllStudents();
                String name = etDelName.getText().toString();
                if (contains(studentItemList, name)) {
                    new StudentDAO(this).DeleteStudent(etDelName.getText().toString());
                    Toast.makeText(MainActivity.this, "Student deleted successfully!!", Toast.LENGTH_SHORT).show();
                    etDelName.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Student not found!!", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    boolean contains(List<StudentItem> list, String name) {
        for (StudentItem item : list) {
            if (item.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
