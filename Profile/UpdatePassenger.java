import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// for passenger to update its information
public class UpdatePassenger {
	
	
	public static void updatePassenger(Passenger p){
		try {
            Class.forName(" ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = " ";
        String user = " ";
        String password = " ";
        Connection conn = null;
        String sql = "Insert Into diver values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        Statement s = null;
        ResultSet rs = null;
        String sql_ck = "Select uName FROM passenger WHERE uName="+p.getuName();
        
        if(p.status=true){
        try {
            conn = DriverManager.getConnection(url, user, password);
            
                      
            pst = conn.prepareStatement(sql);
            pst.setString(2, p.getfName());
            pst.setString(3, p.getlName());
            pst.setBoolean(4, p.getsmoker());
            pst.setInt(5, p.getgender());
            pst.setString(6, p.getemail());
            pst.setString(7, p.getpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                s.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
     }else{
    	 System.out.print("Please log in.");
     }
     }
	
}


