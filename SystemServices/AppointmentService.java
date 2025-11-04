package SystemServices;

import SystemEntity.Appointment;
import SystemInterface.Manageable;
import SystemInterface.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService implements Manageable, Searchable {
    private static List<Appointment> appointmentList = new ArrayList<>();

    public static void createAppointment(String patientId, String doctorId, LocalDate date) {
        String id = "A" + (appointmentList.size() + 1);
        Appointment appointment = new Appointment(id, patientId, doctorId, date);
        addAppointment(appointment);
    }

    public static void createAppointment(String patientId, String doctorId, LocalDate date, String time) {
        String id = "A" + (appointmentList.size() + 1);
        Appointment appointment = new Appointment(id, patientId, doctorId, date, time);
        addAppointment(appointment);
    }

    public static void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
        System.out.println("Appointment " + appointment.getAppointmentId() + " added successfully.");
    }

    public static void editAppointment(String appointmentId, Appointment updatedAppointment) {
        Appointment existing = getAppointmentById(appointmentId);
        if (existing != null) {
            existing.setPatientId(updatedAppointment.getPatientId());
            existing.setDoctorId(updatedAppointment.getDoctorId());
            existing.setAppointmentDate(updatedAppointment.getAppointmentDate());
            existing.setAppointmentTime(updatedAppointment.getAppointmentTime());
            existing.setStatus(updatedAppointment.getStatus());
            existing.setReason(updatedAppointment.getReason());
            existing.setNotes(updatedAppointment.getNotes());

            System.out.println("Appointment " + appointmentId + " updated successfully.");
        } else {
            System.out.println("Appointment " + appointmentId + " not found.");
        }
    }

    public static void removeAppointment(String appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment != null) {
            appointmentList.remove(appointment);
            System.out.println("Appointment " + appointmentId + " removed successfully.");
        } else {
            System.out.println("Appointment " + appointmentId + " not found.");
        }
    }

    public static Appointment getAppointmentById(String appointmentId) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }
        }
        return null;
    }

    public static List<Appointment> getAppointmentsByPatient(String patientId) {
        List<Appointment> results = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            if (appointment.getPatientId().equals(patientId)) {
                results.add(appointment);
            }
        }
        return results;
    }

    public static List<Appointment> getAppointmentsByDoctor(String doctorId) {
        List<Appointment> results = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            if (appointment.getDoctorId().equals(doctorId)) {
                results.add(appointment);
            }
        }
        return results;
    }

    public static List<Appointment> getAppointmentsByDate(LocalDate date) {
        List<Appointment> results = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentDate().equals(date)) {
                results.add(appointment);
            }
        }
        return results;
    }

    //reschedule using only a new date
    public static void rescheduleAppointment(String appointmentId, LocalDate newDate) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.reschedule(newDate, appointment.getAppointmentTime()); // keep old time
        } else {
            System.out.println("Appointment " + appointmentId + " not found.");
        }
    }

    //reschedule using new date and new time
    public static void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.reschedule(newDate, newTime);
        } else {
            System.out.println("Appointment " + appointmentId + " not found.");
        }
    }

    //reschedule using appointment object, new date/time, and a reason
    public static void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason) {
        if (appointment != null) {
            appointment.reschedule(newDate, newTime);
            appointment.setReason(reason);
            System.out.println("Appointment " + appointment.getAppointmentId() +
                    " rescheduled with reason: " + reason);
        } else {
            System.out.println("Invalid appointment object.");
        }
    }

    public static void cancelAppointment(String appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.cancel();
        } else {
            System.out.println("Appointment " + appointmentId + " not found.");
        }
    }

    public static void displayAllAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("----- All Appointments -----");
            for (Appointment appointment : appointmentList) {
                appointment.displayInfo();
                System.out.println("----------------------------");
            }
        }
    }
    public static void displayAppointments(LocalDate date) {
        boolean found = false;
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentDate().equals(date)) {
                appointment.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found on " + date);
        }
    }

    public static void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate) {
        boolean found = false;
        for (Appointment appointment : appointmentList) {
            LocalDate date = appointment.getAppointmentDate();
            if (appointment.getDoctorId().equalsIgnoreCase(doctorId)
                    && (date.isEqual(startDate) || date.isAfter(startDate))
                    && (date.isEqual(endDate) || date.isBefore(endDate))) {
                appointment.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found for Doctor " + doctorId +
                    " between " + startDate + " and " + endDate);
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
