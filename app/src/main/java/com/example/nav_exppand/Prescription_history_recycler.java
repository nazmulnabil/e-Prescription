package com.example.nav_exppand;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Prescription_history_recycler extends RecyclerView.Adapter<Prescription_history_recycler.PresViewholder> {
    Context context;
ArrayList<String> pat_id,pat_names;


    public Prescription_history_recycler(Context context,ArrayList<String> pat_id, ArrayList<String> pat_names) {
        this.context=context;
        this.pat_id = pat_id;
        this.pat_names = pat_names;
    }

    @NonNull
    @Override
    public PresViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View v=layoutInflater.inflate(R.layout.pat_hisotory_sample,parent,false);


        return new PresViewholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull Prescription_history_recycler.PresViewholder holder, int position) {
             holder.pat_id_tv.setText(pat_id.get(position)+". ");
             holder.pat_name_tv.setText(pat_names.get(position)+". ");
             holder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Fragment fragment = new Prescription_information();
                     Bundle bundle = new Bundle();
                     bundle.putString("name", pat_names.get(position));
                     fragment.setArguments(bundle);
                     FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                     FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.frameid, fragment);
                     fragmentTransaction.addToBackStack(null);
                     fragmentTransaction.commit();
                 }
             });
    }

    @Override
    public int getItemCount() {
        return pat_names.size();
    }

    public class PresViewholder  extends RecyclerView.ViewHolder{
        TextView pat_id_tv,pat_name_tv;
       LinearLayout linearLayout;
        public PresViewholder(@NonNull View itemView) {
            super(itemView);

                pat_id_tv=itemView.findViewById(R.id.pat_id);
                pat_name_tv=itemView.findViewById(R.id.pat_name);

        }
    }
}
