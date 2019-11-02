package com.safetyfirst.omte.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.safetyfirst.omte.R;
import com.safetyfirst.omte.model.Technician;

import java.util.ArrayList;

public class TechnicianListAdapter extends RecyclerView.Adapter<TechnicianListAdapter.TechnicianViewHolder> {
    private ArrayList<Technician> technicianArrayList;
    private Context mContext;

    public TechnicianListAdapter(Context mContext, ArrayList<Technician> technicianArrayList) {
        this.technicianArrayList = technicianArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TechnicianViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.technician_list_item, parent, false);
        return new TechnicianListAdapter.TechnicianViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TechnicianViewHolder holder, int position) {
        Technician technician = technicianArrayList.get(position);
        holder.tvTechName.setText(technician.getTechName());
    }

    @Override
    public int getItemCount() {
        return technicianArrayList.size();
    }

    class TechnicianViewHolder extends RecyclerView.ViewHolder {
        TextView tvTechName;

        TechnicianViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTechName = itemView.findViewById(R.id.tv_tech_name);
        }
    }
}
