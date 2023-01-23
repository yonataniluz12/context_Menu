package com.example.context_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button button;
        button=findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent si = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(si);
        });
    }

}