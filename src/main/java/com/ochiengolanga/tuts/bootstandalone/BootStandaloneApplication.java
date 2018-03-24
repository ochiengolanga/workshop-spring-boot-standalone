package com.ochiengolanga.tuts.bootstandalone;

import com.ochiengolanga.tuts.bootstandalone.domains.Rider;
import com.ochiengolanga.tuts.bootstandalone.domains.Team;
import com.ochiengolanga.tuts.bootstandalone.repository.RiderRepository;
import com.ochiengolanga.tuts.bootstandalone.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class BootStandaloneApplication {

	private final RiderRepository riderRepository;
	private final TeamRepository teamRepository;

	public BootStandaloneApplication(RiderRepository riderRepository, TeamRepository teamRepository) {
		this.riderRepository = riderRepository;
		this.teamRepository = teamRepository;
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Stream.of("Yamaha Factory", "Ducati Factory", "Suzuki Factory", "KTM", "Honda Racing", "Tech3 Yamaha")
					.forEach(teamName -> teamRepository.save(new Team(teamName)));

			teamRepository.findAll().forEach(team -> log.info(team.toString()));

			Rider rider1 = new Rider("Valentino Rossi", 46, Rider.RiderSkillLevel.PRO);
			teamRepository.findByNameIgnoreCase("Yamaha Factory").ifPresent(rider1::setTeam);

			Rider rider2 = new Rider("Marc Marquez", 93, Rider.RiderSkillLevel.PRO);
			teamRepository.findByNameIgnoreCase("honda racing").ifPresent(rider2::setTeam);

			riderRepository.saveAll(Arrays.asList(rider1, rider2));

			riderRepository.findAll().forEach(rider -> log.info(rider.toString()));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BootStandaloneApplication.class, args);
	}
}
