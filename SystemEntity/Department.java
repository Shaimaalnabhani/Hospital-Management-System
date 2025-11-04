package SystemEntity;

import SystemHelper.HelperUtils;
import SystemInterface.Displayable;

import java.util.ArrayList;
import java.util.List;

public class Department implements Displayable {
    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<String> doctors;
    private List<String> nurses;
    private int bedCapacity;
    private int availableBeds;

    public Department(String departmentId, String departmentName, String headDoctorId, List<String> doctors, List<String> nurses, int bedCapacity, int availableBeds) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.doctors = doctors;
        this.nurses = nurses;
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;

        System.out.println("Department constructor called.");
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (HelperUtils.isValidString(departmentName, 3)) {
            this.departmentName = departmentName;
        } else {
            System.out.println("Invalid Department Name.");
        }
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        if (HelperUtils.isValidString(headDoctorId)) {
            this.headDoctorId = headDoctorId;
        } else {
            System.out.println("Invalid Head Doctor ID.");
        }
    }

    public List<String> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<String> doctors) {
        if (HelperUtils.isNotNull(doctors)) {
            this.doctors = doctors;
        } else {
            System.out.println("Doctor list cannot be null.");
        }
    }

    public List<String> getNurses() {
        return nurses;
    }

    public void setNurses(List<String> nurses) {
        if (HelperUtils.isNotNull(nurses)) {
            this.nurses = nurses;
        } else {
            System.out.println("Nurse list cannot be null.");
        }
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        if (HelperUtils.isValidNumber(bedCapacity, 1, 1000)) {
            this.bedCapacity = bedCapacity;
        } else {
            System.out.println("Invalid bed capacity (must be between 1–1000).");
        }
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        if (HelperUtils.isValidNumber(availableBeds, 0, bedCapacity)) {
            this.availableBeds = availableBeds;
        } else {
            System.out.println("Invalid available beds (must be between 0–" + bedCapacity + ").");
        }
    }

    public void displayInfo() {
        System.out.println("----- Department Information -----");
        System.out.println("Department ID: " + departmentId);
        System.out.println("Name: " + departmentName);
        System.out.println("Head Doctor ID: " + headDoctorId);
        System.out.println("Doctors: " + (HelperUtils.isNull(doctors) || doctors.isEmpty() ? "None" : doctors));
        System.out.println("Nurses: " + (HelperUtils.isNull(nurses) || nurses.isEmpty() ? "None" : nurses));
        System.out.println("Bed Capacity: " + bedCapacity);
        System.out.println("Available Beds: " + availableBeds);
    }

    @Override
    public void displaySummary() {
        System.out.println(departmentName + " (" + departmentId + ") - Beds: " + availableBeds + "/" + bedCapacity);
    }

    public void assignDoctor(String doctorId) {
        if (HelperUtils.isNull(doctors)) {
            doctors = new ArrayList<>();
        }
        if (HelperUtils.isValidString(doctorId)) {
            if (!doctors.contains(doctorId)) {
                doctors.add(doctorId);
                System.out.println("Doctor " + doctorId + " assigned to Department " + departmentId);
            } else {
                System.out.println("Doctor " + doctorId + " is already assigned.");
            }
        } else {
            System.out.println("Invalid doctor ID.");
        }
    }

    public void assignNurse(String nurseId) {
        if (HelperUtils.isNull(nurses)) {
            nurses = new ArrayList<>();
        }
        if (HelperUtils.isValidString(nurseId)) {
            if (!nurses.contains(nurseId)) {
                nurses.add(nurseId);
                System.out.println("Nurse " + nurseId + " assigned to Department " + departmentId);
            } else {
                System.out.println("Nurse " + nurseId + " is already assigned.");
            }
        } else {
            System.out.println("Invalid nurse ID.");
        }
    }

    public void updateBedAvailability(int newAvailableBeds) {
        if (HelperUtils.isValidNumber(newAvailableBeds, 0, bedCapacity)) {
            this.availableBeds = newAvailableBeds;
            System.out.println("Available beds updated to " + newAvailableBeds + " in Department " + departmentId);
        }
        else {
            System.out.println("Invalid bed count (must be 0–" + bedCapacity + ").");
        }
    }
}
