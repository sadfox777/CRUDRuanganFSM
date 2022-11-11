package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    protected Cursor cursor; //Cursors menyimpan hasil records dari query dalam rows
    Database database;
    Button btn_simpan;
    EditText ruangan,gedung,kapasitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        database = new Database(this);
        ruangan = findViewById(R.id.ruangan);
        gedung = findViewById(R.id.gedung);
        kapasitas = findViewById(R.id.kapasitas);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("INSERT INTO crud (ruangan,gedung, kapasitas) VALUES('"+ruangan.getText().toString()+"', '"+gedung.getText().toString()+"', '"+kapasitas.getText().toString()+"')");
                Toast.makeText(CreateActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();

            }
        });
    }
}