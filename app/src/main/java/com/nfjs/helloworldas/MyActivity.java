package com.nfjs.helloworldas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyActivity extends Activity {
    private static final String TAG = "MyActivity";

    // Using ButterKnife
    @BindView(R.id.text_view) TextView textView;
    @BindView(R.id.edit_text) EditText editText;

    // Not Using ButterKnife
//    private TextView textView;
//    private EditText editText;

    // Using ButterKnife
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ButterKnife.bind(this);
        Log.d(TAG, "onCreate");
    }

    // Not Using ButterKnife
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ButterKnife.bind(this);

        Log.d(TAG, "onCreate");

//        textView = (TextView) findViewById(R.id.text_view);
//        editText = (EditText) findViewById(R.id.edit_text);

        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);

//        Button helloButton = (Button) findViewById(R.id.hello_button);
        Button helloButton = findViewById(R.id.hello_button);

//        helloButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sayHello(v);
//            }
//        });
//        helloButton.setOnClickListener(v -> sayHello(v));
        helloButton.setOnClickListener(this::sayHello);
    }
*/

    // Using ButterKnife
    @OnClick(R.id.hello_button)
    public void sayHello(View view) {
        String name = editText.getText().toString();

        // another way
//        Locale textLocale = textView.getTextLocale();
//        String country = textLocale.getCountry();
//        if (isMexico(country)) {
//            textView.setText(String.format("!Hola, %1$s!", name));
//        } else {
//            textView.setText(String.format("Hello, %1$s!", name));
//        }

        textView.setText(String.format(getString(R.string.greetingText), name));

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    // Not Using ButterKnife
/*
    public void sayHello(View view) {
        String name = editText.getText().toString();

        // another way
//        Locale textLocale = textView.getTextLocale();
//        String country = textLocale.getCountry();
//        if (isMexico(country)) {
//            textView.setText(String.format("!Hola, %1$s!", name));
//        } else {
//            textView.setText(String.format("Hello, %1$s!", name));
//        }

        textView.setText(String.format(getString(R.string.greeting), name));

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
*/

    private boolean isMexico(String country) {
        return country.equals("MX");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
