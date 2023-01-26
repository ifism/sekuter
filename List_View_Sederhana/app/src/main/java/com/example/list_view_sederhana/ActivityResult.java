package com.example.list_view_sederhana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {

    ImageView TVResultGambar;
    TextView TVResult1, TVResult2, TVResult3;
    Toolbar toolbar;


    String nama,lokasi,keterangan;
    int gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        TVResultGambar = findViewById(R.id.idTVResultGambar);
        TVResult1 = findViewById(R.id.idTVResult1);
        TVResult2 = findViewById(R.id.idTVResult2);
        TVResult3 = findViewById(R.id.idTVResult3);
        toolbar = findViewById(R.id.idToolbar);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });


            nama = getIntent().getStringExtra("Nama");
            lokasi = getIntent().getStringExtra("Lokasi");
            keterangan = getIntent().getStringExtra("Keterangan");
            gambar = getIntent().getIntExtra("Gambar",0);



            TVResult1.setText(nama);
            TVResult2.setText(lokasi);
            TVResult3.setText(keterangan);
            TVResultGambar.setImageResource(gambar);


    }
}