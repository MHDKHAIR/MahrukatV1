package org.svuonline.mahrukat.view;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.svuonline.mahrukat.R;
import org.svuonline.mahrukat.helper.DatabaseHelper;

public class CustomerRegistrationActivity extends AppCompatActivity {

    EditText customer_registration_full_name;
    EditText customer_registration_password;
    EditText customer_registration_password_confirmation;
    EditText customer_registration_mobile;
    EditText customer_registration_national_id;
    Spinner  customer_registration_city_id;
    EditText customer_registration_address;
    EditText customer_registration_card_id;
    Spinner  customer_registration_sector_id;
    Spinner  customer_registration_distributor_id;
    Button   customer_registration_btn;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);
        db = new DatabaseHelper(this);

        customer_registration_sector_id = (Spinner)findViewById(R.id.customer_registration_sector_id);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.sectorsList,R.layout.support_simple_spinner_dropdown_item);
        customer_registration_sector_id.setAdapter(adapter1);

        customer_registration_city_id = (Spinner)findViewById(R.id.customer_registration_city_id);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.citiesList,R.layout.support_simple_spinner_dropdown_item);
        customer_registration_city_id.setAdapter(adapter2);

        List<String> allDisList = db.getAllDistributors();
        customer_registration_distributor_id = (Spinner)findViewById(R.id.customer_registration_distributor_id);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, allDisList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customer_registration_distributor_id.setAdapter(dataAdapter);


        customer_registration_full_name = (EditText)findViewById(R.id.customer_registration_full_name);
        customer_registration_password = (EditText)findViewById(R.id.customer_registration_password);
        customer_registration_password_confirmation = (EditText)findViewById(R.id.customer_registration_password_confirmation);
        customer_registration_mobile = (EditText)findViewById(R.id.customer_registration_mobile);
        customer_registration_national_id = (EditText)findViewById(R.id.customer_registration_national_id);
        customer_registration_address = (EditText)findViewById(R.id.customer_registration_address);
        customer_registration_card_id = (EditText)findViewById(R.id.customer_registration_card_id);


        customer_registration_btn = (Button) findViewById(R.id.customer_registration_btn);
        customer_registration_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String cus_exist = customer_registration_card_id.getText().toString().trim();
                boolean cus_exist_bool = db.checkCustomerIfExist(cus_exist);

                if(customer_registration_full_name.getText().toString().trim().equals("") ||
                        customer_registration_password.getText().toString().trim().equals("") ||
                        customer_registration_password_confirmation.getText().toString().trim().equals("") ||
                        customer_registration_mobile.getText().toString().trim().equals("") ||
                        customer_registration_national_id.getText().toString().trim().equals("") ||
                        customer_registration_address.getText().toString().trim().equals("") ||
                        customer_registration_card_id.getText().toString().trim().equals("")) {

                    Toast.makeText(CustomerRegistrationActivity.this, "الرجاء تعبئة كافة الحقول", Toast.LENGTH_SHORT).show();

                } else if (!customer_registration_password.getText().toString().trim().equals(customer_registration_password_confirmation.getText().toString().trim())) {
                    Toast.makeText(CustomerRegistrationActivity.this, "كلمات المرور غير متطابقة", Toast.LENGTH_SHORT).show();
                } else if(cus_exist_bool) {
                    Toast.makeText(CustomerRegistrationActivity.this, "رثم البطاقة موجود مسبقاً", Toast.LENGTH_SHORT).show();
                } else {

                    long val = db.addCustomer(customer_registration_full_name.getText().toString().trim(),
                            customer_registration_password.getText().toString().trim(),
                            customer_registration_mobile.getText().toString().trim(),
                            customer_registration_national_id.getText().toString().trim(),
                            customer_registration_city_id.getSelectedItem().toString().trim(),
                            customer_registration_address.getText().toString().trim(),
                            customer_registration_card_id.getText().toString().trim(),
                            customer_registration_sector_id.getSelectedItem().toString().trim(),
                            customer_registration_distributor_id.getSelectedItem().toString().trim());
                    if (val > 0) {

                        Toast.makeText(CustomerRegistrationActivity.this, "تم إنشاء الزبون الجديد", Toast.LENGTH_SHORT).show();

                    }else {

                        Toast.makeText(CustomerRegistrationActivity.this, "فشل إنشاء الزبون", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}
