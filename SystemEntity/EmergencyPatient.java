package SystemEntity;

import SystemHelper.HelperUtils;
import SystemInterface.Displayable;

import java.time.LocalDate;
import java.util.List;

public class EmergencyPatient extends InPatient implements Displayable {
    private String emergencyType;
    private String arrivalMode;
    private int triageLevel;
    private boolean admittedViaER;

    /*
 * Constructor Chaining Flow:
 * EmergencyPatient() → InPatient() → Patient() → Person()

     - Person initializes basic info.
     - Patient adds patient-specific info.
     - InPatient adds admission details.
     - EmergencyPatient adds emergency info.

 */

    public EmergencyPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords, List<String> appointments, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges, String emergencyType, String arrivalMode, int triageLevel, boolean admittedViaER) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments, admissionDate, dischargeDate, roomNumber, bedNumber, admittingDoctorId, dailyCharges);
        this.emergencyType = HelperUtils.isNull(emergencyType) ? "Unknown" : emergencyType;
        this.arrivalMode = HelperUtils.isNull(arrivalMode) ? "Unknown" : arrivalMode;
        this.triageLevel = triageLevel;
        this.admittedViaER = admittedViaER;

        System.out.println("EmergencyPatient constructor called.");
        //Calls InPatient's constructor
    }

    public EmergencyPatient() {

    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        if (HelperUtils.isNotNull(emergencyType)) {
            this.emergencyType = emergencyType;
        } else {
            System.out.println("⚠ Invalid emergency type. Keeping previous value.");
        }
    }

    public String getArrivalMode() {
        return arrivalMode;
    }

    public void setArrivalMode(String arrivalMode) {
        if (HelperUtils.isNotNull(arrivalMode)) {
            this.arrivalMode = arrivalMode;
        } else {
            System.out.println("Invalid arrival mode. Keeping previous value.");
        }
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        if (triageLevel >= 1 && triageLevel <= 5) {
            this.triageLevel = triageLevel;
        } else {
            System.out.println("Invalid triage level. Must be between 1–5.");
        }
    }

    public boolean isAdmittedViaER() {
        return admittedViaER;
    }

    public void setAdmittedViaER(boolean admittedViaER) {
        this.admittedViaER = admittedViaER;
    }

    @Override
    public long calculateStayDuration() {
        long days = super.calculateStayDuration();
        if (days == 0 && isAdmittedViaER()) {
            return 1; // Minimum 1-day charge for ER admission
        }
        return days;
    }

    @Override
    public double calculateTotalCharges() {
        double baseCharges = super.calculateTotalCharges();
        if (triageLevel <= 2) {
            baseCharges += 500;
        }
        if ("Ambulance".equalsIgnoreCase(arrivalMode)) {
            baseCharges += 300;
        }
        return baseCharges;
    }

    public void prioritizeTreatment() {
        if (triageLevel <= 2) {
            System.out.println(" High-priority case! Immediate attention required for " + getFirstName() + " " + getLastName());
        } else {
            System.out.println("Standard triage level (" + triageLevel + ") assigned for " + getFirstName() + ".");
        }
    }

    @Override
    public String displayInfo() {
        super.displayInfo();
        System.out.println("----- Emergency Details -----");
        System.out.println("Emergency Type: " + (HelperUtils.isNotNull(emergencyType) ? emergencyType : "Unknown"));
        System.out.println("Arrival Mode: " + (HelperUtils.isNotNull(arrivalMode) ? arrivalMode : "Unknown"));
        System.out.println("Triage Level: " + triageLevel);
        System.out.println("Admitted via ER: " + (admittedViaER ? "Yes" : "No"));
        return null;
    }

    @Override
    public void displaySummary() {
        super.displaySummary();
    }
}
