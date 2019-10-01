package com.safetyfirst.omte.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.safetyfirst.omte.R;
import com.safetyfirst.omte.model.Technician;

import java.util.ArrayList;
import java.util.List;

public class TechicianGridAdapter extends ArrayAdapter {
    private ArrayList<Technician> technicianArrayList;

    public TechicianGridAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Technician> objects) {
        super(context, resource, objects);
        technicianArrayList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        itemView = inflater.inflate(R.layout.technician_item, null);
        ImageView imageTech = itemView.findViewById(R.id.image_tech);
        TextView tvTechSkills = itemView.findViewById(R.id.tv_tech_skills);
        TextView tvTechName = itemView.findViewById(R.id.tv_tech_name);
        TextView tvTechDistance = itemView.findViewById(R.id.tv_tech_distance);
        TextView tvTechRevCount = itemView.findViewById(R.id.tv_rev_count);
        RatingBar rbTech = itemView.findViewById(R.id.tv_rate_tech);

        Technician technician = technicianArrayList.get(position);
        tvTechName.setText(technician.getTechName());
        rbTech.setRating((float) 4.5);

        return itemView;
    }
}
