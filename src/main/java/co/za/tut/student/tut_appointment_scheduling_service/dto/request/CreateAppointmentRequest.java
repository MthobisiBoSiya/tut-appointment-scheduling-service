package co.za.tut.student.tut_appointment_scheduling_service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime appointmentTime;

    private AppointmentMode mode;
}
