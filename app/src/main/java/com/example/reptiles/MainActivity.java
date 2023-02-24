package com.example.reptiles;

import static com.example.reptiles.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    View.OnClickListener principalButtonsListener;

    Button firstPrincipalButton;
    Button secondPrincipalButton;
    Button thirdPrincipalButton;
    Button fourthPrincipalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE); // remove title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principalButtonsListener = (View view) -> {
            String buttonText = ((Button) view).getText().toString();// get the button text

            Intent intentSecondActivity = new Intent(this, Activity2.class); // initializes the intent for the Activity2
            Bundle parameters = new Bundle(); // creates bundle to pass parameter to the Activity2
            parameters.putString("classification", buttonText); // adds the button text to classification parameter

            HashMap<String, String> sections = new HashMap<>(); // map to store each section with their url for the web-view
            switch (buttonText) {
                case "Crocodilia":
                    sections.put("Brevirostres","https://es.wikipedia.org/wiki/Brevirostres");
                    sections.put("Gavialoidea","https://es.wikipedia.org/wiki/Gavialoidea");
                    sections.put("Planocraniidae","https://es.wikipedia.org/wiki/Planocraniidae");
                    sections.put("Borealosuchus","https://es.wikipedia.org/wiki/Borealosuchus");
                    break;
                case "Squamata":
                    sections.put("Dibamia","https://es.wikipedia.org/wiki/Dibamidae");
                    sections.put("Laterata","https://es.wikipedia.org/wiki/Laterata");
                    sections.put("Gekkota","https://es.wikipedia.org/wiki/Gekkota");
                    sections.put("Iguania","https://es.wikipedia.org/wiki/Iguania");
                    break;
                case "Testudines":
                    sections.put("Cryptodira","https://es.wikipedia.org/wiki/Cryptodira");
                    sections.put("Pleurodira","https://es.wikipedia.org/wiki/Pleurodira");
                    sections.put("Proganochelydia","https://www.wikidata.org/wiki/Q1188888");
                    break;
                case "Rincocéfalos":
                    sections.put("Sphenodontidae","https://en.wikipedia.org/wiki/Gephyrosauridae");
                    sections.put("Pleurosauridae","https://es.wikipedia.org/wiki/Pleurosauridae");
                    sections.put("Gephyrosauridae","https://en.wikipedia.org/wiki/Gephyrosauridae");
                    break;
                default:
                    sections.put("google","https://www.google.com.mx");
            }
            parameters.putSerializable("sections", sections);
            startActivity(intentSecondActivity.putExtras(parameters));
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