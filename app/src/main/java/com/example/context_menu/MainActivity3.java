package com.example.context_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,0,500,"back");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        String str=item.getTitle().toString();
        if(str.equals("back")){
            Intent si = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(si);
        }
        return true;
    }
}