package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText input1, input2;
    String string1, string2;
    TextView fTip, tTip, tfTip,fTotal, tTotal, tfTotal;
    int fTipV, tTipV, tfTipV,fTotalV, tTotalV, tfTotalV;
    double checkAmount;
    int partySize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitButtonClick(View view) {
        input1 = (EditText) findViewById(R.id.checkAmountValue);
        input2 = (EditText) findViewById(R.id.partySizeValue);
        fTip = (TextView) findViewById(R.id.fifteenPercentTipValue);
        tTip = (TextView) findViewById(R.id.twentyPercentTipValue);
        tfTip = (TextView) findViewById(R.id.twentyfivePercentTipValue);
        fTotal = (TextView) findViewById(R.id.fifteenPercentTotalValue);
        tTotal = (TextView) findViewById(R.id.twentyPercentTotalValue);
        tfTotal = (TextView) findViewById(R.id.twentyfivePercentTotalValue);
        string1 = input1.getText().toString();
        string2 = input2.getText().toString();
        if (string1.isEmpty() || string2.isEmpty()) {
            Toast.makeText(MainActivity.this, "Empty value(s)!", Toast.LENGTH_SHORT).show();
        }
        else {
            checkAmount = Double.parseDouble(string1);
            partySize = Integer.parseInt(string2);
            if (checkAmount < 0 || partySize <= 0) {
                Toast.makeText(MainActivity.this, "Invalid value(s)!", Toast.LENGTH_SHORT).show();
            }
            else {
                fTipV = (int) Math.round(checkAmount * 0.15 / partySize);
                tTipV = (int) Math.round(checkAmount * 0.2 / partySize);
                tfTipV = (int) Math.round(checkAmount * 0.25 / partySize);
                fTotalV = (int) Math.round(checkAmount / partySize) + fTipV;
                tTotalV = (int) Math.round(checkAmount / partySize) + tTipV;
                tfTotalV = (int) Math.round(checkAmount / partySize) + tfTipV;
                fTip.setText(String.valueOf(fTipV));
                tTip.setText(String.valueOf(tTipV));
                tfTip.setText(String.valueOf(tfTipV));
                fTotal.setText(String.valueOf(fTotalV));
                tTotal.setText(String.valueOf(tTotalV));
                tfTotal.setText(String.valueOf(tfTotalV));
            }
        }
    }
}