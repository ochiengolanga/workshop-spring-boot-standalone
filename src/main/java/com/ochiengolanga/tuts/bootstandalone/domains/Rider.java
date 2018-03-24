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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @NotNull(message = "Rider name must be specified")
    private String riderName;

    @NotNull(message = "Rider number must be specified")
    private int number;
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
