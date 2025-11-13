package SystemServices;

import SystemEntity.*;
import SystemHelper.HelperUtils;
import SystemHelper.InputHandler;
import SystemInterface.Manageable;
import SystemInterface.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoctorService implements Manageable, Searchable {
    private static List<Doctor> doctorList = new ArrayList<>();
    private static List<Surgeon> surgeonList  = new ArrayList<>();
    private static List<Consultant> consultantList  = new ArrayList<>();
    private static List<GeneralPractitioner> generalPractitionerList  = new ArrayList<>();


    //
    public static Doctor addDoctor() {
        Doctor doctor = new Doctor();
        String doctorId = HelperUtils.generateId("Dr");
        doctor.setDoctorId(doctorId);
        String firstName = InputHandler.getStringInput("First Name: ");
        doctor.setFirstName(firstName);
        String lastName = InputHandler.getStringInput("Last Name: ");
        doctor.setLastName(lastName);
        String phone = InputHandler.getStringInput("Phone: ");
        doctor.setPhoneNumber(phone);
        LocalDate dateOfBirth = InputHandler.getDateInput("date Of Birth: ");
        doctor.setDateOfBirth(dateOfBirth);
        String gender = InputHandler.getStringInput("gender: ");
        doctor.setGender(gender);
        String email = InputHandler.getStringInput("email: ");
        doctor.setEmail(email);
        String address = InputHandler.getStringInput("address: ");
        doctor.setAddress(address);
        String specialization = InputHandler.getStringInput("specialization: ");
        doctor.setSpecialization(specialization);
        String qualification = InputHandler.getStringInput("qualification: ");
        doctor.setQualification(qualification);
        int experienceYears = InputHandler.getIntInput("experience Years: ");
        doctor.setExperienceYears(experienceYears);
        String departmentId = InputHandler.getStringInput("department Id: ");
        doctor.setDepartmentId(departmentId);
        double consultationFee = InputHandler.getDoubleInput("Consultation Fee: ");
        doctor.setConsultationFee(consultationFee);
        List<String> availableSlots = new ArrayList<>();
        System.out.println("Enter Available Slots (type 'done' to finish):");
        doctor.setAvailableSlots(availableSlots);
        while (true) {
            String slot = InputHandler.getStringInput(" - Slot (e.g., 09:00-10:00): ");
            if (slot.equalsIgnoreCase("done")) break;
            availableSlots.add(slot);
        }
        List<String> assignedPatients = new ArrayList<>();
        System.out.println("Enter Assigned Patient IDs (type 'done' to finish):");
        doctor.setAssignedPatients(assignedPatients);
        while (true) {
            String patientId = InputHandler.getStringInput(" - Patient ID: ");
            if (patientId.equalsIgnoreCase("done")) break;
            assignedPatients.add(patientId);
        }
        return doctor;
    }

    public static void addDoctor(String firstName, String lastName, LocalDate dateOfBirth, String gender, String email, String address, String specialization, int experienceYears,
                                 String phone, double consultationFee, List<String> availableSlots, List<String> assignedPatients) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setDateOfBirth(dateOfBirth);
        doctor.setGender(gender);
        doctor.setEmail(email);
        doctor.setAddress(address);
        doctor.setSpecialization(specialization);
        doctor.setExperienceYears(experienceYears);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);
        doctor.setAvailableSlots(availableSlots);
        doctor.setAssignedPatients(assignedPatients);
        doctorList.add(doctor);
        System.out.println("Doctor added: " + " (" + specialization + "), Fee: " + consultationFee);
    }


//

    public static void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
        System.out.println("Doctor " + doctor.getDoctorId() + " added successfully.");
    }

    public static void addSurgeon() {
        System.out.println("--- Register New Surgeon ---");

        String doctorId = HelperUtils.generateId("SURG"); // use as unique id
        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");
        String phone = InputHandler.getStringInput("Phone: ");
        LocalDate dateOfBirth = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");
        String specialization = InputHandler.getStringInput("Specialization: ");
        String qualification = InputHandler.getStringInput("Qualification: ");
        int experienceYears = InputHandler.getIntInput("Experience Years: ");
        String departmentId = InputHandler.getStringInput("Department ID: ");
        int surgeriesPerformed = InputHandler.getIntInput("Number of Surgeries Performed: ");
        List<String> surgeryTypes = new ArrayList<>();
        System.out.println("Enter Surgery Types (type 'done' to finish):");
        while (true) {
            String type = InputHandler.getStringInput(" - Type: ");
            if (type.equalsIgnoreCase("done")) break;
            surgeryTypes.add(type);
        }
        boolean operationTheatreAccess = InputHandler.getConfirmation("Has Operation Theatre Access?");

        Surgeon surgeon = new Surgeon();
        surgeon.setFirstName(firstName);
        surgeon.setLastName(lastName);
        surgeon.setDateOfBirth(dateOfBirth);
        surgeon.setGender(gender);
        surgeon.setEmail(email);
        surgeon.setAddress(address);
        surgeon.setSpecialization(specialization);
        surgeon.setQualification(qualification);
        surgeon.setExperienceYears(experienceYears);
        surgeon.setPhoneNumber(phone);
        surgeon.setDepartmentId(departmentId);
        surgeon.setSurgeriesPerformed(surgeriesPerformed);
        surgeon.setSurgeryTypes(surgeryTypes);
        surgeon.setOperationTheatreAccess(operationTheatreAccess);
        DoctorService.addDoctor(surgeon);
        System.out.println("Surgeon registered successfully: " + firstName + " " + lastName + " (" + doctorId + ")");
    }

    public static void addConsultant() {
        System.out.println("--- Register New Consultant ---");

        String doctorId = HelperUtils.generateId("CONS");
        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");
        String phone = InputHandler.getStringInput("Phone: ");
        LocalDate dateOfBirth = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");
        String specialization = InputHandler.getStringInput("Specialization: ");
        String qualification = InputHandler.getStringInput("Qualification: ");
        int experienceYears = InputHandler.getIntInput("Experience Years: ");
        String departmentId = InputHandler.getStringInput("Department ID: ");
        List<String> consultationTypes = new ArrayList<>();
        System.out.println("Enter Consultation Types (type 'done' to finish):");
        while (true) {
            String type = InputHandler.getStringInput(" - Type: ");
            if (type.equalsIgnoreCase("done")) break;
            consultationTypes.add(type);
        }

        boolean onlineConsultationAvailable = InputHandler.getConfirmation("Online Consultation Available? (yes/no): ");
        int consultationDuration = InputHandler.getIntInput("Average Consultation Duration (minutes): ");

        Consultant consultant = new Consultant();
        consultant.setDoctorId(doctorId);
        consultant.setFirstName(firstName);
        consultant.setLastName(lastName);
        consultant.setDateOfBirth(dateOfBirth);
        consultant.setGender(gender);
        consultant.setEmail(email);
        consultant.setAddress(address);
        consultant.setSpecialization(specialization);
        consultant.setQualification(qualification);
        consultant.setExperienceYears(experienceYears);
        consultant.setPhoneNumber(phone);
        consultant.setDepartmentId(departmentId);
        consultant.setConsultationTypes(consultationTypes);
        consultant.setOnlineConsultationAvailable(onlineConsultationAvailable);
        consultant.setConsultationDuration(consultationDuration);

        DoctorService.addDoctor(consultant);
        System.out.println("Consultant registered successfully: " + firstName + " " + lastName);
    }

    public static void addGeneralPractitioner() {
        System.out.println("--- Register New General Practitioner ---");
        String doctorId = HelperUtils.generateId("GP");
        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");
        String phone = InputHandler.getStringInput("Phone: ");
        LocalDate dateOfBirth = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");
        String specialization = InputHandler.getStringInput("Specialization: ");
        String qualification = InputHandler.getStringInput("Qualification: ");
        int experienceYears = InputHandler.getIntInput("Experience Years: ");
        String departmentId = InputHandler.getStringInput("Department ID: ");
        boolean walkinAvailable = InputHandler.getConfirmation("Walk-in Available? (yes/no): ");
        boolean homeVisitAvailable = InputHandler.getConfirmation("Home Visit Available? (yes/no): ");
        boolean vaccinationCertified = InputHandler.getConfirmation("Vaccination Certified? (yes/no): ");
        double consultationFee = InputHandler.getDoubleInput("Consultation Fee: ");
        List<String> availableSlots = new ArrayList<>();
        System.out.println("Enter Available Slots (type 'done' to finish):");
        while (true) {
            String slot = InputHandler.getStringInput(" - Slot (e.g., 09:00-10:00): ");
            if (slot.equalsIgnoreCase("done")) break;
            availableSlots.add(slot);
        }
        List<String> assignedPatients = new ArrayList<>();
        System.out.println("Enter Assigned Patient IDs (type 'done' to finish):");
        while (true) {
            String patientId = InputHandler.getStringInput(" - Patient ID: ");
            if (patientId.equalsIgnoreCase("done")) break;
            assignedPatients.add(patientId);
        }

        GeneralPractitioner generalPractitioner = new GeneralPractitioner();
        generalPractitioner.setDoctorId(doctorId);
        generalPractitioner.setFirstName(firstName);
        generalPractitioner.setLastName(lastName);
        generalPractitioner.setDateOfBirth(dateOfBirth);
        generalPractitioner.setGender(gender);
        generalPractitioner.setEmail(email);
        generalPractitioner.setAddress(address);
        generalPractitioner.setSpecialization(specialization);
        generalPractitioner.setQualification(qualification);
        generalPractitioner.setExperienceYears(experienceYears);
        generalPractitioner.setPhoneNumber(phone);
        generalPractitioner.setDepartmentId(departmentId);
        generalPractitioner.setWalkInAvailable(walkinAvailable);
        generalPractitioner.setHomeVisitAvailable(homeVisitAvailable);
        generalPractitioner.setVaccinationCertified(vaccinationCertified);
        generalPractitioner.setConsultationFee(consultationFee);
        generalPractitioner.setAvailableSlots(availableSlots);
        generalPractitioner.setAssignedPatients(assignedPatients);

        // Add to doctor service
        DoctorService.addDoctor(generalPractitioner);
        System.out.println("General Practitioner registered successfully: " + firstName + " " + lastName);
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
    public String add(Object entity) {
        if (entity instanceof Consultant) {
            consultantList.add((Consultant) entity);
            return "Consultant added successfully: ";
        }
        if (entity instanceof Surgeon) {
            surgeonList.add((Surgeon) entity);
            return "Surgeon added successfully: ";
        }
        if (entity instanceof GeneralPractitioner) {
            generalPractitionerList.add((GeneralPractitioner) entity);
            return "General Practitioner added successfully: ";
        }
        if (entity instanceof Doctor) {
            doctorList.add((Doctor) entity);
            return "Doctor added successfully: ";
        }
        return "Invalid entity type.";
    }

    @Override
    public String remove(String id) {
        boolean removedGeneral = doctorList.removeIf(d -> d.getDoctorId().equals(id));
        boolean removedConsultant = consultantList.removeIf(d -> d.getDoctorId().equals(id));
        boolean removedSurgeon = surgeonList.removeIf(d -> d.getDoctorId().equals(id));
        boolean removedGP = generalPractitionerList.removeIf(d -> d.getDoctorId().equals(id));

        if (removedGeneral || removedConsultant || removedSurgeon || removedGP) {
            return "Doctor " + id + " removed successfully.";
        }
        return "Doctor not found.";
    }

    @Override
    public String getAll() {
        if (doctorList.isEmpty() && surgeonList.isEmpty() &&
                consultantList.isEmpty() && generalPractitionerList.isEmpty()) {
            return "No doctors found.";
        }

        StringBuilder result = new StringBuilder("===== All Doctors =====\n");

        if (!doctorList.isEmpty()) {
            result.append("\n-- General Doctors --\n");
            for (Doctor d : doctorList) {
                if (!(d instanceof Consultant) && !(d instanceof Surgeon) && !(d instanceof GeneralPractitioner)) {
                    result.append(d.displayInfo()).append("\n------------------------\n");
                }
            }
        }

        if (!consultantList.isEmpty()) {
            result.append("\n-- Consultant Doctors --\n");
            for (Consultant consultant : consultantList) {
                result.append(consultant.displayInfo()).append("\n------------------------\n");
            }
        }

        if (!surgeonList.isEmpty()) {
            result.append("\n-- Surgeons --\n");
            for (Surgeon surgeon : surgeonList) {
                result.append(surgeon.displayInfo()).append("\n------------------------\n");
            }
        }

        if (!generalPractitionerList.isEmpty()) {
            result.append("\n-- General Practitioners --\n");
            for (GeneralPractitioner gp : generalPractitionerList) {
                result.append(gp.displayInfo()).append("\n------------------------\n");
            }
        }

        return result.toString();
    }

    @Override
    public String search(String keyword) {
        String result = "Search Results:\n";
        boolean found = false;

        // Search across all lists
        for (Doctor d : doctorList) {
            if (d.getFirstName().toLowerCase().contains(keyword.toLowerCase()) ||
                    d.getLastName().toLowerCase().contains(keyword.toLowerCase()) ||
                    d.getSpecialization().toLowerCase().contains(keyword.toLowerCase())) {
                result += d.toString() + "\n";
                found = true;
            }
        }
        for (Consultant consultant : consultantList) {
            if (consultant.getFirstName().toLowerCase().contains(keyword.toLowerCase()) ||
                    consultant.getLastName().toLowerCase().contains(keyword.toLowerCase()) ||
                    consultant.getSpecialization().toLowerCase().contains(keyword.toLowerCase())) {
                result += consultant.toString() + "\n";
                found = true;
            }
        }
        for (Surgeon surgeon : surgeonList) {
            if (surgeon.getFirstName().toLowerCase().contains(keyword.toLowerCase()) ||
                    surgeon.getLastName().toLowerCase().contains(keyword.toLowerCase()) ||
                    surgeon.getSpecialization().toLowerCase().contains(keyword.toLowerCase())) {
                result += surgeon.toString() + "\n";
                found = true;
            }
        }
        for (GeneralPractitioner generalPractitioner : generalPractitionerList) {
            if (generalPractitioner.getFirstName().toLowerCase().contains(keyword.toLowerCase()) ||
                    generalPractitioner.getLastName().toLowerCase().contains(keyword.toLowerCase()) ||
                    generalPractitioner.getSpecialization().toLowerCase().contains(keyword.toLowerCase())) {
                result += generalPractitioner.toString() + "\n";
                found = true;
            }
        }

        return found ? result : "No matches found for keyword: " + keyword;
    }

    @Override
    public String searchById(String id) {
        for (Doctor d : doctorList) {
            if (d.getId().equals(id)) return d.toString();
        }
        // Consultant Doctors
        for (Consultant consultant : consultantList) {
            if (consultant.getDoctorId().equals(id)) return consultant.toString();
        }
        // Surgeons
        for (Surgeon surgeon : surgeonList) {
            if (surgeon.getDoctorId().equals(id)) return surgeon.toString();
        }
        // General Practitioners
        for (GeneralPractitioner generalPractitioner : generalPractitionerList) {
            if (generalPractitioner.getDoctorId().equals(id)) return generalPractitioner.toString();
        }

        return "Doctor not found with ID: " + id;
    }
    public static void addSampleDoctors() {
        String[] names = {"Sara", "Fatima", "Omar", "shima", "Layla", "Ahmed"};
        String[] lastNames = {"AlMashari", "AlRashid", "AlBalushi"};
        String[] qualifications = {"MBBS", "MD", "PhD"};
        String[] specializations = {"Cardiology", "Orthopedics", "Neurology"};
        String[] emailAddress = {"gmail.com", "yahoo.com", "hotmail.com"};
        String[] consultationTypes = {"Emergency", "General", "Specialist", "Follow-up"};

        for (int i = 0; i < 3; i++) {
            Surgeon surgeon = new Surgeon();
            surgeon.setDoctorId(HelperUtils.generateId("DR"));
            surgeon.setFirstName(names[i]);
            surgeon.setLastName(lastNames[i]);
            surgeon.setDateOfBirth(LocalDate.of(1990, 9, 14));
            surgeon.setGender("Female");
            surgeon.setPhoneNumber("92923232" + i);
            surgeon.setEmail(surgeon.getFirstName().toLowerCase() + "." + surgeon.getLastName().toLowerCase() + i + emailAddress[i % emailAddress.length]);
            surgeon.setAddress("123 Main St");
            surgeon.setSpecialization(specializations[i]);
            surgeon.setQualification(qualifications[i]);
            surgeon.setExperienceYears(5);
            surgeon.setDepartmentId("DEP-123" + i);
            surgeon.setConsultationFee(50.0);
            surgeon.setAvailableSlots(new ArrayList<>());
            surgeon.setAssignedPatients(new ArrayList<>());
            surgeon.setSurgeriesPerformed(3);
            surgeon.setSurgeryTypes(new ArrayList<>());
            surgeon.setOperationTheatreAccess(true);
            doctorList.add(surgeon);
        }

        List<Consultant> consultants = new ArrayList<>();

        names = new String[]{"Aisha", "Laila", "Sara"};
        lastNames = new String[]{"Hassan", "Omar", "Ali"};
        specializations = new String[]{"Cardiology", "Dermatology", "Neurology"};
        qualifications = new String[]{"MD", "PhD", "MBBS"};
        emailAddress = new String[]{"@gmail.com", "@hotmail.com", "@yahoo.com"};
        String[] departmentIds = {"DEP-201", "DEP-202", "DEP-203"};
        consultationTypes = new String[]{"Emergency", "General", "Specialist", "Follow-up"};
        boolean[] onlineConsultationAvailable = {true, false, true};
        int[] consultationDurations = {30, 45, 60};

        for (int i = 0; i < 3; i++) {
            Consultant consultant = new Consultant();
            consultant.setDoctorId(HelperUtils.generateId("DOC"));
            consultant.setFirstName(names[i]);
            consultant.setLastName(lastNames[i]);
            consultant.setDateOfBirth(LocalDate.of(1984 + i, 1, 10 + i));
            consultant.setGender("Female");
            consultant.setPhoneNumber("91234567" + i);
            consultant.setEmail(consultant.getFirstName().toLowerCase() + "." + consultant.getLastName().toLowerCase() + i + emailAddress[i % emailAddress.length]);
            consultant.setAddress("45 Health Street, Block " + (i + 1));
            consultant.setSpecialization(specializations[i]);
            consultant.setQualification(qualifications[i]);
            consultant.setExperienceYears(7 + i);
            consultant.setDepartmentId(departmentIds[i]);
            consultant.setConsultationTypes(Collections.singletonList(consultationTypes[i]));
            consultant.setOnlineConsultationAvailable(onlineConsultationAvailable[i]);
            consultant.setConsultationDuration(consultationDurations[i]); // in minutes
            consultants.add(consultant);
        }

        List<GeneralPractitioner> generalPractitioners = new ArrayList<>();

        names = new String[]{"Hoor", "Rashid", "Khaled"};
        lastNames = new String[]{"AlNabhani", "Alfori", "AlMasroori"};
        specializations = new String[]{"Family Medicine", "General Practice", "Community Health"};
        qualifications = new String[]{"MBBS", "MD", "DO"};
        emailAddress = new String[]{"@gmail.com", "@hotmail.com", "@outlook.com"};
        departmentIds = new String[]{"DEP-301", "DEP-302", "DEP-303"};
        boolean[] walkinAvailable = {true, true, false};
        boolean[] homeVisitAvailable = {false, true, true};
        boolean[] vaccinationCertified = {true, true, true};
        double[] consultationFees = {25.0, 30.0, 28.5};

        for (int i = 0; i < 3; i++) {
            GeneralPractitioner generalPractitioner = new GeneralPractitioner();
            generalPractitioner.setDoctorId(HelperUtils.generateId("DOC"));
            generalPractitioner.setFirstName(names[i]);
            generalPractitioner.setLastName(lastNames[i]);
            generalPractitioner.setDateOfBirth(LocalDate.of(1980 + i, 6, 12 + i));
            generalPractitioner.setGender("Male");
            generalPractitioner.setPhoneNumber("91122334" + i);
            generalPractitioner.setEmail(generalPractitioner.getFirstName().toLowerCase() + "." + generalPractitioner.getLastName().toLowerCase() + i + emailAddress[i % emailAddress.length]);
            generalPractitioner.setAddress("Clinic Street No. " + (10 + i));
            generalPractitioner.setSpecialization(specializations[i]);
            generalPractitioner.setQualification(qualifications[i]);
            generalPractitioner.setExperienceYears(8 + i);
            generalPractitioner.setDepartmentId(departmentIds[i]);
            generalPractitioner.setWalkInAvailable(walkinAvailable[i]);
            generalPractitioner.setHomeVisitAvailable(homeVisitAvailable[i]);
            generalPractitioner.setVaccinationCertified(vaccinationCertified[i]);
            generalPractitioner.setConsultationFee(consultationFees[i]);
            generalPractitioner.setAvailableSlots(new ArrayList<>());
            generalPractitioner.setAssignedPatients(new ArrayList<>());
            generalPractitioners.add(generalPractitioner);
        }


    }

}
