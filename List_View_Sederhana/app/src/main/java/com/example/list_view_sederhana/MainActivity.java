package com.example.list_view_sederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView ListItem,ListView;
    SimpleAdapter adapter;
    HashMap<String,String> map;
    ArrayList<HashMap<String,String>>mylist;
    String[] nama;
    String[] lokasi;
    String[] keterangan;
    Integer[] gambar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView = findViewById(R.id.idLV);

        nama = new String[]{
                "Pasar Cidu","Pasar Senggol","Pasar Sentral"
        };
        lokasi = new String[]{
                "Jl. Tinumbu, Kota Makassar","Jl. Pajjaiang, Kota makassar","Jl. Kyai H. Agus Salim, Kota Makassar",

        };
        keterangan = new String[]{
                "Pasar jajanan viral di Makassar","Pasar trift malam di Makassar","Pasar Pusat Perdagangan di Makassar"
        };
        gambar = new Integer[]{
                R.drawable.pasarcidu, R.drawable.pasarsenggol, R.drawable.pasarsentral
        };

        mylist = new ArrayList<HashMap<String, String>>();
        for (int i=0; i<nama.length; i++) {
            map = new HashMap<String, String>();
            map.put("Nama", nama[i]);
            map.put("Lokasi", lokasi[i]);
            map.put("Keterangan", keterangan[i]);
            map.put("Gambar", gambar[i].toString());
            mylist.add(map);
        }

        adapter = new SimpleAdapter(this, mylist, R.layout.list_item,
                    new String[]{"Nama","Lokasi", "Keterangan", "Gambar"}, new int[]{R.id.idTXTNama,
                    (R.id.idTXTLokasi),(R.id.idTXTKeterangan),(R.id.idLVGambar)});


        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {



                Intent page = new Intent(MainActivity.this,ActivityResult.class);
                page.putExtra("Nama", nama[position]);
                page.putExtra("Lokasi", lokasi[position]);
                page.putExtra("Keterangan", keterangan[position]);
                page.putExtra("Gambar",gambar[position]);
                startActivity(page);
            }
        });
    }
}