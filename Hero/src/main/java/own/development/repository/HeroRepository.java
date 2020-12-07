package own.development.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import own.development.model.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    Hero findByName(String name);

    @Modifying
    Long deleteByName(String name);

    boolean existsByName(String name);
}
