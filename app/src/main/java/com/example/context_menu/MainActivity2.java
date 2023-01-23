package com.example.context_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * The type Main activity 2.
 */
public class MainActivity2 extends AppCompatActivity implements View.OnCreateContextMenuListener {
    ListView lV;
    TextView tV;
    boolean type;
    double firstnum, multipliermum,sum;
    String [] arr = new String[20];
    int seriesType;
    int index;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lV = findViewById(R.id.lV);
        tV = findViewById(R.id.tV);

        Intent gi = getIntent();
        firstnum =gi.getDoubleExtra("firstnum", 0);
        multipliermum =gi.getDoubleExtra("multipliermum", 0);
        seriesType = gi.getIntExtra("seriesType",0);
        arr[0] = firstnum + "";
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        lV.setAdapter(adp);
        lV.setOnCreateContextMenuListener(this);
        lV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                return false;
            }
        });

    }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("select");
            menu.add("index");
            menu.add("sum");
            menu.add("back");

        }
    @SuppressLint("SetTextI18n")
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String str=item.getTitle().toString();
        if(str.equals("index")){
            tV.setText(index + "");
        }
        if(str.equals("back"))
            finish();
        return true;
        }
    }