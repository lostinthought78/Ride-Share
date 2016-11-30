import java.util.Scanner;
import java.util.ArrayList;
import com.google.gson.Gson; 

//the interface for passenger sign in and log in 
public class PassengerSignIn {
	//log in
	public static Passenger getPassenger(){
	
		
        Passenger p = new Passenger();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type in username");
        p.setuName(sc.nextLine());
        System.out.println("Please type in password");
        p.setpassword(sc.nextLine());
        p.status=true;
	
	ArrayList<String> list = new ArrayList<String>();
        list.add(p.getuName());
       	list.add(p.getpassword());
		
	GSON theGsonObj = new GSON();
	result = theGSONObj.toGSON(list);

        return  result;
    }
	//sign in
    public static Passenger registerPassenger(){
	
	
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

	ArrayList<String> list = new ArrayList<String>();
        list.add(p.getuName());
	list.add(p.getfName());
	list.add(p.getlName());
	list.add(p.getsmoker());
	list.add(p.getgender());
	list.add(p.getemail());
       	list.add(p.getpassword());
	
         GSON theGsonObj = new GSON();
	result = theGSONObj.toGSON(list);

        return  result;
         }
}
