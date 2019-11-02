package com.safetyfirst.omte.order;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.safetyfirst.omte.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubOrderFragment extends Fragment {


    private TextView tvOrderName, tvOrderAddress, tvOrderComplaint, tvOrderTag;

    public SubOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_order, container, false);
        tvOrderName = view.findViewById(R.id.tv_order_name);
        tvOrderAddress = view.findViewById(R.id.tv_order_address);
        tvOrderComplaint = view.findViewById(R.id.tv_order_complaint);
        tvOrderTag = view.findViewById(R.id.tv_order_tag);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvOrderName.setText("Farhan");
        tvOrderAddress.setText("" +
//                "Pemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan"
                "Pemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan "
                );
        tvOrderComplaint.setText("" +
//                "Pemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan "
                "Pemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan KendaraanPemeriksaan "
        );
        tvOrderTag.setText("Pemeriksaan KendaraanPemeriksaan");
//        tvOrderTag.setText("Tidak ada");
    }
}
