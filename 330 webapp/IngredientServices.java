package com.cs330;

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
public class IngredientServices{


        @Path("/ingredients")
        @POST
        @Produces("text/plain")
        @Consumes("application/x-www-form-urlencoded")
        
        public Response createIngredient(MultivaluedMap<String,String> formFields)throws SQLException, ClassNotFoundException{
        
        System.out.println("In create Ingredient");
        
        String newName=formFields.getFirst("name");
        
        String newCategory=formFields.getFirst("category");
        
        
        String connectStr="jdbc:mysql://localhost:3306/fooddb";
        
        
        
        String username="root";

        String password="csci330pass";
        
        String driver="com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con=DriverManager.getConnection(connectStr,username,password);
        
        System.out.println("connected");
        
        PreparedStatement createStmt=con.prepareStatement("INSERT INTO ingredient(name,category) "+"values(?,?)");
        
        
    
        
        createStmt.setString(1,newName);
        createStmt.setString(2,newCategory);
        
        
        int res=createStmt.executeUpdate();
        
        
        System.out.println("PreparedStatement went through");
        
        System.out.println("Result is: "+res);
        
        if(res==1){
                PreparedStatement retrieveStmt=con.prepareStatement("Select * from ingredient where name=? AND category=?");
                
                
                retrieveStmt.setString(1,newName);
                retrieveStmt.setString(2,newCategory);
                
                ResultSet rs=retrieveStmt.executeQuery();
                
                String result="";
                
                int count=0;
                int MAX=100;
                Ingredient[] ingArray= new Ingredient[MAX];
                
                while(rs.next()){
                int theId=rs.getInt("id");
                String theName=rs.getString("name");
                String theCategory=rs.getString("category");
                 // result+="id: "+theId+" , name: "+theName+"("+theCategory+")\n";
                  
                  Ingredient ing=new Ingredient(theId,theName,theCategory);
                  System.out.println(ing);
                  ingArray[count]=ing;
                  count++;
                }//while
                
                
                ingArray=  Arrays.copyOf(ingArray,count);
                
                Gson theGsonObj= new Gson();
                
                result=theGsonObj.toJson(ingArray);
                System.out.println("the json: \n"+result);
                
                
            
            ResponseBuilder rb=Response.ok(result,MediaType.TEXT_PLAIN);
            
            rb.status(201);
            
            return rb.build();
        
            } //if
        
        
        else{
        
            Gson theGsonObj= new Gson();
            Ingredient[] blankIngArray= new Ingredient[1];
            blankIngArray[0]=new Ingredient(0,"none","none");
            String blankResult= theGsonObj.toJson(blankIngArray);
          //  return blankResult;
          
          return Response.status(700).build();
            }
            
        }









        @Path("/ingredients")
        @GET
        @Produces("text/plain")
        public String getIngredients()throws SQLException, ClassNotFoundException{
            
        String connectStr="jdbc:mysql://localhost:3306/fooddb";
        
        String username="root";

        String password="csci330pass";
        
        String driver="com.mysql.jdbc.Driver";
        Class.forName(driver);

        Connection con=DriverManager.getConnection(connectStr,username,password);

        String query="Select id, name, category From ingredient";
        
        PreparedStatement pStmt=con.prepareStatement(query);

        ResultSet rs=pStmt.executeQuery();
        
        ArrayList<Ingredient> in= new ArrayList<Ingredient>();


        String result="";

        while(rs.next()){
            int theId=rs.getInt("id");
            String theName= rs.getString("name");
            String theCategory=rs.getString("category");
        
            Ingredient gre= new Ingredient(theId,theName,theCategory);
            

            
            in.add(gre);
            
            Gson gO=new Gson();
            
            result = gO.toJson(in);
            
            
        }

        return result;
        }
        
        @Path("/ingredients/{id}")
        @GET
        @Produces("text/plain")

        public Response getIngredientByID(@PathParam("id") String tId) throws SQLException, ClassNotFoundException, NamingException{
          
          IngredientFacade iFacade=IngredientFacade.getInstance();
          
          int intId=0;
          
          try{
           intId =Integer.parseInt(tId);
          }catch(NumberFormatException e){
          
            intId=1;
          }
          
          
          
          Ingredient[] resultArray= iFacade.getIngredientById(intId);
          
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
        


        @Path("/ingredients/ingredient")
        @GET
        @Produces("text/plain")

        public String getIngredientByName(@QueryParam("name")String tName) throws SQLException, ClassNotFoundException{
            String theIng="";

              String connectStr="jdbc:mysql://localhost:3306/fooddb";
        
        String username="root";

        String password="csci330pass";
        
        String driver="com.mysql.jdbc.Driver";
        Class.forName(driver);

        Connection con=DriverManager.getConnection(connectStr,username,password);
       
       String nQuery="Select id, name, category From ingredient WHERE name=?";
        
         PreparedStatement pStmt=con.prepareStatement(nQuery);
         
         pStmt.setString(1,tName);

        ResultSet rs=pStmt.executeQuery();

        ArrayList<Ingredient> in= new ArrayList<Ingredient>();
        String result="";
        
        
        while(rs.next()){
            int theId=rs.getInt("id");
            String theName= rs.getString("name");
            String theCategory=rs.getString("category");
        
          Ingredient gre= new Ingredient(theId,theName,theCategory);
          
          in.add(gre);
            
            Gson gO=new Gson();
            
            result = gO.toJson(in);

        }
        return result;
        }
        
        
        
    

    }