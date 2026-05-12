package co.za.tut.student.tut_appointment_scheduling_service.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LecturerDashboardResponse {

    private long totalAppointments;

    private long pendingRequests;

    private long upcomingSessions;

    private double completionPercentage;
}
