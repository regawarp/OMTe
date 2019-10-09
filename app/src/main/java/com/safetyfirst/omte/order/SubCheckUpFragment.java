package com.safetyfirst.omte.order;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.safetyfirst.omte.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubCheckUpFragment extends Fragment {

    private RecyclerView rvBrokenPart, rvSparepart;
    private TextView tvIdrServiceTotal, tvIdrCheckUpCost, tvIdrPriceTotal;
    private Spinner spnPaymentMethod;
    private Button btnMakePayment;

    private SparepartAdapter sparepartAdapter;
    private BrokenPartAdapter brokenPartAdapter;
    private ArrayList<Sparepart> spareparts;
    private ArrayList<BrokenPart> brokenParts;

    public SubCheckUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_check_up, container, false);

        rvBrokenPart = view.findViewById(R.id.rv_check_up);
        rvSparepart = view.findViewById(R.id.rv_sparepart);
        tvIdrServiceTotal = view.findViewById(R.id.tv_idr_service_total);
        tvIdrCheckUpCost = view.findViewById(R.id.tv_idr_check_up_cost);
        tvIdrPriceTotal = view.findViewById(R.id.tv_idr_price_total);
        spnPaymentMethod = view.findViewById(R.id.spn_payment_method);
        btnMakePayment = view.findViewById(R.id.btn_make_payment);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setSpareparts();
        setBrokenParts();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager layoutManagerBroken = new LinearLayoutManager(getContext());
        sparepartAdapter = new SparepartAdapter(getContext(), spareparts);
        rvSparepart.setLayoutManager(layoutManager);
        rvSparepart.setAdapter(sparepartAdapter);

        brokenPartAdapter = new BrokenPartAdapter(getContext(), brokenParts);
        rvBrokenPart.setLayoutManager(layoutManagerBroken);
        rvBrokenPart.setAdapter(brokenPartAdapter);

        tvIdrServiceTotal.setText("Rp. 105000");
        tvIdrCheckUpCost.setText("Rp. 10000");
        tvIdrPriceTotal.setText("Rp. 115000");
    }

    private void setSpareparts() {
        spareparts = new ArrayList<>();
        Sparepart sparepart = new Sparepart();
        sparepart.setName("Sparepart X");
        sparepart.setIdr(15000);
        spareparts.add(sparepart);
        sparepart = new Sparepart();
        sparepart.setName("Sparepart X");
        sparepart.setIdr(30000);
        spareparts.add(sparepart);
        sparepart = new Sparepart();
        sparepart.setName("Sparepart X");
        sparepart.setIdr(15000);
        spareparts.add(sparepart);
    }

    private void setBrokenParts() {
        brokenParts = new ArrayList<>();
        BrokenPart brokenPart = new BrokenPart();
        brokenPart.setName("Tag X");
        brokenPart.setIdr(15000);
        brokenParts.add(brokenPart);
        brokenPart = new BrokenPart();
        brokenPart.setName("Tag X");
        brokenPart.setIdr(15000);
        brokenParts.add(brokenPart);
        brokenPart = new BrokenPart();
        brokenPart.setName("Tag X");
        brokenPart.setIdr(15000);
        brokenParts.add(brokenPart);
        brokenPart = new BrokenPart();
        brokenPart.setName("Tag X");
        brokenPart.setIdr(15000);
        brokenParts.add(brokenPart);
        brokenPart = new BrokenPart();
        brokenPart.setName("Tag X");
        brokenPart.setIdr(15000);
        brokenParts.add(brokenPart);
        brokenPart = new BrokenPart();
        brokenPart.setName("Tag X");
        brokenPart.setIdr(15000);
        brokenParts.add(brokenPart);
    }
}
