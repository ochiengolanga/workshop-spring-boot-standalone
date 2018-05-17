package com.ochiengolanga.tuts.bootstandalone.repository;

import com.ochiengolanga.tuts.bootstandalone.domains.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource(path = "teams", collectionResourceRel = "teams")
@Repository
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
    Optional<Team> findByNameIgnoreCase(String name);
}