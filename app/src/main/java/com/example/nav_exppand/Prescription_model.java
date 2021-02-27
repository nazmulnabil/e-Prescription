package com.example.nav_exppand;

public class Prescription_model {

    String name;
    String Complaints;
    String Previous_History ;
    String  Local_Examination ;
    String  Diagnosis ;
    String  Investigation ;
    String  Treatments ;
    String  Coordinated_By  ;
    String  Blood_Pressure ;
    String  Total_Visit ;
    String  Medication ;
    String Advice ;
    String  Next_Propose_Date ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComplaints() {
        return Complaints;
    }

    public void setComplaints(String complaints) {
        Complaints = complaints;
    }

    public String getPrevious_History() {
        return Previous_History;
    }

    public void setPrevious_History(String previous_History) {
        Previous_History = previous_History;
    }

    public String getLocal_Examination() {
        return Local_Examination;
    }

    public void setLocal_Examination(String local_Examination) {
        Local_Examination = local_Examination;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        Diagnosis = diagnosis;
    }

    public String getInvestigation() {
        return Investigation;
    }

    public void setInvestigation(String investigation) {
        Investigation = investigation;
    }

    public String getTreatments() {
        return Treatments;
    }

    public void setTreatments(String treatments) {
        Treatments = treatments;
    }

    public String getCoordinated_By() {
        return Coordinated_By;
    }

    public void setCoordinated_By(String coordinated_By) {
        Coordinated_By = coordinated_By;
    }

    public String getBlood_Pressure() {
        return Blood_Pressure;
    }

    public void setBlood_Pressure(String blood_Pressure) {
        Blood_Pressure = blood_Pressure;
    }

    public String getTotal_Visit() {
        return Total_Visit;
    }

    public void setTotal_Visit(String total_Visit) {
        Total_Visit = total_Visit;
    }

    public String getMedication() {
        return Medication;
    }

    public void setMedication(String medication) {
        Medication = medication;
    }

    public String getAdvice() {
        return Advice;
    }

    public void setAdvice(String advice) {
        Advice = advice;
    }

    public String getNext_Propose_Date() {
        return Next_Propose_Date;
    }

    public void setNext_Propose_Date(String next_Propose_Date) {
        Next_Propose_Date = next_Propose_Date;
    }

    public Prescription_model(String name, String complaints, String previous_History, String local_Examination, String diagnosis, String investigation, String treatments, String coordinated_By, String blood_Pressure, String total_Visit, String medication, String advice, String next_Propose_Date) {
        this.name = name;
        Complaints = complaints;
        Previous_History = previous_History;
        Local_Examination = local_Examination;
        Diagnosis = diagnosis;
        Investigation = investigation;
        Treatments = treatments;
        Coordinated_By = coordinated_By;
        Blood_Pressure = blood_Pressure;
        Total_Visit = total_Visit;
        Medication = medication;
        Advice = advice;
        Next_Propose_Date = next_Propose_Date;



    }
}
