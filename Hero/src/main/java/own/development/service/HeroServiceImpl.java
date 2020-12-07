package own.development.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.development.dao.HeroDataService;
import own.development.model.Hero;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroDataService heroDataService;

    @Autowired
    HeroServiceImpl(HeroDataService heroDataService) {
        this.heroDataService = heroDataService;
    }

    @Override
    public List<Hero> getAllHeros() {
        Optional<List<Hero>> optionalHeroes = Optional.ofNullable(heroDataService.getAllHeros());
        return optionalHeroes.orElse(null);
    }

    @Override
    public Hero getHeroByID(Long id) {
        Optional<Hero> optionalHero = heroDataService.getHeroByID(id);
        return optionalHero.orElse(null);
    }

    @Override
    public Hero getHeroByName(String name) {
        Optional<Hero> optionalHero = Optional.ofNullable(heroDataService.getHeroByName(name));
        return optionalHero.orElse(null);
    }

    @Override
    public boolean existsByName(String name) {
        return heroDataService.existsByName(name);
    }

    @Override
    public boolean existsByID(Long id) {
        return heroDataService.existsById(id);
    }

    @Override
    @Transactional
    public Hero addHero(Hero hero) {
        heroDataService.addHero(hero);
        Hero dbHero = null;
        if (heroDataService.existsByName(hero.getName()))
            dbHero = heroDataService.getHeroByName(hero.getName());
        return dbHero;
    }

    @Override
    @Transactional
    public Hero updateHeroByName(String name, Hero hero) {
        Hero dbHero = null;
        if (heroDataService.existsByName(name)) {
            dbHero = heroDataService.getHeroByName(name);
            dbHero.setName(hero.getName());
            return dbHero;
        }
        return dbHero;
    }

    @Override
    @Transactional
    public Optional<Hero> updateHeroByID(Long id, Hero hero) {
        Optional<Hero> dbHero = Optional.empty();
        if (heroDataService.existsById(id)) {
            dbHero = heroDataService.getHeroByID(id);
            dbHero.ifPresent(value -> value.setName(hero.getName()));
            return dbHero;
        }
        return dbHero;
    }

    @Override
    @Transactional
    public boolean deleteHeroByID(long id) {
        if (heroDataService.existsById(id)) {
            heroDataService.deleteHeroByID(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteHeroByName(String name) {
        if (heroDataService.existsByName(name)) {
            heroDataService.deleteHeroByName(name);
            return true;
        }
        return false;
    }
}
