package com.safetyfirst.omte;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.safetyfirst.omte.order.SubCheckUpFragment;
import com.safetyfirst.omte.order.SubFinishFragment;
import com.safetyfirst.omte.order.SubOrderFragment;
import com.safetyfirst.omte.order.SubServiceFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment implements View.OnClickListener {

    private TextView tvOrderCode, tvTechicianName, tvOrderDateTime, textView;
    private ImageView imgTechnician;
    private ImageButton imgButtonChat, imgButtonOrder, imgButtonCheckUp, imgButtonService, imgButtonFinish;

    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvOrderCode = view.findViewById(R.id.tv_order_code);
        tvTechicianName = view.findViewById(R.id.tv_technician_name);
        tvOrderCode = view.findViewById(R.id.tv_order_code);
        tvOrderDateTime = view.findViewById(R.id.tv_order_date_time);
        imgTechnician = view.findViewById(R.id.img_technician);
        imgButtonChat = view.findViewById(R.id.img_btn_chat);
        imgButtonOrder = view.findViewById(R.id.img_btn_order);
        imgButtonCheckUp = view.findViewById(R.id.img_btn_check_up);
        imgButtonService = view.findViewById(R.id.img_btn_service);
        imgButtonFinish = view.findViewById(R.id.img_btn_finish);

        tvOrderCode.setText("KODE ORDER : 000");
        tvTechicianName.setText("Teknisi X");
        tvOrderDateTime.setText("Waktu Order : 17/09/2019 13:00");
        Glide.with(view.getContext())
                .load(R.mipmap.ic_launcher)
                .into(imgTechnician);
//        imgButtonOrder.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.ic_launcher_background));
//        imgButtonCheckUp.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.ic_launcher_background));
//        imgButtonService.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.ic_launcher_background));
//        imgButtonFinish.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.ic_launcher_background));
        imgButtonFinish.setOnClickListener(this);
        imgButtonOrder.setOnClickListener(this);
        imgButtonService.setOnClickListener(this);
        imgButtonCheckUp.setOnClickListener(this);
        if (savedInstanceState == null) {
            Fragment fragment = new SubOrderFragment();
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.frame_sub_frag, fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commit();
        }
    }

    public void handleChat(View view) {

    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        switch (v.getId()) {
            case R.id.img_btn_chat:
                break;
            case R.id.img_btn_order:
                fragment = new SubOrderFragment();
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.frame_sub_frag, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commit();
                break;
            case R.id.img_btn_check_up:
                fragment = new SubCheckUpFragment();
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.frame_sub_frag, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commit();
                break;
            case R.id.img_btn_service:
                fragment = new SubServiceFragment();
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.frame_sub_frag, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commit();
                break;
            case R.id.img_btn_finish:
                fragment = new SubFinishFragment();
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.frame_sub_frag, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commit();
                break;
        }
    }
}
