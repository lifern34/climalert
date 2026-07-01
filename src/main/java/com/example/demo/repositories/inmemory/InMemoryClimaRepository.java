package com.example.demo.repositories.inmemory;

import com.example.demo.models.entities.Clima;
import com.example.demo.repositories.ClimaRepository;
import com.example.demo.utils.GeneradorIdSecuencial;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryClimaRepository implements ClimaRepository {
    private final List<Clima> climas = new ArrayList<>();
    private final GeneradorIdSecuencial generadorId = new GeneradorIdSecuencial();

    @Override
    public List<Clima> findAll() {
        return new ArrayList<>(climas);
    }

    @Override
    public Optional<Clima> findById(Long id) {
        return climas.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public Clima save(Clima clima) {
        if (clima.getId() == null) {
            clima.setId(generadorId.siguiente());
            climas.add(clima);
            return clima;
        }
        delete(clima);
        climas.add(clima);
        return clima;
    }

    @Override
    public void delete(Clima clima) {
        if (clima.getId() == null) {
            return;
        }
        climas.removeIf(c -> c.getId().equals(clima.getId()));
    }
}

