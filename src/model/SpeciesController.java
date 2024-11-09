package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}


	public boolean registerFaunaSpecies(String name, String scientificName, int speciesType, String migratory, String maxWeight) {

		SpeciesType newType =  SpeciesType.BIRD;

        switch (speciesType) {

            case 1:
				newType= SpeciesType.BIRD;
                break;
            case 2:
				newType= SpeciesType.MAMMAL;
                break;
            case 3:
				newType= SpeciesType.AQUATIC_FAUNA;
                break;
            default:
				newType= SpeciesType.BIRD;
                break;
        }

		FaunaSpecies newSpecie = new FaunaSpecies(name, scientificName, newType, migratory, maxWeight);
		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = newSpecie;
				return true;
			}

		}

		return false;

	}
	public boolean registerFloraSpecies(String name, String scientificName, int speciesType, String hasFlowers, String hasFruits, String maxHeigth) {


		SpeciesType newType =  SpeciesType.LAND_FLORA;

        switch (speciesType) {

            case 1:
                newType= SpeciesType.LAND_FLORA;
                break;
			case 2:
                newType= SpeciesType.AQUATIC_FLORA;
                break;
            default:
				newType= SpeciesType.LAND_FLORA;
                break;
        }

		FloraSpecies newSpecie = new FloraSpecies(name, scientificName, newType, hasFlowers, hasFruits, maxHeigth);

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = newSpecie;
				return true;
			}

		}

		return false;

	}

	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getName();
			}
		}

		return msg;

	}


	public String showFloraSpecies() {
		String msg = "Flora Species:\n";
		boolean found = false;
	
		for (Species specie : species) {
			if (specie instanceof FloraSpecies) {
				msg += "- " + specie.getName() + "\n";
				found = true;
			}
		}
	
		return found ? msg : "No flora species registered.";
	}
	
	public String showFaunaSpecies() {
		String msg = "Fauna Species:\n";
		boolean found = false;
	
		for (Species specie : species) {
			if (specie instanceof FaunaSpecies) {
				msg += "- " + specie.getName() + "\n";
				found = true;
			}
		}
	
		return found ? msg : "No fauna species registered.";
	}

	public FaunaSpecies searchFaunaSpecieByObjet(String nameToEdit) {
		for (Species specie : species) {
			if (specie instanceof FaunaSpecies && specie.getName().equalsIgnoreCase(nameToEdit)) {
				return (FaunaSpecies) specie;
			}
		}
		return null;
	}

	public FloraSpecies searchFloraSpecieByObjet(String nameToEdit) {
		for (Species specie : species) {
			if (specie instanceof FloraSpecies && specie.getName().equalsIgnoreCase(nameToEdit)) {
				return (FloraSpecies) specie;
			}
		}
		return null;
	}


	public String SearchSpecie(String nameToConsult) {
        for (int k = 0; k < species.length; k++) {
            if (species[k] != null && species[k].getName().equalsIgnoreCase(nameToConsult)) {
                return species[k].toString();
            }
        }
        return null;
    }


	public boolean deleteSpecie(String nameToDelete) {
        for (int i = 0; i < species.length; i++) {
            if (species[i] != null && species[i].getName().equalsIgnoreCase(nameToDelete)) {
                species[i] = null;
                return true;
            }
        }
        return false;
    }

}
