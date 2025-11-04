package SystemEntity;

import SystemHelper.HelperUtils;
import SystemInterface.Displayable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment implements Displayable {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private String notes;

    public Appointment(String appointmentId, String patientId, String doctorId, LocalDate appointmentDate, String appointmentTime, String status, String reason, String notes) {
        this.appointmentId = HelperUtils.generateId("APP", 6);

        setPatientId(patientId);
        setDoctorId(doctorId);
        setAppointmentDate(appointmentDate);
        setAppointmentTime(appointmentTime);
        setStatus(status);
        setReason(reason);
        setNotes(notes);

        System.out.println("Appointment created successfully with ID: " + this.appointmentId);
    }

    public Appointment(String appointmentId, String patientId, String doctorId, LocalDate appointmentDate, String appointmentTime) {
        this(appointmentId, patientId, doctorId, appointmentDate, appointmentTime, "Scheduled", null, null);
    }

    public Appointment(String appointmentId, String patientId, String doctorId, LocalDate appointmentDate) {
        this(appointmentId, patientId, doctorId, appointmentDate, null, "Scheduled", null, null);
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        if (HelperUtils.isValidString(appointmentId)) {
            this.appointmentId = appointmentId;
        } else {
            System.out.println("⚠ Invalid Appointment ID.");
        }
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isValidString(patientId)) {
            this.patientId = patientId;
        } else {
            System.out.println("⚠ Invalid Patient ID.");
        }
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        if (HelperUtils.isValidString(doctorId)) {
            this.doctorId = doctorId;
        } else {
            System.out.println("⚠ Invalid Doctor ID.");
        }
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        if (HelperUtils.isNotNull(appointmentDate)) {
            this.appointmentDate = appointmentDate;
        } else {
            System.out.println("⚠ Invalid Appointment Date.");
        }
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        if (HelperUtils.isValidString(appointmentTime)) {
            this.appointmentTime = appointmentTime;
        } else {
            System.out.println("⚠ Invalid Appointment Time.");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (HelperUtils.isValidString(status)) {
            this.status = status;
        } else {
            this.status = "Scheduled";
        }
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        if (HelperUtils.isValidString(reason, 3, 100)) {
            this.reason = reason;
        } else {
            this.reason = "General Checkup";
        }
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        if (HelperUtils.isNotNull(notes)) {
            this.notes = notes;
        } else {
            this.notes = "";
        }
    }
    public void displayInfo() {
        System.out.println("----- Appointment -----");
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Date: " + appointmentDate);
        System.out.println("Time: " + appointmentTime);
        System.out.println("Status: " + status);
        System.out.println("Reason: " + reason);
        System.out.println("Notes: " + (HelperUtils.isValidString(notes) ? notes : "None"));
    }

    @Override
    public void displaySummary() {
        System.out.println("Appointment " + appointmentId + " | " + status + " | " + appointmentDate);
    }

    public void reschedule(LocalDate newDate, String newTime) {
        if (HelperUtils.isNotNull(newDate) && HelperUtils.isValidString(newTime)) {
            this.appointmentDate = newDate;
            this.appointmentTime = newTime;
            this.status = "Rescheduled";
            System.out.println("Appointment " + appointmentId + " rescheduled to " + newDate + " at " + newTime);
        } else {
            System.out.println("⚠ Invalid date or time for rescheduling.");
        }
    }

    public void cancel() {
        this.status = "Cancelled";
        System.out.println("Appointment " + appointmentId + " has been cancelled.");
    }

    public void complete() {
        this.status = "Completed";
        System.out.println("Appointment " + appointmentId + " has been completed.");
    }
    // Add notes only
    public void addNotes(String notes) {
        if (HelperUtils.isValidString(notes)) {
            this.notes = (HelperUtils.isNull(this.notes) ? "" : this.notes + "\n") + notes;
            System.out.println("Notes added: " + notes);
        }
    }

    //  Add notes with addedBy info
    public void addNotes(String notes, String addedBy) {
        if (HelperUtils.isValidString(notes) && HelperUtils.isValidString(addedBy)) {
            String entry = String.format("[%s] %s", addedBy, notes);
            this.notes = (HelperUtils.isNull(this.notes) ? "" : this.notes + "\n") + entry;
            System.out.println("Notes added by " + addedBy + ": " + notes);
        }
    }

    //  Add notes with addedBy and timestamp
    public void addNotes(String notes, String addedBy, LocalDateTime timestamp) {
        if (HelperUtils.isValidString(notes) && HelperUtils.isValidString(addedBy) && HelperUtils.isNotNull(timestamp)) {
            String entry = String.format("[%s | %s] %s", addedBy, timestamp, notes);
            this.notes = (HelperUtils.isNull(this.notes) ? "" : this.notes + "\n") + entry;
            System.out.println("Notes added by " + addedBy + " on " + timestamp + ": " + notes);
        }
    }
}
