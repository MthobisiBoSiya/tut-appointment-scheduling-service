package co.za.tut.student.tut_appointment_scheduling_service.controller;

import co.za.tut.student.tut_appointment_scheduling_service.dto.request.CreateAppointmentRequest;
import co.za.tut.student.tut_appointment_scheduling_service.dto.request.UpdateAppointmentStatusRequest;
import co.za.tut.student.tut_appointment_scheduling_service.dto.response.LecturerDashboardResponse;
import co.za.tut.student.tut_appointment_scheduling_service.dto.response.StudentDashboardResponse;
import co.za.tut.student.tut_appointment_scheduling_service.entity.Appointment;
import co.za.tut.student.tut_appointment_scheduling_service.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
@Slf4j
public class AppointmentController {

    private final AppointmentService service;

    @PostMapping
    public Appointment create(@RequestBody CreateAppointmentRequest request) {
        log.info("Create appointment request received: {}", request);
        try {
            return service.createAppointment(request);
        } catch (Exception ex) {
            log.error("Error creating appointment for request: {}", request, ex);
            throw ex;
        }
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return service.getAllAppointments();
    }

    @GetMapping("/student/{studentId}")
    public List<Appointment> studentAppointments(
            @PathVariable Long studentId
    ) {
        return service.getStudentAppointments(studentId);
    }

    @GetMapping("/lecturer/{lecturerId}")
    public List<Appointment> lecturerAppointments(
            @PathVariable Long lecturerId
    ) {
        return service.getLecturerAppointments(lecturerId);
    }

    @PutMapping("/{id}/status")
    public Appointment updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateAppointmentStatusRequest request
    ) {
        return service.updateAppointmentStatus(id, request.getStatus());
    }

    @GetMapping("/dashboard/student/{studentId}")
    public StudentDashboardResponse studentDashboard(
            @PathVariable Long studentId
    ) {
        return service.getStudentDashboard(studentId);
    }

    @GetMapping("/dashboard/lecturer/{lecturerId}")
    public LecturerDashboardResponse lecturerDashboard(
            @PathVariable Long lecturerId
    ) {
        return service.getLecturerDashboard(lecturerId);
    }
}