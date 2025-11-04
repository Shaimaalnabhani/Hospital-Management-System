package SystemServices;

import SystemEntity.Doctor;
import SystemInterface.Manageable;
import SystemEntity.Patient;
import SystemInterface.Searchable;

import java.util.ArrayList;
import java.util.List;

public class DoctorService implements Manageable, Searchable {
    private static List<Doctor> doctorList = new ArrayList<>();


    //
    public static void addDoctor(String firstName, String lastName, String phone) {
        Doctor doctor = new Doctor(
                "D" + (doctorList.size() + 1), // id
                firstName,
                lastName,
                null,  // dateOfBirth
                null,  // gender
                phone,
                null,  // email
                null,  // address
                "DOC" + (doctorList.size() + 1), // doctorId
                null,  // specialization
                null,  // qualification
                0,     // experienceYears
                null,  // departmentId
                0.0,   // consultationFee
                new ArrayList<>(), // availableSlots
                new ArrayList<>()  // assignedPatients
        );
        doctorList.add(doctor);
        System.out.println("Doctor " + firstName + " " + lastName + " added (minimal info).");
    }

    public static void addDoctor(String firstName, String lastName, String phone, double consultationFee) {
        Doctor doctor = new Doctor(
                "D" + (doctorList.size() + 1),
                firstName,
                lastName,
                null,
                null,
                phone,
                null,
                null,
                "DOC" + (doctorList.size() + 1),
                null,
                null,
                0,
                null,
                consultationFee,
                new ArrayList<>(),
                new ArrayList<>()
        );
        doctorList.add(doctor);
        System.out.println("Doctor " + firstName + " " + lastName + " added (with consultation fee).");
    }


    public static void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
        System.out.println("Doctor " + doctor.getDoctorId() + " added successfully.");
    }

    public static void editDoctor(String doctorId, Doctor updatedDoctor) {
        Doctor existing = getDoctorById(doctorId);
        if (existing != null) {
            existing.setFirstName(updatedDoctor.getFirstName());
            existing.setLastName(updatedDoctor.getLastName());
            existing.setDateOfBirth(updatedDoctor.getDateOfBirth());
            existing.setGender(updatedDoctor.getGender());
            existing.setPhoneNumber(updatedDoctor.getPhoneNumber());
            existing.setEmail(updatedDoctor.getEmail());
            existing.setAddress(updatedDoctor.getAddress());
            existing.setSpecialization(updatedDoctor.getSpecialization());
            existing.setQualification(updatedDoctor.getQualification());
            existing.setExperienceYears(updatedDoctor.getExperienceYears());
            existing.setDepartmentId(updatedDoctor.getDepartmentId());
            existing.setConsultationFee(updatedDoctor.getConsultationFee());
            existing.setAvailableSlots(updatedDoctor.getAvailableSlots());
            existing.setAssignedPatients(updatedDoctor.getAssignedPatients());

            System.out.println("Doctor " + doctorId + " updated successfully.");
        } else {
            System.out.println("Doctor " + doctorId + " not found.");
        }
    }

    public static void removeDoctor(String doctorId) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            doctorList.remove(doctor);
            System.out.println("Doctor " + doctorId + " removed successfully.");
        } else {
            System.out.println("Doctor " + doctorId + " not found.");
        }
    }

    public static void assignPatient(String doctorId, String patientId) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            if (!doctor.getAssignedPatients().contains(patientId)) {
                doctor.getAssignedPatients().add(patientId);
                System.out.println("Patient " + patientId + " assigned to Doctor " + doctorId);
            } else {
                System.out.println("Patient already assigned.");
            }
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public static void assignPatient(Doctor doctor, Patient patient) {
        if (doctor != null && patient != null) {
            if (!doctor.getAssignedPatients().contains(patient.getPatientId())) {
                doctor.getAssignedPatients().add(patient.getPatientId());
                System.out.println("Patient " + patient.getPatientId() + " assigned to Doctor " + doctor.getDoctorId());
            } else {
                System.out.println("Patient already assigned.");
            }
        } else {
            System.out.println("Doctor or patient is null.");
        }
    }

    public static void assignPatient(String doctorId, List<String> patientIds) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            for (String pid : patientIds) {
                if (!doctor.getAssignedPatients().contains(pid)) {
                    doctor.getAssignedPatients().add(pid);
                }
            }
            System.out.println("Patients " + patientIds + " assigned to Doctor " + doctorId);
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public static Doctor getDoctorById(String doctorId) {
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId().equals(doctorId)) {
                return doctor;
            }
        }
        return null;
    }
    //display all doctors
    public static void displayAllDoctors() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("----- All Doctors -----");
            for (Doctor doctor : doctorList) {
                doctor.displayInfo();
                System.out.println("----------------------");
            }
        }
    }
    //display doctors filtered by specialization
    public static void displayDoctors(String specialization) {
        boolean found = false;
        System.out.println("===== Doctors (Specialization: " + specialization + ") =====");
        for (Doctor d : doctorList) {
            if (d.getSpecialization() != null && d.getSpecialization().equalsIgnoreCase(specialization)) {
                d.displayInfo();
                System.out.println("----------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No doctors found with specialization: " + specialization);
        }
    }

    public static void displayDoctors(String departmentId, boolean showAvailableOnly) {
        boolean found = false;
        System.out.println("===== Doctors (Department: " + departmentId +
                ", Show Available Only: " + showAvailableOnly + ") =====");
        for (Doctor d : doctorList) {
            boolean inDept = d.getDepartmentId() != null && d.getDepartmentId().equalsIgnoreCase(departmentId);
            boolean available = !d.getAvailableSlots().isEmpty();

            if (inDept && (!showAvailableOnly || available)) {
                d.displayInfo();
                System.out.println("----------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No doctors found matching the criteria.");
        }
    }

    public static List<Doctor> getDoctorsBySpecialization(String specialization) {
        List<Doctor> results = new ArrayList<>();
        String spec = specialization.toLowerCase();

        for (Doctor doctor : doctorList) {
            if (doctor.getSpecialization().toLowerCase().contains(spec)) {
                results.add(doctor);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No doctors found with specialization: " + specialization);
        } else {
            System.out.println("----- Doctors with Specialization: " + specialization + " -----");
            for (Doctor doctor : results) {
                doctor.displayInfo();
                System.out.println("---------------------------------------");
            }
        }

        return results;
    }


    public static List<Doctor> getAvailableDoctors() {
        List<Doctor> results = new ArrayList<>();

        for (Doctor doctor : doctorList) {
            if (!doctor.getAvailableSlots().isEmpty()) {
                results.add(doctor);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No doctors are currently available.");
        } else {
            System.out.println("----- Available Doctors -----");
            for (Doctor doctor : results) {
                doctor.displayInfo();
                System.out.println("----------------------------");
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
