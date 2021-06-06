package com.humanresourcesdemo.humanresources.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_skills")
@AllArgsConstructor
@NoArgsConstructor
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private CurriculumVitae cv;

    @ManyToOne()
    @JoinColumn(name = "skill_id")
    private Skill skill;
}
