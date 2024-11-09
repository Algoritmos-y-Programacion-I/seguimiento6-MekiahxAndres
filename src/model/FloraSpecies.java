package model;

public class FloraSpecies extends Species{
    
    private String hasFlowers;
    private String hasFruits;
    private String maxHeight;
    
    
    


    public FloraSpecies(String name, String scientificName, SpeciesType speciesType, String hasFlowers,
            String hasFruits, String maxHeight) {
        super(name, scientificName, speciesType);
        this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
        this.maxHeight = maxHeight;
    }


    public String getHasFlowers() {
        return hasFlowers;
    }


    public void setHasFlowers(String hasFlowers) {
        this.hasFlowers = hasFlowers;
    }


    public String getHasFruits() {
        return hasFruits;
    }


    public void setHasFruits(String hasFruits) {
        this.hasFruits = hasFruits;
    }


    public String getMaxHeight() {
        return maxHeight;
    }


    public void setMaxHeight(String maxHeight) {
        this.maxHeight = maxHeight;
    }
    


    @Override
    public String toString() {
        return "FloraSpecies [name: "+getName()+" - " +"scientific name: " +getScientificName()+" - " +"Type: "+getSpeciesType()+" - "+"hasFlowers=" + hasFlowers + ", hasFruits=" + hasFruits + ", maxHeight=" + maxHeight + "]";
    }
    
}
