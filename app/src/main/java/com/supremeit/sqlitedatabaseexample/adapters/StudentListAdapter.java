package com.supremeit.sqlitedatabaseexample.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.supremeit.sqlitedatabaseexample.R;
import com.supremeit.sqlitedatabaseexample.models.StudentItem;

import java.util.List;

/**
 * Created by RuShma on 6/15/2016.
 */
public class StudentListAdapter extends BaseAdapter {

    private Context context;
    private List<StudentItem> studentItemList;


    public StudentListAdapter(Context context, List<StudentItem> studentItemList) {
        this.context = context;
        this.studentItemList = studentItemList;
    }

    @Override
    public int getCount() {
        return studentItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        private TextView tvName, tvAddress, tvAge;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_students, parent, false);
            holder.tvName = (TextView) convertView.findViewById(R.id.listName);
            holder.tvAddress = (TextView) convertView.findViewById(R.id.listAddress);
            holder.tvAge = (TextView) convertView.findViewById(R.id.listAge);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position % 2 == 1) {
            convertView.setBackgroundColor(Color.parseColor("#f5f5f5"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#efefef"));
        }

        holder.tvName.setText(studentItemList.get(position).getName());
        holder.tvAddress.setText(studentItemList.get(position).getAddress());
        holder.tvAge.setText(studentItemList.get(position).getAge());

        return convertView;
    }
}
