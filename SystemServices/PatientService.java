package SystemServices;

import SystemEntity.EmergencyPatient;
import SystemEntity.InPatient;
import SystemEntity.OutPatient;
import SystemHelper.HelperUtils;
import SystemHelper.InputHandler;
import SystemInterface.Manageable;
import SystemEntity.Patient;
import SystemInterface.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PatientService implements Manageable, Searchable {
    public static List<Patient> patientList = new ArrayList<>();
    public static List<InPatient> inPatientList = new ArrayList<>();
    public static List<OutPatient> outPatientList = new ArrayList<>();
    public static List<EmergencyPatient> emergencyPatientList = new ArrayList<>();


    //addPatient( minimal info)
    public static void addPatient(String firstName, String lastName, String phone, LocalDate dateOfBirth, String gender, String email, String address, String patientId, String bloodGroup, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> allergies, List<String> medicalRecords, List<String> appointments) {
        if (HelperUtils.isValidString(firstName) && HelperUtils.isValidString(lastName) && HelperUtils.isValidString(phone)) {

            Patient patient = new Patient();
            patient.setPatientId(patientId);
            patient.setFirstName(firstName);
            patient.setLastName(lastName);
            patient.setPhoneNumber(phone);
            patient.setGender(gender);
            patient.setDateOfBirth(dateOfBirth);
            patient.setEmail(email);
            patient.setAddress(address);
            patient.setBloodGroup(bloodGroup);
            patient.setEmergencyContact(emergencyContact);
            patient.setRegistrationDate(registrationDate);
            patient.setInsuranceId(insuranceId);
            patientList.add(patient);

            System.out.println("Patient added: " + firstName + " " + lastName);
        } else {
            System.out.println("Invalid patient details — cannot add");
        }
    }

    //addPatient( with blood group)
    public static void addPatient() {
        String patientId = HelperUtils.generateId("PAT");
        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");
        String phone = InputHandler.getStringInput("Phone: ");
        LocalDate dateOfBirth = InputHandler.getDateInput("date Of Birth: ");
        String gender = InputHandler.getStringInput("gender: ");
        String email = InputHandler.getStringInput("email: ");
        String address = InputHandler.getStringInput("address: ");
        String bloodGroup = InputHandler.getStringInput("blood Group: ");
        String emergencyContact = InputHandler.getStringInput("emergency Contact: ");
        LocalDate registrationDate = InputHandler.getDateInput("registration Date: ");
        String insuranceId = InputHandler.getStringInput("insurance Id: ");
        List<String> allergies = Collections.singletonList(InputHandler.getStringInput("allergies: "));
        List<String> medicalRecords = Collections.singletonList(InputHandler.getStringInput("medicalRecords: "));
        List<String> appointments = Collections.singletonList(InputHandler.getStringInput("appointments: "));
        PatientService.addPatient(firstName, lastName, phone, dateOfBirth, gender, email, address, patientId, bloodGroup, emergencyContact, registrationDate, insuranceId, allergies, medicalRecords, appointments);
    }

    public static void addPatient(Patient patient) {
        if (HelperUtils.isNotNull(patient) && HelperUtils.isValidString(patient.getPatientId())) {
            patientList.add(patient);
            System.out.println("Patient " + patient.getPatientId() + " added successfully");
        } else {
            System.out.println("Cannot add patient — invalid input");
        }
    }

    public static void addInPatient() {
        System.out.println("--- Register New In-Patient ---");

        String patientId = HelperUtils.generateId("INP");
        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");
        String phone = InputHandler.getStringInput("Phone: ");
        LocalDate dateOfBirth = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");
        String bloodGroup = InputHandler.getStringInput("Blood Group: ");
        List<String> allergies = Collections.singletonList(InputHandler.getStringInput("allergies: "));
        List<String> medicalRecords = Collections.singletonList(InputHandler.getStringInput("medicalRecords: "));
        List<String> appointments = Collections.singletonList(InputHandler.getStringInput("appointments: "));
        String emergencyContact = InputHandler.getStringInput("Emergency Contact: ");
        LocalDate registrationDate = InputHandler.getDateInput("Registration Date: ");
        String insuranceId = InputHandler.getStringInput("Insurance ID: ");
        LocalDate admissionDate = InputHandler.getDateInput("Admission Date (yyyy-MM-dd): ");
        LocalDate dischargeDate = InputHandler.getDateInput("Discharge Date (yyyy-MM-dd): ");
        String roomNumber = InputHandler.getStringInput("Room Number: ");
        String bedNumber = InputHandler.getStringInput("Bed Number: ");
        String admittingDoctorId = InputHandler.getStringInput("Admitting Doctor ID: ");
        double dailyCharges = InputHandler.getDoubleInput("Daily Charges (OMR): ");

        InPatient inPatient = new InPatient();
        inPatient.setFirstName(firstName);
        inPatient.setLastName(lastName);
        inPatient.setPhoneNumber(phone);
        inPatient.setGender(gender);
        inPatient.setDateOfBirth(dateOfBirth);
        inPatient.setEmail(email);
        inPatient.setAddress(address);
        inPatient.setPatientId(patientId);
        inPatient.setBloodGroup(bloodGroup);
        inPatient.setEmergencyContact(emergencyContact);
        inPatient.setRegistrationDate(registrationDate);
        inPatient.setInsuranceId(insuranceId);
        inPatient.setAllergies(allergies);
        inPatient.setMedicalRecords(medicalRecords);
        inPatient.setAdmissionDate(admissionDate);
        inPatient.setDischargeDate(dischargeDate);
        inPatient.setRoomNumber(roomNumber);
        inPatient.setBedNumber(bedNumber);
        inPatient.setAppointments(appointments);
        inPatient.setAdmittingDoctorId(admittingDoctorId);
        inPatient.setDailyCharges(dailyCharges);
        addPatient(inPatient);
        System.out.println("In-Patient registered successfully: " + firstName + " " + lastName);
    }

    public static void addOutPatient() {
        System.out.println("--- Register New Out-Patient ---");

        String patientId = HelperUtils.generateId("OUT");
        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");
        String phone = InputHandler.getStringInput("Phone: ");
        LocalDate dateOfBirth = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");
        String bloodGroup = InputHandler.getStringInput("Blood Group: ");
        String emergencyContact = InputHandler.getStringInput("Emergency Contact: ");
        LocalDate registrationDate = InputHandler.getDateInput("Registration Date: ");
        String insuranceId = InputHandler.getStringInput("Insurance ID: ");
        int visitCount = InputHandler.getIntInput("Number of Visits: ");
        LocalDate lastVisitDate = LocalDate.parse(InputHandler.getStringInput("Last Visit Date (yyyy-MM-dd): "));
        String preferredDoctorId = InputHandler.getStringInput("Preferred Doctor ID: ");

        OutPatient outPatient = new OutPatient();
        outPatient.setFirstName(firstName);
        outPatient.setLastName(lastName);
        outPatient.setPhoneNumber(phone);
        outPatient.setGender(gender);
        outPatient.setDateOfBirth(dateOfBirth);
        outPatient.setEmail(email);
        outPatient.setAddress(address);
        outPatient.setPatientId(patientId);
        outPatient.setBloodGroup(bloodGroup);
        outPatient.setEmergencyContact(emergencyContact);
        outPatient.setRegistrationDate(registrationDate);
        outPatient.setInsuranceId(insuranceId);
        outPatient.setVisitCount(visitCount);
        outPatient.setLastVisitDate(lastVisitDate);
        outPatient.setPreferredDoctorId(preferredDoctorId);

        // Add Out-Patient to list
        addPatient(outPatient);
        System.out.println("Out-Patient registered successfully: " + firstName + " " + lastName);
    }

    public static void addEmergencyPatient() {
        System.out.println("--- Register Emergency Patient ---");

        String patientId = HelperUtils.generateId("EMP");
        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");
        String phone = InputHandler.getStringInput("Phone: ");
        LocalDate dateOfBirth = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");
        String bloodGroup = InputHandler.getStringInput("Blood Group: ");
        String emergencyContact = InputHandler.getStringInput("Emergency Contact: ");
        List<String> allergies = Collections.singletonList(InputHandler.getStringInput("allergies: "));
        List<String> medicalRecords = Collections.singletonList(InputHandler.getStringInput("medicalRecords: "));
        List<String> appointments = Collections.singletonList(InputHandler.getStringInput("appointments: "));
        LocalDate registrationDate = InputHandler.getDateInput("Registration Date: ");
        String insuranceId = InputHandler.getStringInput("Insurance ID: ");
        String emergencyType = InputHandler.getStringInput("Emergency Type (e.g., Accident, Cardiac, Trauma): ");
        String arrivalMode = InputHandler.getStringInput("Arrival Mode (e.g., Ambulance, Walk-in): ");
        int triageLevel = InputHandler.getIntInput("Triage Level (1-5): ", 1, 5);
        boolean admittedViaER = InputHandler.getConfirmation("Admitted via ER?");
        LocalDate admissionDate = InputHandler.getDateInput("Admission Date: ");
        LocalDate dischargeDate = InputHandler.getDateInput("Discharge Date: ");
        String roomNumber = InputHandler.getStringInput("Room Number: ");
        String bedNumber = InputHandler.getStringInput("Bed Number: ");
        String admittingDoctorId = InputHandler.getStringInput("Admitting Doctor ID: ");
        double dailyCharges = InputHandler.getDoubleInput("Daily Charges: ");


        EmergencyPatient emergencyPatient = new EmergencyPatient();
        emergencyPatient.setFirstName(firstName);
        emergencyPatient.setLastName(lastName);
        emergencyPatient.setPhoneNumber(phone);
        emergencyPatient.setGender(gender);
        emergencyPatient.setDateOfBirth(dateOfBirth);
        emergencyPatient.setEmail(email);
        emergencyPatient.setAddress(address);
        emergencyPatient.setPatientId(patientId);
        emergencyPatient.setBloodGroup(bloodGroup);
        emergencyPatient.setEmergencyContact(emergencyContact);
        emergencyPatient.setRegistrationDate(registrationDate);
        emergencyPatient.setInsuranceId(insuranceId);
        emergencyPatient.setAllergies(allergies);
        emergencyPatient.setMedicalRecords(medicalRecords);
        emergencyPatient.setAdmissionDate(admissionDate);
        emergencyPatient.setDischargeDate(dischargeDate);
        emergencyPatient.setRoomNumber(roomNumber);
        emergencyPatient.setBedNumber(bedNumber);
        emergencyPatient.setAppointments(appointments);
        emergencyPatient.setAdmittingDoctorId(admittingDoctorId);
        emergencyPatient.setDailyCharges(dailyCharges);
        emergencyPatient.setEmergencyType(emergencyType);
        emergencyPatient.setArrivalMode(arrivalMode);
        emergencyPatient.setTriageLevel(triageLevel);
        emergencyPatient.setAdmittedViaER(admittedViaER);

        addPatient(emergencyPatient);
        System.out.println("Emergency Patient registered successfully: " + firstName + " " + lastName);
    }


    public static void editPatient(String patientId, Patient updatedPatient) {
        Patient existing = getPatientById(patientId);
        if (existing != null) {
            if (updatedPatient.getEmail() != null && !HelperUtils.isValidEmail(updatedPatient.getEmail())) {
                System.out.println("Invalid email format. Update canceled.");
            }
            if (updatedPatient.getPhoneNumber() != null && !HelperUtils.isValidPhone(updatedPatient.getPhoneNumber())) {
                System.out.println("Invalid phone number. Update canceled.");
            }
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
    public static List<Patient> searchPatients() {
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine();
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

    public static List<Patient> searchPatients(String keyword) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patientList) {
            if ((patient.getFirstName() != null && patient.getFirstName().toLowerCase().contains(keyword.toLowerCase())) ||
                    (patient.getLastName() != null && patient.getLastName().toLowerCase().contains(keyword.toLowerCase())) ||
                    (patient.getPhoneNumber() != null && patient.getPhoneNumber().contains(keyword)) ||
                    (patient.getEmail() != null && patient.getEmail().toLowerCase().contains(keyword.toLowerCase()))
            ) {
                result.add(patient);
            }
        }
        return result;
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

    public static List<Patient> searchPatientsByName(String name) {
        List<Patient> results = new ArrayList<>();
        if (!HelperUtils.isValidString(name)) return results;

        String searchTerm = name.toLowerCase();
        for (Patient patient : patientList) {
            if (HelperUtils.isNotNull(patient.getFirstName()) && patient.getFirstName().toLowerCase().contains(searchTerm) ||
                    HelperUtils.isNotNull(patient.getLastName()) && patient.getLastName().toLowerCase().contains(searchTerm)) {
                results.add(patient);
            }
        }
        return results;
    }

    @Override
    public String add(Object entity) {
        if (entity instanceof InPatient) {
            inPatientList.add((InPatient) entity);
            return "InPatient added successfully!";
        }

        if (entity instanceof OutPatient) {
            outPatientList.add((OutPatient) entity);
            return "OutPatient added successfully!";
        }

        if (entity instanceof EmergencyPatient) {
            emergencyPatientList.add((EmergencyPatient) entity);
            return "Emergency Patient added successfully!";
        }

        if (entity instanceof Patient) {
            patientList.add((Patient) entity);
            return "Patient added successfully!";
        }
        return "Invalid entity type.";

    }

    @Override
    public String remove(String id) {
        boolean removedGeneral = patientList.removeIf(p -> p.getPatientId().equals(id));
        boolean removedIn = inPatientList.removeIf(p -> p.getPatientId().equals(id));
        boolean removedOut = outPatientList.removeIf(p -> p.getPatientId().equals(id));
        boolean removedEmergency = emergencyPatientList.removeIf(p -> p.getPatientId().equals(id));

        if (removedGeneral || removedIn || removedOut || removedEmergency) {
            return "Patient removed successfully!";
        } else {
            return "Patient not found!";
        }
    }

    @Override
    public String getAll() {
        if (patientList.isEmpty() && inPatientList.isEmpty()
                && outPatientList.isEmpty() && emergencyPatientList.isEmpty()) {
            return "No patients available.";
        }

        StringBuilder result = new StringBuilder("===== Patient List =====\n");

        if (!patientList.isEmpty()) {
            result.append("\n-- General Patients --\n");
            for (Patient p : patientList) {
                if (!(p instanceof InPatient) && !(p instanceof OutPatient) && !(p instanceof EmergencyPatient)) {
                    result.append(p.displayInfo("")).append("\n------------------------\n");
                }
            }
        }

        if (!inPatientList.isEmpty()) {
            result.append("\n-- InPatients --\n");
            for (InPatient ip : inPatientList) {
                result.append(ip.displayInfo("")).append("\n------------------------\n");
            }
        }

        if (!outPatientList.isEmpty()) {
            result.append("\n-- OutPatients --\n");
            for (OutPatient op : outPatientList) {
                result.append(op.displayInfo("")).append("\n------------------------\n");
            }
        }

        if (!emergencyPatientList.isEmpty()) {
            result.append("\n-- Emergency Patients --\n");
            for (EmergencyPatient ep : emergencyPatientList) {
                result.append(ep.displayInfo("")).append("\n------------------------\n");
            }
        }

        return result.toString();
    }

    @Override
    public String search(String keyword) {
        String result = "Search Results:\n";
        boolean found = false;
        // General patients
        for (Patient p : patientList) {
            if (p.getFirstName().contains(keyword) || p.getLastName().contains(keyword)) {
                result += "ID" + p.getId() + " - Patient ID: " + p.getPatientId() + " - " + p.getFirstName() + " " + p.getLastName() + "\n";
                found = true;
            }
        }
        // InPatients
        for (InPatient ip : inPatientList) {
            if (ip.getFirstName().contains(keyword) || ip.getLastName().contains(keyword)) {
                result += "ID" + ip.getId() + " - Patient ID: " + ip.getPatientId() + " - " + ip.getFirstName() + " " + ip.getLastName() + "\n";
                found = true;
            }
        }
        // OutPatients
        for (OutPatient op : outPatientList) {
            if (op.getFirstName().contains(keyword) || op.getLastName().contains(keyword)) {
                result += "ID" + op.getId() + " - Patient ID: " + op.getPatientId() + " - " + op.getFirstName() + " " + op.getLastName() + "\n";
                found = true;
            }
        }
        // EmergencyPatients
        for (EmergencyPatient ep : emergencyPatientList) {
            if (ep.getFirstName().contains(keyword) || ep.getLastName().contains(keyword)) {
                result += "ID" + ep.getId() + " - Patient ID: " + ep.getPatientId() + " - " + ep.getFirstName() + " " + ep.getLastName() + "\n";
                found = true;
            }
        }
        if (!found) {
            return "No patients found for keyword: " + keyword;
        }
        return result;
    }

    @Override
    public String searchById(String id) {
        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                return "Patient found: " + p.getFirstName() + " " + p.getLastName();
            }
        }
        for (InPatient ip : inPatientList) {
            if (ip.getId().equals(id)) {
                return "InPatient found: " + ip.getFirstName() + " " + ip.getLastName();
            }
        }
        for (OutPatient op : outPatientList) {
            if (op.getId().equals(id)) {
                return "OutPatient found: " + op.getFirstName() + " " + op.getLastName();
            }
        }
        for (EmergencyPatient ep : emergencyPatientList) {
            if (ep.getId().equals(id)) {
                return "EmergencyPatient found: " + ep.getFirstName() + " " + ep.getLastName();
            }
        }
        return "Patient not found for ID: " + id;
    }
    public static void sampleData() {
        String[] names = {"Abdullah", "Maryam", "Noura", "Maher", "Mohammed", "Shaima"};
        String[] lastNames = {"AlMashari", "AlDughaishi", "AlBalushi", "Alfori", "AlMasroori", "AlNabhani"};
        String[] allergies = {"Peanuts", "Shellfish", "Dairy", "Eggs", "Soy", "Wheat"};
        String[] bloodGroups = {"A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-"};
        String[] emailAddress = {"@gmail.com", "@hotmail.com", "@yahoo.com", "@outlook.com"};
        String[] emergencyTypes = {"Medical", "Trauma", "Burns", "Surgical", "Environmental"};
//2 patient
        for (int i = 0; i < 3; i++) {
            Patient patient = new Patient();
            patient.setId("987654432" + i);
            patient.setPatientId("PAT-123" + i);
            patient.setFirstName(names[i]);
            patient.setLastName(lastNames[i]);
            patient.setDateOfBirth(LocalDate.of(1990, 9, 14));
            patient.setGender("Female");
            patient.setPhoneNumber("92923232" + i);
            patient.setEmail(patient.getFirstName().toLowerCase() + "." + patient.getLastName().toLowerCase() + i + emailAddress[i % emailAddress.length]);
            patient.setAddress("123 Main St");
            patient.setBloodGroup(bloodGroups[i]);
            patient.setAllergies(new ArrayList<>());
            patient.setEmergencyContact("9876543210");
            patient.setRegistrationDate(LocalDate.now());
            patient.setInsuranceId("INS123" + i);
            patientList.add(patient);
        }

        List<InPatient> inPatients = new ArrayList<>();

        names = new String[]{"Abdullah", "Maryam", "Maher", "Mohammed"};
        lastNames = new String[]{"AlMashari", "AlDughaishi", "AlBalushi", "Alfori"};
        bloodGroups = new String[]{"A+", "B+", "O-", "AB+"};
        emailAddress = new String[]{"@gmail.com", "@hotmail.com", "@yahoo.com", "@outlook.com"};
        String[] roomNumbers = {"101", "102", "103", "104"};
        String[] bedNumbers = {"1A", "1B", "2A", "2B"};
        String[] doctorIds = {"DOC001", "DOC002", "DOC003", "DOC004"};
        double[] dailyCharges = {50.0, 55.0, 60.0, 65.0};

        for (int i = 0; i < 3; i++) {
            InPatient inPatient = new InPatient();

            //inpatients sample data
            inPatient.setId("INP-" + (1000 + i));
            inPatient.setPatientId("INPAT-" + (200 + i));
            inPatient.setFirstName(names[i]);
            inPatient.setLastName(lastNames[i]);
            inPatient.setDateOfBirth(LocalDate.of(1988 + i, 5, 10 + i));
            inPatient.setGender("Female");
            inPatient.setPhoneNumber("98765432" + i);
            inPatient.setEmail(names[i].toLowerCase() + "." + lastNames[i].toLowerCase() + emailAddress[i % emailAddress.length]);
            inPatient.setAddress("Ward Street No. " + (10 + i));
            inPatient.setBloodGroup(bloodGroups[i]);
            inPatient.setEmergencyContact("99887766" + i);
            inPatient.setRegistrationDate(LocalDate.now());
            inPatient.setInsuranceId("INS-" + (300 + i));
            inPatient.setAllergies(new ArrayList<>(List.of("None")));
            inPatient.setMedicalRecords(new ArrayList<>());
            inPatient.setAppointments(new ArrayList<>());
            inPatient.setAdmissionDate(LocalDate.now().minusDays(5 + i));
            inPatient.setDischargeDate(LocalDate.now().plusDays(3 + i));
            inPatient.setRoomNumber(roomNumbers[i]);
            inPatient.setBedNumber(bedNumbers[i]);
            inPatient.setAdmittingDoctorId(doctorIds[i]);
            inPatient.setDailyCharges(dailyCharges[i]);

            inPatients.add(inPatient);
        }


        //outpatients sample data
        List<OutPatient> outPatients = new ArrayList<>();

        names = new String[]{"Khalid", "Huda"};
        lastNames = new String[]{"Salim", "Ali"};
        bloodGroups = new String[]{"A-", "B+", "O+", "AB-"};
        emailAddress = new String[]{"@gmail.com", "@hotmail.com", "@yahoo.com", "@outlook.com"};
        doctorIds = new String[]{"DOC101", "DOC102", "DOC103", "DOC104"};
        int[] visitCounts = {3, 5, 2, 4};

        for (int i = 0; i < 2; i++) {
            OutPatient outPatient = new OutPatient();

            // Basic Patient information
            outPatient.setId("OUT-" + (100 + i));
            outPatient.setPatientId("OUTPAT-" + (200 + i));
            outPatient.setFirstName(names[i]);
            outPatient.setLastName(lastNames[i]);
            outPatient.setGender("Male"); // or change based on index if you want variety
            outPatient.setDateOfBirth(LocalDate.of(1992 + i, 4, 10 + i));
            outPatient.setPhoneNumber("91234567" + i);
            outPatient.setEmail(names[i].toLowerCase() + "." + lastNames[i].toLowerCase() + emailAddress[i % emailAddress.length]);
            outPatient.setAddress("45 Street No. " + (10 + i));
            outPatient.setBloodGroup(bloodGroups[i]);
            outPatient.setEmergencyContact("99887766" + i);
            outPatient.setRegistrationDate(LocalDate.now().minusDays(i));
            outPatient.setInsuranceId("INS-" + (500 + i));
            outPatient.setVisitCount(visitCounts[i]);
            outPatient.setLastVisitDate(LocalDate.now().minusWeeks(i + 1));
            outPatient.setPreferredDoctorId(doctorIds[i]);
            outPatients.add(outPatient);
        }

        List<EmergencyPatient> emergencyPatients = new ArrayList<>();

        names = new String[]{"Salma", "Hassan", "Fatima", "Rashid"};
        lastNames = new String[]{"Omar", "Ali", "Yusuf", "Nasser"};
        bloodGroups = new String[]{"O+", "A-", "B+", "AB+"};
        emailAddress = new String[]{"@gmail.com", "@hotmail.com", "@yahoo.com", "@outlook.com"};
        roomNumbers = new String[]{"E101", "E102", "E103", "E104"};
        bedNumbers = new String[]{"B1", "B2", "B3", "B4"};
        doctorIds = new String[]{"DOC201", "DOC202", "DOC203", "DOC204"};
        emergencyTypes = new String[]{"Accident", "Heart Attack", "Burn Injury", "Asthma Attack"};
        String[] arrivalModes = {"Ambulance", "Walk-in", "Helicopter", "Police"};
        int[] triageLevels = {1, 2, 3, 2}; // 1 = critical, 3 = stable
        boolean[] admittedViaER = {true, true, false, true};
        dailyCharges = new double[]{120.0, 130.0, 110.0, 150.0};

        for (int i = 0; i < 4; i++) {
            EmergencyPatient emergencyPatient = new EmergencyPatient();
            emergencyPatient.setId("EMP-" + (1000 + i));
            emergencyPatient.setPatientId("EMERG-" + (300 + i));
            emergencyPatient.setFirstName(names[i]);
            emergencyPatient.setLastName(lastNames[i]);
            emergencyPatient.setGender("Male");
            emergencyPatient.setDateOfBirth(LocalDate.of(1989 + i, 3, 15 + i));
            emergencyPatient.setPhoneNumber("91122334" + i);
            emergencyPatient.setEmail(names[i].toLowerCase() + "." + lastNames[i].toLowerCase() + emailAddress[i % emailAddress.length]);
            emergencyPatient.setAddress("Emergency Ward, Block " + (i + 1));
            emergencyPatient.setBloodGroup(bloodGroups[i]);
            emergencyPatient.setEmergencyContact("99887766" + i);
            emergencyPatient.setRegistrationDate(LocalDate.now());
            emergencyPatient.setInsuranceId("INS-" + (600 + i));
            emergencyPatient.setAllergies(new ArrayList<>(List.of("None")));
            emergencyPatient.setMedicalRecords(new ArrayList<>());
            emergencyPatient.setAppointments(new ArrayList<>());
            emergencyPatient.setAdmissionDate(LocalDate.now().minusDays(1 + i));
            emergencyPatient.setDischargeDate(LocalDate.now().plusDays(2 + i));
            emergencyPatient.setRoomNumber(roomNumbers[i]);
            emergencyPatient.setBedNumber(bedNumbers[i]);
            emergencyPatient.setAdmittingDoctorId(doctorIds[i]);
            emergencyPatient.setDailyCharges(dailyCharges[i]);
            emergencyPatient.setEmergencyType(emergencyTypes[i]);
            emergencyPatient.setArrivalMode(arrivalModes[i]);
            emergencyPatient.setTriageLevel(triageLevels[i]);
            emergencyPatient.setAdmittedViaER(admittedViaER[i]);

            emergencyPatients.add(emergencyPatient);
        }


    }


}
