package com.example.meterstoinches.meterstoinches;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
    1 meter = 39.3701 inches
     */

    private EditText enterMeters;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterMeters = (EditText) findViewById(R.id.metersEditText);
        convertButton = (Button) findViewById(R.id.convertid);
        resultTextView = (TextView) findViewById(R.id.resultid);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conversion logic
                double multiplier = 39.37;
                double result = 0.00;
                //if user doesn't enter anything
                if (enterMeters.getText().toString().equals("")) {
                    resultTextView.setText(R.string.errorMessage);
                    resultTextView.setTextColor(Color.RED);

                } else {
                    double metervalue = Double.parseDouble(enterMeters.getText().toString());
                    result = metervalue * multiplier;
                    resultTextView.setTextColor(Color.BLACK);
                    resultTextView.setText(String.format("%.2f", result) + " inches"); //roundoff
                    //resultTextView.setText(Double.toString(result)+" inches"); without roundoff
                }
            }
        });
    }
}
