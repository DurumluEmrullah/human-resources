package com.humanresourcesdemo.humanresources.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name="work_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private CurriculumVitae cv;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;

    @NotNull
    @Column(name = "started_date")
    private Date startedDate;

    @Column(name = "finished_date")
    private Date finishedDate;

}
