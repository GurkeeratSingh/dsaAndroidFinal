package com.example.gurkeeratsingh.dsaandroidfinal;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class miAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> itemname;
    private final List<String> imgid;
    private final List<String> type;

    public miAdapter(Activity context, List<String> itemname, List<String> imgid, List<String> type) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.type=type;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname.get(position));
        Picasso.with(getContext()).load(imgid.get(position)).into(imageView);
        extratxt.setText("Tipo: "+type.get(position));
        return rowView;

    };
}