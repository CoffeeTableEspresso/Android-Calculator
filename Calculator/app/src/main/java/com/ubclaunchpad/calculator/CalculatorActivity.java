package com.ubclaunchpad.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = CalculatorActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        findViewById(R.id.operation_add).setOnClickListener(this);
        findViewById(R.id.operation_sub).setOnClickListener(this);
        findViewById(R.id.operation_multi).setOnClickListener(this);
        findViewById(R.id.operation_div).setOnClickListener(this);
        findViewById(R.id.operation_exp).setOnClickListener(this);
        findViewById(R.id.operation_log).setOnClickListener(this);
        findViewById(R.id.operation_atan2).setOnClickListener(this);
    }

    /**
     * This implementation of the click listener is for the view found in res/layout/activity_calculator
     * The functions in general should grab the appropriate inputs, and if they are valid, computes the answer.
     * The answer should be displayed in a second activity labelled "AnswerActivity"
     * @param v
     */
    @Override
    public void onClick(View v) {
        // get first and second inputs from EditText to float.
        double result;
        double first;
        double second;

        try {
            first = Double.parseDouble(((EditText) findViewById(R.id.firstInput)).getText().toString());
            second = Double.parseDouble(((EditText) findViewById(R.id.secondInput)).getText().toString());
        }
        catch (Exception e) {
            Log.e(TAG, "INVALID INPUT FOR firstInput or secondInput");
            Toast.makeText(this, "ERROR: INVALID INPUT(S)", Toast.LENGTH_LONG).show();
            return;
        }

        switch (v.getId())
        {
            case R.id.operation_add:
            {
                result = first + second;
                //TODO add function
                break;
            }
            case R.id.operation_sub:
            {
                result = first - second;
                //TODO subtract function
                break;
            }
            case R.id.operation_multi:
            {
                result = first * second;
                //TODO multiply function
                break;
            }
            case R.id.operation_div:
            {
                if (second == 0.0) {
                    Log.e(TAG, "ATTEMPTED TO DIVIDE BY ZERO");
                    Toast.makeText(this, "ERROR: DIVISION BY ZERO", Toast.LENGTH_LONG).show();
                    return;
                }
                    result = first / second;
                //TODO divide function
                break;
            }
            case R.id.operation_exp:
            {
                result = Math.pow(first, second);
                //TODO exponent function
                break;
            }
            case R.id.operation_atan2:
            {
                result = Math.atan2(first, second);
                break;
            }
            //TODO any extra implmentations (optional)
            default:
            {
                Toast.makeText(this, "Click not implmented yet", Toast.LENGTH_LONG).show();
                Log.e(TAG, "View id: " + v.getId() + " click not implemented yet");
                return;
            }
        }
        Toast.makeText(this, "Answer = " + result, Toast.LENGTH_LONG).show();
        //((TextView)findViewById(R.id.answer)).setText("Answer = " + String.valueOf(result));
    }
}
