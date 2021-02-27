package com.example.nav_exppand;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class prescription_history extends Fragment {

  RecyclerView recyclerView;
  ArrayList<String> patient_names,patient_id;
  Dbhelper dbhelper;
  Cursor cursor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prescription_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycler_pres_history_id);
        dbhelper=new Dbhelper(getActivity());
        patient_id=new ArrayList<>();
        patient_names=new ArrayList<>();
        get_prescription_data();
        Prescription_history_recycler adapter =new Prescription_history_recycler(getActivity(),patient_id,patient_names);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }



    private Cursor get_prescription_data() {

        dbhelper=new Dbhelper(getActivity());
        cursor=dbhelper.get_all_patient_data();


        if( cursor!=null&&cursor.getCount()>0){

            if(cursor.moveToFirst()) {
                do {
                     patient_id.add(cursor.getString(0));
                     patient_names.add(cursor.getString(1));

                }
                while (cursor.moveToNext());
                cursor.close();

            }
        }


        return cursor;



    }


}