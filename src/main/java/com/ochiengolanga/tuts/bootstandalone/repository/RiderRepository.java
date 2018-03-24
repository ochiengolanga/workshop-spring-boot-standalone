package com.ochiengolanga.tuts.bootstandalone.repository;

import com.ochiengolanga.tuts.bootstandalone.domains.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
    List<Rider> findByTeamId(Long teamId);
}
