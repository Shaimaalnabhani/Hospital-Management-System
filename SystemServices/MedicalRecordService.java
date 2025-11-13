package SystemServices;

import SystemHelper.HelperUtils;
import SystemInterface.Manageable;
import SystemEntity.MedicalRecord;
import SystemInterface.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService implements Manageable, Searchable {
    private static List<MedicalRecord> recordList = new ArrayList<>();
    private static List<MedicalRecord> medicalRecordList = new ArrayList<>();


    public static void addRecord(MedicalRecord record) {
        if (HelperUtils.isNotNull(record)) {
            recordList.add(record);
            System.out.println("Medical record " + record.getRecordId() + " added successfully");
        } else {
            System.out.println("Can't add record");
        }
    }

    public static void editRecord(String recordId, MedicalRecord updatedRecord) {
        MedicalRecord existingRecord = getRecordById(recordId);
        if (HelperUtils.isNotNull(existingRecord) && HelperUtils.isNotNull(updatedRecord)) {
            int index = recordList.indexOf(existingRecord);
            if (index >= 0) {
                recordList.set(index, updatedRecord);
                System.out.println("Medical record " + recordId + " updated successfully");
            } else {
                System.out.println("Medical record " + recordId + " not found ");
            }
        } else {
            System.out.println("Invalid input — existing or updated record is null");
        }
    }

    public static boolean removeRecord(String recordId) {
        if (HelperUtils.isNull(recordId)) {
            return false;
        }
        System.out.println("Deleting medical record with ID: " + recordId);
        return medicalRecordList.removeIf(r -> recordId.equals(r.getRecordId()));
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
    public String add(Object entity) {
        if (entity instanceof MedicalRecord) {
            medicalRecordList.add((MedicalRecord) entity);
            return "Medical record added successfully!";
        }
        return "Invalid object type.";
    }


    @Override
    public String remove(String id) {
        return removeRecord(id) ? "Medical record deleted successfully." : "Failed to delete medical record.";
    }


    @Override
    public String getAll() {
        if (medicalRecordList.isEmpty()) {
            return "No medical records available.";
        }

        StringBuilder sb = new StringBuilder("===== Medical Records =====\n");
        for (MedicalRecord r : medicalRecordList) {
            sb.append(r.displayInfo("")).append(System.lineSeparator());
            sb.append("------------------------").append(System.lineSeparator());
        }
        return sb.toString();
    }


    public String search(String keyword) {
        StringBuilder sb = new StringBuilder();
        for (MedicalRecord r : medicalRecordList) {
            if (r.getDiagnosis().toLowerCase().contains(keyword.toLowerCase()) ||
                    r.getPrescription().toLowerCase().contains(keyword.toLowerCase()) ||
                    r.getNotes().toLowerCase().contains(keyword.toLowerCase()) ||
                    r.getTestResults().toLowerCase().contains(keyword.toLowerCase()) ||
                    r.getPatientId().toLowerCase().contains(keyword.toLowerCase()) ||
                    r.getDoctorId().toLowerCase().contains(keyword.toLowerCase())) {
                sb.append(r.displayInfo(""));
                sb.append(System.lineSeparator());
            }
        }
        return sb.length() > 0 ? sb.toString() : "No medical records found for: " + keyword;
    }

    @Override
    public String searchById(String id) {
        MedicalRecord record = getRecordById(id);
        if (HelperUtils.isNull(record)) {
            return "Medical record not found for ID: " + id;
        }
        record.displayInfo("");
        return "Search complete.";
    }

    public static void addSampleMedicalRecords() {
        String[] mrDates = {"2023-04-01", "2023-04-02", "2023-04-03", "2023-04-04", "2023-04-05", "2023-04-06", "2023-04-07", "2023-04-08", "2023-04-09", "2023-04-10"};
        for (int i = 0; i < 12; i++) {
            MedicalRecord record = new MedicalRecord();
            record.setRecordId("MR-123" + i);
            record.setPatientId("PAT-123" + i);
            record.setDoctorId("DR-123" + i);
            record.setVisitDate(LocalDate.parse(mrDates[i % mrDates.length]));
            record.setDiagnosis("Diagnosis " + i);
            record.setPrescription("Prescription " + i);
            record.setTestResults("Test Results " + i);
            record.setNotes("Notes " + i);
            recordList.add(record);
        }
    }

}
