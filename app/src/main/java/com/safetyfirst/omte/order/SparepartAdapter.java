package com.safetyfirst.omte.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.safetyfirst.omte.R;

import java.util.ArrayList;

public class SparepartAdapter extends RecyclerView.Adapter<SparepartAdapter.SparepartViewHolder> {

    private final Context context;
    private final ArrayList<Sparepart> spareparts;

    public SparepartAdapter(Context context, ArrayList<Sparepart> spareparts) {
        this.context = context;
        this.spareparts = spareparts;
    }

    @NonNull
    @Override
    public SparepartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_sparepart, parent, false);
        return new SparepartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SparepartViewHolder holder, int position) {
        holder.tvSparepartName.setText(spareparts.get(position).getName());
        holder.tvPriceSparepart.setText("Rp. " + spareparts.get(position).getIdr());
    }

    @Override
    public int getItemCount() {
        return spareparts.size();
    }

    public class SparepartViewHolder extends RecyclerView.ViewHolder {

        final TextView tvSparepartName, tvPriceSparepart;

        public SparepartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSparepartName = itemView.findViewById(R.id.tv_sparepart);
            tvPriceSparepart = itemView.findViewById(R.id.tv_idr_sparepart);
        }
    }
}
