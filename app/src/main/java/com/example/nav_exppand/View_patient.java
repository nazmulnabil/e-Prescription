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
import android.widget.Toast;

import java.util.ArrayList;


public class View_patient extends Fragment {

    RecyclerView recyclerView;
     ArrayList<String> patientlist_name;
     ArrayList<String> patientlist_age;
     ArrayList<String> patientlist_gender;
     ArrayList<String> patientlist_nickname;
     ArrayList<String> patientlist_mobile;
     ArrayList<String> patientlist_email;
    Cursor cursor;
    Dbhelper dbhelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_view_patient, container, false);


        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbhelper=new Dbhelper(getActivity());
        patientlist_name=new ArrayList<>();
        patientlist_gender=new ArrayList<>();
        patientlist_age=new ArrayList<>();
        patientlist_nickname=new ArrayList<>();
        patientlist_mobile=new ArrayList<>();
        patientlist_email=new ArrayList<>();
        getalldata();


        Toast.makeText(getActivity(),"view clicked",Toast.LENGTH_SHORT).show();


        recyclerView=view.findViewById(R.id.vp_recyclerviewid);


        Add_patient_recycler adapter=new Add_patient_recycler(getActivity(),patientlist_name,patientlist_age,patientlist_gender,patientlist_nickname,patientlist_mobile,patientlist_email);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);



        recyclerView.setAdapter(adapter);
    }

    private Cursor getalldata() {
        dbhelper=new Dbhelper(getActivity());
        cursor=dbhelper.get_all_patient_data();






        if( cursor!=null&&cursor.getCount()>0){

            if(cursor.moveToFirst()) {
                do {

                    patientlist_name.add(cursor.getString(1));

                    patientlist_age.add(cursor.getString(2));
                    patientlist_age.remove(null);
                    patientlist_gender.add(cursor.getString(3));
                    patientlist_nickname.add(cursor.getString(4));
                    patientlist_mobile.add(cursor.getString(5));
                    patientlist_email.add(cursor.getString(6));

                }
                while (cursor.moveToNext());
                cursor.close();

            }
        }


         return cursor;

    }


}

