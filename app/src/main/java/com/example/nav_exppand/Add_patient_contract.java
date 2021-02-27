package com.example.nav_exppand;

import android.provider.BaseColumns;

public class Add_patient_contract {
    private Add_patient_contract() {
    }

    public static class Add_patient_database implements BaseColumns{

        public static final String TABLE_NAME = "_Add_patient";
        public static final String COLUMN_Patient_name= "patient_name";
        public static final String COLUMN_Patient_age = "patient_age";
        public static final String COLUMN_Patient_gender = "patient_gender";
        public static final String COLUMN_patient_nickname = "patient_nickname";
        public static final String COLUMN_patient_mobile = "patient_mobile";
        public static final String COLUMN_patient_email = "patient_email";



    }

    public static class Add_prescription implements BaseColumns{

        public static final String _TABLE_NAME = "_Add_prescription";
        public static final String Patient_name_C0L= "patient_name";
        public static final String Complaints_C0L = "Complaints";
        public static final String Previous_History_C0L = "Previous_History";
        public static final String LOCAL_Examination_C0L = "Local_Examination";
        public static final String Diagnosis_C0L  = "Diagnosis ";
        public static final String Investigation_C0L  = "Investigation ";
        public static final String Treatments_C0L  = "Treatments ";
        public static final String Coordinate_C0L  = "Coordinated_By ";
        public static final String Blood_Pressure_C0L  = "Blood_Pressure ";
        public static final String Total_Visit_C0L  = "Total_Visit ";
    public static final String MEDICATION_C0L  = "MEDICATION ";
    public static final String Advice_C0L  = "Advice ";
    public static final String Next_Propose_Date_COL  = "Next_Propose_Date ";






    }

}
