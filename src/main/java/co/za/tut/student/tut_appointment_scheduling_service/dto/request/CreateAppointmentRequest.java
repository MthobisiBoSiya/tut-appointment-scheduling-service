package co.za.tut.student.tut_appointment_scheduling_service.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import co.za.tut.student.tut_appointment_scheduling_service.enums.AppointmentMode;

@Data
public class CreateAppointmentRequest {

    private Long studentId;

    private Long lecturerId;

    private String studentNumber;

    private String lecturerName;

    private String moduleCode;

    private String moduleName;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private AppointmentMode mode;
}
