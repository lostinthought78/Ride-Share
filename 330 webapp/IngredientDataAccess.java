
package com.cs330;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;


public class IngredientDataAccess{
    private static IngredientDataAccess singleton;
    
    private DataSource dataSource;

    
    private IngredientDataAccess() throws NamingException,SQLException{
        Context initContext= new InitialContext();
        Context envContext=(Context) initContext.lookup("java:/comp/env");
        
        this.dataSource = (DataSource) envContext.lookup("jdbc/fooddb");
        
    }
    
    
/////////////////////

    public static IngredientDataAccess getInstance() throws NamingException, SQLException{
        if(singleton == null){
            singleton = new IngredientDataAccess();
        }
      
            return singleton;
        
    }
    
    
    
//////////////////////
    public Connection getConnection () throws SQLException{
    
        return dataSource.getConnection();
    
    
    }
    
    
    
    
    
    
    
    


}