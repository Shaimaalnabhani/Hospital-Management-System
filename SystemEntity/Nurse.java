package SystemEntity;

import SystemHelper.HelperUtils;

import java.time.LocalDate;
import java.util.List;

public class Nurse extends Person {
    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<String> assignedPatients;

    /*
     * Constructor Chaining Flow:
     * Nurse() → Person()
     */


    public Nurse(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String nurseId, String departmentId, String shift, String qualification, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.nurseId = HelperUtils.isNull(nurseId) ? HelperUtils.generateId("NUR") : nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = assignedPatients;

        System.out.println("Nurse constructor called.");
        //Calls Person's constructor
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        if (HelperUtils.isValidString(nurseId, 3)) {
            this.nurseId = nurseId;
        } else {
            System.out.println("Invalid nurse ID — keeping old value.");
        }
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        if (HelperUtils.isValidString(departmentId, 2)) {
            this.departmentId = departmentId;
        } else {
            System.out.println("Invalid department ID.");
        }
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        if (HelperUtils.isValidString(shift)) {
            this.shift = shift;
        } else {
            System.out.println("Invalid shift name.");
        }
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        if (HelperUtils.isValidString(qualification, 2)) {
            this.qualification = qualification;
        } else {
            System.out.println("Invalid qualification.");
        }
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        if (HelperUtils.isNotNull(assignedPatients)) {
            this.assignedPatients = assignedPatients;
        } else {
            System.out.println("Assigned patients list is null — not updated.");
        }
    }

    public void assignPatient(String patientId) {
        if (HelperUtils.isNull(patientId) || patientId.isEmpty()) {
            System.out.println("Invalid patient ID.");
            return;
        }

        if (HelperUtils.isNull(assignedPatients)) {
            System.out.println("Assigned patients list not initialized.");
            return;
        }

        if (!assignedPatients.contains(patientId)) {
            assignedPatients.add(patientId);
            System.out.println("Patient " + patientId + " assigned to Nurse " + nurseId);
        } else {
            System.out.println("Patient " + patientId + " is already assigned.");
        }
    }

    public void removePatient(String patientId) {
        if (HelperUtils.isNull(patientId) || patientId.isEmpty()) {
            System.out.println("Invalid patient ID.");
            return;
        }

        if (HelperUtils.isNull(assignedPatients)) {
            System.out.println("No assigned patients list found.");
            return;
        }

        if (assignedPatients.contains(patientId)) {
            assignedPatients.remove(patientId);
            System.out.println("Patient " + patientId + " removed from Nurse " + nurseId);
        } else {
            System.out.println("Patient " + patientId + " is not assigned to this nurse.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("----- Nurse Information -----");
        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Department ID: " + (HelperUtils.isNull(departmentId) ? "Not Assigned" : departmentId));
        System.out.println("Shift: " + (HelperUtils.isNull(shift) ? "Not Set" : shift));
        System.out.println("Qualification: " + (HelperUtils.isNull(qualification) ? "Not Provided" : qualification));
        System.out.println("Assigned Patients: " + (assignedPatients.isEmpty() ? "None" : assignedPatients));
    }
}
