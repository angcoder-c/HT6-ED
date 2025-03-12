package com.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Pokemon> pokemonMap;
        List<Pokemon> userPokemons = new LinkedList<>();
        
        System.out.print("""
            Implementación:
            (1) HashMap
            (2) TreeMap
            (3) LinkedHashMap
        >>> """);
        int mainMenu = sc.nextInt();
        sc.nextLine();
        
        pokemonMap = PokemonMapFactory.createMap(mainMenu);
        loadPokemon(pokemonMap);
        
        String subMenu = "";
        while (!subMenu.equals("6")) {
            System.out.print("""
            (1) Agregar un pokemon a mi equipo
            (2) Mostrar datos de un pokemon
            (3) Mostrar mi equipo ordenado por tipo
            (4) Mostrar todos los Pokemon ordenados por tipo
            (5) Buscar Pokemon por habilidad
            (6) Salir
            >>> """);
            
            subMenu = sc.nextLine();

            if (subMenu.equals("1")){
                agregarPokemonUserPokemons(sc, pokemonMap, userPokemons);
            }

            if (subMenu.equals("2")){
                mostrarPokemons(sc, pokemonMap);
            }

            if (subMenu.equals("3")){
                mostrarUserPokemonsTipo(userPokemons);
            }

            if (subMenu.equals("4")){
                mostrarPokemonsTipo(pokemonMap);
            }

            if (subMenu.equals("5")){
                buscarPokemonHabilidad(sc, pokemonMap);
            }
        }
        
        sc.close();
    }
    
    /**
     * carga los datos de los desde un archivo del csv
     * @param pokemonMap map de pokemons
     */
    private static void loadPokemon(Map<String, Pokemon> pokemonMap) {
        String csvFile = "pokemon_data_pokeapi.csv";
        String line;
        String csvSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // headers
            br.readLine();
            
            // datos
            while ((line = br.readLine()) != null) {
                
                String[] quotes = line.split("\"");
                String[] data;
                if (quotes.length != 1) {
                    String dataString = quotes[0] + quotes[1].replace(",", "\s") + quotes[2];
                    data = dataString.split(csvSplitBy);
                } else {
                    data = line.split(csvSplitBy);
                }
                
                String name = data[0];
                int number = Integer.parseInt(data[1]);
                String type1 = data[2];
                String type2 = data[3];
                String classification = data[4];
                float height = Float.parseFloat(data[5]); 
                float weight = Float.parseFloat(data[6]);
                String abilities = data[7];
                int generation = Integer.parseInt(data[8]);
                Boolean legendary = !data[9].equals("No");
                
                Pokemon pokemon = new Pokemon(
                    name, 
                    number,
                    type1,
                    type2,
                    classification,
                    height,
                    weight,
                    abilities,
                    generation,
                    legendary
                );
                pokemonMap.put(name, pokemon);
            }
            
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    /**
     * agrega un pokemon a la lista del usuario
     * @param sc objeto scanner
     * @param pokemonMap map de pokemons
     * @param userPokemons pokemons del usuario
     */
    private static void agregarPokemonUserPokemons(Scanner sc, Map<String, Pokemon> pokemonMap, List<Pokemon> userPokemons) {
        System.out.print("Nombre: ");
        String pokemonName = sc.nextLine();
        
        Pokemon pokemon = pokemonMap.get(pokemonName);
        if (pokemon == null) {
            System.out.println("No encontrado");
            return;
        }
        
        boolean alreadyExists=false;

        for (int index = 0; index < userPokemons.size(); index++) {
            Pokemon tempPokemon = userPokemons.get(index);
            if (tempPokemon.equals(pokemon)) {
                alreadyExists=true;
            }
        }
        
        if (alreadyExists) {
            System.out.println("Ya existe en tu lista");
        } else {
            userPokemons.add(pokemon);
            System.out.println(pokemonName + " agregado");
        }
    }
    
    /**
     * datos de un pokemon
     * @param sc objeto scanner
     * @param pokemonMap map de pokemons
     */
    private static void mostrarPokemons(Scanner sc, Map<String, Pokemon> pokemonMap) {
        System.out.print("Nombre: ");
        String pokemonName = sc.nextLine();
        
        Pokemon pokemon = pokemonMap.get(pokemonName);
        if (pokemon == null) {
            System.out.println("No encontrado");
            return;
        }
        
        System.out.println(pokemon.getDetailedInfo());
    }
    
    /**
     * pokemones del usuario ordenada por tipo
     * @param userPokemons pokemons del usuario.
     */
    private static void mostrarUserPokemonsTipo(List<Pokemon> userPokemons) {
        if (userPokemons.isEmpty()) {
            System.out.println("Colección vacía.");
            return;
        }

        for (int index = 0; index < userPokemons.size(); index++) {
            Pokemon pokemon = userPokemons.get(index);

            System.out.println(
                pokemon.getName() + " " + 
                pokemon.getType1()
            );   
        }
    }
    
    /**
     * lista todos los Pokémon en el map ordenados por tipo
     * @param pokemonMap map de pokemons
     */
    private static void mostrarPokemonsTipo(Map<String, Pokemon> pokemonMap) {
        List<Pokemon> todos = new LinkedList<>(pokemonMap.values());
        
        todos.sort(
            Comparator
            .comparing(Pokemon::getType1)
            .thenComparing(Pokemon::getName)
        );

        for (int index = 0; index < todos.size(); index++) {
            Pokemon pokemon = todos.get(index);

            System.out.println(
                pokemon.getName() + " " + 
                pokemon.getType1()
            );   
        }
    }

    /**
     * busca y muestra los pokémon que tienen una habilidad
     * @param sc objeto scanner
     * @param pokemonMap HashMap con los datos de los pokémon
     */
    private static void buscarPokemonHabilidad(Scanner sc, Map<String, Pokemon> pokemonMap) {
        System.out.print("Ingrese la habilidad a buscar: ");
        String ability = sc.nextLine().toLowerCase();
        List<Pokemon> coincidencias = new LinkedList<>();
        
        for (Pokemon pokemon : pokemonMap.values()) {
            if (pokemon.getAbilities().toLowerCase().contains(ability)) {
                coincidencias.add(pokemon);
            }
        }
        
        if (coincidencias.isEmpty()) {
            System.out.println("No hay coincidencias");
            return;
        }

        for (int index = 0; index < coincidencias.size(); index++) {
            Pokemon pokemon = coincidencias.get(index);

            System.out.println(
                pokemon.getName() + " " + 
                pokemon.getType1() + " " +
                pokemon.getAbilities()
            );   
        }
    }
}
