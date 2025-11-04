package SystemServices;

import SystemEntity.Department;
import SystemInterface.Manageable;
import SystemInterface.Searchable;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements Manageable, Searchable {
    private static List<Department> departmentList = new ArrayList<>();

    public static void addDepartment(Department department) {
        departmentList.add(department);
        System.out.println("Department " + department.getDepartmentId() + " added successfully.");
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
