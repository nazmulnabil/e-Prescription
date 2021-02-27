package com.example.nav_exppand;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;


public class Prescription extends Fragment {
    Cursor cursor;
    Dbhelper dbhelper;
    SQLiteDatabase sqLiteDatabase;
    ArrayList<String> patientlist_name;
    Spinner spinner_patient;
    Button savebtn;
    TextInputLayout Complaints_tl,Previous_History_tl,Local_Examination_tl,Diagnosis_tl,Investigation_tl,

    Treatment_tl,Coordinated_By_tl,Blood_Pressure_tl,Total_Visit_tl,Advice_tl,Next_Propose_Date_tl,Medication_tl;


    TextInputEditText Complaints_te,Previous_History_te,Local_Examination_te,Diagnosis_te,Investigation_te,

    Treatment_te,Coordinated_By_te,Blood_Pressure_te,Total_Visitte,Advice_te,Next_Propose_Date_te,Medication_te;


    String Name,Complaints,Previous_History,Local_Examination,Diagnosis,Investigation_,

    Treatment,Coordinated_By,Blood_Pressure,Total_Visit,Advice,Next_Propose_Date,Medication;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prescription, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        dbhelper=new Dbhelper(getActivity());

        savebtn=view.findViewById(R.id.save_prescription_btnid);
        spinner_patient=view.findViewById(R.id.spin_namelist);

        //init Text input fields
        Complaints_tl=view.findViewById(R.id.Complaintsetid);
        Complaints_te=view.findViewById(R.id.Complaintsed);
        Previous_History_tl=view.findViewById(R.id.Previous_Historyetid);
        Previous_History_te=view.findViewById(R.id.Previous_Historyed);
        Local_Examination_tl=view.findViewById(R.id.Local_Examinationetid);
        Local_Examination_te=view.findViewById(R.id.Local_Examinationed);
        Diagnosis_tl=view.findViewById(R.id.Diagnosis_etid);
        Diagnosis_te=view.findViewById(R.id.Diagnosis_ed);
        Investigation_tl=view.findViewById(R.id.Investigation_etid);
        Investigation_te=view.findViewById(R.id.Investigation_ed);
        Treatment_tl=view.findViewById(R.id.Treatments_etid);
        Treatment_te=view.findViewById(R.id.Treatments_ed);
        Coordinated_By_tl=view.findViewById(R.id.Coordinated_By_etid);
        Coordinated_By_te=view.findViewById(R.id.Coordinated_By_ed);
        Blood_Pressure_tl=view.findViewById(R.id.Blood_Pressure_etid);
        Blood_Pressure_te=view.findViewById(R.id.Blood_Pressure_ed);
        Total_Visit_tl=view.findViewById(R.id.Total_Visit_etid);
        Total_Visitte=view.findViewById(R.id.Total_Visit_ed);
        Advice_tl=view.findViewById(R.id.Advice_etid);
        Advice_te=view.findViewById(R.id.Advice_ed);
        Next_Propose_Date_tl=view.findViewById(R.id.Next_Propose_Date_etid);
        Next_Propose_Date_te=view.findViewById(R.id.Next_Propose_Date_ed);
        Medication_tl=view.findViewById(R.id.Medication_etid);
        Medication_te=view.findViewById(R.id.Medication_ed);


        //init spinner
        patientlist_name=new ArrayList<>();
        get_allpatient_spinner();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,patientlist_name);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_patient.setAdapter(adapter);

        spinner_patient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Name=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //save n print button onclick
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Complaints=Complaints_tl.getEditText().getText().toString().trim();
                Previous_History=Previous_History_tl.getEditText().getText().toString().trim();
                Local_Examination=Local_Examination_tl.getEditText().getText().toString().trim();
               Diagnosis=Diagnosis_tl.getEditText().getText().toString().trim();
               Investigation_=Investigation_tl.getEditText().getText().toString().trim();
               Treatment=Treatment_tl.getEditText().getText().toString().trim();
               Coordinated_By=Coordinated_By_tl.getEditText().getText().toString().trim();
             Blood_Pressure=Blood_Pressure_tl.getEditText().getText().toString().trim();
             Total_Visit=Total_Visit_tl.getEditText().getText().toString().trim();
             Medication=Medication_tl.getEditText().getText().toString().trim();
            Advice=Advice_tl.getEditText().getText().toString().trim();
           Next_Propose_Date=Next_Propose_Date_tl.getEditText().getText().toString().trim();

           Prescription_model prescription_model=new Prescription_model(Name,Complaints,Previous_History,Local_Examination,Diagnosis,Investigation_,Treatment,Coordinated_By,Blood_Pressure,Total_Visit,Medication,Advice,Next_Propose_Date);

           dbhelper.Add_prescription(prescription_model);

            }
        });




    }

    private void Init() {




    }


    private Cursor get_allpatient_spinner (){
        dbhelper=new Dbhelper(getActivity());
        cursor=dbhelper.get_all_patient_data();
        if( cursor!=null&&cursor.getCount()>0){

            if(cursor.moveToFirst()) {
                do {

                    patientlist_name.add(cursor.getString(1));



                }
                while (cursor.moveToNext());
                cursor.close();

            }
        }


        return cursor;

    }
}