package com.example.projecttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailkampus extends AppCompatActivity {
    ImageView id;
    TextView nama, akreditas, status, jenis, alamat, kota, provinsi, website, singkat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailkampus);



        id = (ImageView)findViewById(R.id.logo);
        nama = (TextView)findViewById(R.id.nama);
        akreditas = (TextView)findViewById(R.id.akreditas);
        status = (TextView)findViewById(R.id.status);
        jenis = (TextView)findViewById(R.id.jenis);
        alamat = (TextView)findViewById(R.id.alamat);
        kota = (TextView)findViewById(R.id.kota);
        provinsi = (TextView)findViewById(R.id.provinsi);
        website = (TextView)findViewById(R.id.website);
        singkat = (TextView)findViewById(R.id.singkat);

        Intent i = getIntent();

        String b = i.getStringExtra("nama");
        String c = i.getStringExtra("akreditas");
        String d = i.getStringExtra("status");
        String e = i.getStringExtra("jenis");
        String f = i.getStringExtra("alamat");
        String g = i.getStringExtra("kota");
        String h = i.getStringExtra("provinsi");
        String ii = i.getStringExtra("website");
        String j = i.getStringExtra("singkat");

        id.setImageResource(R.drawable.abstrak1);
        nama.setText(b);
        akreditas.setText(c);
        status.setText(d);
        jenis.setText(e);
        alamat.setText(f);
        kota.setText(g);
        provinsi.setText(h);
        website.setText(ii);
        singkat.setText(j);


    }
    }
