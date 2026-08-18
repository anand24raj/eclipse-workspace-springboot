package com.nt.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COURSES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @NonNull
    @Column(length = 100, nullable = false)
    private String courseTitle;

    @NonNull
    @Column(length = 50, nullable = false)
    private String category;

    @NonNull
    @Column(length = 50, nullable = false)
    private String instructorName;

    @NonNull
    @Column(nullable = false)
    private Double price;

    @NonNull
    @Column(nullable = false)
    private Integer durationInHours;

    @NonNull
    @Column(nullable = false)
    private Double rating;

    @NonNull
    @Column(length = 20, nullable = false)
    private String language;
}