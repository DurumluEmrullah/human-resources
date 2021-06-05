package com.humanresourcesdemo.humanresources.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int educationId;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private CurriculumVitae cv;

    @ManyToOne()
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne()
    @JoinColumn(name = "departmant_id")
    private Departmant departmant;

    @Column(name = "started_date")
    private Date startedDate;

    @Column(name = "finished_date")
    private Date finshedDate;
}
