package com.ikt.event.management.repository.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatorsOfEventsDto {
    private Long coordinatorId;
    private String coordinatorName;
    private Long companyId;
    private Long eventId;
    private String eventName;
    private String companyName;
}
