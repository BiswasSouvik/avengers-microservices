package own.development.avengers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import own.development.avengers.client.InformationServiceProxy;
import own.development.avengers.exception.AvengersNotFound;
import own.development.avengers.model.Avenger;
import own.development.avengers.model.Information;
import own.development.avengers.security.AccessToken;
import own.development.avengers.service.AvengersService;

import java.util.List;

@RestController
//@Controller
//@EnableOAuth2Sso
public class AvengersController {
    private final InformationServiceProxy informationServiceProxy;
    private final AvengersService avengersService;

    @Autowired
    public AvengersController(InformationServiceProxy informationServiceProxy,
                              AvengersService avengersService) {
        this.informationServiceProxy = informationServiceProxy;
        this.avengersService = avengersService;
    }

    @GetMapping(value = "/avengers/index", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getIndex() {
        return "index";
    }

    @GetMapping(value = "/avengers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Avenger>> getAllAvenger() throws AvengersNotFound {
        return avengersService.getAll().map(avengers ->
                new ResponseEntity<>(avengers, HttpStatus.OK))
                .orElseThrow(AvengersNotFound::new);
    }

    @GetMapping(value = "/avengers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_admin')")
    public String getAvengerById(@PathVariable Long id, Model model) throws AvengersNotFound {
        final ResponseEntity<Information> informationById = informationServiceProxy.
                findInformationById(AccessToken.getAccessToken(), id);

        final ResponseEntity<Avenger> avengerResponseEntity = avengersService.getAvengerById(id).map(avenger -> {
            avenger.setInformation(informationById.getBody());
            return new ResponseEntity<Avenger>(avenger, HttpStatus.OK);
        }).orElseThrow(() -> new AvengersNotFound(id));

        model.addAttribute("avenger", avengerResponseEntity.getBody());
        return "secure";
    }

    /*@GetMapping(value = "/avengers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Avenger> getAvengerById(@PathVariable Long id) throws AvengersNotFound {
        final ResponseEntity<Information> informationById = informationServiceProxy.findInformationById(id);
        return avengersService.getAvengerById(id).map(avenger -> {
            avenger.setInformation(informationById.getBody());
            return new ResponseEntity<Avenger>(avenger, HttpStatus.OK);
        }).orElseThrow(() -> new AvengersNotFound(id));
    }*/

    @PostMapping(value = "/avengers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Avenger> addAvenger(@RequestBody Avenger avenger) {
        ResponseEntity<Information> informationResponseEntity = informationServiceProxy
                .addInformation(avenger.getInformation());
        avenger.setInformation(informationResponseEntity.getBody());
        return new ResponseEntity<Avenger>(avengersService.addAvenger(avenger),HttpStatus.OK);
    }

}
