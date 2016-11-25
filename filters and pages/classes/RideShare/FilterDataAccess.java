package RideShare;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;


public class FilterDataAccess{
    private static FilterDataAccess singleton;
    
    private DataSource dataSource;

    
    private FilterDataAccess() throws NamingException,SQLException{
        Context initContext= new InitialContext();
        Context envContext=(Context) initContext.lookup("java:/comp/env");
        
        this.dataSource = (DataSource) envContext.lookup("jdbc/project");// change here to set the name of the database
        
    }
    
    
/////////////////////

    public static FilterDataAccess getInstance() throws NamingException, SQLException{
        if(singleton == null){
            singleton = new FilterDataAccess();
        }
      
            return singleton;
        
    }
    
    
    
//////////////////////
    public Connection getConnection () throws SQLException{
    
        return dataSource.getConnection();
    
    
    }
    
    
    
    
    
    
    
    


}