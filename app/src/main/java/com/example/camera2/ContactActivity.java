package com.example.camera2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class ContactActivity extends AppCompatActivity {

    ListView contactsListView;
    ImageView showContactsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        try {
            showContactsImageView = findViewById(R.id.showContactsImageView);
            contactsListView = findViewById(R.id.contactsListView);
            final ContactListAdapter contactListAdapter = new ContactListAdapter(
                    this,
                    R.layout.contact_view_layout,
                    UtilContactsList.contactsArrayList);
            contactsListView.setAdapter(contactListAdapter);
            contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    try {
                        Contact contact = (Contact) UtilContactsList.contactsArrayList.get(i);
                        Intent toEditPage = new Intent(ContactActivity.this, EditOrDeleteContactActivity.class);
                        toEditPage.putExtra("position", i);
                        toEditPage.putExtra("contact-name", contact.getContactName());
                        toEditPage.putExtra("contact-number", contact.getContactNumber());
                        startActivity(toEditPage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            showContactsImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}