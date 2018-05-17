package com.ochiengolanga.tuts.bootstandalone.utils.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="riders")
public class RidersEndpoint {
}
