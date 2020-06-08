package org.svuonline.mahrukat.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.svuonline.mahrukat.R;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.svuonline.mahrukat.R;
import org.svuonline.mahrukat.helper.DatabaseHelper;


public class EditDistributorActivity extends AppCompatActivity {

    DatabaseHelper db;
    Spinner  select_distributor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_distributor);

        db = new DatabaseHelper(this);
        List<String> allDisList = db.getAllDistributors();
        select_distributor = (Spinner)findViewById(R.id.select_distributor);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, allDisList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_distributor.setAdapter(dataAdapter);

        String selected_item = select_distributor.getSelectedItem().toString();
        List<String> oneDistributorData = db.getDistributor(selected_item);

        EditText editText = (EditText)findViewById(R.id.distributor_registration_full_name);

//        for (int i=0;i < oneDistributorData.size();i++)
//        {
//            Log.i("Value of element "+i,oneDistributorData.get(i));
//        }

//        String x = oneDistributorData.get(2);
//        editText.setText("resr", TextView.BufferType.EDITABLE);

    }
}
