package com.g7.e_medical;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_id = "com.g7.e_medical.EXTRA_id";
    public static final String EXTRA_name = "com.g7.e_medical.EXTRA_name";
    public static final String EXTRA_blood = "com.g7.e_medical.EXTRA_blood";
    public static final String EXTRA_asthma = "com.g7.e_medical.EXTRA_asthma";
    public static final String EXTRA_blood_pressure = "com.g7.e_medical.EXTRA_blood_pressure";
    public static final String EXTRA_heart_disease = "com.g7.e_medical.EXTRA_heart_disease";
    public static final String EXTRA_diabetes = "com.g7.e_medical.EXTRA_diabetes";
    public static final String EXTRA_other = "com.g7.e_medical.EXTRA_other";
    public static final String EXTRA_none = "com.g7.e_medical.EXTRA_none";


    TextView Tblood, Tname, Tasthma, Tblood_pressure, Theart_disease, Tdiabetes, Tother, Tnone;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.studentdetail);

        Tblood = findViewById(R.id.blood_value);
        Tname = findViewById(R.id.name_value);
        Tasthma = findViewById(R.id.asthma_value);
        Tblood_pressure = findViewById(R.id.blood_pressure_value);
        Theart_disease = findViewById(R.id.heart_disease_value);
        Tdiabetes = findViewById(R.id.diabetes_value);
        Tother = findViewById(R.id.other_value);
        Tnone = findViewById(R.id.none_value);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra(EXTRA_id)) {
            setTitle("Detail");
            Tname.setText(intent.getStringExtra(EXTRA_name));
            Tblood.setText(intent.getStringExtra(EXTRA_blood));
            Tasthma.setText(intent.getStringExtra(EXTRA_asthma));
            Tblood_pressure.setText(intent.getStringExtra(EXTRA_blood_pressure));
            Theart_disease.setText(intent.getStringExtra(EXTRA_heart_disease));
            Tdiabetes.setText(intent.getStringExtra(EXTRA_diabetes));
            Tother.setText(intent.getStringExtra(EXTRA_other));
            Tnone.setText(intent.getStringExtra(EXTRA_none));

        }
    }
}

