package com.gisela.praktikum01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Dashboard extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fabTambahPemasukan)
    void fabTambahPemasukanOnAct(){
        Intent goToAddIncome =new Intent(Dashboard.this,addIncome.class);
        startActivity(goToAddIncome);
    }

    @OnClick(R.id.btnIncome)
    void btnIncomeOnAct (){
        Intent goToIncome = new Intent(Dashboard.this,pemasukan.class);
        startActivity(goToIncome);

    }

    @OnClick(R.id.btnOutcome)
    void btnOutcome(){
        Intent goToOutcome = new Intent(Dashboard.this, pengeluaran.class);
        startActivity(goToOutcome);
    }

    @OnClick(R.id.btnAlokasi)
    void btnAlokasiOnAct(){
        Intent goToAlokasi = new Intent(Dashboard.this, Alokasi.class);
        startActivity(goToAlokasi);
    }
}
