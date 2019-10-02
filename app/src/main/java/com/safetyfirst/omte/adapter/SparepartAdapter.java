package com.safetyfirst.omte.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.safetyfirst.omte.R;
import com.safetyfirst.omte.model.Sparepart;

import java.util.ArrayList;

public class SparepartAdapter extends RecyclerView.Adapter<SparepartAdapter.SparepartViewHolder> {
    private ArrayList<Sparepart> sparepartArrayList;
    private Context mContext;

    public SparepartAdapter(Context mContext, ArrayList<Sparepart> sparepartArrayList) {
        this.sparepartArrayList = sparepartArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SparepartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.sparepart_item, parent, false);
        return new SparepartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SparepartViewHolder holder, int position) {
        Sparepart sparepart = sparepartArrayList.get(position);
        holder.tvSpareName.setText(sparepart.getSpareName());
        holder.tvSpareCategory.setText(sparepart.getSpareCategory());
        holder.tvSparePrice.setText(String.format("Rp. %s", sparepart.getSparePrice()));
    }

    @Override
    public int getItemCount() {
        return sparepartArrayList.size();
    }

    class SparepartViewHolder extends RecyclerView.ViewHolder {
        ImageView imageSpare;
        TextView tvSpareName, tvSpareCategory, tvSparePrice;

        SparepartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageSpare = itemView.findViewById(R.id.image_spare_part);
            tvSpareName = itemView.findViewById(R.id.tv_spare_name);
            tvSpareCategory = itemView.findViewById(R.id.tv_spare_category);
            tvSparePrice = itemView.findViewById(R.id.tv_spare_price);
        }
    }
}
