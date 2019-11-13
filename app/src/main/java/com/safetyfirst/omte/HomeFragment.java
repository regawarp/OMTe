package com.safetyfirst.omte;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.safetyfirst.omte.adapter.SparepartAdapter;
import com.safetyfirst.omte.adapter.TechicianGridAdapter;
import com.safetyfirst.omte.model.Sparepart;
import com.safetyfirst.omte.model.Technician;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private RecyclerView rvSparepart;
    private ArrayList<Technician> technicianArrayList = new ArrayList<>();
    private ArrayList<Sparepart> sparepartArrayList = new ArrayList<>();
    TechicianGridAdapter techicianGridAdapter;
    ExpandableHeightGridView gridTechnician;
    private Button btnReparasiMotor;

    public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvSparepart = view.findViewById(R.id.rv_sparepart_terbaru);
        initializeData();

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        SparepartAdapter sparepartAdapter = new SparepartAdapter(getContext(), sparepartArrayList);
        rvSparepart.setAdapter(sparepartAdapter);
        rvSparepart.setLayoutManager(layoutManager1);

        sparepartAdapter.notifyDataSetChanged();

        //GridView
        gridTechnician = view.findViewById(R.id.grid_teknisi_terdekat);

        btnReparasiMotor = view.findViewById(R.id.btn_reparasi_motor);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("technicians")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Technician technician = document.toObject(Technician.class);
                                technicianArrayList.add(technician);
                            }
                            techicianGridAdapter.notifyDataSetChanged();
                        } else {
                            Log.w("Error FireStore", "Error getting documents.", task.getException());
                        }
                    }
                });
        techicianGridAdapter = new TechicianGridAdapter(getContext(), R.id.tv_tech_name, technicianArrayList);
        gridTechnician.setAdapter(techicianGridAdapter);
        gridTechnician.setExpanded(true);

        btnReparasiMotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),FormKeluhan.class);
                startActivity(intent);
            }
        });
    }

    private void initializeData() {
        technicianArrayList.add(new Technician("1", "Regawa"));
        technicianArrayList.add(new Technician("2", "Rama"));
        sparepartArrayList.add(new Sparepart("Honda X23", "Rantai", 10000));
        sparepartArrayList.add(new Sparepart("Kit", "Fairing", 15000));
        sparepartArrayList.add(new Sparepart("Takuta 23", "Ban", 20000));
        sparepartArrayList.add(new Sparepart("RoadFighter", "Knalpot", 90000));
    }

}
