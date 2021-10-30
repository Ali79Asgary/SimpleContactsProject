package com.example.camera2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditOrDeleteContactActivity extends AppCompatActivity {

    Button btnEditContactEditPage;
    Button btnDeleteContactEditPage;
    EditText txtContactNameEditPage;
    EditText txtContactNumberEditPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_or_delete_contact);
        try {
            btnEditContactEditPage = findViewById(R.id.btnEditContactEditPage);
            btnDeleteContactEditPage = findViewById(R.id.btnDeleteContactEditPage);
            txtContactNameEditPage = findViewById(R.id.txtContactNameEditPage);
            txtContactNumberEditPage = findViewById(R.id.txtContactNumberEditPage);

            int position = getIntent().getIntExtra("position", 0);
            String contactName = getIntent().getStringExtra("contact-name");
            String contactNumber = getIntent().getStringExtra("contact-number");

            txtContactNameEditPage.setText(contactName);
            txtContactNumberEditPage.setText(contactNumber);

            btnEditContactEditPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Contact contact = new Contact(
                            txtContactNameEditPage.getText().toString(),
                            txtContactNumberEditPage.getText().toString());
                    UtilContactsList.contactsArrayList.set(position, contact);
                }
            });

            btnDeleteContactEditPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UtilContactsList.contactsArrayList.remove(position);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}