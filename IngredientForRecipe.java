package com.cs330;

/**

*/

public class IngredientForRecipe { 

	private int id = 0;
	private String name = "no name yet";
	private String unit = "no unit yet";
	private int calsPerUnit = 0;
	private int proteinPerUnit = 0;
	private int carbsPerUnit = 0;

/** 
 default constructor
*/
	public IngredientForRecipe() {
		setId(0);
		setName("no name yet");
		setUnit("no unit yet");
		setCalsPerUnit(0);
		setProteinPerUnit(0);
		setCarbsPerUnit(0);
	}

/**
 overloaded constructor
 */
	public IngredientForRecipe(int id, String name, String unit, int cals, int protein, int carbs) {
		setId(id);
		setName(name);
		setUnit(unit);
		setCalsPerUnit(cals);
		setProteinPerUnit(protein);
		setCarbsPerUnit(carbs);
	}


// SETTERS //

	public void setId(int idIn) {
		if (idIn >= 0) {
			id = idIn;
		} else {
			System.out.println("Error: ID must be greater than or equal to 0");
		}
	}

	public void setName(String nameIn) {
		if (nameIn.length() > 0 && nameIn.length() <= 100) {
			name = nameIn;
		} else {
			System.out.println("Error: Recipe name must be between 1 and 100 characters");
		}
	}

	public void setUnit(String unitIn) {
		unit = unitIn;
	}

	public void setCalsPerUnit(int cals){
		if (cals >= 0 && cals < 10000) {
			calsPerUnit = cals;
		} else {
			System.out.println("Error: Calories must be greater than or equal to 0");
		}
	}

	public void setProteinPerUnit(int protein) {
		if (protein >= 0) {
			proteinPerUnit = protein;
		} else {
			System.out.println("Error: Proteins must be greater than or equal to 0");
		}	
	}	

	public void setCarbsPerUnit(int carbs) {
		if (carbs >= 0) {
			carbsPerUnit = carbs;
		} else {
			System.out.println("Error: Carbs must be greater than or equal to 0");
		}
	}



// GETTERS //

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public int getCalsPerUnit() {
		return calsPerUnit;
	}

	public int getProteinPerUnit() {
		return proteinPerUnit;
	}

	public int getCarbsPerUnit() {
		return carbsPerUnit;
	}

	// toString method //
	
	@Override
	public String toString() {
		String answer = getId() + "." + getName() + ": " + getUnit() + "\nCalories: " + getCalsPerUnit() + "\nProtein: " + getProteinPerUnit() + "\nCarbs: " + 	getCarbsPerUnit();
		return answer;
	}
	

// PRINT METHOD //
	public void print(){
		System.out.println("\nID: " + getId());
		System.out.println("Name: " + getName());
		System.out.println("Units: " + getUnit());
		System.out.println("CalsPerUnit: " + getCalsPerUnit());
		System.out.println("ProteinPerUnit: " + getProteinPerUnit());
		System.out.println("CarbsPerUnit:" + getCarbsPerUnit() + "\n");
	}

}


