package co.za.tut.student.tut_appointment_scheduling_service.service;


import java.util.List;

import co.za.tut.student.tut_appointment_scheduling_service.dto.request.CreateAppointmentRequest;
import co.za.tut.student.tut_appointment_scheduling_service.dto.response.LecturerDashboardResponse;
import co.za.tut.student.tut_appointment_scheduling_service.dto.response.StudentDashboardResponse;
import co.za.tut.student.tut_appointment_scheduling_service.entity.Appointment;

public interface AppointmentService {

    Appointment createAppointment(CreateAppointmentRequest request);

    List<Appointment> getAllAppointments();

    List<Appointment> getStudentAppointments(Long studentId);

    List<Appointment> getLecturerAppointments(Long lecturerId);

    Appointment updateAppointmentStatus(Long id, String status);

    StudentDashboardResponse getStudentDashboard(Long studentId);

    LecturerDashboardResponse getLecturerDashboard(Long lecturerId);

    void markExpiredAppointments();
}
