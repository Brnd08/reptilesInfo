package com.example.reptiles;

import static com.example.reptiles.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    View.OnClickListener principalButtonsListener;

    Button firstPrincipalButton;
    Button secondPrincipalButton;
    Button thirdPrincipalButton;
    Button fourthPrincipalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principalButtonsListener = (View view) -> {
            String buttonText = ((Button) view).getText().toString();
            startActivity(new Intent(this, Activity2.class).putExtra("classification", buttonText));
        };

        firstPrincipalButton = (Button) findViewById(firstButton);
        secondPrincipalButton = (Button) findViewById(secondButton);
        thirdPrincipalButton = (Button) findViewById(thirdButton);
        fourthPrincipalButton = (Button) findViewById(fourthButton);

        firstPrincipalButton.setOnClickListener(principalButtonsListener);
        secondPrincipalButton.setOnClickListener(principalButtonsListener);
        thirdPrincipalButton.setOnClickListener(principalButtonsListener);
        fourthPrincipalButton.setOnClickListener(principalButtonsListener);

    }


}