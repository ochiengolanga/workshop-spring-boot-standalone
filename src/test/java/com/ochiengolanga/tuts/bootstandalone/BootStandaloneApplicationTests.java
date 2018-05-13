package com.ochiengolanga.tuts.bootstandalone;

import com.ochiengolanga.tuts.bootstandalone.domains.Rider;
import com.ochiengolanga.tuts.bootstandalone.domains.Team;
import com.ochiengolanga.tuts.bootstandalone.repository.RiderRepository;
import com.ochiengolanga.tuts.bootstandalone.repository.TeamRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootStandaloneApplicationTests {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private RiderRepository riderRepository;

	private Team teamOne;
	private Rider riderOne;
	private Rider riderTwo;

	@Before
	public void init() {
		riderRepository.deleteAll();
		teamRepository.deleteAll();

		teamOne = new Team();
		teamOne.setName("Nairobi JVM Group");
		teamRepository.save(teamOne);
	}

	@Test
	public void testTeamCreate() {
		final List<Team> teams = teamRepository.findAll();

		Assert.assertEquals(teams.size(), 1);
	}

}
