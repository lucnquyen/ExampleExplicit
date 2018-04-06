package com.example.lucnguyen.explicitintentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {
    private String firstName;
    private String lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        // Intent is passed into
        Intent intent = this.getIntent();
        this.firstName =intent.getStringExtra("firstName");
        this.lastName = intent.getStringExtra("lastName");

        String greeting = "Hello " + firstName + " " + lastName;

        TextView textGreeting = (TextView) this.findViewById(R.id.text_greeting);
        textGreeting.setText(greeting);
    }

    // When completed this Activity, send feedback to the caller.
    @Override
    public void finish() {
        // Prepare data intent
        Intent data = new Intent();
        data.putExtra("feedback", "I'm "+ this.firstName+", Hi!");
        // Activity finished ok, return the data
        this.setResult(MainActivity.RESULT_OK, data);
        super.finish();
    }


    // The method is called when the user clicks the Back button.
    public void backClicked(View view)  {
        // Calling onBackPressed().
        // Gọi phương thức onBackPressed().
        this.onBackPressed();
    }
}
