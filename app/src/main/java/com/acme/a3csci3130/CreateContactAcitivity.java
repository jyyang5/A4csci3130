package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText businessNumField, nameField, primrayBusinessField,addressField, provienceField; //nameField, emailField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        //nameField = (EditText) findViewById(R.id.name);
        //emailField = (EditText) findViewById(R.id.email);

        businessNumField = (EditText) findViewById(R.id.businessNum);
        nameField = (EditText) findViewById(R.id.name);
        primrayBusinessField = (EditText) findViewById(R.id.primrayBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provienceField = (EditText) findViewById(R.id.provience);


    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        //String name = nameField.getText().toString();
        //String email = emailField.getText().toString();

        String businessNum = businessNumField.getText().toString();
        String name = nameField.getText().toString();
        String primrayBusiness = primrayBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String provience = provienceField.getText().toString();


        //Contact person = new Contact(personID, name, email);
        Contact person = new Contact(businessNum, name,primrayBusiness,address, provience);


        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
