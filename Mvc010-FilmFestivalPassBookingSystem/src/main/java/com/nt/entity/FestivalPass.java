package com.nt.entity;

import org.springframework.stereotype.Controller;

import lombok.Data;

@Data
@Controller	
public class FestivalPass {

    private Long passId;
    private String visitorName;
    private String nationality;
    private String festivalCategory;
    private String passType;
    private Long visitingDays;
    private String email;
}