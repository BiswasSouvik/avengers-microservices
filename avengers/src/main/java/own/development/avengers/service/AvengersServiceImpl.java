package own.development.avengers.service;

import org.springframework.stereotype.Service;
import own.development.avengers.model.Avenger;
import own.development.avengers.repository.AvengerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AvengersServiceImpl implements AvengersService{
    private final AvengerRepository avengerRepository;

    public AvengersServiceImpl(AvengerRepository avengerRepository) {
        this.avengerRepository = avengerRepository;
    }

    @Override
    public Optional<Avenger> getAvengerById(Long id) {
        return avengerRepository.findById(id);
    }

    @Override
    public Avenger addAvenger(Avenger avenger) {
        return avengerRepository.save(avenger);
    }

    @Override
    public Optional<List<Avenger>> getAll() {
        return Optional.of(avengerRepository.findAll());
    }
}
