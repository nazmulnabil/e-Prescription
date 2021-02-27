package com.example.nav_exppand;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Add_patient_recycler extends RecyclerView.Adapter<Add_patient_recycler.PatientiewHolder> {


    Context context;
    ArrayList<String> id;
    ArrayList<String> patient_names;
    ArrayList<String> patient_ages;
    ArrayList<String> patient_gender;
    ArrayList<String> patient_nickname;
    ArrayList<String> patient_mobile;
    ArrayList<String> patient_email;


    public Add_patient_recycler(Context context, ArrayList<String> patient_names, ArrayList<String> patient_ages, ArrayList<String> patient_gender, ArrayList<String> patient_nickname, ArrayList<String> patient_mobile, ArrayList<String> patient_email) {
        this.context = context;
        this.patient_names = patient_names;
        this.patient_ages = patient_ages;
        this.patient_gender = patient_gender;
        this.patient_nickname = patient_nickname;
        this.patient_mobile = patient_mobile;
        this.patient_email = patient_email;
    }



    @NonNull
    @Override
    public PatientiewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View v=layoutInflater.inflate(R.layout.view_pat_sample,parent,false);


        return new PatientiewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientiewHolder holder, int position) {
       holder.name.setText("NAME:"+patient_names.get(position));
       holder.gender.setText("GENDER:"+patient_gender.get(position));
       holder.age.setText("AGE:"+patient_ages.get(position));
       holder.nickname.setText("NICKNAME:"+patient_nickname.get(position));
       holder.mobile.setText("MOBILE:"+patient_mobile.get(position));
       holder.email.setText("EMAIL:"+patient_email.get(position));


    }

    @Override
    public int getItemCount() {
        return patient_names.size();
    }

    public class PatientiewHolder extends RecyclerView.ViewHolder {
     RelativeLayout relativeLayout;
        TextView name, gender,age,nickname,mobile,email;

        public PatientiewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.sample_name);
            gender = itemView.findViewById(R.id.sample_gender);
            age = itemView.findViewById(R.id.sample_age);
           nickname = itemView.findViewById(R.id.sample_nickname);
           mobile = itemView.findViewById(R.id.sample_mobile);
           email = itemView.findViewById(R.id.sample_email);


        }
    }
}