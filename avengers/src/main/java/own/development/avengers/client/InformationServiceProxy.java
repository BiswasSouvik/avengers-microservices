package own.development.avengers.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import own.development.avengers.model.Information;

@FeignClient(name = "information-service")
public interface InformationServiceProxy {
    String AUTH_TOKEN = "Authorization";

    /*@GetMapping(value = "/informations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Information> findInformationById(@PathVariable Long id);*/

    @GetMapping(value = "/informations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Information> findInformationById(@RequestHeader(AUTH_TOKEN) String bearerToken,
                                                    @PathVariable Long id);

    @PostMapping(value = "/informations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Information> addInformation(@RequestBody Information information);
}
