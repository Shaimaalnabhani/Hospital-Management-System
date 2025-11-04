package SystemInterface;

import SystemEntity.Appointment;

import java.time.LocalDate;

public interface Appointable {

  boolean  scheduleAppointment(Appointment appointment);
  boolean  cancelAppointment(String appointmentId);
  boolean  rescheduleAppointment(String appointmentId, LocalDate newDate);

}
