package com.ochiengolanga.tuts.bootstandalone.web;

import com.ochiengolanga.tuts.bootstandalone.domains.Rider;
import com.ochiengolanga.tuts.bootstandalone.repository.RiderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/riders")
public class RidersController {

    private final RiderRepository riderRepository;

    public RidersController(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @GetMapping
    public List<Rider> getRiders() {
        return riderRepository.findAll();
    }
}
