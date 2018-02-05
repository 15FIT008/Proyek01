package com.gisela.praktikum01;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtEmail) EditText txtEmail;
    @BindView(R.id.txtPassword) EditText txtPassword;
    @BindView(R.id.btnLogin) Button btnLogin;
    @BindView(R.id.btnRegistrasi) Button btnRegistrasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.btnLogin)
    void btnLoginOnAct(){
        if(TextUtils.isEmpty(txtEmail.getText().toString().trim()) || TextUtils.isEmpty(txtPassword.getText().toString().trim())){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Please fill all field!");
            alert.show();
        }else if (!txtEmail.getText().toString().trim().equals("giselakurniawati18@gmail.com") || !txtPassword.getText().toString().trim().equals("ukm12345*")) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Your email or password is not valid");
            alert.show();
        }else {
            Intent goToDashboard =new Intent(MainActivity.this,Dashboard.class);
            startActivity(goToDashboard);
        }
    }

    @OnClick (R.id.btnRegistrasi)
    void btnRegistrasiOnAct(){
        Intent goToRegistrasi =new Intent(MainActivity.this,Register.class);
        startActivity(goToRegistrasi);
    }
}
