package com.safetyfirst.omte.order;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.safetyfirst.omte.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubServiceFragment extends Fragment {

    private TextView tvIdrServiceTotal, tvIdrCheckUpCost, tvIdrPriceTotal;
    private Button btnMakePayment;
    private Spinner spnPaymentMethod;


    public SubServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_service, container, false);
        tvIdrServiceTotal = view.findViewById(R.id.tv_idr_service_total);
        tvIdrCheckUpCost = view.findViewById(R.id.tv_idr_check_up_cost);
        tvIdrPriceTotal = view.findViewById(R.id.tv_idr_price_total);

        btnMakePayment = view.findViewById(R.id.btn_make_payment);
        spnPaymentMethod = view.findViewById(R.id.spn_payment_method);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.payment_method, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnPaymentMethod.setAdapter(adapter);
        tvIdrServiceTotal.setText("Rp. 75.000");
        tvIdrCheckUpCost.setText("Rp. 10.000");
        tvIdrPriceTotal.setText("Rp. 85.000");

        btnMakePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
