package own.development.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.development.model.Hero;
import own.development.repository.HeroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HeroDataServiceImpl implements HeroDataService {

    private final HeroRepository heroRepository;

    @Autowired
    HeroDataServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public List<Hero> getAllHeros() {
        return heroRepository.findAll();
    }

    @Override
    public Optional<Hero> getHeroByID(Long id) {
        return heroRepository.findById(id);
    }

    @Override
    public Hero getHeroByName(String name) {
        return heroRepository.findByName(name);
    }

    @Override
    public Hero addHero(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Hero updateHeroByName(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Hero updateHeroByID(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public void deleteHeroByID(Long id) {
        heroRepository.deleteById(id);
    }

    @Override
    public Long deleteHeroByName(String name) {
        return heroRepository.deleteByName(name);
    }

    @Override
    public boolean existsByName(String name) {
        return heroRepository.existsByName(name);
    }

    @Override
    public boolean existsById(Long id) {
        return heroRepository.existsById(id);
    }
}
