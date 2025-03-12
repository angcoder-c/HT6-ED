package com.api;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PokemonMapFactory {
    
    public static Map<String, Pokemon> createMap(int opcion) {
        if (opcion==1) {
            return new HashMap<>();
        }

        if (opcion==2) {
            return new TreeMap<>();
        }

        if (opcion==3) {
            return new LinkedHashMap<>();
        }
        
        return new HashMap<>();
    }
}
