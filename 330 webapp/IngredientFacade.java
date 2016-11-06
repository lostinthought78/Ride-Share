package com.cs330;
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

public class IngredientFacade{

    
    private static IngredientFacade singleton;
    
    private IngredientDataAccess dao;
    
    private IngredientFacade() throws NamingException, SQLException{
    
            this.dao = IngredientDataAccess.getInstance();
    
    }
    
    public static IngredientFacade getInstance() throws NamingException, SQLException{
    
        if(singleton == null){
        
            singleton = new IngredientFacade();
        }
        
        return singleton;
    
    }
    
    
    public Ingredient[] getIngredient() throws SQLException{
    
   
           Connection con=dao.getConnection();
        
        PreparedStatement stmt=con.prepareStatement("Select id, name, category FROM ingredient");
        
        ResultSet rs=stmt.executeQuery();

    
    
    Ingredient [] ingArray= new Ingredient[100];
    int count=0;
    
        
        
        if(count>0){
            ingArray= Arrays.copyOf(ingArray,count);
            return ingArray;
        }
        else{
        while(rs.next()){
            int theId2=rs.getInt("id");
            String tName=rs.getString("name");
            String theCategory=rs.getString("category");
            Ingredient ing= new Ingredient(theId2, tName, theCategory);
            ingArray[count]=ing;
            count++;
            }
        }
        
        
        if(count>0){
            ingArray= Arrays.copyOf(ingArray,count);
            
            return ingArray;
        }
        else{
        return null;
        }
        
    
    
    }
    
    public Ingredient[] getIngredientByName(String theName) throws SQLException, ClassNotFoundException {
    
    
         Connection con=dao.getConnection();
        
        PreparedStatement stmt=con.prepareStatement("Select id, name, category FROM ingredient where name=?");
        stmt.setString(1,theName);
        ResultSet rs=stmt.executeQuery();

    
    
    Ingredient [] ingArray= new Ingredient[100];
    int count=0;
    
        
        
        if(count>0){
            ingArray= Arrays.copyOf(ingArray,count);
            return ingArray;
        }
        else{
        while(rs.next()){
            int theId2=rs.getInt("id");
            String tName=rs.getString("name");
            String theCategory=rs.getString("category");
            Ingredient ing= new Ingredient(theId2, tName, theCategory);
            ingArray[count]=ing;
            count++;
            }
        }
        
        
        if(count>0){
            ingArray= Arrays.copyOf(ingArray,count);
            
            return ingArray;
        }
        else{
        return null;
        }
        
    
    
    }
        
        
    public Ingredient[] getIngredientById(int theId) throws SQLException , ClassNotFoundException{
    
        Connection con=dao.getConnection();
        
        PreparedStatement stmt=con.prepareStatement("Select id, name, category FROM ingredient where id=?");
        stmt.setInt(1,theId);
        ResultSet rs=stmt.executeQuery();

    
    
    Ingredient [] ingArray= new Ingredient[100];
    int count=0;
    
      
        
        if(count>0){
            ingArray= Arrays.copyOf(ingArray,count);
            return ingArray;
        }
        else{
        while(rs.next()){
            int theId2=rs.getInt("id");
            String theName=rs.getString("name");
            String theCategory=rs.getString("category");
            Ingredient ing= new Ingredient(theId2, theName, theCategory);
            ingArray[count]=ing;
            count++;
            }
        }
        
        
        if(count>0){
            ingArray= Arrays.copyOf(ingArray,count);
            
            return ingArray;
        }
        else{
        return null;
        }
    
    }
    
    
    public Ingredient[] CreateIngredient(Ingredient ITAdd) throws SQLException, ClassNotFoundException{
    
     
    
  
            Connection con=dao.getConnection();
        
        

        PreparedStatement createStmt=con.prepareStatement("INSERT INTO ingredient(name,category) "+"values(?,?)");
        
        
        String newName=ITAdd.getName();
        
        String newCategory=ITAdd.getCategory();
    
        
        createStmt.setString(1,newName);
        createStmt.setString(2,newCategory);
        
       createStmt.executeUpdate();
       
       
       PreparedStatement stmt=con.prepareStatement("Select * from ingredient WHERE name=? and category=?");
       
       stmt.setString(1,newName);
        stmt.setString(2,newCategory);
        ResultSet rs= stmt.executeQuery();
        
        
    
    
    Ingredient [] ingArray= new Ingredient[100];
    int count=0;
    
      
        
        if(count>0){
            ingArray= Arrays.copyOf(ingArray,count);
            return ingArray;
        }
        else{
        while(rs.next()){
            int theId2=rs.getInt("id");
            String theName=rs.getString("name");
            String theCategory=rs.getString("category");
            Ingredient ing= new Ingredient(theId2, theName, theCategory);
            ingArray[count]=ing;
            count++;
            }
        }
        
        
        if(count>0){
            ingArray= Arrays.copyOf(ingArray,count);
            
            return ingArray;
        }
        else{
        return null;
        }
        
        
        
        
        
        

    
    
   
    
    }



}