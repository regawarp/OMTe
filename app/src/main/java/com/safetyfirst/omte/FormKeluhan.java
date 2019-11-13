package com.safetyfirst.omte;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FormKeluhan extends AppCompatActivity {
    private Button btnSubmitKeluhan;
    private EditText etAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_keluhan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Isi Form Keluhan");

        btnSubmitKeluhan = findViewById(R.id.btn_submit_keluhan);
        etAlamat = findViewById(R.id.et_alamat);

        btnSubmitKeluhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormKeluhan.this, PilihTeknisi.class);
                startActivity(intent);
            }
        });
        etAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormKeluhan.this, PilihAlamat.class);
                startActivity(intent);
            }
        });
    }

}
