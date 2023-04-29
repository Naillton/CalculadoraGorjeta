package com.example.calculadoragorjeta;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textV6;
    private EditText edtNumber;
    private TextView textV2;
    private TextView textV5;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textV2 = findViewById(R.id.textView2);
        textV5 = findViewById(R.id.textView5);
        textV6 = findViewById(R.id.textView6);
        edtNumber = findViewById(R.id.editTextNumber);
        SeekBar seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textV2.setText(progress+"%");
                textV5.setText(progress+"%");
                calc(progress);
            }
            @SuppressLint("SetTextI18n")
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textV2.setText(seekBar.getProgress()+"%");
                textV5.setText(seekBar.getProgress()+"%");
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textV2.setText(seekBar.getProgress()+"%");
                textV5.setText(seekBar.getProgress()+"%");
            }
        });
    }
    @SuppressLint("SetTextI18n")
    void calc(double percent) {
        double value = 0;
        if (edtNumber.getText().toString().length() != 0) {
            value = parseDouble(edtNumber.getText().toString());
        }
        double result = (percent/100) * value;
        textV6.setText(""+Math.round(result * 100) / 100);
    }
}