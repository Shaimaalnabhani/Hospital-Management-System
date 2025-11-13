package SystemEntity;

import SystemInterface.Displayable;
import SystemHelper.HelperUtils;

import java.time.LocalDate;
import java.util.List;

public class Patient extends Person implements Displayable {
    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<String> medicalRecords;
    private List<String> appointments;

    /*
     * Constructor Chaining Flow:
     * Patient() → Person()
     */

    public Patient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords, List<String> appointments) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;

        System.out.println("Patient constructor called.");

        //Calls Person's constructor
    }

    public Patient() {

    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isValidString(patientId, 3)) {
            this.patientId = patientId;
        } else {
            System.out.println("Invalid patient ID — keeping previous value.");
        }
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        if (HelperUtils.isNotNull(allergies)) {
            this.allergies = allergies;
        }
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        if (HelperUtils.isValidString(emergencyContact, 5)) {
            this.emergencyContact = emergencyContact;
        }
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if (HelperUtils.isNotNull(registrationDate)) {
            this.registrationDate = registrationDate;
        }
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List<String> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<String> medicalRecords) {
        if (HelperUtils.isNotNull(medicalRecords)) {
            this.medicalRecords = medicalRecords;
        }
    }

    public List<String> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<String> appointments) {
        if (HelperUtils.isNotNull(appointments)) {
            this.appointments = appointments;
        }
    }

    public void addMedicalRecord(String record) {
        if (HelperUtils.isNotNull(medicalRecords)) {
            medicalRecords.add(record);
        } else {
            System.out.println("Medical records list is not initialized.");
        }
    }

    public void addAppointment(String appointment) {
        if (HelperUtils.isNotNull(appointments)) {
            appointments.add(appointment);
        } else {
            System.out.println("Appointments list is not initialized.");
        }
    }

    public void updateInsurance(String newInsuranceId) {
        if (HelperUtils.isValidString(newInsuranceId, 3)) {
            this.insuranceId = newInsuranceId;
            System.out.println("Insurance ID updated to: " + newInsuranceId);
        } else {
            System.out.println("Invalid insurance ID.");
        }
    }

    @Override
    public String displayInfo() {
        super.displayInfo();
        System.out.println("----- Patient Information -----");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Blood Group: " + (HelperUtils.isNull(bloodGroup) ? "Unknown" : bloodGroup));
        System.out.println("Allergies: " + ((allergies == null || allergies.isEmpty()) ? "None" : String.join(", ", allergies)));
        System.out.println("Emergency Contact: " + (HelperUtils.isNull(emergencyContact) ? "Not Provided" : emergencyContact));
        System.out.println("Registration Date: " + HelperUtils.formatDate(registrationDate));
        System.out.println("Insurance ID: " + (HelperUtils.isNull(insuranceId) ? "None" : insuranceId));
        System.out.println("Medical Records: " + ((medicalRecords == null || medicalRecords.isEmpty()) ? "No records" : medicalRecords));
        System.out.println("Appointments: " + ((appointments == null || appointments.isEmpty()) ? "No appointments" : appointments));

        return null;
    }
    // Update phone only
    public void updateContact(String phone) {
        setPhoneNumber(phone);
        System.out.println("Contact updated: Phone = " + phone);
    }

    // Update phone and email
    public void updateContact(String phone, String email) {
        setPhoneNumber(phone);
        setEmail(email);
        System.out.println("Contact updated: Phone = " + phone + ", Email = " + email);
    }

    // Update phone, email, and address
    public void updateContact(String phone, String email, String address) {
        setPhoneNumber(phone);
        setEmail(email);
        setAddress(address);
        System.out.println("Contact updated: Phone = " + phone + ", Email = " + email + ", Address = " + address);
    }

}
