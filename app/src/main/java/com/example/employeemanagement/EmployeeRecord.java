package com.example.employeemanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmployeeRecord extends AppCompatActivity {

    EditText name, contact, dob;
    Button btnInsert,btnUpdate,btnDelete,btnView;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_record);

        name = (EditText) findViewById(R.id.name);
        contact = (EditText) findViewById(R.id.contact);
        dob = (EditText) findViewById(R.id.dob);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnView = (Button) findViewById(R.id.btnView);
        db = new DBHelper(this);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = name.getText().toString();
                String contactText = contact.getText().toString();
                String dobText = dob.getText().toString();

                Boolean checkinsertdata = db.insertuserdata(nameText, contactText, dobText);
                if (checkinsertdata == true)
                    Toast.makeText(EmployeeRecord.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else

                    Toast.makeText(EmployeeRecord.this, "No data Entry Inserted", Toast.LENGTH_SHORT).show();
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = name.getText().toString();
                String contactText = contact.getText().toString();
                String dobText = dob.getText().toString();

                Boolean checkupdatedata = db.updateuserdata(nameText, contactText, dobText);
                if (checkupdatedata == true)
                    Toast.makeText(EmployeeRecord.this, " Entry Updated", Toast.LENGTH_SHORT).show();
                else

                    Toast.makeText(EmployeeRecord.this, " Entry Not Updated", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = name.getText().toString();
                Boolean checkdeletedata = db.deletedata(nameText);
                if (checkdeletedata == true)
                    Toast.makeText(EmployeeRecord.this, " Entry deleted", Toast.LENGTH_SHORT).show();
                else

                    Toast.makeText(EmployeeRecord.this, " Entry Not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(EmployeeRecord.this, "Np Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Name: " + res.getString(0) + "\n");
                    buffer.append("Contact: " + res.getString(1) + "\n");
                    buffer.append("Date of Birth: " + res.getString(2) + "\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(EmployeeRecord.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }
}
