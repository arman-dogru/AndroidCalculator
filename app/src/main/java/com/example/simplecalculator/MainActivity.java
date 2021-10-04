package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private enum Operator {none, add, sub, nul, div, eq}
    private double data01 = 0, data02 = 0;
    private Operator opp = Operator.none;
    private boolean hadDot = false;
    private boolean requireCleaning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNumericalbtn(View view) {

        int pressID = view.getId();

        TextView curtext = findViewById(R.id.resultText);

        if (opp == Operator.eq){
            opp = Operator.none;
            curtext.setText("");
        }
        if (requireCleaning) {
            requireCleaning = false;
            curtext.setText("");
        }

        switch (pressID) {
            case R.id.btn0:
                curtext.setText(curtext.getText() + "0");
                break;

            case R.id.btn01:
                curtext.setText(curtext.getText() + "01");
                break;
            case R.id.btn02:
                curtext.setText(curtext.getText() + "2");
                break;
            case R.id.btn03:
                curtext.setText(curtext.getText() + "3");
                break;
            case R.id.btn04:
                curtext.setText(curtext.getText() + "4");
                break;
            case R.id.btn05:
                curtext.setText(curtext.getText() + "5");
                break;
            case R.id.btn06:
                curtext.setText(curtext.getText() + "6");
                break;
            case R.id.btn07:
                curtext.setText(curtext.getText() + "7");
                break;
            case R.id.btn08:
                curtext.setText(curtext.getText() + "8");
                break;
            case R.id.btn09:
                curtext.setText(curtext.getText() + "9");
                break;
            case R.id.btnDot:
                if (!hadDot) {
                    curtext.setText(curtext.getText() + ".");
                    hadDot = true;
                }
                break;
            default:
                curtext.setText("ERROR");
                Log.d("ERROR","ERROR: Unknown button was pressed.");
                break;
        }
    }

    public void onClickFunctionbtn(View view){
        int pressID = view.getId();
        TextView curtext = findViewById(R.id.resultText);

        if (pressID == R.id.btnClear){
            opp = Operator.none;
            curtext.setText("");
            data01 = 0;
            data02 = 0;
            requireCleaning = false;
            return;
        }
        String datatext = curtext.getText().toString();
        double numberVal = datatext.length()>0 ? Double.parseDouble(datatext):0;

        if(opp == Operator.none){
            data01 = numberVal;
            requireCleaning = true;
            switch (pressID){
                case R.id.btnEquals:
                    opp = Operator.eq;
                    data01 = 0;
                    break;
                case R.id.btnAdd:
                    opp = Operator.add;
                    break;
                case R.id.btnSubtract:
                    opp = Operator.sub;
                    break;
                case R.id.btnMultiply:
                    opp = Operator.nul;
                    break;
                case R.id.btnDivide:
                    opp = Operator.div;
                    break;
                case R.id.btnClear:
                    opp = Operator.none;
                    break;


            }
        } else {
            double result = 0;
            data02 = numberVal;

            switch (opp){
                case eq:

                    break;
                case none:
                    break;

                case add:
                    result = data01 + data02;
                    break;

                case sub:
                    result = data01 - data02;
                    break;

                case div:
                    result = data01 / data02;
                    break;

                case nul:
                    result = data01 * data02;
                    break;
            }
            data01 = result;
            opp = Operator.none;
            if ((result - (int)result) != 0) {
                curtext.setText(String.valueOf(result));

            }
            else {
                curtext.setText(String.valueOf((int)result));
            }
        }



    }
}