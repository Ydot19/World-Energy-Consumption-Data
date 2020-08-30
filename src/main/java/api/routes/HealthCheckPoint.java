package api.routes;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import api.response.bodies.HealthCheckPointResponse;

@RestController
public class HealthCheckPoint {
    private static final String response = "Reached the health checkpoint";

    @GetMapping(value = "/health", produces = "application/json")
    @ResponseBody
    public HealthCheckPointResponse getHealthResponse(){
        return new HealthCheckPointResponse(response);
    }

}