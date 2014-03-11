package com.example.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {

    private Button nextButton;
    private SharedPreferences sharedPref;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        nextButton = (Button)findViewById(R.id.gototext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (SecondActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        mEditText = (EditText)findViewById(R.id.text_view);

        sharedPref = getSharedPreferences(Preferences.PREFERENCES, Context.MODE_PRIVATE);

        String receivedData = sharedPref.getString(Preferences.first_transfered_data, null);
        if (receivedData != null)
            mEditText.setText(receivedData);



    }

}
