package com.gisela.praktikum01.entity;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gisela.praktikum01.MainActivity;

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

public class UserLoginTask extends AsyncTask<String, Void, UserWrapper>{

    private Context context;

    public UserLoginTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPostExecute(UserWrapper userWrapper) {
        super.onPostExecute(userWrapper);
        ((MainActivity) context).openDashboard(userWrapper);
    }

    @Override
    protected UserWrapper doInBackground(String... strings) {
        Uri uri = Uri.parse("http://10.0.2.2/wsExpenseManager/service/user_login_service.php")
                .buildUpon().build();
        UserWrapper userWraper = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(uri.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(6000);
            urlConnection.setRequestMethod("POST");

            StringBuilder builder = new StringBuilder("email=")
                    .append(URLEncoder.encode(strings[0], "UTF-8"))
                    .append("&password=")
                    .append(URLEncoder.encode(strings[1], "UTF-8"));

            DataOutputStream dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
            dataOutputStream.writeBytes(builder.toString());
            dataOutputStream.flush();
            dataOutputStream.close();

            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                ObjectMapper objectMapper = new ObjectMapper();
                userWraper = objectMapper.readValue(inputStream, UserWrapper.class);
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
        return userWraper;
    }
}
