package com.cs490;

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
public class FilterServices{


        @Path("/filter")
        @POST
        @Produces("text/plain")
        @Consumes("application/x-www-form-urlencoded")
        
        public Response createFilter(MultivaluedMap<int,int,int,int> formFields)throws SQLException, ClassNotFoundException, NamingException{
        
		
         int smoke=formFields.getFirst("smoke");
         int space=formFields.getFirst("space");
		 int pet=formFields.getFirst("pet");
         int gender=formFields.getFirst("gender");
        
        
        
            Filter f = new Filter(smoke,pet,space,gender);
        
          FilterFacade fFacade=FilterFacade.getInstance();
          
         
          
          
          
          Filter[] resultArray= iFacade.CreateFilter(f);
          
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
          
         
          Filter[] resultArray= fFacade.getIngredient();
          
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
        
        @Path("/filter/{id}")
        @GET
        @Produces("text/plain")

        public Response getFilterByID(@PathParam("id") String tId) throws SQLException, ClassNotFoundException, NamingException{
          
          FilterFacade fFacade=FilterFacade.getInstance();
          
          int intId=0;
          
          try{
           intId =Integer.parseInt(tId);
          }catch(NumberFormatException e){
          
            intId=1;
          }
          
          
          
          Filter[] resultArray= fFacade.getFilterById(intId);
          
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