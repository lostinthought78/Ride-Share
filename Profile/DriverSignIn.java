import java.util.Scanner;

public class DriverSignIn {
public static Driver getDriver(){
		
        Driver d = new Driver();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type in username");
        d.setuName(sc.nextLine());
        System.out.println("Please type in password");
        d.setpassword(sc.nextLine());
        d.status=1;
        return  d;
    }
	//зЂВс
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
         
         return  d;
         }
}
