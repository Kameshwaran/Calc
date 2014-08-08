package com.codebrahma.kamesh.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import java.util.HashMap;


public class CalculatorActivity extends Activity {

    private HashMap<Integer, CalcButton> idToButtonMap;

    private EditText display;

    private String operand1, operand2;
    private char operator;

    public CalculatorActivity(){
        idToButtonMap = new HashMap<Integer, CalcButton>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initializeUIWidgets();
        bindEventListenersToAllWidgets();
    }

    private void bindEventListenersToAllWidgets() {

        OnClickListener clickListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                store(view)
            }
        };

        for( CalcButton calcButton : idToButtonMap.values()){
            calcButton.button.setOnClickListener(clickListener);
        }
    }

    private void store(View view){
        int buttonId = view.getId();
        CalcButton calcButton = idToButtonMap.get(buttonId);

        if( calcButton.isNumber() ){
            Integer number = calcButton.getNumber();
            if(operator == '\0') {
                operand1 = (operand1 + number).toString();
            }
            else{
                operand2 = (operand2 + number).toString();
            }
        }

        if( calcButton.isSymbol() ) switch (calcButton.text) {
            case "+":
            case "-":
            case "*":
            case "/":
                operator = ((Character) text);
                break;
            case "C":
                clearOperandsAndOperator();
                break;
            case "=":
                calculate();
                break;
        }

    }

    private void calculate(){
        
    }

    private void clearOperandsAndOperator(){
        operand1 = "";
        operand2 = "";
        operator = '\0';
    }

    private void initializeUIWidgets() {

        idToButtonMap.put(R.id.btnOne, new CalcButton( CalculatorConstants.One, getButtonById( R.id.btnOne ) ));
        idToButtonMap.put(R.id.btnTwo, new CalcButton( CalculatorConstants.Two, getButtonById( R.id.btnTwo ) ));
        idToButtonMap.put(R.id.btnThree, new CalcButton( CalculatorConstants.Three, getButtonById( R.id.btnThree ) ));
        idToButtonMap.put(R.id.btnFour, new CalcButton( CalculatorConstants.Four, getButtonById( R.id.btnFour ) ));
        idToButtonMap.put(R.id.btnFive, new CalcButton( CalculatorConstants.Five, getButtonById( R.id.btnFive ) ));
        idToButtonMap.put(R.id.btnSix, new CalcButton( CalculatorConstants.Six, getButtonById( R.id.btnSix ) ));
        idToButtonMap.put(R.id.btnSeven, new CalcButton( CalculatorConstants.Seven, getButtonById( R.id.btnSeven ) ));
        idToButtonMap.put(R.id.btnEight, new CalcButton( CalculatorConstants.Eight, getButtonById( R.id.btnEight ) ));
        idToButtonMap.put(R.id.btnNine, new CalcButton( CalculatorConstants.Nine, getButtonById( R.id.btnNine ) ));
        idToButtonMap.put(R.id.btnZero, new CalcButton( CalculatorConstants.Zero, getButtonById( R.id.btnZero ) ));
        idToButtonMap.put(R.id.btnPlus, new CalcButton( CalculatorConstants.Plus, getButtonById( R.id.btnPlus ) ));
        idToButtonMap.put(R.id.btnMinus, new CalcButton( CalculatorConstants.Minus, getButtonById( R.id.btnMinus ) ));
        idToButtonMap.put(R.id.btnStar, new CalcButton( CalculatorConstants.Star, getButtonById( R.id.btnStar ) ));
        idToButtonMap.put(R.id.btnSlash, new CalcButton( CalculatorConstants.Slash, getButtonById( R.id.btnSlash ) ));
        idToButtonMap.put(R.id.btnEqualTo, new CalcButton( CalculatorConstants.EqualTo, getButtonById( R.id.btnEqualTo ) ));

        //Initializing TextField
        display = (EditText) this.findViewById(R.id.display);

    }


    private Button getButtonById(int id) {
        return (Button) this.findViewById(id);
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

class CalcButton {
    public String text;
    public Button button;

    public CalcButton(String text, Button button){
        this.text = text;
        this.button = button;
    }

    public boolean isNumber(){
        try {
            getNumber();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean isSymbol(){
        return !isNumber();
    }

    public Integer getNumber(){
        return Integer.parseInt(text);
    }
}