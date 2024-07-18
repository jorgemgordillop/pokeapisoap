// src/main/java/com/example/pokemon/service/PokemonService.java
package com.example.pokemon.service;

import com.example.pokemon.client.PokeApiClient;
import com.example.pokemon.client.PokemonResponse;
import com.example.pokemon.model.PokeEntity;
import com.example.pokemon.model.Pokemon;
import com.example.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private PokeApiClient pokeApiClient;

    @Autowired
    public PokemonService(PokeApiClient pokeApiClient, PokemonRepository pokemonRepository) {
        this.pokeApiClient = pokeApiClient;
        this.pokemonRepository = pokemonRepository;
    }

    private PokemonRepository pokemonRepository;

    public Pokemon getPokemon(String nameOrId) {
        PokemonResponse response = pokeApiClient.getPokemon(nameOrId);
        String abilities = response.getAbilities().stream()
                .map(ability -> ability.getAbility().getName())
                .collect(Collectors.joining(", "));

        PokeEntity pokemon = new PokeEntity();
        pokemon.setName(response.getName());
        pokemon.setAbilities(abilities);
        pokemon.setImageUrl(response.getSprites().getFront_default());
        pokemon.setQueryDate(LocalDateTime.now());

        Pokemon pok = new Pokemon();

        pokemonRepository.save(pokemon);

        pok.setAbilities(abilities);
        pok.setName(response.getName());
        pok.setImageUrl(response.getSprites().getFront_default());
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(zonedDateTime);

        XMLGregorianCalendar xmlGregorianCalendar = null;
        try {
            xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pok.setQueryDate(xmlGregorianCalendar);

        return pok;
    }
}
