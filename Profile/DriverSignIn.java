import java.util.Scanner;
import java.util.ArrayList;
import com.google.gson.Gson; 

//The interface for login and sign in for driver
public class DriverSignIn {
public static ArrayList<Driver> getDriver(){
	//log in	
	List<Driver> list = new Arraylist<Driver>();
        Driver d = new Driver();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type in username");
        d.setuName(sc.nextLine());
        System.out.println("Please type in password");
        d.setpassword(sc.nextLine());
        d.status=1;
        rGSON theGsonObj = new GSON();
	result = theGSONObj.toGSON(list);

        return  result;
    }
	//sign in 
    public static ArrayList<Driver> registerDriver(){
	List<Driver> list = new Arraylist<Driver>();
    	Driver d = new Driver();
    	 Scanner sc = new Scanner(System.in);
         System.out.println("Please type in username");
         d.setuName(sc.nextLine());
         System.out.println("Please type in firstname");
         d.setfName(sc.nextLine());
         System.out.println("Please type in lastname");
         d.setlName(sc.nextLine());
         System.out.println("Are you a smoker? (true/false)");
         d.setsmoker(sc.nextBoolean());
         System.out.println("Please type in your gender");
         d.setgender(sc.nextInt());
         System.out.println("Please type in email");
         d.setemail(sc.nextLine());
         System.out.println("Please type in password");
         d.setpassword(sc.nextLine());
         System.out.println("Please type in your car's color");
         d.setcarColor(sc.nextLine());
         System.out.println("Please type in your car's type");
         d.setcarMake(sc.nextLine());
         System.out.println("Do you have pet (Yes or no)");
         d.setpet(sc.nextInt());
         System.out.println("Please type in the rest of your seat");
         d.setcargo(sc.nextInt());
         rGSON theGsonObj = new GSON();
	result = theGSONObj.toGSON(list);
         return result;
         }
}
