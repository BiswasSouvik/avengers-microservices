package own.development.avengers.service;

import own.development.avengers.model.Avenger;

import java.util.List;
import java.util.Optional;

public interface AvengersService {
    Optional<Avenger> getAvengerById(Long id);
    Avenger addAvenger(Avenger avenger);
    Optional<List<Avenger>> getAll();
}
