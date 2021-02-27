package com.example.nav_exppand;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Dbhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Mypatterns.db";
    private static final int DATABASE_VERSION = 5;

    private SQLiteDatabase db;

    final String ADD_PATIENTS_TABLE = "CREATE TABLE " +
            Add_patient_contract.Add_patient_database.TABLE_NAME + " ( " +
            Add_patient_contract.Add_patient_database._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Add_patient_contract.Add_patient_database.COLUMN_Patient_name + " TEXT, " +
            Add_patient_contract.Add_patient_database.COLUMN_Patient_age + " TEXT, " +
            Add_patient_contract.Add_patient_database.COLUMN_Patient_gender+ " TEXT, " +
            Add_patient_contract.Add_patient_database.COLUMN_patient_nickname + " TEXT, " +
            Add_patient_contract.Add_patient_database.COLUMN_patient_mobile + " TEXT," +
            Add_patient_contract.Add_patient_database.COLUMN_patient_email + " TEXT" +
            ")";


    final String ADD_PRESCRIPTION_TABLE = "CREATE TABLE " +
           Add_patient_contract.Add_prescription._TABLE_NAME + " ( " +
            Add_patient_contract.Add_prescription._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Add_patient_contract.Add_prescription.Patient_name_C0L + " TEXT, " +
            Add_patient_contract.Add_prescription.Complaints_C0L + " TEXT, " +
            Add_patient_contract.Add_prescription.Previous_History_C0L + " TEXT, "  +

          Add_patient_contract.Add_prescription.LOCAL_Examination_C0L + " TEXT, " +
            Add_patient_contract.Add_prescription.Diagnosis_C0L+ " TEXT," +
            Add_patient_contract.Add_prescription.Investigation_C0L+ " TEXT," +
            Add_patient_contract.Add_prescription.Treatments_C0L+ " TEXT," +
            Add_patient_contract.Add_prescription.Coordinate_C0L+ " TEXT," +
            Add_patient_contract.Add_prescription.Blood_Pressure_C0L+ " TEXT," +
            Add_patient_contract.Add_prescription.Total_Visit_C0L+ " TEXT," +
            Add_patient_contract.Add_prescription.MEDICATION_C0L+ " TEXT," +
            Add_patient_contract.Add_prescription.Advice_C0L+ " TEXT," +
            Add_patient_contract.Add_prescription.Next_Propose_Date_COL + " TEXT" +
            ")";


    public Dbhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ADD_PATIENTS_TABLE);
        db.execSQL(ADD_PRESCRIPTION_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  Add_patient_contract.Add_patient_database.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +  Add_patient_contract.Add_prescription._TABLE_NAME);
        onCreate(db);

    }

    public long addition(String name,String age,String gender,String nickname ,String mobile ,String email ){
        ContentValues cv = new ContentValues();
        SQLiteDatabase db=this.getWritableDatabase();
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_Patient_name, name);
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_Patient_age, age);
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_Patient_gender,gender);
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_patient_nickname,nickname);
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_patient_mobile, mobile);
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_patient_email, email);

        long rowid=db.insert(Add_patient_contract.Add_patient_database.TABLE_NAME, null, cv);
        return rowid;
    }

    public void addPatient(add_question_model patient) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db=this.getWritableDatabase();
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_Patient_name, patient.getName());
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_Patient_age, patient.getAge());
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_patient_nickname, patient.getNickname());
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_Patient_gender, patient.getGender());
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_patient_mobile, patient.getMobile());
        cv.put( Add_patient_contract.Add_patient_database.COLUMN_patient_email, patient.getEmail());

        db.insert(Add_patient_contract.Add_patient_database.TABLE_NAME, null, cv);
    }


    public Cursor get_all_patient_data(){
        Cursor cursor;


        db = this.getReadableDatabase();
       cursor = db.rawQuery("SELECT * FROM " + Add_patient_contract.Add_patient_database.TABLE_NAME, null);



        return cursor;
    }




    public Cursor info(String name){

        db = getReadableDatabase();

         Cursor cursor=db.rawQuery("SELECT * FROM " + Add_patient_contract.Add_patient_database.TABLE_NAME+
                " WHERE "+Add_patient_contract.Add_patient_database.COLUMN_Patient_name+" = "+name, null);


        return cursor;
    }


    public void Add_prescription(Prescription_model prescription){
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        contentValues.put(Add_patient_contract.Add_prescription.Patient_name_C0L,prescription.getName());
        contentValues.put(Add_patient_contract.Add_prescription.Complaints_C0L,prescription.getComplaints());
        contentValues.put(Add_patient_contract.Add_prescription.Previous_History_C0L,prescription.getPrevious_History());
        contentValues.put(Add_patient_contract.Add_prescription.LOCAL_Examination_C0L,prescription.getLocal_Examination());
        contentValues.put(Add_patient_contract.Add_prescription.Diagnosis_C0L,prescription.getDiagnosis());
        contentValues.put(Add_patient_contract.Add_prescription.Investigation_C0L,prescription.getInvestigation());
        contentValues.put(Add_patient_contract.Add_prescription.Treatments_C0L,prescription.getTreatments());
        contentValues.put(Add_patient_contract.Add_prescription.Coordinate_C0L,prescription.getCoordinated_By());
        contentValues.put(Add_patient_contract.Add_prescription.Blood_Pressure_C0L,prescription.getBlood_Pressure());
        contentValues.put(Add_patient_contract.Add_prescription.Total_Visit_C0L,prescription.getTotal_Visit());
        contentValues.put(Add_patient_contract.Add_prescription.MEDICATION_C0L,prescription.getMedication());
        contentValues.put(Add_patient_contract.Add_prescription.Advice_C0L,prescription.getAdvice());
        contentValues.put(Add_patient_contract.Add_prescription.Next_Propose_Date_COL,prescription.getNext_Propose_Date());


         sqLiteDatabase.insert(Add_patient_contract.Add_prescription._TABLE_NAME, null, contentValues);


    }


    public Cursor get_all_prescription_data(){
        Cursor cur;


        db = this.getReadableDatabase();
        cur= db.rawQuery("SELECT * FROM " + Add_patient_contract.Add_prescription._TABLE_NAME, null);



        return cur;
    }



    public Cursor pres_info(String name){

        db = getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM " + Add_patient_contract.Add_prescription._TABLE_NAME+
                " WHERE "+Add_patient_contract.Add_prescription.Patient_name_C0L+" = '"+name+"'", null);


        return cursor;
    }




}
