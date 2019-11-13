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

public class BrokenPartAdapter extends RecyclerView.Adapter<BrokenPartAdapter.BrokenPartViewHolder> {

    private final Context context;
    private final ArrayList<BrokenPart> brokenParts;

    public BrokenPartAdapter(Context context, ArrayList<BrokenPart> brokenParts) {
        this.context = context;
        this.brokenParts = brokenParts;
    }


    @NonNull
    @Override
    public BrokenPartAdapter.BrokenPartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_broken_part, parent, false);
        return new BrokenPartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrokenPartViewHolder holder, int position) {
        holder.tvBrokenPartName.setText(brokenParts.get(position).getName());
        holder.tvPriceBrokenPart.setText("Rp. " + brokenParts.get(position).getIdr());
    }

    @Override
    public int getItemCount() {
        return brokenParts.size();
    }

    public class BrokenPartViewHolder extends RecyclerView.ViewHolder {

        final TextView tvBrokenPartName, tvPriceBrokenPart;

        public BrokenPartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBrokenPartName = itemView.findViewById(R.id.tv_broken_part);
            tvPriceBrokenPart = itemView.findViewById(R.id.tv_idr_service);
        }
    }
}
