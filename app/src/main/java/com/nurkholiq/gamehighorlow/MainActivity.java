package com.nurkholiq.gamehighorlow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int inputNumber;

    private void randomNumber() {
        Random random = new Random();
        inputNumber = random.nextInt(20) + 1;
    }

    public void onGuess(View view) {
        String message;
        EditText edtNumber = (EditText) findViewById(R.id.edt_number);
        try {
            int guessNumbers = Integer.parseInt(edtNumber.getText().toString());
            if (guessNumbers < inputNumber) {
                message = "Higher !!";
            } else if (guessNumbers > inputNumber) {
                message = "Lower !!";
            } else {
                message = "Yeee... saya ketahuan !!";
                randomNumber();
            }
            Toast.makeText(this, "Result: " + message, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            System.out.println("Ada kesalahan " + e);
            Toast.makeText(this, "Ada kesalahan " + e, Toast.LENGTH_SHORT).show();
        } finally {
            System.out.println("Saya akan ketahuan di angka: " + inputNumber);
            System.out.println("Nilai angka yang di masukan user: " + edtNumber.getText());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        inputNumber = random.nextInt(20) + 1; //membatasi angka sampai 20 dari 1
    }
}