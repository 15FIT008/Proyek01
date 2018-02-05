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
}
