package SystemEntity;

import SystemHelper.HelperUtils;

import java.time.LocalDate;
import java.util.List;

public class Consultant extends Doctor {

    private List<String> consultationTypes;
    private boolean onlineConsultationAvailable;
    private int consultationDuration;

    /*
     * Constructor Chaining Flow:
     * Consultant() → Doctor() → Person()
     */
    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        if (HelperUtils.isNull(consultationTypes)) {
            this.consultationTypes = List.of();
        }
        else {
            this.consultationTypes = consultationTypes;
        }

        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
        System.out.println("Consultant constructor called.");
        //Calls Doctor's constructor
    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {
        if (HelperUtils.isNotNull(consultationTypes)) {
            this.consultationTypes = consultationTypes;
        } else {
            System.out.println("Warning: Consultation types cannot be null.");
        }
    }

    public boolean isOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(boolean onlineConsultationAvailable) {
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        if (HelperUtils.isPositive(consultationDuration)) {
            this.consultationDuration = consultationDuration;
        } else {
            System.out.println("Invalid consultation duration. Must be positive.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Consultation Types: " +
                (HelperUtils.isNull(consultationTypes) || consultationTypes.isEmpty() ? "None" : String.join(", ", consultationTypes)));
        System.out.println("Online Consultation Available: " + (onlineConsultationAvailable ? "Yes" : "No"));
        System.out.println("Consultation Duration: " + consultationDuration + " minutes");
    }

    public void scheduleConsultation(String type, String patientId, String slot) {
        if (HelperUtils.isNull(type) || HelperUtils.isNull(patientId) || HelperUtils.isNull(slot)) {
            System.out.println("Invalid input — cannot schedule consultation.");
        }
        if (!consultationTypes.contains(type)) {
            consultationTypes.add(type);
        }
        if (HelperUtils.isNotNull(getAssignedPatients())) {
            getAssignedPatients().add(patientId);
        }

        if (HelperUtils.isNotNull(getAvailableSlots())) {
            getAvailableSlots().remove(slot);
        }
        System.out.println("Scheduled " + type + " consultation with patient " + patientId + " at " + slot);
    }

    public void provideSecondOpinion(String patientId, String notes) {
        if (HelperUtils.isNull(patientId) || HelperUtils.isNull(notes)) {
            System.out.println("Cannot provide second opinion — missing patient ID or notes.");
        }
        System.out.println("Consultant " + getDoctorId() + " provided a second opinion for patient " + patientId);
        System.out.println("Notes: " + notes);
    }
}
