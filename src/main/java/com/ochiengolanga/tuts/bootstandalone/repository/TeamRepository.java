package com.ochiengolanga.tuts.bootstandalone.repository;

import com.ochiengolanga.tuts.bootstandalone.domains.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByNameIgnoreCase(String name);

}
