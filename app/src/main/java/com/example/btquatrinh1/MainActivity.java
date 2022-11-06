package com.example.btquatrinh1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvItems = (ListView) findViewById(R.id.lv_items);

        // Prepare to binding for ListView
        final List<String> data = new ArrayList<>();
        data.add(0,"Linear Layout");
        data.add(1,"Relative Layout");
        data.add(2,"Table Layout");

        // Create Adapter with data and row
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        // Set Adapter for ListView
        lvItems.setAdapter(adapter);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(id == 0) {
                    Intent intent = new Intent(MainActivity.this, LinearLayout.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "hello 1"+" "+id, Toast.LENGTH_SHORT).show();
                }
                if(id == 1) {
                    Toast.makeText(MainActivity.this, "hello 2"+" "+id, Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(MainActivity.this, RelativeLayout.class);
                    startActivity(intent1);
                }
                if(id == 2) {
                    Toast.makeText(MainActivity.this, "hello 3"+" "+id, Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(MainActivity.this, TableLayout.class);
                    startActivity(intent2);
                }
            }
        });

        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"hello"+""+id, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //thao tác cuận list v
        lvItems.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.e(TAG, "onScrollStateChanged: " + scrollState);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.e(TAG, "onScroll: " + "firstVisibleItem: " + firstVisibleItem + ", visibleItemCount: " + visibleItemCount + ", totalCount: " + totalItemCount);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item one selected", Toast.LENGTH_SHORT).show();
                OpenDialog();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item two selected", Toast.LENGTH_SHORT).show();
                OpenDialog();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item three selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void OpenDialog() {
        DiaLog exDiaLog = new DiaLog();
        exDiaLog.show(getSupportFragmentManager(), "example dialog");
    }

}