package com.gisela.praktikum01;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends AppCompatActivity {

    @BindView(R.id.txtFullName) EditText txtFullname;
    @BindView(R.id.txtEmail) EditText txtEmail;
    @BindView(R.id.txtPassword) EditText txtPassword;
    @BindView(R.id.txtRePassword) EditText txtRePassword;
    @BindView(R.id.btnRegistrasi) Button btnBackToLogin;
    @BindView(R.id.btnBackToLogin) ImageButton btnRegistrasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnBackToLogin)
    void btnBackToLoginOnAct (){
        Intent goToLogin =new Intent(Register.this,MainActivity.class);
        startActivity(goToLogin);
    }

    @OnClick(R.id.btnRegistrasi)
    void btnRegistrasiOnAct(){
        if(TextUtils.isEmpty(txtFullname.getText().toString().trim()) || TextUtils.isEmpty(txtEmail.getText().toString().trim()) || TextUtils.isEmpty(txtPassword.getText().toString().trim()) || TextUtils.isEmpty(txtRePassword.getText().toString().trim())){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Please fill all field!");
            alert.show();
        }else if (txtEmail.getText().toString().trim().equals("giselakurniawati18@gmail.com")){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Your email has already registered!");
            alert.show();
        }else if(!txtPassword.getText().toString().trim().equals(txtRePassword.getText().toString().trim())){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Your password and re-password are mismatch!");
            alert.show();
        }
        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Your registration is successful!");
            alert.show();
            Intent goToLogin =new Intent(Register.this,MainActivity.class);
            startActivity(goToLogin);
        }
    }
}
