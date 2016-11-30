import java.util.Scanner;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.Arrays;
import java.util.ArrayList;
import com.google.gson.Gson;
import javax.naming.*;

@Path("ws2")
//the interface for passenger sign in and log in 
public class PassengerIn {
	@Path()
	@POST
	@Produces()
	@Consumes()
	//log in
	public static Passenger getPassenger(){
		public createSignIn(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException{
			String uName=formFields.getFirst("uName");
			String password=formFields.getFirst("password");
			Passenger p = new Passenger(uName,password);
			PassengerIn pIn = PassengerIn.getinstance();
			Passenger[] resultArray= iFacade.CreatePassenger(p);
    	
			if(resultArray !=null){
	            Gson theGsonObj=new Gson();
	            
	            String result=theGsonObj.toJson(resultArray);
	            
	            ResponseBuilder rb= Response.ok(result, MediaType.TEXT_PLAIN);
	            rb.status(200);
	            
	            return rb.build();
	          
	          }
	          else{
	            return Response.status(700).build();
	          }
    	
    		}
		
    
		}
	//sign in
    public static Passenger registerPassenger(){
    		public createSignIn(MultivaluedMap<String,String,String,Boolean,int,String,String> formFields) throws SQLException, ClassNotFoundException, NamingException{
			String uName=formFields.getFirst("uName");
			String fName=formFields.getFirst("fName");
			String lName=formFields.getFirst("lName");
			Boolean smoker=formFields.getFirst("smoker");
			int gender=formFields.getFirst("gender");
			String email=formFields.getFirst("email");
			String password=formFields.getFirst("password");
			Passenger p = new Passenger();
			PassengerIn pIn = PassengerIn.getinstance();
			Passenger[] resultArray= iFacade.CreatePassenger(p);
    	
			if(resultArray !=null){
	            Gson theGsonObj=new Gson();
	            
	            String result=theGsonObj.toJson(resultArray);
	            
	            ResponseBuilder rb= Response.ok(result, MediaType.TEXT_PLAIN);
	            rb.status(200);
	            
	            return rb.build();
	          
	          }
	          else{
	            return Response.status(700).build();
	          }
    	
    		}
    }
}
