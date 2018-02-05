package com.gisela.praktikum01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class pengeluaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSaldo)
    void btnSaldoOnAct (){
        Intent goToDashboard = new Intent(pengeluaran.this,Dashboard.class);
        startActivity(goToDashboard);

    }

    @OnClick(R.id.btnIncome)
    void btnIncome(){
        Intent goToIncome = new Intent(pengeluaran.this, pemasukan.class);
        startActivity(goToIncome);
    }

    @OnClick(R.id.btnAlokasi)
    void btnAlokasiOnAct(){
        Intent goToAlokasi = new Intent(pengeluaran.this, Alokasi.class);
        startActivity(goToAlokasi);
    }
}
