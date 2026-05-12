package co.za.tut.student.tut_appointment_scheduling_service.controller;

import co.za.tut.student.tut_appointment_scheduling_service.dto.request.CreateAppointmentRequest;
import co.za.tut.student.tut_appointment_scheduling_service.dto.response.LecturerDashboardResponse;
import co.za.tut.student.tut_appointment_scheduling_service.dto.response.StudentDashboardResponse;
import co.za.tut.student.tut_appointment_scheduling_service.entity.Appointment;
import co.za.tut.student.tut_appointment_scheduling_service.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;

    @PostMapping
    public Appointment create(@RequestBody CreateAppointmentRequest request) {
        return service.createAppointment(request);
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