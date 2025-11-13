package SystemEntity;

import SystemHelper.HelperUtils;
import SystemInterface.Displayable;

import java.time.LocalDate;
import java.util.List;

public class GeneralPractitioner extends Doctor implements Displayable {

    private boolean walkInAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;


    /*
     * Constructor Chaining Flow:
     * GeneralPractitioner() → Doctor() → Person()

     - Person initializes basic info.
     - Patient adds patient-specific info.
     - InPatient adds admission details.
     - EmergencyPatient adds emergency info.
     */

    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, boolean walkInAvailable, boolean homeVisitAvailable, boolean vaccinationCertified) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.walkInAvailable = walkInAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;

        System.out.println("GeneralPractitioner constructor called.");

        //Calls Doctor's constructor
    }

    public GeneralPractitioner() {

    }

    public boolean isWalkInAvailable() {
        return walkInAvailable;
    }

    public void setWalkInAvailable(boolean walkInAvailable) {
        this.walkInAvailable = walkInAvailable;
    }

    public boolean isHomeVisitAvailable() {
        return homeVisitAvailable;
    }

    public void setHomeVisitAvailable(boolean homeVisitAvailable) {
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public boolean isVaccinationCertified() {
        return vaccinationCertified;
    }

    public void setVaccinationCertified(boolean vaccinationCertified) {
        this.vaccinationCertified = vaccinationCertified;
    }

    public void scheduleHomeVisit(String patientId, String dateTime) {
        if (!homeVisitAvailable) {
            System.out.println("Home visits are not available for this GP.");

        }
        if (HelperUtils.isNull(patientId) || HelperUtils.isNull(dateTime)) {
            System.out.println("⚠ Invalid patient ID or date/time for home visit.");
            return;
        }

        if (HelperUtils.isNotNull(getAssignedPatients())) {
            getAssignedPatients().add(patientId);
        }
        System.out.println("Scheduled a home visit for patient " + patientId + " at " + dateTime);
    }

    public void administerVaccine(String patientId, String vaccineName) {
        if (!vaccinationCertified) {
            System.out.println("This GP is not certified to administer vaccines.");
        }

        if (HelperUtils.isNull(patientId) || HelperUtils.isNull(vaccineName)) {
            System.out.println("Invalid patient ID or vaccine name.");
        }
        System.out.println("Administered " + vaccineName + " vaccine to patient " + patientId);
    }
    @Override
    public String displayInfo() {
        super.displayInfo();
        System.out.println("Walk-in Available: " + (walkInAvailable ? "Yes" : "No"));
        System.out.println("Home Visit Available: " + (homeVisitAvailable ? "Yes" : "No"));
        System.out.println("Vaccination Certified: " + (vaccinationCertified ? "Yes" : "No"));
        return null;
    }

    @Override
    public void displaySummary() {
        super.displaySummary();
    }
}
