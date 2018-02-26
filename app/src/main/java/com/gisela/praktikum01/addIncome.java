package com.gisela.praktikum01;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.gisela.praktikum01.adapter.IncomeCategoryAdapter;
import com.gisela.praktikum01.entity.IncomeCategory;
import com.gisela.praktikum01.entity.IncomeCategoryTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class addIncome extends AppCompatActivity {

    @BindView(R.id.cmbKategoriPemasukan) Spinner cmbKategoriPemasukan;
    @BindView(R.id.txtPemasukan) EditText txtPemasukan;
    @BindView(R.id.txtDeskripsi) EditText txtDeskripsi;
    @BindView(R.id.txtDate) EditText txtDate;
    @BindView(R.id.btnBack) ImageButton btnBack;
    Calendar calendar=Calendar.getInstance();
    Spinner spinner;
    private IncomeCategoryAdapter icAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);
        ButterKnife.bind(this);
        spinner = (Spinner) findViewById(R.id.cmbKategoriPemasukan);
        icAdapter= new IncomeCategoryAdapter(this);
        spinner.setAdapter(icAdapter);
        IncomeCategoryTask icTask = new IncomeCategoryTask(this);
        icTask.execute();
    }

    public void updateListWithData(ArrayList<IncomeCategory> categories) {
        if (null != categories) {
            icAdapter.setItems(categories);
        }
    }

    @OnClick(R.id.btnBack)
    void btnBackOnAct (){
        Intent goToDashboard =new Intent(addIncome.this,Dashboard.class);
        startActivity(goToDashboard);
    }

    @OnClick(R.id.btnTambahPemasukan)
    void btnTambahPemasukanOnAct(){
        if (TextUtils.isEmpty(txtDate.getText().toString().trim()) || TextUtils.isEmpty
                (cmbKategoriPemasukan.getSelectedItem().toString().trim()) || TextUtils.isEmpty
                (txtPemasukan.getText().toString().trim())){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Please fill all field");
            alert.show();
        }else {
            Date getDate = new Date();
            String kategori = cmbKategoriPemasukan.getSelectedItem().toString().trim();
            int pemasukan = Integer.valueOf(txtPemasukan.getText().toString().trim());
            String deskripsi = txtDeskripsi.getText().toString().trim();
        }
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
