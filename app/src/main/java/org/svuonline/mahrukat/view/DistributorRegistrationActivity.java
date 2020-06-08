package org.svuonline.mahrukat.view;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.*;

import org.svuonline.mahrukat.R;
import org.svuonline.mahrukat.helper.DatabaseHelper;

public class DistributorRegistrationActivity extends AppCompatActivity {

    EditText distributor_registration_full_name;
    EditText distributor_registration_password;
    EditText distributor_registration_password_confirmation;
    EditText distributor_registration_mobile;
    EditText distributor_registration_national_id;
    Spinner distributor_registration_city_id;
    EditText distributor_registration_address;
    EditText distributor_registration_cr_no;
    Spinner distributor_registration_sector_id;
    EditText distributor_registration_max_cylinders;
    Button distributor_registration_btn;

    DatabaseHelper db;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor_registration);

           db = new DatabaseHelper(this);
           distributor_registration_sector_id = (Spinner)findViewById(R.id.distributor_registration_sector_id);
           ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.sectorsList,R.layout.support_simple_spinner_dropdown_item);
           distributor_registration_sector_id.setAdapter(adapter1);

           distributor_registration_city_id = (Spinner)findViewById(R.id.distributor_registration_city_id);
           ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.citiesList,R.layout.support_simple_spinner_dropdown_item);
           distributor_registration_city_id.setAdapter(adapter2);

           distributor_registration_full_name = (EditText)findViewById(R.id.distributor_registration_full_name);
           distributor_registration_password = (EditText)findViewById(R.id.distributor_registration_password);
           distributor_registration_password_confirmation = (EditText)findViewById(R.id.distributor_registration_password_confirmation);
           distributor_registration_mobile = (EditText)findViewById(R.id.distributor_registration_mobile);
           distributor_registration_national_id = (EditText)findViewById(R.id.distributor_registration_national_id);
           distributor_registration_address = (EditText)findViewById(R.id.distributor_registration_address);
           distributor_registration_cr_no = (EditText)findViewById(R.id.distributor_registration_cr_no);
           distributor_registration_max_cylinders = (EditText)findViewById(R.id.distributor_registration_max_cylinders);

           distributor_registration_btn = (Button) findViewById(R.id.distributor_registration_btn);
           distributor_registration_btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   final String dis_exist = distributor_registration_cr_no.getText().toString().trim();
                   boolean dis_exist_bool = db.checkDistributorIfExist(dis_exist);

                   if(distributor_registration_full_name.getText().toString().trim().equals("") ||
                           distributor_registration_password.getText().toString().trim().equals("") ||
                           distributor_registration_password_confirmation.getText().toString().trim().equals("") ||
                           distributor_registration_mobile.getText().toString().trim().equals("") ||
                           distributor_registration_national_id.getText().toString().trim().equals("") ||
                           distributor_registration_address.getText().toString().trim().equals("") ||
                           distributor_registration_cr_no.getText().toString().trim().equals("") ||
                           distributor_registration_max_cylinders.getText().toString().trim().equals("")) {

                       Toast.makeText(DistributorRegistrationActivity.this, "يرجى تعبئة كافة الحقول", Toast.LENGTH_SHORT).show();

                   } else if (!distributor_registration_password.getText().toString().trim().equals(distributor_registration_password_confirmation.getText().toString().trim())) {
                       Toast.makeText(DistributorRegistrationActivity.this, "كلمات المرور غير متطابقة", Toast.LENGTH_SHORT).show();
                   } else if(dis_exist_bool) {
                       Toast.makeText(DistributorRegistrationActivity.this, "رقم السجل التجاري موجود مسبقاً", Toast.LENGTH_SHORT).show();
                   } else {

                       long val = db.addDistributor(distributor_registration_full_name.getText().toString().trim(),
                               distributor_registration_password.getText().toString().trim(),
                               distributor_registration_mobile.getText().toString().trim(),
                               distributor_registration_national_id.getText().toString().trim(),
                               distributor_registration_city_id.getSelectedItem().toString().trim(),
                               distributor_registration_address.getText().toString().trim(),
                               distributor_registration_cr_no.getText().toString().trim(),
                               distributor_registration_sector_id.getSelectedItem().toString().trim(),
                               distributor_registration_max_cylinders.getText().toString().trim());
                       if (val > 0) {

                           Toast.makeText(DistributorRegistrationActivity.this, "تم إنشاء الموزع الجديد", Toast.LENGTH_SHORT).show();

                       }else {

                       Toast.makeText(DistributorRegistrationActivity.this, "فشل إنشاء الموزع", Toast.LENGTH_SHORT).show();
                       }

                   }
               }
           });

       }
}
