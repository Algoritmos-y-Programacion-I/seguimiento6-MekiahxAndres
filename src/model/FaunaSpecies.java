package model;

public class FaunaSpecies extends Species{

    private String migratory;
    private String maxWeight;
    
    public FaunaSpecies(String name, String scientificName, SpeciesType speciesType, String migratory,
            String maxWeight) {
        super(name, scientificName, speciesType);
        this.migratory = migratory;
        this.maxWeight = maxWeight;
    }


    public String getMigratory() {
        return migratory;
    }


    public void setMigratory(String migratory) {
        this.migratory = migratory;
    }


    public String getMaxWeight() {
        return maxWeight;
    }


    public void setMaxWeight(String maxWeight) {
        this.maxWeight = maxWeight;
    }


    @Override
    public String toString() {
        return "FaunaSpecies [name: "+getName()+" - " +" scientific name: "+getScientificName()+" - "+" Type: "+getSpeciesType()+" - "+" migratory=" + migratory + ", maxWeight=" + maxWeight + "]";
    }

    public void setSpeciesType(int newTypeSpecie) {
        throw new UnsupportedOperationException("Unimplemented method 'setSpeciesType'");
    }

    

    
    
}
