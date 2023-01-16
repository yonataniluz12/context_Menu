package com.example.context_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;


/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The E t.
     */
    EditText eT,
    /**
     * The E t 2.
     */
    eT2;
    /**
     * The T b.
     */
    ToggleButton tB;
    /**
     * The Firstnum.
     */
    double firstnum;
    /**
     * The Si.
     */
    Intent si;
    /**
     * The Multipliermum.
     */
    double multipliermum;
    /**
     * The Chek.
     */
    int chek = -999;
    String [] arr = new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eT = findViewById(R.id.eT);
        eT2 = findViewById(R.id.eT2);
        tB = findViewById(R.id.tB);

    }

    /**
     * Go.
     *
     * @param view the view
     */
    public void go(View view) {
        if (tB.isChecked()) {
            chek = 0;
            for (int i = 1; i < arr.length; i++)
                arr[i] = String.format("%s", (firstnum * Math.pow(multipliermum, i)));

        }
        else {
            chek = 1;
            for (int i = 1; i < arr.length; i++)
                arr[i] = (firstnum + multipliermum * (i)) + "";
        }
        if (inputOk()) {
            si.putExtra("multipliermum", multipliermum);
            si.putExtra("firstnum", firstnum);
            si.putExtra("seriesType", chek);
            si.putExtra("arr",arr);
            startActivity(si);
        } else
            Toast.makeText(MainActivity.this, "You must chose the series type", Toast.LENGTH_LONG).show();
    }


    /**
     * Input ok boolean.
     *
     * @return the boolean
     */
    public boolean inputOk() {
        String st = eT.getText().toString();
        if (st.matches("-?\\d+(\\.\\d+)?")) {
            firstnum = Double.parseDouble(st);
            String st2 = eT2.getText().toString();
            if (st2.matches("-?\\d+(\\.\\d+)?")) {
                multipliermum = Double.parseDouble(st);
                String[] arr = new String[20];
                arr[0] =  firstnum + "";
                return true;
            }
            eT2.setText("");
            Toast.makeText(MainActivity.this, "You must enter a number", Toast.LENGTH_LONG).show();
            return false;
            }
        eT.setText("");
        Toast.makeText(MainActivity.this, "You must enter a number", Toast.LENGTH_LONG).show();
        return false;
    }
}
