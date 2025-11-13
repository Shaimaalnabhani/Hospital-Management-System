package SystemServices;

import SystemEntity.Department;
import SystemHelper.HelperUtils;
import SystemInterface.Manageable;
import SystemInterface.Searchable;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements Manageable, Searchable {
    private static List<Department> departmentList = new ArrayList<>();

    public static void addDepartment(Department department) {
        if (HelperUtils.isNotNull(department)) {
            departmentList.add(department);
            System.out.println("Department " + department.getDepartmentId() + " added successfully");
        } else {
            System.out.println("Can't add department");
        }
    }

    public static void editDepartment(String departmentId, Department updatedDepartment) {
        Department existing = getDepartmentById(departmentId);
        if (existing != null) {
            existing.setDepartmentName(updatedDepartment.getDepartmentName());
            existing.setHeadDoctorId(updatedDepartment.getHeadDoctorId());
            existing.setDoctors(updatedDepartment.getDoctors());
            existing.setNurses(updatedDepartment.getNurses());
            existing.setBedCapacity(updatedDepartment.getBedCapacity());
            existing.setAvailableBeds(updatedDepartment.getAvailableBeds());

            System.out.println("Department " + departmentId + " updated successfully.");
        } else {
            System.out.println("Department " + departmentId + " not found.");
        }
    }

    public static void removeDepartment(String departmentId) {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            departmentList.remove(department);
            System.out.println("Department " + departmentId + " removed successfully.");
        } else {
            System.out.println("Department " + departmentId + " not found.");
        }
    }

    public static Department getDepartmentById(String departmentId) {
        for (Department department : departmentList) {
            if (department.getDepartmentId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }

    public static void displayAllDepartments() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            System.out.println("----- All Departments -----");
            for (Department department : departmentList) {
                department.displayInfo();
                System.out.println("---------------------------");
            }
        }
    }

    public static void assignDoctorToDepartment(String doctorId, String departmentId) {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            department.assignDoctor(doctorId);
        } else {
            System.out.println("Department " + departmentId + " not found.");
        }
    }

    public static void assignNurseToDepartment(String nurseId, String departmentId) {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            department.assignNurse(nurseId);
        } else {
            System.out.println("Department " + departmentId + " not found.");
        }
    }

    @Override
    public String add(Object entity) {
        if (entity instanceof Department) {
            departmentList.add((Department) entity);
            return "Department added successfully!";
        }
        return "Invalid entity type.";
    }

    @Override
    public String remove(String id) {
        Department department = getDepartmentById(id);
        if (HelperUtils.isNotNull(department)) {
            departmentList.remove(department);
            return "Department with ID " + id + " removed successfully!";
        }
        return "Department not found.";
    }

    @Override
    public String getAll() {
        if (departmentList.isEmpty()) {
            return "No departments available.";
        }
        StringBuilder sb = new StringBuilder("===== Department List =====\n");
        for (Department department : departmentList) {
            sb.append(department.displayInfo(""));
            sb.append(System.lineSeparator());
            sb.append("---------------------------\n");
        }
        return sb.toString();    }

    @Override
    public String search(String keyword) {
        StringBuilder sb = new StringBuilder();
        for (Department d : departmentList) {
            if (d.getDepartmentName().toLowerCase().contains(keyword.toLowerCase())) {
                sb.append(d.displayInfo(""));
                sb.append(System.lineSeparator());
            }
        }
        return sb.length() > 0 ? sb.toString() : "No departments found for: " + keyword;
    }

    @Override
    public String searchById(String id) {
        Department dept = getDepartmentById(id);
        if (HelperUtils.isNotNull(dept)) {
            return dept.displayInfo("");
        }
        return "Department not found: " + id;
    }
    public static void addSampleDepartments() {
        String[] departmentNames = {"Cardiology", "Orthopedics",
                "Neurology", "Gastroenterology",
                "Endocrinology", "Pulmonology",
                "Nephrology", "Oncology",
                "Dermatology", "Psychiatry",
                "Pediatrics", "Geriatrics",
                "General Surgery", "Emergency",
                "Trauma Center", "Pharmacy",
                "Physiotherapy",
        };
        for (int i = 0; i < 4; i++) {
            Department department = new Department();
            department.setDepartmentName(departmentNames[i]);
            department.setHeadDoctorId("DR-123" + i);
            department.setDoctors(new ArrayList<>());
            department.setNurses(new ArrayList<>());
            department.setBedCapacity(50);
            department.setAvailableBeds(30);
            departmentList.add(department);

        }
    }


}
