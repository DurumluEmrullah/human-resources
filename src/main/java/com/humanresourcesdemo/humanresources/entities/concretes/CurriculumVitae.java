package com.humanresourcesdemo.humanresources.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor

public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private int cvId;

    @Column(name ="worker_id")
    private int workerId;

    @Column(name = "profile_url")
    private String profileUrl;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "linked_url")
    private String linkedUrl;




}
