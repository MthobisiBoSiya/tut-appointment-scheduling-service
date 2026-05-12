package co.za.tut.student.tut_appointment_scheduling_service.repository;

import co.za.tut.student.tut_appointment_scheduling_service.entity.Appointment;
import co.za.tut.student.tut_appointment_scheduling_service.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByStudentId(Long studentId);

    List<Appointment> findByLecturerId(Long lecturerId);

    long countByStudentId(Long studentId);

    long countByLecturerId(Long lecturerId);

    long countByStudentIdAndStatus(Long studentId, AppointmentStatus status);

    long countByLecturerIdAndStatus(Long lecturerId, AppointmentStatus status);

    long countByStudentIdAndAppointmentDateAfter(Long studentId, LocalDate date);

    long countByLecturerIdAndAppointmentDateAfter(Long lecturerId, LocalDate date);
}