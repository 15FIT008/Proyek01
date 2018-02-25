package com.gisela.praktikum01;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class addOutcome extends AppCompatActivity {

    @BindView(R.id.cmbKategoriPemasukan) Spinner cmbKategoriPemasukan;
    @BindView(R.id.txtDate) EditText txtDate;
    @BindView(R.id.btnBack) ImageButton btnBack;
    Calendar calendar=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_outcome);
        ButterKnife.bind(this);
        List<String> kategori = new ArrayList();
        kategori.add("Makan Berat");
        kategori.add("Makan Ringan");
        kategori.add("Listrik");
        kategori.add("Transportasi");
        Spinner spinner = (Spinner) findViewById(R.id.cmbKategoriPengeluaran);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, kategori);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @OnClick(R.id.btnBack)
    void btnBackOnAct (){
        Intent goToDashboard =new Intent(addOutcome.this,Dashboard.class);
        startActivity(goToDashboard);
    }

    @OnClick(R.id.txtDate)
    public void txtDateOnAct(View v){
        new DatePickerDialog(this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            txtDateUpdate();
        }
    };

    private void txtDateUpdate(){
        String format = "dd/MM/YYYY";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format, Locale.US);
        txtDate.setText(simpleDateFormat.format(calendar.getTime()));
    }
}
