package ui;

import java.util.Scanner;

import model.FaunaSpecies;
import model.FloraSpecies;
import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	public void showMainMenu() {

		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Funa Species");
			System.out.println("2. Register a FloraSpecies");
			System.out.println("3. Consult Information of Specie");
			System.out.println("4. Edit a Fauna Species");
			System.out.println("5. Edit a Flora Species");
			System.out.println("6. Delete a Species");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

				case 1:
					registerFaunaSpecies();
					break;
				case 2:
					registerFloraSpecies();
					break;
				case 3:
					consultInformationSpecie();
					break;
				case 4:
					editFaunaSpecies();
					break;
				case 5:
					editFloraSpecies();
					break;
				case 6:
					deleteSpecies();
					break;
				case 0:
					System.out.println("Thanks for using our system");
					stopFlag = true;
					break;
				default:
					System.out.println("You must type a valid option");
					break;

			}

		}

	}

	public void registerFaunaSpecies() {

		reader.nextLine();

		System.out.println("Type the new Species' name: ");
		String name = reader.nextLine();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.nextLine();

		System.out.println("Type the new Species' type (1.Bird, 2.Mammal, 3.Aquatic Fauna): ");
		int speciesType = reader.nextInt();

		reader.nextLine();

		System.out.println("Is the specie migratory?(yes/no):  ");
		String migratory = reader.nextLine();

		System.out.println("What is the maximum weight it can reach?: ");
		String maxWeigth = reader.nextLine();

		if (speciesController.registerFaunaSpecies(name, scientificName, speciesType, migratory, maxWeigth)) {

			System.out.println("Species registered successfully");

		} else {

			System.out.println("Error, Species couldn't be registered");
		}

	}

	public void registerFloraSpecies() {

		reader.nextLine();

		System.out.println("Type the new Species' name: ");
		String name = reader.next();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.next();

		System.out.println("Type the new Species' type (1.Lan Flora, 2.Aquatic Flora): ");
		int speciesType = reader.nextInt();

		reader.nextLine();

		System.out.println("The specie has flowers?(yes/no):  ");
		String hasFlowers = reader.nextLine();

		System.out.println("The specie has fruits?(yes/no):  ");
		String hasFruits = reader.nextLine();

		System.out.println("What is the maximum height it can reach?:  ");
		String maxHeigth = reader.nextLine();

		if (speciesController.registerFloraSpecies(name, scientificName, speciesType, hasFlowers, hasFruits,
				maxHeigth)) {

			System.out.println("Species registered successfully");

		} else {

			System.out.println("Error, Species couldn't be registered");
		}

	}

	public void consultInformationSpecie() {

		reader.nextLine();
		System.out.println(speciesController.showSpeciesList());

		System.out.println("Which Species do you want to review?: ");
		String nameToConsult = reader.nextLine();

		String consult = speciesController.SearchSpecie(nameToConsult);

		if (consult == null) {
			System.out.println("No species found");
		} else {
			System.out.println("La information of the specie is: " + consult);
		}
	}

	public void editFaunaSpecies() {
		reader.nextLine(); 

		
		System.out.println(speciesController.showFaunaSpecies());

		System.out.println("Enter the name of the Fauna Species to edit: ");
		String nameToEdit = reader.nextLine();

		
		FaunaSpecies faunaToEdit = speciesController.searchFaunaSpecieByObjet(nameToEdit);

		if (faunaToEdit == null) {
			System.out.println("No Fauna Species found with that name.");
		} else {
			
			System.out.println("Current information: " + faunaToEdit);

			System.out.println("Enter the new name: ");
			String newName = reader.nextLine();

			System.out.println("Enter the new scientific name: ");
			String newScientificName = reader.nextLine();

			System.out.println("Is the species migratory? (yes/no): ");
			String newMigratory = reader.nextLine();

			System.out.println("Enter the new maximum weight: ");
			String newMaxWeight = reader.nextLine();

			faunaToEdit.setName(newName);
			faunaToEdit.setScientificName(newScientificName);
			faunaToEdit.setMigratory(newMigratory);
			faunaToEdit.setMaxWeight(newMaxWeight);

			System.out.println("Fauna Species updated successfully!");
		}
	}

	public void editFloraSpecies() {
		reader.nextLine(); 

		
		System.out.println(speciesController.showFloraSpecies());

		System.out.println("Enter the name of the Flora Species to edit: ");
		String nameToEdit = reader.nextLine();

		FloraSpecies floraToEdit = speciesController.searchFloraSpecieByObjet(nameToEdit);

		if (floraToEdit == null) {
			System.out.println("No Flora Species found with that name.");
		} else {
			System.out.println("Current information: " + floraToEdit);

			System.out.println("Enter the new name: ");
			String newName = reader.nextLine();

			System.out.println("Enter the new scientific name: ");
			String newScientificName = reader.nextLine();

			System.out.println("Does the species have flowers? (yes/no): ");
			String newHasFlowers = reader.nextLine();

			System.out.println("Does the species have fruits? (yes/no): ");
			String newHasFruits = reader.nextLine();

			System.out.println("Enter the new maximum height: ");
			String newMaxHeight = reader.nextLine();

			floraToEdit.setName(newName);
			floraToEdit.setScientificName(newScientificName);
			floraToEdit.setHasFlowers(newHasFlowers);
			floraToEdit.setHasFruits(newHasFruits);
			floraToEdit.setMaxHeight(newMaxHeight);

			System.out.println("Flora Species updated successfully!");
		}
	}

	public void deleteSpecies() {

		reader.nextLine();
		System.out.println(speciesController.showSpeciesList());

		System.out.println("type the name of the species to be eliminated: ");
		String nameToDelete = reader.nextLine();

		boolean deleted = speciesController.deleteSpecie(nameToDelete);
		if (deleted) {
			System.out.println("Species successfully eliminated");
		} else {
			System.out.println("No species found");
		}

	}

}
