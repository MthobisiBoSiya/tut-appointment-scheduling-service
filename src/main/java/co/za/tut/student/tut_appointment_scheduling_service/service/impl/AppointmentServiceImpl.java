package co.za.tut.student.tut_appointment_scheduling_service.service.impl;


import co.za.tut.student.tut_appointment_scheduling_service.dto.request.CreateAppointmentRequest;
import co.za.tut.student.tut_appointment_scheduling_service.dto.response.LecturerDashboardResponse;
import co.za.tut.student.tut_appointment_scheduling_service.dto.response.StudentDashboardResponse;
import co.za.tut.student.tut_appointment_scheduling_service.entity.Appointment;
import co.za.tut.student.tut_appointment_scheduling_service.enums.AppointmentStatus;
import co.za.tut.student.tut_appointment_scheduling_service.repository.AppointmentRepository;
import co.za.tut.student.tut_appointment_scheduling_service.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;

    @Override
    public Appointment createAppointment(CreateAppointmentRequest request) {

        Appointment appointment = Appointment.builder()
                .studentId(request.getStudentId())
                .lecturerId(request.getLecturerId())
                .studentNumber(request.getStudentNumber())
                .lecturerName(request.getLecturerName())
                .moduleCode(request.getModuleCode())
                .moduleName(request.getModuleName())
                .appointmentDate(request.getAppointmentDate())
                .appointmentTime(request.getAppointmentTime())
                .mode(request.getMode())
                .status(AppointmentStatus.PENDING)
                .build();

        return repository.save(appointment);
    }

    @Override
    public List<Appointment> getStudentAppointments(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    @Override
    public List<Appointment> getLecturerAppointments(Long lecturerId) {
        return repository.findByLecturerId(lecturerId);
    }

    @Override
    public StudentDashboardResponse getStudentDashboard(Long studentId) {

        long total = repository.countByStudentId(studentId);

        long pending = repository.countByStudentIdAndStatus(
                studentId,
                AppointmentStatus.PENDING
        );

        long upcoming = repository.countByStudentIdAndAppointmentDateAfter(
                studentId,
                LocalDate.now()
        );

        long completed = repository.countByStudentIdAndStatus(
                studentId,
                AppointmentStatus.COMPLETED
        );

        double percentage = total == 0
                ? 0
                : ((double) completed / total) * 100;

        return StudentDashboardResponse.builder()
                .totalAppointments(total)
                .pendingRequests(pending)
                .upcomingSessions(upcoming)
                .attendancePercentage(percentage)
                .build();
    }

    @Override
    public LecturerDashboardResponse getLecturerDashboard(Long lecturerId) {

        long total = repository.countByLecturerId(lecturerId);

        long pending = repository.countByLecturerIdAndStatus(
                lecturerId,
                AppointmentStatus.PENDING
        );

        long upcoming = repository.countByLecturerIdAndAppointmentDateAfter(
                lecturerId,
                LocalDate.now()
        );

        long completed = repository.countByLecturerIdAndStatus(
                lecturerId,
                AppointmentStatus.COMPLETED
        );

        double percentage = total == 0
                ? 0
                : ((double) completed / total) * 100;

        return LecturerDashboardResponse.builder()
                .totalAppointments(total)
                .pendingRequests(pending)
                .upcomingSessions(upcoming)
                .completionPercentage(percentage)
                .build();
    }
}
