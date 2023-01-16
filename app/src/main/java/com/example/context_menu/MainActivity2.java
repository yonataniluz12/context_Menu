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
    /**
     * The L v.
     */
    ListView lV;
    /**
     * The T v.
     */
    TextView tV;
    /**
     * The Gi.
     */
    Intent gi = getIntent();
    int chek;
    double firstnum, multipliermum;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lV = findViewById(R.id.lV);
        tV =findViewById(R.id.tV);
        firstnum = gi.getDoubleExtra("firstnum", 0);
        multipliermum=gi.getDoubleExtra("multipliermum", 0);
        chek =gi.getIntExtra("seriesType", 0);
        String[] arr = gi.getStringArrayExtra("arr");
        ArrayAdapter <String> adp = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arr);
        lV.setAdapter(adp);
        lV.setOnCreateContextMenuListener(this);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,0,100,"next");
        menu.add(0,0,200,"back");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        String str=item.getTitle().toString();
        Intent si1 = null;
        if(str.equals("next")) si1 =new Intent(getApplicationContext(),MainActivity3.class );
        else if (str.equals("back")) si1=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(si1);
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("index");
        menu.add("sum");
    }
    @SuppressLint("SetTextI18n")
    public boolean onContextItemSelected(MenuItem item) {
        String str = item.getTitle().toString();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;

        if (str.equals("sum")) {
            double sum;
            if (chek == 1){
                sum = ((2*firstnum +index*multipliermum)*(index+1)) /2;
            }
            else{
                sum= firstnum * (((Math.pow(multipliermum,index+1))-1)/(multipliermum-1));
            }
            tV.setText(String.format("%s", sum));
        }
        else{
            tV.setText("x="+(index+1));
        }
        return super.onContextItemSelected(item);
    }
}