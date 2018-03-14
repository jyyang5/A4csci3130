package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Map;

public class DetailViewActivity extends Activity {

    private EditText businessNumField, nameField, primrayBusinessField,addressField, provienceField; //nameField, emailField, ;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        appState = ((MyApplicationData) getApplicationContext());
        businessNumField = (EditText) findViewById(R.id.businessNum);
        nameField = (EditText) findViewById(R.id.name);
        primrayBusinessField = (EditText) findViewById(R.id.primrayBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provienceField = (EditText) findViewById(R.id.provience);

        if(receivedPersonInfo != null){
            businessNumField.setText(receivedPersonInfo.businessNum);
            nameField.setText(receivedPersonInfo.name);
            primrayBusinessField.setText(receivedPersonInfo.primrayBusiness);
            addressField.setText(receivedPersonInfo.address);
            provienceField.setText(receivedPersonInfo.provience);
        }
    }

    public void updateContact(View v){
        //Update contact funcionality
        String id = receivedPersonInfo.uid;

        //String uid = appState.firebaseReference.push().getKey();
        String businessNum = businessNumField.getText().toString();
        String name = nameField.getText().toString();
        String primrayBusiness = primrayBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String provinece = provienceField.getText().toString();

        Contact newContract = new Contact(id,businessNum,name,primrayBusiness,address,provinece);
        Map<String, Object> newValue = newContract.toMap();
        appState.firebaseReference.child(id).setValue(newValue);
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void eraseContact(View v)
    {
        //Erase contact functionality
        appState = ((MyApplicationData) getApplicationContext());
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
        finish();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
