package com.codebrahma.kamesh.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.*;
import android.widget.*;


public class CalculatorActivity extends Activity {

    private Button btnOne,
                   btnTwo,
                   btnThree,
                   btnFour,
                   btnFive,
                   btnSix,
                   btnSeven,
                   btnEight,
                   btnNine,
                   btnZero,
                   btnPlus,
                   btnMinus,
                   btnStar,
                   btnSlash,
                   btnEqualTo,
                   btnClear;
    private EditText display;

    private float operand1, operand2;
    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initializeUIWidgets();
    }

    private void initializeUIWidgets() {

        //Initializing Buttons
        btnOne = (Button) this.findViewById(R.id.btnOne);
        btnTwo = (Button) this.findViewById(R.id.btnTwo);
        btnThree = (Button) this.findViewById(R.id.btnThree);
        btnFour = (Button) this.findViewById(R.id.btnFour);
        btnFive = (Button) this.findViewById(R.id.btnFive);
        btnSix = (Button) this.findViewById(R.id.btnSix);
        btnSeven = (Button) this.findViewById(R.id.btnSeven);
        btnEight = (Button) this.findViewById(R.id.btnEight);
        btnNine = (Button) this.findViewById(R.id.btnNine);
        btnZero = (Button) this.findViewById(R.id.btnZero);
        btnPlus = (Button) this.findViewById(R.id.btnPlus);
        btnMinus = (Button) this.findViewById(R.id.btnMinus);
        btnStar = (Button) this.findViewById(R.id.btnStar);
        btnSlash = (Button) this.findViewById(R.id.btnSlash);

        //Initializing TextField
        display = (EditText) this.findViewById(R.id.display);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
