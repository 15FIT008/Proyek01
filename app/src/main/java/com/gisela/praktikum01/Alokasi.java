package com.gisela.praktikum01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Alokasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alokasi);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSaldo)
    void btnSaldoOnAct (){
        Intent goToDashboard = new Intent(Alokasi.this,Dashboard.class);
        startActivity(goToDashboard);

    }

    @OnClick(R.id.btnOutcome)
    void btnOutcome(){
        Intent goToOutcome = new Intent(Alokasi.this, pengeluaran.class);
        startActivity(goToOutcome);
    }

    @OnClick(R.id.btnOutcome)
    void btnOutcomeOnAct(){
        Intent goToPengeluaran = new Intent(Alokasi.this, pengeluaran.class);
        startActivity(goToPengeluaran);
    }
}
