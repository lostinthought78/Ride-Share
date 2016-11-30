import java.util.Scanner;
import java.util.ArrayList;
import com.google.gson.Gson; 

//the interface for passenger sign in and log in 
public class PassengerSignIn {
	//log in
	public static ArrayList<Passenger> getPassenger(){
	
	List<Passenger> list = new Arraylist<Passenger>();	
        Passenger p = new Passenger();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type in username");
        p.setuName(sc.nextLine());
        System.out.println("Please type in password");
        p.setpassword(sc.nextLine());
        p.status=true;
	
	GSON theGsonObj = new GSON();
	result = theGSONObj.toGSON(list);

        return  result;
    }
	//sign in
    public static ArrayList<Passenger> registerPassenger(){
	
	List<Passenger> list = new Arraylist<Passenger>();
    	Passenger p = new Passenger();
    	 Scanner sc = new Scanner(System.in);
         System.out.println("Please type in username");
         p.setuName(sc.nextLine());
         System.out.println("Please type in firstname");
         p.setfName(sc.nextLine());
         System.out.println("Please type in lastname");
         p.setlName(sc.nextLine());
         System.out.println("Are you a smoker? (true/false)");
         p.setsmoker(sc.nextBoolean());
         System.out.println("Please type in your gender");
         p.setgender(sc.nextInt());
         System.out.println("Please type in email");
         p.setemail(sc.nextLine());
         System.out.println("Please type in password");
         p.setpassword(sc.nextLine());

	
         GSON theGsonObj = new GSON();
	result = theGSONObj.toGSON(list);

        return  result;
         }
}
