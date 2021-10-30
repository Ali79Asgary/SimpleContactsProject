package com.example.camera2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactListAdapter extends ArrayAdapter<Contact> {

    private Context mContext;
    int mResource;

    public ContactListAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        try {
            String contactName = getItem(position).getContactName();
            String contactNumber = getItem(position).getContactNumber();

            Contact contact = new Contact(contactName, contactNumber);

            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(mResource, parent, false);

            TextView lblContactName = convertView.findViewById(R.id.lblContactName);
            lblContactName.setText(contactName);

            TextView lblContactNumber = convertView.findViewById(R.id.lblContactNumber);
            lblContactNumber.setText(contactNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertView;
    }
}
