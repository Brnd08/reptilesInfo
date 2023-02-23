package com.example.reptiles;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebView;
import android.widget.TextView;

import java.util.HashMap;


public class Activity2 extends AppCompatActivity {

    TextView titleText;
    WebView myWebView;
    TabLayout.OnTabSelectedListener tabSelectedListener;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        TabLayout.Tab newtab = new TabLayout.Tab();
        newtab.setText("Brevirostres");
        tabLayout.addTab(newtab, true);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);



        titleText = (TextView) findViewById(R.id.secondActivityTitle);

        Bundle receivedParameters = getIntent().getExtras();
        String newActivityTitle = receivedParameters.getString("classification");
        titleText.setText(newActivityTitle);

        HashMap<String, String> sections = (HashMap<String, String>) receivedParameters.getSerializable("sections");

        tabSelectedListener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myWebView.loadUrl(sections.get(tab.getText()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }
}