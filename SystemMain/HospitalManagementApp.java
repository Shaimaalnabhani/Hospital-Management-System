package SystemMain;

import java.util.Scanner;

public class HospitalManagementApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        int choice = 0;

        while (choice != 8) {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Nurse Management");
            System.out.println("4. Appointment Management");
            System.out.println("5. Medical Records Management");
            System.out.println("6. Department Management");
            System.out.println("7. Reports and Statistics");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                showPatientMenu();
            } else if (choice == 2) {
                showDoctorMenu();
            } else if (choice == 3) {
                showNurseMenu();
            } else if (choice == 4) {
                showAppointmentMenu();
            } else if (choice == 5) {
                showMedicalRecordMenu();
            } else if (choice == 6) {
                showDepartmentMenu();
            } else if (choice == 7) {
                showReportsMenu();
            } else if (choice == 8) {
                System.out.println("Exiting system... Goodbye!");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showPatientMenu() {
        int option = 0;

        while (option != 10) {
            System.out.println("\n--- PATIENT MANAGEMENT ---");
            System.out.println("1. Register New Patient");
            System.out.println("2. Register InPatient");
            System.out.println("3. Register OutPatient");
            System.out.println("4. Register Emergency Patient");
            System.out.println("5. View All Patients");
            System.out.println("6. Search Patient");
            System.out.println("7. Update Patient Information");
            System.out.println("8. Remove Patient");
            System.out.println("9. View Patient Medical History");
            System.out.println("10. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Registering new patient...");
            } else if (option == 2) {
                System.out.println("Registering inpatient...");
            } else if (option == 3) {
                System.out.println("Registering outpatient...");
            } else if (option == 4) {
                System.out.println("Registering emergency patient...");
            } else if (option == 5) {
                System.out.println("Viewing all patients...");
            } else if (option == 6) {
                System.out.println("Searching patient...");
            } else if (option == 7) {
                System.out.println("Updating patient info...");
            } else if (option == 8) {
                System.out.println("Removing patient...");
            } else if (option == 9) {
                System.out.println("Viewing patient medical history...");
            } else if (option == 10) {
                System.out.println("Returning to main menu...");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showDoctorMenu() {
        int option = 0;

        while (option != 11) {
            System.out.println("\n--- DOCTOR MANAGEMENT ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Surgeon");
            System.out.println("3. Add Consultant");
            System.out.println("4. Add General Practitioner");
            System.out.println("5. View All Doctors");
            System.out.println("6. Search Doctor by Specialization");
            System.out.println("7. View Available Doctors");
            System.out.println("8. Assign Patient to Doctor");
            System.out.println("9. Update Doctor Information");
            System.out.println("10. Remove Doctor");
            System.out.println("11. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Adding doctor...");
            } else if (option == 2) {
                System.out.println("Adding surgeon...");
            } else if (option == 3) {
                System.out.println("Adding consultant...");
            } else if (option == 4) {
                System.out.println("Adding general practitioner...");
            } else if (option == 5) {
                System.out.println("Viewing all doctors...");
            } else if (option == 6) {
                System.out.println("Searching doctor by specialization...");
            } else if (option == 7) {
                System.out.println("Viewing available doctors...");
            } else if (option == 8) {
                System.out.println("Assigning patient to doctor...");
            } else if (option == 9) {
                System.out.println("Updating doctor info...");
            } else if (option == 10) {
                System.out.println("Removing doctor...");
            } else if (option == 11) {
                System.out.println("Returning to main menu...");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showNurseMenu() {
        int option = 0;

        while (option != 8) {
            System.out.println("\n--- NURSE MANAGEMENT ---");
            System.out.println("1. Add Nurse");
            System.out.println("2. View All Nurses");
            System.out.println("3. View Nurses by Department");
            System.out.println("4. View Nurses by Shift");
            System.out.println("5. Assign Nurse to Patient");
            System.out.println("6. Update Nurse Information");
            System.out.println("7. Remove Nurse");
            System.out.println("8. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Adding nurse...");
            } else if (option == 2) {
                System.out.println("Viewing all nurses...");
            } else if (option == 3) {
                System.out.println("Viewing nurses by department...");
            } else if (option == 4) {
                System.out.println("Viewing nurses by shift...");
            } else if (option == 5) {
                System.out.println("Assigning nurse to patient...");
            } else if (option == 6) {
                System.out.println("Updating nurse info...");
            } else if (option == 7) {
                System.out.println("Removing nurse...");
            } else if (option == 8) {
                System.out.println("Returning to main menu...");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showAppointmentMenu() {
        int option = 0;

        while (option != 10) {
            System.out.println("\n--- APPOINTMENT MANAGEMENT ---");
            System.out.println("1. Schedule New Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. View Appointments by Patient");
            System.out.println("4. View Appointments by Doctor");
            System.out.println("5. View Appointments by Date");
            System.out.println("6. Reschedule Appointment");
            System.out.println("7. Cancel Appointment");
            System.out.println("8. Complete Appointment");
            System.out.println("9. View Upcoming Appointments");
            System.out.println("10. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Scheduling new appointment...");
            } else if (option == 2) {
                System.out.println("Viewing all appointments...");
            } else if (option == 3) {
                System.out.println("Viewing appointments by patient...");
            } else if (option == 4) {
                System.out.println("Viewing appointments by doctor...");
            } else if (option == 5) {
                System.out.println("Viewing appointments by date...");
            } else if (option == 6) {
                System.out.println("Rescheduling appointment...");
            } else if (option == 7) {
                System.out.println("Cancelling appointment...");
            } else if (option == 8) {
                System.out.println("Completing appointment...");
            } else if (option == 9) {
                System.out.println("Viewing upcoming appointments...");
            } else if (option == 10) {
                System.out.println("Returning to main menu...");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
    private static void showMedicalRecordMenu() {
        int option = 0;

        while (option != 8) {
            System.out.println("\n--- MEDICAL RECORDS MANAGEMENT ---");
            System.out.println("1. Create Medical Record");
            System.out.println("2. View All Records");
            System.out.println("3. View Records by Patient");
            System.out.println("4. View Records by Doctor");
            System.out.println("5. Update Medical Record");
            System.out.println("6. Delete Medical Record");
            System.out.println("7. Generate Patient History Report");
            System.out.println("8. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Creating medical record...");
            } else if (option == 2) {
                System.out.println("Viewing all records...");
            } else if (option == 3) {
                System.out.println("Viewing records by patient...");
            } else if (option == 4) {
                System.out.println("Viewing records by doctor...");
            } else if (option == 5) {
                System.out.println("Updating medical record...");
            } else if (option == 6) {
                System.out.println("Deleting medical record...");
            } else if (option == 7) {
                System.out.println("Generating patient history report...");
            } else if (option == 8) {
                System.out.println("Returning to main menu...");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
    private static void showDepartmentMenu() {
        int option = 0;

        while (option != 8) {
            System.out.println("\n--- DEPARTMENT MANAGEMENT ---");
            System.out.println("1. Add Department");
            System.out.println("2. View All Departments");
            System.out.println("3. View Department Details");
            System.out.println("4. Assign Doctor to Department");
            System.out.println("5. Assign Nurse to Department");
            System.out.println("6. Update Department Information");
            System.out.println("7. View Department Statistics");
            System.out.println("8. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Adding department...");
            } else if (option == 2) {
                System.out.println("Viewing all departments...");
            } else if (option == 3) {
                System.out.println("Viewing department details...");
            } else if (option == 4) {
                System.out.println("Assigning doctor to department...");
            } else if (option == 5) {
                System.out.println("Assigning nurse to department...");
            } else if (option == 6) {
                System.out.println("Updating department info...");
            } else if (option == 7) {
                System.out.println("Viewing department statistics...");
            } else if (option == 8) {
                System.out.println("Returning to main menu...");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
    private static void showReportsMenu() {
        int option = 0;

        while (option != 6) {
            System.out.println("\n--- REPORTS & STATISTICS ---");
            System.out.println("1. Daily Appointments Report");
            System.out.println("2. Doctor Performance Report");
            System.out.println("3. Department Occupancy Report");
            System.out.println("4. Patient Statistics");
            System.out.println("5. Emergency Cases Report");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Generating daily appointments report...");
            } else if (option == 2) {
                System.out.println("Generating doctor performance report...");
            } else if (option == 3) {
                System.out.println("Generating department occupancy report...");
            } else if (option == 4) {
                System.out.println("Generating patient statistics...");
            } else if (option == 5) {
                System.out.println("Generating emergency cases report...");
            } else if (option == 6) {
                System.out.println("Returning to main menu...");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}