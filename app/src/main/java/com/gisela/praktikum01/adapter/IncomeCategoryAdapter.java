package com.gisela.praktikum01.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gisela.praktikum01.R;
import com.gisela.praktikum01.entity.IncomeCategory;

import java.util.ArrayList;

/**
 * Created by Shiroinu on 2/26/2018.
 */

public class IncomeCategoryAdapter extends BaseAdapter{
   
    private ArrayList<IncomeCategory> categories;
    private Context context;

    public IncomeCategoryAdapter(Context context) {
        this.context = context;
        categories = new ArrayList<>();
    }

    public ArrayList<IncomeCategory> getCategories() {
        return categories;
    }

    public void setItems(ArrayList<IncomeCategory> categories) {
        this.categories.clear();
        this.categories = categories;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.spinner_income_category, parent, false);
        }

        IncomeCategory category = (IncomeCategory) getItem(i);

        TextView textViewItemName = convertView.findViewById(R.id.tv_income_category);
        textViewItemName.setText(category.getCategory());

        return convertView;
    }
}
