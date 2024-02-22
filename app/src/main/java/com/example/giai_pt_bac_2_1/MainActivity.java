package com.example.giai_pt_bac_2_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtA, edtB, edtC;
    private TextView txtResult;

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        Button btnSolve = findViewById(R.id.btnSolve);
        txtResult = findViewById(R.id.txtResult);

        btnSolve.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:

                    btnSolve.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.hoverColor));
                    break;
                case MotionEvent.ACTION_UP:
                    
                    btnSolve.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.defaultColor));
                    break;
            }
            return false;
        });

        btnSolve.setOnClickListener(v -> {
            String aString = edtA.getText().toString();
            String bString = edtB.getText().toString();
            String cString = edtC.getText().toString();

            try {
                double a = Double.parseDouble(aString);
                double b = Double.parseDouble(bString);
                double c = Double.parseDouble(cString);

                double delta = b * b - 4 * a * c;

                if (delta < 0) {
                    txtResult.setText("Phương trình vô nghiệm");
                } else if (delta == 0) {
                    double x = -b / (2 * a);
                    txtResult.setText("Phương trình có nghiệm kép: x = " + x);
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    txtResult.setText("Nghiệm của phương trình ax^2 + bx + c = 0 là:\n x1 = " + x1 + "\n x2 = " + x2);
                }
            } catch (NumberFormatException e) {
                txtResult.setText("Vui lòng nhập hệ số a, b và c ");
            }
        });
    }
}

