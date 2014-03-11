package com.example.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {

     private Button nextButton;
     private SharedPreferences sharedPref;
     private EditText mEditText;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

         sharedPref = getSharedPreferences(Preferences.PREFERENCES, Context.MODE_PRIVATE);

         setContentView(R.layout.activity_login);
         nextButton = (Button)findViewById(R.id.gototext);
         nextButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 SharedPreferences.Editor editor = sharedPref.edit();

                 editor.putString(Preferences.first_transfered_data, mEditText.getText().toString());

                 editor.commit();

                 Intent intent = new Intent (LoginActivity.this, SecondActivity.class);
                 startActivity(intent);
             }

         });

        mEditText = (EditText)findViewById(R.id.text_view);
     }

 }
