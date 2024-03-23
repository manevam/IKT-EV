package com.ikt.event.management.repository.views;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventAttendanceDto {
    private Long attendanceId;
    private String personName;
    private Long personId;
    private String eventName;
    private Long eventId;
    private Long companyId;
    private String companyName;

    public EventAttendanceDto(String eventName, Long eventId, Long companyId, String companyName) {
        this.eventName = eventName;
        this.eventId = eventId;
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public EventAttendanceDto(Long attendanceId, String personName, Long personId, String eventName, Long eventId) {
        this.attendanceId = attendanceId;
        this.personName = personName;
        this.personId = personId;
        this.eventName = eventName;
        this.eventId = eventId;
    }
}