package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    //private EditText nameField, emailField;
    private EditText businessNumField, nameField, primrayBusinessField,addressField, provienceField; //
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        //nameField = (EditText) findViewById(R.id.name);
       // emailField = (EditText) findViewById(R.id.email);

        businessNumField = (EditText) findViewById(R.id.businessNum);
        nameField = (EditText) findViewById(R.id.name);
        primrayBusinessField = (EditText) findViewById(R.id.primrayBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provienceField = (EditText) findViewById(R.id.provience);


        if(receivedPersonInfo != null){
            //nameField.setText(receivedPersonInfo.name);
            //emailField.setText(receivedPersonInfo.email);

            businessNumField.setText(receivedPersonInfo.businessNum);
            nameField.setText(receivedPersonInfo.name);
            primrayBusinessField.setText(receivedPersonInfo.primrayBusiness);
            addressField.setText(receivedPersonInfo.address);
            provienceField.setText(receivedPersonInfo.provience);

        }
    }

    //Button editButton = (Button)findViewById(R.id.editButton);
    //Button deleteButton = (Button)findViewById(R.id.deleteButton);




    public void updateContact(View v){
        //TODO: Update contact funcionality
        /*editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }


             }
             */
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
    }
}
