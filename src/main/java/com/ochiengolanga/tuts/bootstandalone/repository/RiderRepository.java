package com.ochiengolanga.tuts.bootstandalone.repository;

import com.ochiengolanga.tuts.bootstandalone.domains.Rider;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "riders", collectionResourceRel = "riders")
public interface RiderRepository extends PagingAndSortingRepository<Rider, Long> {
    List<Rider> findByTeamId(Long teamId);
}