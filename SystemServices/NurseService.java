package SystemServices;

import SystemHelper.HelperUtils;
import SystemHelper.InputHandler;
import SystemInterface.Manageable;
import SystemEntity.Nurse;
import SystemInterface.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NurseService implements Manageable, Searchable {
    private static List<Nurse> nurseList = new ArrayList<>();


    public static void addNurse(Nurse nurse) {
        nurseList.add(nurse);
        System.out.println("Nurse " + nurse.getNurseId() + " added successfully.");
    }

    public static void addNurse(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String nurseId, List<String> assignedPatients, String qualification, String shift, String departmentId) {
        System.out.println("--- Register New Nurse ---");
        nurseId = HelperUtils.generateId("NUR");
        firstName = InputHandler.getStringInput("First Name: ");
        lastName = InputHandler.getStringInput("Last Name: ");
        phoneNumber = InputHandler.getStringInput("Phone: ");
        dateOfBirth = InputHandler.getDateInput("Date of Birth: ");
        gender = InputHandler.getStringInput("Gender: ");
        email = InputHandler.getStringInput("Email: ");
        address = InputHandler.getStringInput("Address: ");
        departmentId = InputHandler.getStringInput("Department ID: ");
        shift = InputHandler.getStringInput("Shift (Morning/Afternoon/Night): ");
        qualification = InputHandler.getStringInput("Qualification: ");
        assignedPatients = new ArrayList<>();
        System.out.println("Enter Assigned Patient IDs (type 'done' to finish):");
        while (true) {
            String patientId = InputHandler.getStringInput(" - Patient ID: ");
            if (patientId.equalsIgnoreCase("done")) break;
            assignedPatients.add(patientId);
        }
    }

    public static void editNurse(String nurseId, Nurse updatedNurse) {
        Nurse existing = getNurseById(nurseId);
        if (existing != null) {
            existing.setFirstName(updatedNurse.getFirstName());
            existing.setLastName(updatedNurse.getLastName());
            existing.setDateOfBirth(updatedNurse.getDateOfBirth());
            existing.setGender(updatedNurse.getGender());
            existing.setPhoneNumber(updatedNurse.getPhoneNumber());
            existing.setEmail(updatedNurse.getEmail());
            existing.setAddress(updatedNurse.getAddress());
            existing.setDepartmentId(updatedNurse.getDepartmentId());
            existing.setShift(updatedNurse.getShift());
            existing.setQualification(updatedNurse.getQualification());
            existing.setAssignedPatients(updatedNurse.getAssignedPatients());

            System.out.println("Nurse " + nurseId + " updated successfully.");
        } else {
            System.out.println("Nurse " + nurseId + " not found.");
        }
    }

    public static void removeNurse(String nurseId) {
        Nurse nurse = getNurseById(nurseId);
        if (nurse != null) {
            nurseList.remove(nurse);
            System.out.println("Nurse " + nurseId + " removed successfully.");
        } else {
            System.out.println("Nurse " + nurseId + " not found.");
        }
    }


    public static Nurse getNurseById(String nurseId) {
        for (Nurse nurse : nurseList) {
            if (nurse.getNurseId().equals(nurseId)) {
                return nurse;
            }
        }
        return null;
    }


    public static void displayAllNurses() {
        if (nurseList.isEmpty()) {
            System.out.println("No nurses found.");
        } else {
            System.out.println("----- All Nurses -----");
            for (Nurse nurse : nurseList) {
                nurse.displayInfo();
                System.out.println("---------------------");
            }
        }
    }

    public static List<Nurse> getNursesByDepartment(String departmentId) {
        List<Nurse> results = new ArrayList<>();
        for (Nurse nurse : nurseList) {
            if (nurse.getDepartmentId().equalsIgnoreCase(departmentId)) {
                results.add(nurse);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No nurses found in Department: " + departmentId);
        } else {
            System.out.println("----- Nurses in Department: " + departmentId + " -----");
            for (Nurse nurse : results) {
                nurse.displayInfo();
                System.out.println("---------------------------------");
            }
        }

        return results;
    }

    public static List<Nurse> getNursesByShift(String shift) {
        List<Nurse> results = new ArrayList<>();
        String lowerShift = shift.toLowerCase();

        for (Nurse nurse : nurseList) {
            if (nurse.getShift().toLowerCase().equals(lowerShift)) {
                results.add(nurse);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No nurses found in shift: " + shift);
        } else {
            System.out.println("----- Nurses in Shift: " + shift + " -----");
            for (Nurse nurse : results) {
                nurse.displayInfo();
                System.out.println("-------------------------------");
            }
        }

        return results;
    }

    @Override
    public String add(Object entity) {
        if (entity instanceof Nurse) {
            nurseList.add((Nurse) entity);
            return "Nurse added successfully!";
        }
        return "Invalid entity type.";
    }

    @Override
    public String remove(String id) {
        Nurse nurse = getNurseById(id);
        if (HelperUtils.isNotNull(nurse)) {
            nurseList.remove(nurse);
            return "Nurse with ID " + id + " removed successfully!";
        }
        return "Nurse not found.";
    }

    @Override
    public String getAll() {
        if (nurseList.isEmpty()) {
            return "No nurses available.";
        }

        StringBuilder sb = new StringBuilder("===== Nurse List =====\n");
        for (Nurse nurse : nurseList) {
            sb.append(nurse.displayInfo("")).append(System.lineSeparator());
            sb.append("------------------------").append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String search(String keyword) {
        if (HelperUtils.isNull(keyword) || keyword.trim().isEmpty()) {
            return "Invalid keyword.";
        }

        StringBuilder sb = new StringBuilder();
        for (Nurse nurse : nurseList) {
            if ((HelperUtils.isNotNull(nurse.getFirstName()) && nurse.getFirstName().toLowerCase().contains(keyword.toLowerCase())) ||
                    (HelperUtils.isNotNull(nurse.getLastName()) && nurse.getLastName().toLowerCase().contains(keyword.toLowerCase())) ||
                    (HelperUtils.isNotNull(nurse.getEmail()) && nurse.getEmail().toLowerCase().contains(keyword.toLowerCase())) ||
                    (HelperUtils.isNotNull(nurse.getShift()) && nurse.getShift().toLowerCase().contains(keyword.toLowerCase())) ||
                    (HelperUtils.isNotNull(nurse.getDepartmentId()) && nurse.getDepartmentId().toLowerCase().contains(keyword.toLowerCase()))) {

                sb.append("- ")
                        .append(nurse.getFirstName()).append(" ")
                        .append(nurse.getLastName())
                        .append(" (Nurse ID: ").append(nurse.getNurseId()).append(")")
                        .append(System.lineSeparator());
            }
        }
        return sb.length() > 0 ? "Search Results:\n" + sb.toString() : "";
    }

    @Override
    public String searchById(String id) {
        Nurse nurse = getNurseById(id);
        if (HelperUtils.isNotNull(nurse)) {
            return "Nurse found: " + nurse.getFirstName() + " " + nurse.getLastName();
        }
        return "Nurse not found with ID: " + id;
    }
    public static void addSampleNurses() {
        String[] names = {"Sara", "Fatima", "Noura", "shaima", "Maryam", "Aisha"};
        String[] lastNames = {"AlNabhani", "AlRashid", "AlBalushi"};
        String[] shifts = {"Morning", "Evening", "Night"};
        String[] qualifications = {"RN", "LPN", "CNA"};
        String[] emailAddress = {"gmail.com", "yahoo.com", "hotmail.com"};
        for (int i = 0; i < 6; i++) {
            Nurse nurse = new Nurse();
            nurse.setNurseId(HelperUtils.generateId("NUR"));
            nurse.setFirstName(names[i]);
            nurse.setLastName(lastNames[i % lastNames.length]);
            nurse.setDateOfBirth(LocalDate.of(1997, 03, 17));
            nurse.setGender("Female");
            nurse.setPhoneNumber("92923232" + i);
            nurse.setEmail(nurse.getFirstName().toLowerCase() + "." + nurse.getLastName().toLowerCase() + i + emailAddress[i % emailAddress.length]);
            nurse.setAddress("123 Main St");
            nurse.setDepartmentId("DEP-123" + i);
            nurse.setShift(shifts[i % 3]);
            nurse.setQualification(qualifications[i % 3]);
            nurse.setAssignedPatients(new ArrayList<>());
            nurseList.add(nurse);
        }
    }

}
