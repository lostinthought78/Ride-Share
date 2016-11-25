package RideShare;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 *
 */
class User{
	private int ID;
    private String no;
    private String name;
    private int age;
    private int carID;
    private String add;
	
	
	public void setID(int id){
		
		this.ID=ID;
	}
	
	public int getID(){
		
		return ID;
	}
	
	
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void getcarID() {
  this.carID = carID;    
    }
    public String setcarID(String carID) {
 return carID;    
}
    public String getAdd() {
        return add;
    }
    public void setAdd(String add) {
        this.add = add;
    }
}