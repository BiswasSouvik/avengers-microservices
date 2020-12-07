package own.development.service;

import own.development.model.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroService {
    //Get Methods
    List<Hero> getAllHeros();
    Hero getHeroByID(Long id);
    Hero getHeroByName(String name);
    boolean existsByName(String name);
    boolean existsByID(Long id);

    //Post Method
    Hero addHero(Hero hero);

    //Put Methods
    Hero updateHeroByName(String name, Hero hero);
    Optional<Hero> updateHeroByID(Long id, Hero hero);

    //Delete Methods
    boolean deleteHeroByID(long id);
    boolean deleteHeroByName(String name);
}
