package co.za.tut.student.tut_appointment_scheduling_service.entity;


import co.za.tut.student.tut_appointment_scheduling_service.enums.AppointmentMode;
import co.za.tut.student.tut_appointment_scheduling_service.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    private Long lecturerId;

    private String studentNumber;

    private String lecturerName;

    private String moduleCode;

    private String moduleName;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private AppointmentMode mode;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
}
