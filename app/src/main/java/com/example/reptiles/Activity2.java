package com.example.reptiles;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Activity2 extends AppCompatActivity {

    TextView titleText;
    WebView myWebView;
    TabLayout.OnTabSelectedListener tabSelectedListener;
    TabLayout tabLayout;
    Bundle receivedParameters;
    String newActivityClassification;
    HashMap<String, String> sections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
            receivedParameters = getIntent().getExtras();
            newActivityClassification = receivedParameters.getString("classification");
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

    @Override
    protected void onStop() {
        super.onStop();
        tabLayout.removeAllTabs();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tabLayout.removeAllTabs();
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onStart() {
        super.onStart();

        titleText = (TextView) findViewById(R.id.secondActivityTitle);
        titleText.setText(newActivityClassification);
        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                //view.loadUrl(url);
                System.out.println("hello");
                return false;
            }
        });
        myWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptEnabled(true);

        sections = (HashMap<String, String>) receivedParameters.getSerializable("sections");
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addOnTabSelectedListener(tabSelectedListener);

        for (String category : sections.keySet()) {
            TabLayout.Tab newtab = tabLayout.newTab().setText(category);
            tabLayout.addTab(newtab,true);
        }

    }
}