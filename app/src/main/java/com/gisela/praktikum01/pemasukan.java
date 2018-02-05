package com.gisela.praktikum01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class pemasukan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemasukan);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSaldo)
    void btnSaldoOnAct (){
        Intent goToDashboard = new Intent(pemasukan.this,Dashboard.class);
        startActivity(goToDashboard);

    }

    @OnClick(R.id.btnOutcome)
    void btnOutcome(){
        Intent goToOutcome = new Intent(pemasukan.this, pengeluaran.class);
        startActivity(goToOutcome);
    }

    @OnClick(R.id.btnAlokasi)
    void btnAlokasiOnAct(){
        Intent goToAlokasi = new Intent(pemasukan.this, Alokasi.class);
        startActivity(goToAlokasi);
    }
}
