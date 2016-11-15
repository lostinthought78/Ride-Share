package com.cs490;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class FilterFacade{

    
    private static FilterFacade singleton;
    
    private FilterDataAccess dao;
    
    private FilterFacade() throws NamingException, SQLException{
    
            this.dao = FilterDataAccess.getInstance();
    
    }
    
    public static FilterFacade getInstance() throws NamingException, SQLException{
    
        if(singleton == null){
        
            singleton = new FilterFacade();
        }
        
        return singleton;
    
    }
    
    
    public Filter[] getFilter() throws SQLException{
    
   
           Connection con=dao.getConnection();
        
        PreparedStatement stmt=con.prepareStatement("Select ID, Smoke, gender, pet, space FROM Filter");
        
        ResultSet rs=stmt.executeQuery();

    
    
		filter[] filtArray= new Filter[100];
    int count=0;
    
        
        
        if(count>0){
            filtArray= Arrays.copyOf(filtArray,count);
            return filtArray;
        }
        else{
        while(rs.next()){
            int theId2=rs.getInt("ID");
            int smoke=rs.getInt("Smoke");
            int gender=rs.getInt("gender");
			int pet=rs.getInt("pet");
            Filter filt= new Filter(theId2, smoke, gender, pet);
            filtArray[count]=filt;
            count++;
            }
        }
        
        
        if(count>0){
            filtArray= Arrays.copyOf(filtArray,count);
            
            return filtArray;
        }
        else{
        return null;
        }
        
    
    
    }
    
	
	
        
    
    
    }
        
        
    public Filter[] getFilterById(int theId) throws SQLException , ClassNotFoundException{
    
        Connection con=dao.getConnection();
        
        PreparedStatement stmt=con.prepareStatement("Select ID, Smoke,gender, pet, space FROM Filter where id=?");
        stmt.setInt(1,theId);
        ResultSet rs=stmt.executeQuery();

    
    
    Filter [] filtArray= new Filter[100];
    int count=0;
    
      
        
        if(count>0){
            filtArray= Arrays.copyOf(filtArray,count);
            return filtArray;
        }
        else{
        while(rs.next()){
            int theId2=rs.getInt("ID");
            int smoke=rs.getInt("Smoke");
            int pet=rs.getInt("pet");
			int gender=rs.getInt("gender");
            Filter filt= new Filter(theId2, smoke, pet, gender);
            filtArray[count]=filt;
            count++;
            }
        }
        
        
        if(count>0){
            filtArray= Arrays.copyOf(filtArray,count);
            
            return filtArray;
        }
        else{
        return null;
        }
    
    }
    
    
    public Filter[] CreateFilter(Filter fTAdd) throws SQLException, ClassNotFoundException{
    
     
    
  
            Connection con=dao.getConnection();
        
        

        PreparedStatement createStmt=con.prepareStatement("INSERT INTO filter(Smoke,gender,pet,storage) "+"values(?,?,?,?)");
        
         int smoke= fTAdd.getSmoke();
		 int pet= fTAdd.getpet();
		 int space= fTAdd.getSpace();
		 int gender= fTAdd.getGender();
	
        
        createStmt.setString(1,smoke);
        createStmt.setString(2,gender);
		createStmt.setString(3,pet);
        createStmt.setString(4,storage);
        
       createStmt.executeUpdate();
       
       
       PreparedStatement stmt=con.prepareStatement("Select * from filter WHERE Smoke=? and gender=? and pet=? and storage=?");
       
       stmt.setInt(1,smoke);
        stmt.setInt(2,gender);
		stmt.setInt(3,pet);
		stmt.setInt(4,storage);
		
		
        ResultSet rs= stmt.executeQuery();
        
        
    
    
		Filter [] filtArray= new Filter[100];
    int count=0;
    
      
        
        if(count>0){
            filtArray= Arrays.copyOf(filtArray,count);
            return filtArray;
        }
        else{
        while(rs.next()){
             int theId2=rs.getInt("ID");
            int smoke=rs.getString("Smoke");
            int pet=rs.getString("pet");
			int gender=rs.getString("gender");
            String theCategory=rs.getString("pet");
            Filter filt= new Filter(theId2, smoke, pet, gender);
            filtArray[count]=filt;
            count++;
            }
        }
        
        
        if(count>0){
            filtArray= Arrays.copyOf(filtArray,count);
            
            return filtArray;
        }
        else{
        return null;
        }
           
    
    }



}