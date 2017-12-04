package com.example.akshayjk.attempt1.Helper;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.akshayjk.attempt1.ClubSports_Activities.CS_Schedule;
import com.example.akshayjk.attempt1.ClubSports_Activities.ClubSports;
import com.example.akshayjk.attempt1.ClubSports_Activities.FormsList;
import com.example.akshayjk.attempt1.IntraSports_Activities.IntraSports;
import com.example.akshayjk.attempt1.R;
import com.example.akshayjk.attempt1.Rec_Activities.BuckleyArmory;
import com.example.akshayjk.attempt1.Rec_Activities.DaCenter;
import com.example.akshayjk.attempt1.Rec_Activities.RecCenter;
import com.example.akshayjk.attempt1.Rec_Activities.RecFac;

import java.io.File;

/**
 * Created by AkshayJk on 20-Nov-17.
 */

public class pdfread extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=null;
        Bundle bundle=getIntent().getExtras();
        int code=bundle.getInt("code");
        switch (code){
            case 1: intent=new Intent(pdfread.this, RecFac.class);
                    break;
            case 2: intent=new Intent(pdfread.this, IntraSports.class);
                    break;
            case 3: intent=new Intent(pdfread.this, ClubSports.class);
                    break;
            case 4: intent=new Intent(pdfread.this, FormsList.class);
                    break;
            case 5: intent=new Intent(pdfread.this, CS_Schedule.class);
                    break;
            case 6: intent=new Intent(pdfread.this, BuckleyArmory.class);
                    break;
            case 7:
            case 8: intent=new Intent(pdfread.this, DaCenter.class);
                    break;
        }
        startActivity(intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfread);
        final Context context=getApplicationContext();
        Bundle bundle=getIntent().getExtras();
        String message=bundle.getString("filename");
        readpdf(context, message);
    }

    public void readpdf(Context context, String message) {
        int percheck = ContextCompat.checkSelfPermission(pdfread.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        AssetManager assetManager = getAssets();
        WebView webView = (WebView) findViewById(R.id.webview);
        String[] files = null;
        try {
            files = assetManager.list("");

        } catch (Exception e) {
            Toast.makeText(context, "Failed to get asset file lost", Toast.LENGTH_LONG).show();
        }
        File outFile = new File("file:///android_asset/fachours1.pdf");

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setBuiltInZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/pdfjs/web/viewer.html?file=" + "file:///android_asset/" + message + "#zoom=page-width");
    }
}