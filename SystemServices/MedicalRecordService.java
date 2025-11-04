package SystemServices;

import SystemInterface.Manageable;
import SystemEntity.MedicalRecord;
import SystemInterface.Searchable;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService implements Manageable, Searchable {
    private static List<MedicalRecord> recordList = new ArrayList<>();


    public static void addRecord(MedicalRecord record) {
        recordList.add(record);
        System.out.println("Medical record " + record.getRecordId() + " added successfully.");
    }

    public static void editRecord(String recordId, MedicalRecord updatedRecord) {
        MedicalRecord existing = getRecordById(recordId);
        if (existing != null) {
            existing.setPatientId(updatedRecord.getPatientId());
            existing.setDoctorId(updatedRecord.getDoctorId());
            existing.setVisitDate(updatedRecord.getVisitDate());
            existing.setDiagnosis(updatedRecord.getDiagnosis());
            existing.setPrescription(updatedRecord.getPrescription());
            existing.setTestResults(updatedRecord.getTestResults());
            existing.setNotes(updatedRecord.getNotes());

            System.out.println("Medical record " + recordId + " updated successfully.");
        } else {
            System.out.println("Medical record " + recordId + " not found.");
        }
    }

    public static void removeRecord(String recordId) {
        MedicalRecord record = getRecordById(recordId);
        if (record != null) {
            recordList.remove(record);
            System.out.println("Medical record " + recordId + " removed successfully.");
        } else {
            System.out.println("Medical record " + recordId + " not found.");
        }
    }

    public static MedicalRecord getRecordById(String recordId) {
        for (MedicalRecord record : recordList) {
            if (record.getRecordId().equals(recordId)) {
                return record;
            }
        }
        return null;
    }

    public static List<MedicalRecord> getRecordsByPatientId(String patientId) {
        List<MedicalRecord> results = new ArrayList<>();
        for (MedicalRecord record : recordList) {
            if (record.getPatientId().equals(patientId)) {
                results.add(record);
            }
        }
        return results;
    }

    public static List<MedicalRecord> getRecordsByDoctorId(String doctorId) {
        List<MedicalRecord> results = new ArrayList<>();
        for (MedicalRecord record : recordList) {
            if (record.getDoctorId().equals(doctorId)) {
                results.add(record);
            }
        }
        return results;
    }

    public static void displayPatientHistory(String patientId) {
        List<MedicalRecord> patientRecords = getRecordsByPatientId(patientId);
        if (patientRecords.isEmpty()) {
            System.out.println("No medical records found for patient ID: " + patientId);
        } else {
            System.out.println("----- Medical History for Patient ID: " + patientId + " -----");
            for (MedicalRecord record : patientRecords) {
                record.displayInfo();
                System.out.println("----------------------------------------");
            }
        }
    }

    public static void displayAllRecords() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records found.");
        } else {
            System.out.println("----- All Medical Records -----");
            for (MedicalRecord record : recordList) {
                record.displayInfo();
                System.out.println("----------------------------------------");
            }
        }
    }


    @Override
    public void add(Object entity) {

    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public List<Object> search(String keyword) {
        return List.of();
    }

    @Override
    public Object searchById(String id) {
        return null;
    }
}
