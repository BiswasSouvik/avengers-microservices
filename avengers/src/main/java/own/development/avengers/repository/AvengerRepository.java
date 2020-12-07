package own.development.avengers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import own.development.avengers.model.Avenger;

@Repository
public interface AvengerRepository extends JpaRepository<Avenger, Long> {
}
