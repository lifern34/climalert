package com.example.demo.repositories;

import com.example.demo.models.entities.Clima;

import java.util.List;
import java.util.Optional;

public interface ClimaRepository {
    List<Clima> findAll();

    Optional<Clima> findById(Long id);

    Clima save(Clima clima);

    void delete(Clima clima);
}
