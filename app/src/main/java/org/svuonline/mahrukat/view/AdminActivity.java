package org.svuonline.mahrukat.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.svuonline.mahrukat.R;

public class AdminActivity extends AppCompatActivity {

    Button create_new_customer_btn;
    Button create_new_distributor_btn;
    Button edit_distributor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        create_new_customer_btn = (Button) findViewById(R.id.create_new_customer);
        create_new_customer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create_new_customer_int = new Intent(AdminActivity.this, CustomerRegistrationActivity.class);
                startActivity(create_new_customer_int);
            }
        });
        create_new_distributor_btn = (Button) findViewById(R.id.create_new_distributor);
        create_new_distributor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create_new_distributor_int = new Intent(AdminActivity.this, DistributorRegistrationActivity.class);
                startActivity(create_new_distributor_int);
            }
        });
        edit_distributor = (Button) findViewById(R.id.edit_distributor);
        edit_distributor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_distributor = new Intent(AdminActivity.this, EditDistributorActivity.class);
                startActivity(edit_distributor);
            }
        });

    }
}
