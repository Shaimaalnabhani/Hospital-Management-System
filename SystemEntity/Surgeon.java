package SystemEntity;

import SystemHelper.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Surgeon extends Doctor {

    private int surgeriesPerformed ;
    private List<String> surgeryTypes;
    private boolean operationTheatreAccess;


    /*
     * Constructor Chaining Flow:
     * Surgeon() → Doctor() → Person()
     */
    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, int surgeriesPerformed, List<String> surgeryTypes, boolean operationTheatreAccess) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = HelperUtils.isNotNull(surgeryTypes) ? surgeryTypes : new ArrayList<>();
        this.operationTheatreAccess = operationTheatreAccess;

        System.out.println("Surgeon constructor called.");
        //Calls Doctor's constructor
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        if (surgeriesPerformed >= 0) {
            this.surgeriesPerformed = surgeriesPerformed;
        }
        else {
            System.out.println("Invalid surgery count.");
        }
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        if (HelperUtils.isNotNull(surgeryTypes)) {
            this.surgeryTypes = surgeryTypes;
        }
        else {
            System.out.println("Surgery type list cannot be null.");
        }
    }

    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Surgeries Performed: " + surgeriesPerformed);
        System.out.println("Surgery Types: " + surgeryTypes);
        System.out.println("Operation Theatre Access: " + operationTheatreAccess);
    }

    public void performSurgery(String surgeryType) {
        if (!operationTheatreAccess) {
            System.out.println("Surgeon does not have operation theatre access!");
            return;
        }

        if (!HelperUtils.isValidString(surgeryType)) {
            System.out.println("Invalid surgery type.");
            return;
        }

        if (!surgeryTypes.contains(surgeryType)) {
            surgeryTypes.add(surgeryType);
        }

        surgeriesPerformed++;
        System.out.println("Performed surgery: " + surgeryType + " | Total surgeries: " + surgeriesPerformed);
    }


    public void updateSurgeryCount(int newCount) {
        if (newCount >= 0) {
            surgeriesPerformed = newCount;
            System.out.println("Surgery count updated to " + surgeriesPerformed);
        } else {
            System.out.println("Invalid surgery count.");
        }
    }

}
