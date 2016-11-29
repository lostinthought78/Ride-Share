import java.util.Scanner;
 
public class Test {
 
    public static void main(String[] args) {
 
        int chos = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t Login:Type in 1\t\t Signin: Type in 2\t\t Update your profile: Type in 3");
        chos = sc.nextInt();
        switch(chos){
        case 1: Check.checkPassenger(PassengerSignIn.getPassenger());break;
        case 2: PassengerRegister.registPassenger(PassengerSignIn.registerPassenger());break;
        default: System.out.println("Please type in correct number");break;
        }
    }
 
}