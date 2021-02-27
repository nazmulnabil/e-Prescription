package com.example.nav_exppand;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Prescription_information extends Fragment {


    Dbhelper dbhelper;
    Cursor cursor;
   TextView Name;
   TextView Complaints;
   TextView Previous_History;
   TextView Local_Examination;
   TextView Diagnosis;
  TextView Investigation;
 TextView Treatment;
 TextView Coordinated_By;
  TextView Blood_Pressure;
   TextView Total_Visit;
   TextView Medication;
   TextView Advice;
   TextView Next_Propose_Date;

   String name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prescription_information, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getActivity(),"Patient added successfully",Toast.LENGTH_SHORT).show();

      //init views
       Name=view.findViewById(R.id.nameTV) ;
      Complaints=view.findViewById(R.id.ComplaintsTV) ;
       Previous_History=view.findViewById(R.id.Previous_HistoryTV) ;
      Local_Examination=view.findViewById(R.id.Local_ExaminationTV) ;
       Diagnosis=view.findViewById(R.id.DiagnosisTV) ;
      Investigation=view.findViewById(R.id.InvestigationTV) ;
      Treatment=view.findViewById(R.id.TreatmentTV) ;
       Coordinated_By=view.findViewById(R.id.Coordinated_ByTV) ;
      Blood_Pressure=view.findViewById(R.id.Blood_PressureTV) ;
      Total_Visit=view.findViewById(R.id.Total_VisitTV) ;
     Medication=view.findViewById(R.id.MedicationTV) ;
      Advice=view.findViewById(R.id.AdviceTV) ;
     Next_Propose_Date=view.findViewById(R.id.Next_Propose_DateTV) ;




     Bundle bundle = this.getArguments();
     if (bundle != null) {
           name= bundle.getString("name" ,"");

     }


     get_prescription_data();


    }



    private void get_prescription_data() {
        dbhelper=new Dbhelper(getActivity());

        cursor=dbhelper.pres_info(name);


        if( cursor!=null&&cursor.getCount()>0){

            if(cursor.moveToFirst()) {
                do {
                     Name.setText("Name: "+cursor.getString(1));
                    Complaints.setText("Complaints: "+cursor.getString(2));
                    Previous_History.setText("Previous History: "+cursor.getString(3));
                    Local_Examination.setText("Local Examination: "+cursor.getString(4));
                    Diagnosis.setText("Diagnosis: "+cursor.getString(5));
                    Investigation.setText("Investigation: "+cursor.getString(6));
                    Treatment.setText("Treatment: "+cursor.getString(7));
                     Coordinated_By.setText("Coordinated By: "+cursor.getString(8));
                     Blood_Pressure.setText("Blood Pressure: "+cursor.getString(9));
                    Total_Visit.setText("Total Visit: "+cursor.getString(10));
                   Medication.setText("Medication: "+cursor.getString(11));
                 Advice.setText("Advice: "+cursor.getString(12));
               Next_Propose_Date.setText("Next Propose Date: "+cursor.getString(13));


                }
                while (cursor.moveToNext());
                cursor.close();

            }
        }



    }


}
