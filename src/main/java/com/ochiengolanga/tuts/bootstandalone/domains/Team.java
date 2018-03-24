package com.ochiengolanga.tuts.bootstandalone.domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Version
    @Column(name = "team_version")
    private Long version;

    @Column(name = "team_name", nullable = false)
    private String name;

    public Team(String name) {
        this.name = name;
    }
}
