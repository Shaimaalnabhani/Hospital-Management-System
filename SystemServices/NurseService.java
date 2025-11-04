package SystemServices;

import SystemInterface.Manageable;
import SystemEntity.Nurse;
import SystemInterface.Searchable;

import java.util.ArrayList;
import java.util.List;

public class NurseService implements Manageable, Searchable {
    private static List<Nurse> nurseList = new ArrayList<>();


    public static void addNurse(Nurse nurse) {
        nurseList.add(nurse);
        System.out.println("Nurse " + nurse.getNurseId() + " added successfully.");
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
