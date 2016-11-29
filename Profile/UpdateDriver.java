import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateDriver {
	
	
	public static void updateDriver(Driver d){
		try {
            Class.forName(" ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = " ";
        String user = " ";
        String password = " ";
        Connection conn = null;
        String sql = "Insert Into passenger values(?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        Statement s = null;
        ResultSet rs = null;
        String sql_ck = "Select uName FROM driver WHERE uName="+d.getuName();
        
        if(d.status=true){
        try {
            conn = DriverManager.getConnection(url, user, password);
            
                      
            pst = conn.prepareStatement(sql);
            pst.setString(1, d.getuName());
            pst.setString(2, d.getfName());
            pst.setString(3, d.getlName());
            pst.setBoolean(4, d.getsmoker());
            pst.setInt(5, d.getgender());
            pst.setString(6, d.getemail());
            pst.setString(7, d.getpassword());
            pst.setString(8, d.getcarColor());
            pst.setString(9, d.getcarMake());
            pst.setInt(10, d.getpet());
            pst.setInt(10, d.getcargo());
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


