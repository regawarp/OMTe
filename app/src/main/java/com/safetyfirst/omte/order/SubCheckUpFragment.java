package com.safetyfirst.omte.order;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.safetyfirst.omte.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubCheckUpFragment extends Fragment {


    public SubCheckUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sub_check_up, container, false);
    }

}
