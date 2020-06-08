package org.svuonline.mahrukat.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import org.svuonline.mahrukat.R;
import org.svuonline.mahrukat.helper.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    DatabaseHelper db;
    Spinner userType;
    View activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        username = (EditText) findViewById(R.id.username_or_id);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        userType = (Spinner)findViewById(R.id.userTypeSpinner);
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.userType,R.layout.support_simple_spinner_dropdown_item);
        userType.setAdapter(adapter);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = userType.getSelectedItem().toString();
                String user = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                if (item.equals("مدير")){
                    boolean res = db.checkAdmin(user, pwd);
                    if (res) {
                        Intent loginScreen = new Intent(LoginActivity.this, AdminActivity.class);
                        startActivity(loginScreen);
                    } else {
                        Toast.makeText(LoginActivity.this, "خطأ بتسجيل الدخول", Toast.LENGTH_SHORT).show();
                    }
                }else if (item.equals("موزّع")){
                    boolean res = db.checkDistributor(user, pwd);
                    if (res) {
                        Intent loginScreen = new Intent(LoginActivity.this, DistributorActivity.class);
                        startActivity(loginScreen);
                    } else {
                        Toast.makeText(LoginActivity.this, "خطأ بتسجيل الدخول", Toast.LENGTH_SHORT).show();
                    }
                }else {

                    boolean res = db.checkCustomer(user, pwd);
                    if (res) {
                        Intent loginScreen = new Intent(LoginActivity.this, CustomerActivity.class);
                        startActivity(loginScreen);
                    } else {
                        Toast.makeText(LoginActivity.this, "خطأ بتسجيل الدخول", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        userType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = userType.getSelectedItem().toString();

                if (item.equals("مدير")) {
                    username.setHint("اسم المستخدم");

                } else if (item.equals("موزّع")) {
                    username.setHint("رقم السجل التجاري");

                } else
                    username.setHint("رثم البطاقة");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
