package com.example.lucnguyen.explicitintentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textFirstName;
    private EditText textLastName;
    private TextView textFeedback;
    public static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        this.textFirstName = (EditText) this.findViewById(R.id.text_firstName);
        this.textLastName = (EditText) this.findViewById(R.id.text_lastName);
        this.textFeedback = (TextView) this.findViewById(R.id.text_feedback);
    }

    // When "Greeting activity commplete" , it send back a feedback!
    //  (If you have started it by startActivityForResult())
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
       if(resultCode == MainActivity.RESULT_OK && requestCode == MY_REQUEST_CODE)
       {
           String feedback = data.getStringExtra("feedback");
           this.textFeedback.setText(feedback);
       }
       else
       {
           this.textFeedback.setText("!?");
       }
    }

    // The method is called when the user clicks on "Show Greeting" button.
    public void showGreeting(View view)
    {
        String firstName = this.textFirstName.getText().toString();
        String lastName = this.textLastName.getText().toString();
        // Explicit Intent
        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("firstName", firstName);
        intent.putExtra("lastName", lastName);

        // Start Activity and no need feedback
        // this.startActivity(intent)

        // start Activity need feedback
        this.startActivityForResult(intent, MY_REQUEST_CODE);
    }
}
