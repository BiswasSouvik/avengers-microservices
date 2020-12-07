package own.development.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import own.development.exception.HeroNotFoundException;
import own.development.model.Hero;
import own.development.model.HeroWrapper;
import own.development.service.HeroService;
import own.development.utility.GeneralTextTokens;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/heros")
public class HeroController {

    private final HeroService heroService;

    @Autowired
    HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HeroWrapper> getAllHeros() {
        Optional<List<Hero>> optionalHeroes = Optional.ofNullable(heroService.getAllHeros());
        return optionalHeroes.map(heroes -> {
            HeroWrapper heroWrapper = new HeroWrapper();
            heroWrapper.setHeroes(heroes);
            return new ResponseEntity<>(heroWrapper, HttpStatus.OK);
        }).orElseThrow(() -> new HeroNotFoundException("No Hero"));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getHeroByID(@PathVariable Long id) {
        Optional<Hero> optionalHero = Optional.ofNullable(heroService.getHeroByID(id));
        return optionalHero.map(hero -> {
            ResponseEntity<Hero> responseEntity = new ResponseEntity<>(hero, HttpStatus.OK);
            System.out.println(responseEntity.getBody());
            return responseEntity;
        })

                .orElseThrow(() -> new HeroNotFoundException(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> getHeroByName(@RequestParam String name) {
        Optional<Hero> optionalHero = Optional.ofNullable(heroService.getHeroByName(name));
        return optionalHero.map(hero -> new ResponseEntity<>(hero, HttpStatus.OK))
                .orElseThrow(() -> new HeroNotFoundException(name));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> addHero(@RequestBody Hero hero) {
        Hero addedHero = heroService.addHero(hero);
        System.out.println(addedHero);
        return new ResponseEntity<>(addedHero, HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> updateHeroByName(@RequestParam String name, @RequestBody Hero hero) {
        Optional<Hero> optionalHero = Optional.ofNullable(heroService.updateHeroByName(name, hero));
        return optionalHero.map(hero1 -> new ResponseEntity<>(hero1, HttpStatus.OK))
                .orElseThrow(() -> new HeroNotFoundException(name));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> updateHeroByID(@PathVariable Long id, @RequestBody Hero hero) {
        Optional<Hero> optionalHero = heroService.updateHeroByID(id, hero);
        return optionalHero.map(hero1 -> new ResponseEntity<>(hero1, HttpStatus.OK))
                .orElseThrow(() -> new HeroNotFoundException(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteHeroByID(@PathVariable long id) {
        if (heroService.deleteHeroByID(id))
            return new ResponseEntity<>(GeneralTextTokens.DELETED_HERO_ID.getProperty() + id,
                    HttpStatus.OK);
        else
            throw new HeroNotFoundException(id);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteHeroByName(@RequestParam String name) {
        if (heroService.deleteHeroByName(name))
            return new ResponseEntity<>(GeneralTextTokens.DELETED_HERO_NAME.getProperty() + name,
                    HttpStatus.OK);
        else
            throw new HeroNotFoundException(name);
    }
}
