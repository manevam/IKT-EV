package com.ikt.event.management.repository.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NumberOfEventsPerCompanyDto {
    private String companyName;
    private Long numberOfEvents;
    private int eventMonth;
    private int eventYear;
}