package RideShare;

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


@Path("w2")
public class FilterServices{


        @Path("/filterCreate")
        @POST
        @Produces("text/plain")
        @Consumes("application/x-www-form-urlencoded")
        public Response createFilter(MultivaluedMap<String,String> formFields)throws SQLException, ClassNotFoundException, NamingException{
        
		
         String smoke=formFields.getFirst("smoke");
         String space=formFields.getFirst("space");
		 String pet=formFields.getFirst("pet");
         String gender=formFields.getFirst("gender");      


		 int smoke2=Integer.parseInt(smoke);
		 int space2=Integer.parseInt(space);
		 int pet2=Integer.parseInt(pet);
		 int gender2=Integer.parseInt(gender);
		 
		 
            Filter f = new Filter(smoke2,pet2,space2,gender2);
        
          FilterFacade fFacade=FilterFacade.getInstance();
          
          
          Filter[] resultArray= fFacade.CreateFilter(f);
          
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



		
		
		
		
        @Path("/filterUsers")
        @POST
        @Produces("text/plain")
        @Consumes("application/x-www-form-urlencoded")
        
        public Response getUsers(MultivaluedMap<String, String> formFields)throws SQLException, ClassNotFoundException, NamingException{
        
		
		
		 String smoke=formFields.getFirst("smoke");
         String space=formFields.getFirst("space");
		 String pet=formFields.getFirst("pet");
         String gender=formFields.getFirst("gender");      


		 int smoke2=Integer.parseInt(smoke);
		 int space2=Integer.parseInt(space);
		 int pet2=Integer.parseInt(pet);
		 int gender2=Integer.parseInt(gender);
		 
		 
            Filter f = new Filter(smoke2,pet2,space2,gender2);
		
		
          FilterFacade fFacade=FilterFacade.getInstance();
          
          
          User[] resultArray= fFacade.getUsers(f);
          
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







        @Path("/filter")
        @GET
        @Produces("text/plain")
        public Response getFilters()throws SQLException, ClassNotFoundException, NamingException{
            
       
        
        FilterFacade fFacade=FilterFacade.getInstance();
          
         
          Filter[] resultArray= fFacade.getFilter();
          
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
		
		
		
		
    @GET
    @Path("/filterPrint")
    @Produces(MediaType.TEXT_HTML)
    public String printOnly()
    {
        System.out.println("running successfully");
        return "<p>this webservice</p>";
    }
		
		
		
		
        
    }