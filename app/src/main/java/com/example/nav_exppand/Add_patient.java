package com.example.nav_exppand;

import android.content.ContentValues;
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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Add_patient#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add_patient extends Fragment {

    //views

    TextInputLayout nametl,agetl,nicknametl,mobile_tl,email_tl;
     TextInputEditText namete,agete,nicknamete,mobile_te,email_te;
    Spinner Gender_spin;
    String name,age,gender,nickname,mobile,email;
    Button add;
    String[] arraySpinner = new String[]{
      "Male","Female"
    };




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Add_patient() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Add_patient newInstance(String param1, String param2) {
        Add_patient fragment = new Add_patient();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_patient, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nametl=view.findViewById(R.id.nameetid);
        agetl=view.findViewById(R.id.ageetid);
        Gender_spin=view.findViewById(R.id.genderetid);
        nicknametl=view.findViewById(R.id.nicknameetid);
        email_tl=view.findViewById(R.id.emailetid);
        mobile_tl=view.findViewById(R.id.mobiletid);


        namete=view.findViewById(R.id._nameet);
        agete=view.findViewById(R.id.ageet);
        nicknamete=view.findViewById(R.id.nicknameet);
       mobile_te=view.findViewById(R.id.mobilet);
        email_te=view.findViewById(R.id.emailet);
        add=view.findViewById(R.id.addpatientbtn);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Gender_spin.setAdapter(adapter);

        Gender_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=nametl.getEditText().getText().toString().trim();
                age=agetl.getEditText().getText().toString().trim();
                nickname=nicknametl.getEditText().getText().toString().trim();
                mobile=mobile_tl.getEditText().getText().toString().trim();
                email=email_tl.getEditText().getText().toString().trim();





                //add_question_model add_patient=new add_question_model(name,age,gender,nickname,mobile,email);

               Dbhelper dbhelper=new Dbhelper(getActivity());
               // dbhelper.addPatient(add_patient);
               long row= dbhelper.addition(name,age,gender,nickname,mobile,email);

               Toast.makeText(getActivity(),"Patient added successfully",Toast.LENGTH_SHORT).show();
            }
        });

      }




}