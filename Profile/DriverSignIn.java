import java.util.Scanner;
import java.util.ArrayList;
import com.google.gson.Gson; 

//The interface for login and sign in for driver
public class DriverSignIn {
public static Driver getDriver(){
	//log in	
	
        Driver d = new Driver();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type in username");
        d.setuName(sc.nextLine());
        System.out.println("Please type in password");
        d.setpassword(sc.nextLine());
        d.status=1;
	
	ArrayList<String> list = new ArrayList<String>();
        list.add(d.getuName());
	list.add(d.getpassword());
	
	
        rGSON theGsonObj = new GSON();
	result = theGSONObj.toGSON(list);
	
        return  result;
    }
	//sign in 
    public static Driver registerDriver(){
	
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
	    
	    
	    
	ArrayList<String> list = new ArrayList<String>();
        list.add(d.getuName());
	list.add(d.getfName());
	list.add(d.getlName());
	list.add(d.getsmoker());
	list.add(d.getgender());
	list.add(d.getemail());
       	list.add(d.getpassword());
	list.add(d.getcarColor());
	list.add(d.getcarMake());
	 list.add(d.getcargo());
	 list.add(d.getemail());
         rGSON theGsonObj = new GSON();
	result = theGSONObj.toGSON(list);
         return result;
         }
}
