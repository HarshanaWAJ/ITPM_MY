package com.example.itpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.itpm.models.RateModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FeedBackForm extends AppCompatActivity {

    private int onTimeScoreInt;
    private int serviceScoreInt;

    EditText staffId;
    EditText feedbackMessage;
    Spinner serviceRateSpinner;
    Spinner onTimeRateSpinner;

    Button submitBtn;

    //Database Ref
    DatabaseReference  rateDatabaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_form);

        onTimeRateSpinner = findViewById(R.id.onTimeScoreSpinner);
        onTimeRateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) { // Check if a valid selection is made
                    String onTimeScore = parent.getItemAtPosition(position).toString();
                    switch (onTimeScore) {
                        case "Very Low":
                            onTimeScoreInt = 1;
                            break;
                        case "Low":
                            onTimeScoreInt = 2;
                            break;
                        case "Medium":
                            onTimeScoreInt = 3;
                            break;
                        case "High":
                            onTimeScoreInt = 4;
                            break;
                        case "Very High":
                            onTimeScoreInt = 5;
                            break;
                    }
                    Toast.makeText(FeedBackForm.this, "Your Score:" + onTimeScoreInt, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        serviceRateSpinner = findViewById(R.id.serviceScoreSpinner);
        serviceRateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) { // Check if a valid selection is made
                    String serviceScore =  parent.getItemAtPosition(position).toString();
                    switch (serviceScore) {
                        case "Very Low":
                            serviceScoreInt = 1;
                            break;
                        case "Low":
                            serviceScoreInt = 2;
                            break;
                        case "Medium":
                            serviceScoreInt = 3;
                            break;
                        case "High":
                            serviceScoreInt = 4;
                            break;
                        case "Very High":
                            serviceScoreInt = 5;
                            break;
                    }
                    Toast.makeText(FeedBackForm.this, "Your Score:" + serviceScoreInt, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> scoreList = new ArrayList<>();
        scoreList.add("Select One");
        scoreList.add("Very Low");
        scoreList.add("Low");
        scoreList.add("Medium");
        scoreList.add("High");
        scoreList.add("Very High");
        ArrayAdapter<String> scoreAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, scoreList);
        scoreAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        onTimeRateSpinner.setAdapter(scoreAdapter);
        serviceRateSpinner.setAdapter(scoreAdapter);

        // Set the default selection to "Select One" and disable it
        onTimeRateSpinner.setSelection(0, false);
        serviceRateSpinner.setSelection(0, false);

        staffId = findViewById(R.id.staffIdEt);
        feedbackMessage = findViewById(R.id.feedbackEt);
        submitBtn = findViewById(R.id.feedbackSubmitBtn);
        //Submit Method
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertRateData();
            }
        });

        rateDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Staff_Rates");
    }

    private void insertRateData() {
        String etStaffId = staffId.getText().toString();
        String etFeedbackMessage = feedbackMessage.getText().toString();
        String onTimeRate = onTimeRateSpinner.getSelectedItem().toString();
        String onServiceRate = serviceRateSpinner.getSelectedItem().toString();
        RateModel rate = new RateModel(etStaffId, etFeedbackMessage, onTimeRate, onServiceRate, onTimeScoreInt, serviceScoreInt);
        rateDatabaseRef.push().setValue(rate);
        Toast.makeText(FeedBackForm.this, "You Have Rated the Staff Member ", Toast.LENGTH_SHORT).show();
    }

}