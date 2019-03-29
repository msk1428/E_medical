package com.g7.e_medical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class add extends AppCompatActivity  {

    public static final String EXTRA_name = "com.g7.e_medical.EXTRA_name";
    public static final String EXTRA_blood = "com.g7.e_medical.EXTRA_blood";
    public static final String EXTRA_asthma = "com.g7.e_medical.EXTRA_asthma";
    public static final String EXTRA_blood_pressure = "com.g7.e_medical.EXTRA_blood_pressure";
    public static final String EXTRA_heart_disease = "com.g7.e_medical.EXTRA_heart_disease";
    public static final String EXTRA_diabetes = "com.g7.e_medical.EXTRA_diabetes";
    public static final String EXTRA_other = "com.g7.e_medical.EXTRA_other";
    public static final String EXTRA_none = "com.g7.e_medical.EXTRA_none";
    public String Asthma="no", blood_pressure="no", heart_disease="no", diabetes="no", other="no", none="no", blood="no";
    private EditText editTextname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        editTextname = findViewById(R.id.input_name);



        Spinner spinner = (Spinner) findViewById(R.id.blood1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                blood=(String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        setTitle("Add record");

    }

    private void saverecored() {
        String name = editTextname.getText().toString();
        if (name.trim().isEmpty() ) {
            Toast.makeText(this, "Please insert a student name ", Toast.LENGTH_SHORT).show();
            return;
        }else if(none == "yes"&&(Asthma=="yes"||diabetes=="yes"||heart_disease=="yes"||blood_pressure=="yes"||other=="yes")){
            Toast.makeText(this, "Please don't choose none with other choices", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_name, name);
        data.putExtra(EXTRA_blood, blood);
        data.putExtra(EXTRA_asthma, Asthma);
        data.putExtra(EXTRA_diabetes, diabetes);
        data.putExtra(EXTRA_heart_disease, heart_disease);
        data.putExtra(EXTRA_blood_pressure, blood_pressure);
        data.putExtra(EXTRA_none, none);
        data.putExtra(EXTRA_other, other);
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_recored_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkbox_Asthma:
                if (checked) {
                    Asthma = "yes";
                } else {
                    Asthma = "no";
                }
                break;
            case R.id.checkbox_diabetes:
                if (checked) {
                    diabetes = "yes";
                } else {
                    diabetes = "no";
                }
                break;
            case R.id.checkbox_heart_disease:
                if (checked) {
                    heart_disease = "yes";
                } else {
                    heart_disease = "no";
                }
                break;
            case R.id.checkbox_blood_pressure:
                if (checked) {
                    blood_pressure = "yes";
                } else {
                    blood_pressure = "no";
                }
                break;
            case R.id.checkbox_none:
                if (checked) {
                    none = "yes";
                } else {
                    none = "no";
                }
                break;
            case R.id.checkbox_other:
                if (checked) {
                    other = "yes";
                } else {
                    other = "no";
                }
                break;

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                saverecored();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
