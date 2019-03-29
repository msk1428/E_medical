package com.g7.e_medical;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class listActivity extends AppCompatActivity  {
    private recordViewModel recordviewModel;
    public static final int Add_REQ = 1;
    public static final int detail_REQ = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        FloatingActionButton floatingActionButton = findViewById(R.id.button_add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listActivity.this, add.class);
                startActivityForResult(intent, Add_REQ);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final Adapter_record adapterRecord = new Adapter_record();
        recyclerView.setAdapter(adapterRecord);

        recordviewModel = ViewModelProviders.of(this).get(recordViewModel.class);
        recordviewModel.getAllrecored().observe(this, new Observer<List<M_recored>>() {
            @Override
            public void onChanged(@Nullable List<M_recored> m_recoreds) {
                adapterRecord.setM_recoreds(m_recoreds);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                recordviewModel.delete(adapterRecord.getM_record(viewHolder.getAdapterPosition()));
                Toast.makeText(listActivity.this, "Record deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        adapterRecord.setOnItemClickListener(new Adapter_record.OnItemClickListener() {
            @Override
            public void onItemClick(M_recored m_recored) {

                Intent intent = new Intent(listActivity.this,DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_id,m_recored.getId());
                intent.putExtra(DetailActivity.EXTRA_name,m_recored.getName());
                intent.putExtra(DetailActivity.EXTRA_blood,m_recored.getBlood());
                intent.putExtra(DetailActivity.EXTRA_asthma,m_recored.getAsthma());
                intent.putExtra(DetailActivity.EXTRA_blood_pressure,m_recored.getBlood_pressure());
                intent.putExtra(DetailActivity.EXTRA_diabetes,m_recored.getDiabetes());
                intent.putExtra(DetailActivity.EXTRA_heart_disease,m_recored.getHeart_disease());
                intent.putExtra(DetailActivity.EXTRA_none,m_recored.getNone());
                intent.putExtra(DetailActivity.EXTRA_other,m_recored.getOther());
                startActivityForResult(intent,detail_REQ);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Add_REQ && resultCode == RESULT_OK) {
            String name = data.getStringExtra(add.EXTRA_name);
            String blood = data.getStringExtra(add.EXTRA_blood);
            String asthma = data.getStringExtra(add.EXTRA_asthma);
            String blood_pressure= data.getStringExtra(add.EXTRA_blood_pressure);
            String heart_disease= data.getStringExtra(add.EXTRA_heart_disease);
            String diabetes=data.getStringExtra(add.EXTRA_diabetes);
            String other=data.getStringExtra(add.EXTRA_other);
            String none=data.getStringExtra(add.EXTRA_none);

                M_recored m_recored = new M_recored(blood, name, asthma,blood_pressure, heart_disease, diabetes, other, none);
            recordviewModel.insert(m_recored);

            Toast.makeText(this, "record saved", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "record not saved", Toast.LENGTH_LONG).show();
            return;
        }
    }

}
