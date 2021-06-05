package com.humanresourcesdemo.humanresources.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "language_levels")
@AllArgsConstructor
@NoArgsConstructor
public class LanguageLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private int levelId;

    @Column(name = "level")
    private String level;
}
