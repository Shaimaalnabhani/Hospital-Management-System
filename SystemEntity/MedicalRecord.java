package SystemEntity;

import SystemHelper.HelperUtils;

import java.time.LocalDate;

public class MedicalRecord {
    private String recordId;
    private String patientId;
    private String doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;

    public MedicalRecord(String recordId, String patientId, String doctorId, LocalDate visitDate, String diagnosis, String prescription, String testResults, String notes) {
        this.recordId = HelperUtils.isNotNull(recordId) ? recordId : HelperUtils.generateId("REC");
        this.patientId = HelperUtils.isValidString(patientId) ? patientId : "UNKNOWN_PATIENT";
        this.doctorId = HelperUtils.isValidString(doctorId) ? doctorId : "UNKNOWN_DOCTOR";
        this.visitDate = HelperUtils.isNotNull(visitDate) ? visitDate : LocalDate.now();
        this.diagnosis = HelperUtils.isValidString(diagnosis) ? diagnosis : "Not Diagnosed";
        this.prescription = HelperUtils.isValidString(prescription) ? prescription : "None";
        this.testResults = HelperUtils.isValidString(testResults) ? testResults : "Pending";
        this.notes = HelperUtils.isValidString(notes) ? notes : "No additional notes.";


        System.out.println("MedicalRecord constructor called.");
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        if (HelperUtils.isValidString(recordId, 3)) {
            this.recordId = recordId;
        } else {
            System.out.println("Invalid Record ID, keeping previous value.");
        }
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isValidString(patientId)) {
            this.patientId = patientId;
        } else {
            System.out.println("Invalid Patient ID.");
        }
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        if (HelperUtils.isValidString(doctorId)) {
            this.doctorId = doctorId;
        } else {
            System.out.println("Invalid Doctor ID.");
        }
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        if (HelperUtils.isNotNull(visitDate)) {
            this.visitDate = visitDate;
        } else {
            System.out.println("Invalid Visit Date.");
        }
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if (HelperUtils.isValidString(diagnosis, 3)) {
            this.diagnosis = diagnosis;
        } else {
            System.out.println(" Invalid Diagnosis.");
        }
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        if (HelperUtils.isValidString(prescription)) {
            this.prescription = prescription;
        } else {
            System.out.println("Invalid Prescription.");
        }
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        if (HelperUtils.isValidString(testResults)) {
            this.testResults = testResults;
        } else {
            System.out.println("Invalid Test Results.");
        }
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        if (HelperUtils.isValidString(notes)) {
            this.notes = notes;
        } else {
            System.out.println(" Invalid Notes input.");
        }
    }

    public void displayInfo() {
        System.out.println("----- Medical Record -----");
        System.out.println("Record ID: " + recordId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Visit Date: " + visitDate);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Prescription: " + prescription);
        System.out.println("Test Results: " + testResults);
        System.out.println("Notes: " + notes);
    }

}
