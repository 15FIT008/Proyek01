package com.gisela.praktikum01;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gisela.praktikum01.entity.UserLoginTask;
import com.gisela.praktikum01.entity.UserWrapper;

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
        }else{
            UserLoginTask userLoginTask = new UserLoginTask(this);
            System.out.println("EMAIL : " + txtEmail.getText().toString() + "PASSWORD : " +
                    txtPassword.getText().toString());
            userLoginTask.execute(txtEmail.getText().toString(), txtPassword.getText().toString());
        }
    }
    public void openDashboard (UserWrapper userWrapper) {
        if (null != userWrapper && userWrapper.getStatus() == 1) {
            Toast.makeText(this, userWrapper.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Dashboard.class);
            this.startActivity(intent);
            this.finish();
        } else {
            Toast.makeText(this, this.getResources().getString(R.string.user_not_approved),
                    Toast.LENGTH_SHORT).show();
        }
    }
    @OnClick (R.id.btnRegistrasi)
    void btnRegistrasiOnAct(){
        Intent goToRegistrasi =new Intent(MainActivity.this,Register.class);
        startActivity(goToRegistrasi);
    }
}
