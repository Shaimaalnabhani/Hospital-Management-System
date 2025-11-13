package SystemInterface;

import SystemEntity.Appointment;

import java.time.LocalDate;

public interface Appointable {

  void scheduleAppointment(Appointment appointment);

  void scheduleAppointment(String appointmentId, LocalDate newDate);

  boolean cancelAppointment(String appointmentId);
}
