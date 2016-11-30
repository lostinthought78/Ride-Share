package rideshare.domain;

public class DriverOptions {
	private Boolean smoker;
	private Boolean luggage;
	private Boolean pets;
	
	public Boolean getSmoker() {
		return smoker;
	}
	public void setSmoker(Boolean smoker) {
		this.smoker = smoker;
	}
	public Boolean getLuggage() {
		return luggage;
	}
	public void setLuggage(Boolean luggage) {
		this.luggage = luggage;
	}
	public Boolean getPets() {
		return pets;
	}
	public void setPets(Boolean pets) {
		this.pets = pets;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	private String gender;
}