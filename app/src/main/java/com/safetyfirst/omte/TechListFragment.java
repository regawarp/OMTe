package com.safetyfirst.omte;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.safetyfirst.omte.adapter.TechnicianListAdapter;
import com.safetyfirst.omte.model.Technician;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TechListFragment extends Fragment {
    private RecyclerView rvListTech;
    private ArrayList<Technician> technicianArrayList = new ArrayList<>();
    private TechnicianListAdapter technicianListAdapter;

    public TechListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tech_list, container, false);
        rvListTech = view.findViewById(R.id.rv_list_tech);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        technicianListAdapter = new TechnicianListAdapter(getContext(), technicianArrayList);
        rvListTech.setAdapter(technicianListAdapter);
        rvListTech.setLayoutManager(layoutManager);
        technicianListAdapter.notifyDataSetChanged();
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
                            technicianListAdapter.notifyDataSetChanged();
                        } else {
                            Log.w("Error FireStore", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
