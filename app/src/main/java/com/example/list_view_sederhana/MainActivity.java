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

    //deklarasi variabel
    ListView ListItem,ListView;
    SimpleAdapter adapter;
    HashMap<String,String> map;
    ArrayList<HashMap<String,String>>mylist;
    String[] nama;
    String[] Nim;
    String[] kelas;
    Integer[] gambar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //proses menghubungkan ke layout
        ListView = findViewById(R.id.idLV);

        nama = new String[]{
                "Fahrah Lestari","Nurlatifah Ismail","Mughirah Nur"
        };
        Nim = new String[]{
                "42520007","42520020","42520013"

        };
        kelas = new String[]{
                "3A TKJ","3A TKJ","3A TKJ"
        };
        gambar = new Integer[]{
                R.drawable.mh1, R.drawable.mh2, R.drawable.mh3
        };

        mylist = new ArrayList<HashMap<String, String>>();
        for (int i=0; i<nama.length; i++) {
            map = new HashMap<String, String>();
            map.put("Nama", nama[i]);
            map.put("Nim", Nim[i]);
            map.put("Kelas", kelas[i]);
            map.put("Gambar", gambar[i].toString());
            mylist.add(map);
        }

        //buat variabel adapter bertipe string yang isinya nama, nim, kelas dan gambar
        adapter = new SimpleAdapter(this, mylist, R.layout.list_item,
                    new String[]{"Nama","Nim", "Kelas", "Gambar"}, new int[]{R.id.idTXTNama,
                    (R.id.idTXTNim),(R.id.idTXTKelas),(R.id.idLVGambar)});


        //set list view menggunakan variabel adapter
        ListView.setAdapter(adapter);

        //metode set on item click listener
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {



                Intent page = new Intent(MainActivity.this,ActivityResult.class);
                page.putExtra("Nama", nama[position]);
                page.putExtra("Nim", Nim[position]);
                page.putExtra("Kelas", kelas[position]);
                page.putExtra("Gambar",gambar[position]);
                startActivity(page);
            }
        });
    }
}