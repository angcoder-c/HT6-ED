package com.api;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokemonTest {
    
    private Map<String, Pokemon> pokemonMap;
    private Pokemon bulbasaur;
    private Pokemon ivysaur;
    
    @BeforeEach
    void setUp() {
        pokemonMap = new HashMap<>();

        bulbasaur = new Pokemon(
            "Bulbasaur",
            1,
            "Grass",
            "Poison",
            "Seed Pokémon",
            0.7,
            6.9,
            "Chlorophyll",
            1,
            false
        );

        ivysaur = new Pokemon(
            "Ivysaur",
            2,
            "Grass",
            "Poison",
            "Seed Pokémon",
            1,
            13,
            "Overgrow",
            1,
            false
        );
        
        pokemonMap.put("Bulbasaur", bulbasaur);
        pokemonMap.put("Ivysaur", ivysaur);
    }
    
    @Test
    void testFindPokemonByAbility() {
        List<Pokemon> coincidencias = new ArrayList<>();
        
        for (Pokemon pokemon : pokemonMap.values()) {
            if (pokemon.getAbilities().toLowerCase().contains("chlorophyll")) {
                coincidencias.add(pokemon);
            }
        }
        assertEquals(1, coincidencias.size());
        assertEquals("Bulbasaur", coincidencias.get(0).getName());
        
        coincidencias.clear();
        for (Pokemon pokemon : pokemonMap.values()) {
            if (pokemon.getAbilities().toLowerCase().contains("overgrow")) {
                coincidencias.add(pokemon);
            }
        }
        
        assertEquals(1, coincidencias.size());
        assertEquals("Ivysaur", coincidencias.get(0).getName());
    }
    
    @Test
    void testPokemonFactoryCreatesCorrectMapType() {
        
        Map<String, Pokemon> hashMap = PokemonMapFactory.createMap(1);
        assertTrue(hashMap instanceof HashMap);
        
        Map<String, Pokemon> treeMap = PokemonMapFactory.createMap(2);
        assertTrue(treeMap instanceof TreeMap);
        
        Map<String, Pokemon> linkedHashMap = PokemonMapFactory.createMap(3);
        assertTrue(linkedHashMap instanceof LinkedHashMap);
    }
}
