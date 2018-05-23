package com.ochiengolanga.tuts.bootstandalone.services;

import com.ochiengolanga.tuts.bootstandalone.domains.Team;
import com.ochiengolanga.tuts.bootstandalone.repository.TeamRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable("teams")
    public List<Team> fetchTeams() {
        this.simulateSlowService();
        return repository.findAll();
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
