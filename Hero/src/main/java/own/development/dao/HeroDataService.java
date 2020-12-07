package own.development.dao;

import own.development.model.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroDataService {
    //Get Methods
    List<Hero> getAllHeros();
    Optional<Hero> getHeroByID(Long Id);
    Hero getHeroByName(String name);

    //Post Method
    Hero addHero(Hero hero);

    //Put Methods
    Hero updateHeroByName(Hero hero);
    Hero updateHeroByID(Hero hero);

    //Delete Methods
    void deleteHeroByID(Long id);
    Long deleteHeroByName(String name);

    //Existance
    boolean existsByName(String name);
    boolean existsById(Long id);
}
