package model;

public class Species {

    private String name;
    private String scientificName;
    private SpeciesType speciesType;

    public Species(String name, String scientificName, SpeciesType speciesType) {
        this.name = name;
        this.scientificName = scientificName;
        this.speciesType = speciesType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public SpeciesType getSpeciesType() {
        return speciesType;
    }

    public void setSpeciesType(SpeciesType speciesType) {
        this.speciesType = speciesType;
    }

    @Override
    public String toString() {
        return "Species [name=" + name + ", scientificName=" + scientificName + ", speciesType=" + speciesType + "]";
    }
}