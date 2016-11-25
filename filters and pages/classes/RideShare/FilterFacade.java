package RideShare;
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
        
        PreparedStatement stmt=con.prepareStatement("Select ID, Smoke, gender, pet, storage FROM Filter");
        
        ResultSet rs=stmt.executeQuery();

    
    
		Filter[] filtArray= new Filter[100];
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
			int storage=rs.getInt("storage");
            Filter filt= new Filter(theId2, smoke, gender, pet,storage);
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
    

			 public User[] getUsers(Filter fil) throws SQLException{
			
		   
				   Connection con=dao.getConnection();
				   
				   int smoke=fil.getSmoke();
				   int gender=fil.getGender();
				   int pet=fil.getpet();
				   int storage=fil.getSpace();
				   
				
				PreparedStatement stmt=con.prepareStatement("Select ID FROM Filter Where Smoke=? and gender=? and pet=? and storage=?");
				stmt.setInt(1,smoke);
				stmt.setInt(2,gender);
				stmt.setInt(3,pet);
				stmt.setInt(4,storage);
				ResultSet rs=stmt.executeQuery();
				  int [] idArray= new int[100];
				  User[] pArray=new User[100];
				  
				  int count=0;
					
					  
						
					
						while(rs.next()){
							int theId2=rs.getInt("ID");
							idArray[count]=theId2;
							count++;
							}
						
						/*
						modify here for full functions
						
						*/
						
						

				
						
						
						for(int i=0; i<idArray.length;i++){
							
						PreparedStatement pstmt=con.prepareStatement("Select fName, uName, lName,ID FROM Driver Where ID=?");
							
						
						pstmt.setInt(1,idArray[i]);
						
						rs=pstmt.executeQuery();
							
							while (rs.next()){
							
							
							String fName=rs.getString("fName");
							String lName=rs.getString("lName");
							
							int id=rs.getInt("ID");
							
							String uName=rs.getString("uName");
							
							
							User u=new User();
							u.setName(fName+" "+lName);
							
							u.setID(id);
							
							u.setNo(uName);
							pArray[i]=u;
							

							}
						
						}
						
						      
						if(count>0){
							pArray= Arrays.copyOf(pArray,count);
							
							return pArray;
						}
						else{
						return null;
						}
			
			
			}
	
	
	
    
    public Filter[] CreateFilter(Filter fTAdd) throws SQLException, ClassNotFoundException{
    
     
    
  
            Connection con=dao.getConnection();
        
        

        PreparedStatement createStmt=con.prepareStatement("INSERT INTO Filter(Smoke,gender,pet,storage) values(?,?,?,?);");
        
         int smoke= fTAdd.getSmoke();
		 int pet= fTAdd.getpet();
		 int space= fTAdd.getSpace();
		 int gender= fTAdd.getGender();
	
        
        createStmt.setInt(1,smoke);
        createStmt.setInt(2,gender);
		createStmt.setInt(3,pet);
        createStmt.setInt(4,space);
        
       createStmt.executeUpdate();
       
       
       PreparedStatement stmt=con.prepareStatement("Select * from Filter WHERE Smoke=? and gender=? and pet=? and storage=?");
       
       stmt.setInt(1,smoke);
        stmt.setInt(2,gender);
		stmt.setInt(3,pet);
		stmt.setInt(4,space);
		
		
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
            int smoke2=rs.getInt("Smoke");
            int pet2=rs.getInt("pet");
			int gender2=rs.getInt("gender");
			int storage2=rs.getInt("storage");

 
            Filter filt= new Filter(theId2, smoke2, gender2,pet2,storage2 );
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