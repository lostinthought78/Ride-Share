package RideShare;

public class Filter {
	
	
	int ID;
	int smoke;
	int pet;
	int space;
	int gender; //male :1; female: 0
	
	public Filter(int ID, int smoke,int pet,int space, int gender){
		
		setID(ID);
		setSmoke(smoke);
		setPet(pet);
		setSpace(space);
		setGender(gender);
		
		
	}
	
	
	
	public Filter(int smoke,int pet,int space, int gender){
		setSmoke(smoke);
		setPet(pet);
		setSpace(space);
		setGender(gender);
		
		
	}
	
	private void setSmoke(int smoke){
		
		this.smoke=smoke;
		
	}
	private void setPet(int pet){
		
		this.pet=pet;
		
	}
	private void setSpace(int space){
		
		this.space=space;
		
	}
	private void setGender(int gender){
		
		this.gender=gender;
		
	}
	
	public void setID(int ID){
		
		this.ID=ID;
		
	}
	
	
	public int getSmoke(){
		
		return smoke;
	}
	
	public int getpet(){
		
		return pet;
		
	}
	
	public int getSpace(){
		
		return space;
		
	}
	
	public int getGender(){
		
		return gender;
	}
	
	public int getID(){
		
		return ID;
	}
	

}