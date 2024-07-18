// src/main/java/com/example/pokemon/repository/PokemonRepository.java
package com.example.pokemon.repository;

import com.example.pokemon.model.PokeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokeEntity, Long> {
}
