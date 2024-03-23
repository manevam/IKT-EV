package com.ikt.event.management.repository.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllTimeAttendanceDto {
    private String name;
    private Long totalAttendance;
}
