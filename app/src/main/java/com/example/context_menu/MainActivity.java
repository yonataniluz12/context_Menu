package com.example.context_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;


/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    Button btn1;
    /**
     * The E t.
     */
    EditText eT1,
    /**
     * The E t 2.
     */
    eT2;
    /**
     * The T b.
     */
    RadioButton rB1,rB2;
    /**
     * The Firstnum.
     */
    double firstnum;
    /**
     * The Si.
     */
    Intent si ;
    /**
     * The Multipliermum.
     */
    double multipliermum;
    /**
     * The Chek.
     */
    int seriesType = -1;
    String [] arr = new String[20];
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eT1 = findViewById(R.id.eT);
        eT2 = findViewById(R.id.eT2);
        rB1 =findViewById(R.id.rB1);
        rB2 = findViewById(R.id.rB2);
        si = new Intent(this, MainActivity2.class);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(view -> {
            if (rB1.isChecked()) {
                seriesType = 0;
                for (int i = 1; i < arr.length; i++)
                    arr[i] = (firstnum + multipliermum * (i)) + "";
            }
            else if(rB2.isChecked()) {
                seriesType = 1;
                for (int i = 1; i < arr.length; i++)
                    arr[i] = String.format("%s", (firstnum * Math.pow(multipliermum, i)));
            }
            if (seriesType==-1)
                Toast.makeText(MainActivity.this, "You must chose the series type", Toast.LENGTH_LONG).show();

            else if(inputOk()){
                si.putExtra(" multipliermum", multipliermum);
                si.putExtra("firstnum",firstnum);
                si.putExtra("seriesType", seriesType);
                si.putExtra("arr",arr);
                startActivity(si);
            }
        });

    }
    public boolean inputOk() {
        String st = eT1.getText().toString();
        if (st.matches("-?\\d+(\\.\\d+)?")) {
            firstnum = Double.parseDouble(st);
            st = eT2.getText().toString();
            if (st.matches("-?\\d+(\\.\\d+)?")) {
                multipliermum = Double.parseDouble(st);
                return true;
            } else {
                eT2.setText("");
                Toast.makeText(MainActivity.this, "You must enter a number", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        else {
            eT1.setText("");
            Toast.makeText(MainActivity.this, "You must enter a number", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}