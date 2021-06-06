package com.humanresourcesdemo.humanresources.entities.concretes;

import com.sun.istack.NotNull;
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
    @NotNull
    @JoinColumn(name = "cv_id")
    private CurriculumVitae cv;

    @ManyToOne()
    @NotNull
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne()
    @NotNull
    @JoinColumn(name = "departmant_id")
    private Departmant departmant;

    @NotNull
    @Column(name = "started_date")
    private Date startedDate;

    @Column(name = "graduate_date")
    private Date graduateDate;
}
