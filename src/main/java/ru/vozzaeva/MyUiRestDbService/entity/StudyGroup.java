package ru.vozzaeva.MyUiRestDbService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDY_GROUPS")
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "faculty", nullable = false, length = 100)
    private String faculty;

    @Column(name = "course", nullable = false)
    private Integer course;
}