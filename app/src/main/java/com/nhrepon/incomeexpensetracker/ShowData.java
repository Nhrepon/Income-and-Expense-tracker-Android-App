package com.nhrepon.incomeexpensetracker;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowData extends AppCompatActivity {

    TextView showDataTitle;
    ListView listView;
    DatabaseHelper dbHelper;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_data);


        showDataTitle=findViewById(R.id.showDataTitle);
        listView=findViewById(R.id.dataList);
        dbHelper = new DatabaseHelper(this);

        Cursor cursor = dbHelper.getAllData();

        if (cursor!= null && cursor.getCount()>0){

            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                double amount = cursor.getDouble(1);
                String description = cursor.getString(2);
                double time = cursor.getDouble(3);

                //showDataTitle.append("\n"+id + " - " + amount + " - " + description);

                hashMap = new HashMap<>();
                hashMap.put("id", ""+id);
                hashMap.put("amount", ""+amount);
                hashMap.put("description", ""+description);
                hashMap.put("time", ""+time);
                arrayList.add(hashMap);
            }

            listView.setAdapter(new dataAdapter());
            //showDataTitle.append("\n"+id+" - "+ amount);
        }else {
            showDataTitle.append("\nNo data available");
        }


    }

/////////////////////////////////////////////////////////////////////////////////////////
public class dataAdapter extends BaseAdapter{

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = getLayoutInflater();
        View dataView= inflater.inflate(R.layout.item, parent, false);
        TextView itemAmount=dataView.findViewById(R.id.itemAmount);
        TextView itemDescription=dataView.findViewById(R.id.itemDescription);
        TextView itemTime=dataView.findViewById(R.id.itemTime);
        Button itemDelete=dataView.findViewById(R.id.itemDelete);

        hashMap=arrayList.get(position);
        String id=hashMap.get("id");
        String amount=hashMap.get("amount");
        String description=hashMap.get("description");
        String Time=hashMap.get("time");

        itemAmount.setText("Amount: "+amount);
        itemDescription.setText("Description: "+description);
        itemTime.setText("Time: "+Time);
        itemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return dataView;
    }
}




}
















