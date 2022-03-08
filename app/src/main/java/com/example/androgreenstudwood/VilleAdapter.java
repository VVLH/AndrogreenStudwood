package com.example.androgreenstudwood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class VilleAdapter extends BaseAdapter {

    Context context;
    String listvilles[];
    int listimages[];
    LayoutInflater inflater;


    public VilleAdapter(Context context, String [] listville, int [] images){

        this.context = context;
        this.listvilles = listville;
        this.listimages = images;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return listvilles.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.sigle_item, null);
        TextView txtView = (TextView) convertView.findViewById(R.id.TextView1);
        ImageView imageville = (ImageView) convertView.findViewById(R.id.imageVille);
        txtView.setText(listvilles[position]);
        imageville.setImageResource(listimages[position]);
        return convertView;
    }
}

