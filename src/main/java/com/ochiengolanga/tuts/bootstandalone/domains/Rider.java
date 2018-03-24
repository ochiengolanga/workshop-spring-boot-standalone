package com.ochiengolanga.tuts.bootstandalone.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "riders")
public class Rider implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rider_id")
    private Long id;

    @Version
    @Column(name = "rider_version")
    private Long version;

    @NotNull(message = "Rider name must be specified")
    @Column(name = "rider_name", nullable = false, unique = true)
    private String riderName;

    @NotNull(message = "Rider number must be specified")
    @Column(name = "rider_number", nullable = false, unique = true, updatable = false)
    private int number;

    @Enumerated(EnumType.STRING)
    @Column(name = "rider_skilllevel")
    private RiderSkillLevel skillLevel;

    @ManyToOne
    private Team team;

    public Rider(String riderName, int number, RiderSkillLevel skillLevel) {
        this.riderName = riderName;
        this.number = number;
        this.skillLevel = skillLevel;
    }

    public enum RiderSkillLevel {
        NOVICE, INTERMEDIATE, PRO
    }
}
