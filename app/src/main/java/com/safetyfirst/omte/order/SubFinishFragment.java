package com.safetyfirst.omte.order;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.fragment.app.Fragment;

import com.safetyfirst.omte.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubFinishFragment extends Fragment {

    private TextView tvFinishTitle;
    private AppCompatRatingBar rbService;
    private EditText edtDescriptionService;
    private Button btnRatingInput;

    public SubFinishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_finish, container, false);
        tvFinishTitle = view.findViewById(R.id.tv_finish_title);
        rbService = view.findViewById(R.id.rb_techician);
        edtDescriptionService = view.findViewById(R.id.edt_description);
        btnRatingInput = view.findViewById(R.id.btn_rating_input);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String technisian = "Teknisi X";
        tvFinishTitle.setText("Berikan Rating Terhadap " + technisian);
    }
}
