package com.gisela.praktikum01.entity;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gisela.praktikum01.MainActivity;
import com.gisela.praktikum01.Register;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Shiroinu on 2/25/2018.
 */

public class UserRegisterTask extends AsyncTask<String, Void, DataWrapper>{

    private Context context;

    public UserRegisterTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPostExecute(DataWrapper dataWrapper) {
        super.onPostExecute(dataWrapper);
        ((Register) context).openMainActivity(dataWrapper);
    }

    @Override
    protected DataWrapper doInBackground(String... strings) {
        Uri uri = Uri.parse("http://10.0.2.2/wsExpenseManager/service/add_user_service.php")
                .buildUpon().build();
        DataWrapper dataWrapper = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(uri.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(6000);
            urlConnection.setRequestMethod("POST");

            StringBuilder builder = new StringBuilder("fullname=")
                    .append(URLEncoder.encode(strings[0], "UTF-8"))
                    .append("&email=")
                    .append(URLEncoder.encode(strings[1], "UTF-8"))
                    .append("&password=")
                    .append(URLEncoder.encode(strings[2], "UTF-8"));

            DataOutputStream dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
            dataOutputStream.writeBytes(builder.toString());
            dataOutputStream.flush();
            dataOutputStream.close();

            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                ObjectMapper objectMapper = new ObjectMapper();
                dataWrapper = objectMapper.readValue(inputStream, DataWrapper.class);
                inputStream.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return dataWrapper;
    }
}
