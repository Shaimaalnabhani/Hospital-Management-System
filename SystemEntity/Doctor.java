package SystemEntity;

import SystemHelper.HelperUtils;
import SystemInterface.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person implements Displayable {
    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    private List<String> availableSlots;
    private List<String> assignedPatients;

    /*
     * Constructor Chaining Flow:
     * Doctor() → Person()
     */


    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.doctorId = HelperUtils.generateId("DOC", 5);
        ;
        setSpecialization(specialization);
        setQualification(qualification);
        setExperienceYears(experienceYears);
        setDepartmentId(departmentId);
        setConsultationFee(consultationFee);

        this.availableSlots = HelperUtils.isNotNull(availableSlots) ? availableSlots : new ArrayList<>();
        this.assignedPatients = HelperUtils.isNotNull(assignedPatients) ? assignedPatients : new ArrayList<>();

        System.out.println("Doctor constructor called. ID: " + doctorId);
    }
    //Calls Person's constructor

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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (HelperUtils.isValidString(specialization, 3)) {
            this.specialization = specialization;
        } else {
            System.out.println("Invalid specialization name.");
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

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        if (HelperUtils.isValidNumber(experienceYears, 0, 60)) {
            this.experienceYears = experienceYears;
        } else {
            System.out.println("Invalid experience years (must be 0–60).");
        }
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        if (HelperUtils.isValidString(departmentId)) {
            this.departmentId = departmentId;
        } else {
            System.out.println("Invalid Department ID.");
        }
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        if (HelperUtils.isValidNumber(consultationFee, 1, 1000)) {
            this.consultationFee = consultationFee;
        } else {
            System.out.println("Invalid consultation fee (must be between 1–1000).");
        }
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        if (HelperUtils.isNotNull(availableSlots)) {
            this.availableSlots = availableSlots;
        } else {
            System.out.println("Available slots cannot be null.");
        }
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        if (HelperUtils.isNotNull(assignedPatients)) {
            this.assignedPatients = assignedPatients;
        } else {
            System.out.println("Assigned patients list cannot be null.");
        }
    }

    public void assignPatient(String patientId) {
        if (HelperUtils.isNull(assignedPatients)) {
            assignedPatients = new ArrayList<>();
        }

        if (HelperUtils.isValidString(patientId)) {
            if (!assignedPatients.contains(patientId)) {
                assignedPatients.add(patientId);
                System.out.println("Patient " + patientId + " assigned to Doctor " + doctorId);
            }
            else {
                System.out.println("Patient " + patientId + " is already assigned.");
            }
        }
        else {
            System.out.println("Invalid patient ID.");
        }
    }

    public void removePatient(String patientId) {
        if (HelperUtils.isNotNull(assignedPatients) && assignedPatients.contains(patientId)) {
            assignedPatients.remove(patientId);
            System.out.println("Patient " + patientId + " removed from Doctor " + doctorId);
        } else {
            System.out.println("Patient " + patientId + " not found.");
        }
    }

    public void updateAvailability(List<String> newSlots) {
        if (HelperUtils.isNotNull(newSlots)) {
            this.availableSlots = newSlots;
            System.out.println("Availability updated for Doctor " + doctorId);
        } else {
            System.out.println("New slots list cannot be null.");
        }
    }

    // Add a single available slot
    public void addAvailability(String slot) {
        if (HelperUtils.isNull(availableSlots)) {
            availableSlots = new ArrayList<>();
        }
        if (HelperUtils.isValidString(slot)) {
            availableSlots.add(slot);
            System.out.println("Added availability slot: " + slot);
        } else {
            System.out.println("Invalid slot entry.");
        }
    }

    //  Add multiple availability slots
    public void addAvailability(List<String> slots) {
        if (HelperUtils.isNull(availableSlots)) {
            availableSlots = new ArrayList<>();
        }
        if (HelperUtils.isNotNull(slots) && !slots.isEmpty()) {
            availableSlots.addAll(slots);
            System.out.println("Added multiple availability slots: " + slots);
        } else {
            System.out.println("Slot list is empty or invalid.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("----- Doctor Information -----");
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Department ID: " + departmentId);
        System.out.println("Consultation Fee: $" + consultationFee);
        System.out.println("Available Slots: " + (HelperUtils.isNull(availableSlots) || availableSlots.isEmpty() ? "None" : availableSlots));
        System.out.println("Assigned Patients: " + (HelperUtils.isNull(assignedPatients) || assignedPatients.isEmpty() ? "None" : assignedPatients));
    }

    @Override
    public void displaySummary() {
        System.out.println("Dr. " + getFirstName() + " " + getLastName() +
                " | " + specialization +
                " | Exp: " + experienceYears + " yrs" +
                " | Fee: $" + consultationFee);
    }

    // Update only the fee
    public void updateFee(double fee) {
        if (HelperUtils.isValidNumber(fee, 1, 1000)) {
            this.consultationFee = fee;
            System.out.println("Consultation fee updated to: " + fee);
        } else {
            System.out.println("Invalid fee value.");
        }
    }

    // Update fee with a reason
    public void updateFee(double fee, String reason) {
        if (HelperUtils.isValidNumber(fee, 1, 1000)) {
            this.consultationFee = fee;
            System.out.println("Consultation fee updated to: " + fee + " | Reason: " + reason);
        } else {
            System.out.println("Invalid fee value.");
        }
    }
}
