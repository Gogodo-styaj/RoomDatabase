package com.example.roomdatabase.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomdatabase.R;
import com.example.roomdatabase.room.Mahasiswa;

import static com.example.roomdatabase.AppApplication.db;

public class EditActivity extends AppCompatActivity {

    Mahasiswa mahasiswa;
    private Button savedata;
    private EditText etAlamat;
    private EditText etKejuruan;
    private EditText etNama;
    private EditText etNim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        savedata = findViewById(R.id.save);
        etAlamat = findViewById(R.id.etAlamat1);
        etKejuruan = findViewById(R.id.etKejuruan1);
        etNim = findViewById(R.id.etNim1);
        etNama = findViewById(R.id.etNama1);

        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etAlamat.getText().toString().isEmpty() && !etKejuruan.getText().toString().isEmpty() &&
                        !etNama.getText().toString().isEmpty() && !etNim.getText().toString().isEmpty()) {

                    mahasiswa = new Mahasiswa();
                    mahasiswa.setAlamat(etAlamat.getText().toString());
                    mahasiswa.setKejuruan(etKejuruan.getText().toString());
                    mahasiswa.setNama(etNama.getText().toString());
                    mahasiswa.setNim(etNim.getText().toString());
                    //Insert data in database
                    db.userDao().update(mahasiswa);
                    startActivity(new Intent(EditActivity.this, DetailActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
