package com.example.pokemon.controller;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private PokemonService pokemonService;


    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{nameOrId}")
    public Pokemon getPokemon(@PathVariable String nameOrId) {
        return pokemonService.getPokemon(nameOrId);
    }
}