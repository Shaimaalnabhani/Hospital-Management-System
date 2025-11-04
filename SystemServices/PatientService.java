package SystemServices;

import SystemInterface.Manageable;
import SystemEntity.Patient;
import SystemInterface.Searchable;

import java.util.ArrayList;
import java.util.List;

public class PatientService implements Manageable, Searchable {
    private static List<Patient> patientList = new ArrayList<>();

    //addPatient( minimal info)
    public static void addPatient(String firstName, String lastName, String phone) {
        Patient patient = new Patient(
                "P" + (patientList.size() + 1), // id
                firstName,
                lastName,
                null,   // dateOfBirth
                null,   // gender
                phone,
                null,   // email
                null,   // address
                "PID" + (patientList.size() + 1), // patientId
                null,   // bloodGroup
                new ArrayList<>(), // allergies
                null,   // emergencyContact
                null,   // registrationDate
                null,   // insuranceId
                new ArrayList<>(), // medicalRecords
                new ArrayList<>()  // appointments
        );
        patientList.add(patient);
        System.out.println("Patient " + firstName + " " + lastName + " added successfully (minimal info).");
    }

    //addPatient( with blood group)
    public static void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        Patient patient = new Patient(
                "P" + (patientList.size() + 1),
                firstName,
                lastName,
                null,
                null,
                phone,
                email,
                null,
                "PID" + (patientList.size() + 1),
                bloodGroup,
                new ArrayList<>(),
                null,
                null,
                null,
                new ArrayList<>(),
                new ArrayList<>()
        );
        patientList.add(patient);
        System.out.println("Patient " + firstName + " " + lastName + " added successfully (with blood group and email).");
    }

    // addPatient(full object)
    public static void addPatient(Patient patient) {
        patientList.add(patient);
        System.out.println("Patient " + patient.getPatientId() + " added successfully.");
    }

    public static void editPatient(String patientId, Patient updatedPatient) {
        Patient existing = getPatientById(patientId);
        if (existing != null) {
            existing.setFirstName(updatedPatient.getFirstName());
            existing.setLastName(updatedPatient.getLastName());
            existing.setDateOfBirth(updatedPatient.getDateOfBirth());
            existing.setGender(updatedPatient.getGender());
            existing.setPhoneNumber(updatedPatient.getPhoneNumber());
            existing.setEmail(updatedPatient.getEmail());
            existing.setAddress(updatedPatient.getAddress());
            existing.setBloodGroup(updatedPatient.getBloodGroup());
            existing.setAllergies(updatedPatient.getAllergies());
            existing.setEmergencyContact(updatedPatient.getEmergencyContact());
            existing.setRegistrationDate(updatedPatient.getRegistrationDate());
            existing.setInsuranceId(updatedPatient.getInsuranceId());
            existing.setMedicalRecords(updatedPatient.getMedicalRecords());
            existing.setAppointments(updatedPatient.getAppointments());

            System.out.println("Patient " + patientId + " updated successfully.");
        } else {
            System.out.println("Patient " + patientId + " not found.");
        }
    }

    public static void removePatient(String patientId) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            patientList.remove(patient);
            System.out.println("Patient " + patientId + " removed successfully.");
        } else {
            System.out.println("Patient " + patientId + " not found.");
        }
    }

    public static Patient getPatientById(String patientId) {
        for (Patient patient : patientList) {
            if (patient.getPatientId().equals(patientId)) {
                return patient;
            }
        }
        return null;
    }

    // display all patients
    public static void displayAllPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("----- All Patients -----");
            for (Patient patient : patientList) {
                patient.displayInfo();
                System.out.println("-----------------------");
            }
        }
    }

    // display filtered by criteria
    public static void displayPatients(String filter) {
        System.out.println("===== Filtered Patients (" + filter + ") =====");
        boolean found = false;
        for (Patient p : patientList) {
            if ((p.getBloodGroup() != null && p.getBloodGroup().equalsIgnoreCase(filter)) ||
                    (p.getGender() != null && p.getGender().equalsIgnoreCase(filter))) {
                p.displayInfo();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No patients match the filter: " + filter);
        }
    }

    // display limited number
    public static void displayPatients(int limit) {
        System.out.println("===== Displaying first " + limit + " patients =====");
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (int i = 0; i < Math.min(limit, patientList.size()); i++) {
            patientList.get(i).displayInfo();
            System.out.println("------------------------");
        }
    }

    // searchPatients - search by any field
    public static List<Patient> searchPatients(String keyword) {
        List<Patient> results = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Patient p : patientList) {
            if ((p.getFirstName() != null && p.getFirstName().toLowerCase().contains(lowerKeyword)) ||
                    (p.getLastName() != null && p.getLastName().toLowerCase().contains(lowerKeyword)) ||
                    (p.getPhoneNumber() != null && p.getPhoneNumber().contains(keyword)) ||
                    (p.getEmail() != null && p.getEmail().toLowerCase().contains(lowerKeyword)) ||
                    (p.getBloodGroup() != null && p.getBloodGroup().equalsIgnoreCase(keyword))) {
                results.add(p);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No patients found matching '" + keyword + "'.");
        } else {
            System.out.println("----- Search Results (keyword: '" + keyword + "') -----");
            for (Patient patient : results) {
                patient.displayInfo();
                System.out.println("-------------------------");
            }
        }

        return results;
    }

    // searchPatients - search by name
    public static List<Patient> searchPatients(String firstName, String lastName) {
        List<Patient> results = new ArrayList<>();
        for (Patient p : patientList) {
            if ((p.getFirstName() != null && p.getFirstName().equalsIgnoreCase(firstName)) &&
                    (p.getLastName() != null && p.getLastName().equalsIgnoreCase(lastName))) {
                results.add(p);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No patients found with name '" + firstName + " " + lastName + "'.");
        } else {
            System.out.println("----- Search Results (Name: " + firstName + " " + lastName + ") -----");
            for (Patient patient : results) {
                patient.displayInfo();
                System.out.println("-------------------------");
            }
        }
        return results;
    }

    @Override
    public void add(Object entity) {

    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public List<Object> search(String keyword) {
        return List.of();
    }

    @Override
    public Object searchById(String id) {
        return null;
    }
}
