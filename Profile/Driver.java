import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Driver{
    private String uName;
    private String fName;
    private String lName;
    private boolean smoker;
    private int gender;
    private String email;
    private String password;
    private String carColor;
    private String carMake;
    private int pet;
    private int cargo;
    public boolean status=false;

   
    public void setuName(String uName) {
        this.uName = uName;
    }
    public String getuName() {
        return uName;
    }
    
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getfName() {
        return fName;
    }
    
    public void setlName(String lName) {
        this.lName = lName;
    }
    public String getlName() {
        return lName;
    }
    
    public void setsmoker(boolean somker) {
        this.smoker = smoker;
    }
    public boolean getsmoker() {
        return smoker;
    }
    
    public void setgender(int gender) {
        this.gender = gender;
    }
    public int getgender() {
        return gender;
    }
    
    public void setemail(String email) {
        this.email = email;
    }
    public String getemail() {
        return email;
    }
    
    public void setpassword(String password) {
        this.password= password;
    }
    public String getpassword() {
        return password;
    }
    
    public void setcarColor(String carColor) {
        this.carColor= carColor;
    }
    public String getcarColor() {
        return carColor;
    }
    
    public void setcarMake(String carMake) {
        this.carMake= carMake;
    }
    public String getcarMake() {
        return carMake;
    }
    
    public void setpet(int pet) {
        this.pet = pet;
    }
    public int getpet() {
        return pet;
    }
    
    public void setcargo(int cargo) {
        this.cargo = cargo;
    }
    public int getcargo() {
        return cargo;
    }
    
    public void setstatus(boolean status) {
        this.status = status;
    }
    public boolean getstatus() {
        return status;
    }
 

}