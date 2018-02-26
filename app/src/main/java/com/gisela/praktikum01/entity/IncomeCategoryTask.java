package com.gisela.praktikum01.entity;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gisela.praktikum01.addIncome;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Shiroinu on 2/26/2018.
 */

public class IncomeCategoryTask extends AsyncTask<Void, Void, ArrayList<IncomeCategory>>{

    private Context context;

    public IncomeCategoryTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPostExecute(ArrayList<IncomeCategory> categories) {
        super.onPostExecute(categories);
        ((addIncome) context).updateListWithData(categories);
    }

    @Override
    protected ArrayList<IncomeCategory> doInBackground(Void... voids) {
        ArrayList<IncomeCategory> categories = new ArrayList<>();
        Uri uri = Uri.parse("http://10.0.2.2/wsExpenseManager/service/get_income_categories_service.php").buildUpon().build();
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(uri.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(6000);
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                ObjectMapper objectMapper = new ObjectMapper();
                categories.addAll(Arrays.asList(objectMapper.readValue(url, IncomeCategory[].class)));
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
        return categories;
    }
}
