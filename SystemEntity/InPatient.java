package SystemEntity;

import SystemHelper.HelperUtils;
import SystemInterface.Billable;
import SystemInterface.Displayable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class InPatient extends Patient implements Displayable, Billable {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;
    private double balance;

    /*
     * Constructor Chaining Flow:
     * InPatient() → Patient() → Person()
     */


    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords, List<String> appointments, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments);
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;

        System.out.println("InPatient constructor called.");
        //Calls Patient's constructor
    }

    public InPatient() {
        super();
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        if (HelperUtils.isNull(admissionDate)) {
            System.out.println("Admission date cannot be null.");
        }
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        if (HelperUtils.isNull(dischargeDate)) {
            System.out.println("Discharge date cannot be null.");
        }
        this.dischargeDate = dischargeDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        if (!HelperUtils.isValidString(roomNumber, 1)) {
            System.out.println("Invalid room number.");
        }
        this.roomNumber = roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        if (!HelperUtils.isValidString(bedNumber, 1)) {
            System.out.println("Invalid bed number.");
        }
        this.bedNumber = bedNumber;
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        if (!HelperUtils.isValidString(admittingDoctorId, 3)) {
            System.out.println("Invalid admitting doctor ID.");
        }
        this.admittingDoctorId = admittingDoctorId;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        if (dailyCharges <= 0) {
            System.out.println("Daily charges must be positive.");
        }
        this.dailyCharges = dailyCharges;
    }

    @Override
    public String displayInfo() {
        super.displayInfo();
        System.out.println("----- InPatient Details -----");
        System.out.println("Admission Date: " + (HelperUtils.isNotNull(admissionDate) ? admissionDate : "N/A"));
        System.out.println("Discharge Date: " + (HelperUtils.isNotNull(dischargeDate) ? dischargeDate : "N/A"));
        System.out.println("Room Number: " + (HelperUtils.isValidString(roomNumber) ? roomNumber : "N/A"));
        System.out.println("Bed Number: " + (HelperUtils.isValidString(bedNumber) ? bedNumber : "N/A"));
        System.out.println("Admitting Doctor ID: " + (HelperUtils.isValidString(admittingDoctorId) ? admittingDoctorId : "N/A"));
        System.out.println("Daily Charges: " + dailyCharges);
        System.out.println("Stay Duration: " + calculateStayDuration() + " days");
        System.out.println("Total Charges: " + calculateTotalCharges());

        return null;
    }
    public long calculateStayDuration() {
        if (HelperUtils.isNull(admissionDate) || HelperUtils.isNull(dischargeDate)) {
            return 0;
        } else {
            return ChronoUnit.DAYS.between(admissionDate, dischargeDate);
        }
    }

    public double calculateTotalCharges() {
        long days = calculateStayDuration();
        if (days <= 0) {
            return dailyCharges;
        } else {
            return days * dailyCharges;
        }
    }

    @Override
    public double calculateCharges() {
        long stayDays = calculateStayDuration();
        double total = stayDays * dailyCharges;
        balance += total;
        System.out.println("Total charges for " + stayDays + " days: $" + total);
        return total;
    }

    @Override
    public String generateBill() {
        return "Bill for InPatient " + getFirstName() + ": $" + balance;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) return false;
        balance -= amount;
        System.out.println("Payment processed: $" + amount + ". Remaining: $" + balance);
        return true;
    }
}
