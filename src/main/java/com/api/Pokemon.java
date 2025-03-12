package com.api;

public class Pokemon {
    
    private String name;
    private int number;
    private String type1;
    private String type2;
    private String classification;
    private double height; 
    private double weight;
    private String abilities;
    private int generation;
    private Boolean legendary;

    public Pokemon(
        String name,
        int number,
        String type1,
        String type2,
        String classification,
        double height,
        double weight,
        String abilities,
        int generation,
        Boolean legendary
        ) {
        this.number = number;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.generation = generation;
        this.legendary = legendary;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.classification = classification;
    }
    
    /**
     * gets
     */
    public int getNumber() { 
        return this.number; 
    }
    public String getName() { 
        return this.name; 
    }
    public String getType1() { 
        return this.type1; 
    }
    public String getType2() { 
        return this.type2; 
    }
    public int getGeneration() { 
        return this.generation; 
    }
    public boolean isLegendary() { 
        return this.legendary; 
    }
    public String getAbilities() { 
        return this.abilities; 
    }
    public double getWeight() { 
        return this.weight; 
    }
    public double getHeight() { 
        return this.height; 
    }
    public String getClassification() { 
        return this.classification; 
    }
    
    /**
     * @return obtener los datos del pokemon
     */
    public String getDetailedInfo() {
        String response = 
        "Nombre: " + this.name + "\n" +
        "Numero: " + this.number + "\n" +
        "Tipo 1: " + this.type1 + "\n" +
        "Tipo 2: " + this.type2 + "\n" +
        "Peso: " + this.weight + "\n" +
        "Alto: " + this.height + "\n" +
        "Clasificación: " + this.classification + "\n" +
        "Generación: " + this.generation + "\n" +
        "Legendario: " + this.legendary + "\n" +
        "Hablidades: "+ this.abilities;

        return response;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
    
        if (obj == null || !(obj instanceof Pokemon)) {
            return false;
        }
    
        Pokemon pokemon = (Pokemon) obj;
        return name.equals(pokemon.name);
    }    
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
