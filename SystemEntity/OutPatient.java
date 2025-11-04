package SystemEntity;

import SystemHelper.HelperUtils;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patient {
    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;


    /*
     * Constructor Chaining Flow:
     * OutPatient() → Patient() → Person()
     */
    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords, List<String> appointments, int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments);
        this.visitCount = HelperUtils.isPositive(visitCount) ? visitCount : 0;
        this.lastVisitDate = HelperUtils.isNotNull(lastVisitDate) ? lastVisitDate : LocalDate.now();
        this.preferredDoctorId = HelperUtils.isNotNull(preferredDoctorId) ? preferredDoctorId : "Not Assigned";

        System.out.println("OutPatient constructor called.");
        //Calls Patient's constructor
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        if (HelperUtils.isPositive(visitCount)) {
            this.visitCount = visitCount;
        } else {
            System.out.println("Invalid visit count. Must be positive.");
        }
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        if (HelperUtils.isNotNull(lastVisitDate)) {
            this.lastVisitDate = lastVisitDate;
        } else {
            System.out.println("Invalid date — keeping previous last visit date.");
        }
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        if (HelperUtils.isValidString(preferredDoctorId, 3)) {
            this.preferredDoctorId = preferredDoctorId;
        } else {
            System.out.println("Invalid doctor ID — keeping previous value.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("----- OutPatient Details -----");
        System.out.println("Visit Count: " + visitCount);
        System.out.println("Last Visit Date: " + (HelperUtils.isNotNull(lastVisitDate) ? lastVisitDate : "N/A"));
        System.out.println("Preferred Doctor ID: " + (HelperUtils.isNotNull(preferredDoctorId) ? preferredDoctorId : "Not assigned"));
    }

    public void scheduleFollowUp(LocalDate followUpDate) {
        if (HelperUtils.isNotNull(followUpDate)) {
            this.lastVisitDate = followUpDate;
            System.out.println("Follow-up scheduled on " + followUpDate +
                    " for OutPatient ID: " + getPatientId());
        } else {
            System.out.println("Invalid follow-up date.");
        }
    }

    public void updateVisitCount() {
        this.visitCount++;
        this.lastVisitDate = LocalDate.now();
        System.out.println("Visit count updated to " + visitCount + " for OutPatient ID: " + getPatientId());
    }
}
