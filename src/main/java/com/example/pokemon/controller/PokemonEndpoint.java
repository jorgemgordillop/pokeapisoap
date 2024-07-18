package com.example.pokemon.controller;

import com.example.pokemon.model.GetPokemonRequest;
import com.example.pokemon.model.GetPokemonResponse;
import com.example.pokemon.model.ObjectFactory;
import com.example.pokemon.model.Pokemon;
import com.example.pokemon.service.PokemonService;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/pokemon";


    private PokemonService pokemonService;

    @Autowired
    public PokemonEndpoint(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public JAXBElement<GetPokemonResponse> getPokemon(@RequestPayload JAXBElement<GetPokemonRequest> request) {
        ObjectFactory factory = new ObjectFactory();
        GetPokemonResponse response = new GetPokemonResponse();
        response.setPokemon(pokemonService.getPokemon(request.getValue().getNameOrId()));
        return factory.createGetPokemonResponse(response);
    }
}
