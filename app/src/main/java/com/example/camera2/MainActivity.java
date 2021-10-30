package com.example.camera2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnContact;
    Button btnAddContact;
    EditText txtContactName;
    EditText txtContactNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            btnContact = findViewById(R.id.btnContact);
            btnAddContact = findViewById(R.id.btnAddContact);
            txtContactName = findViewById(R.id.txtContactName);
            txtContactNumber = findViewById(R.id.txtContactNumber);

            btnContact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        Intent toContacts = new Intent(MainActivity.this, ContactActivity.class);
                        startActivity(toContacts);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });

            btnAddContact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        Contact newContact = new Contact(
                                txtContactName.getText().toString(),
                                txtContactNumber.getText().toString());
                        UtilContactsList.contactsArrayList.add(newContact);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}