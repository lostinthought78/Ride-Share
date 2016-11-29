import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class CheckDriver {
 //check whether the driver has log in
    
        public static void checkDriver(Driver d)
        {
            try {
                Class.forName(" ");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String url = " ";
            String user = " ";
            String password = " ";
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement pst = null;
             
            String sql = "Select name from passenger where uName = ? and password = ? ";
            try {
                conn = DriverManager.getConnection(url, user, password);
                pst = conn.prepareStatement(sql);
                pst.setString(1, d.getuName());
                pst.setString(2,d.getpassword());
                rs = pst.executeQuery(); 
                while(rs.next()){
                    d.setuName(rs.getString(1));
                }               
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    rs.close();
                    pst.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(d.getuName() == null || d.getuName().isEmpty()){
                System.out.println("Fail to login");
            }else{
                System.out.println("Welcome"+d.getuName()+"log in");
            }
             
        }
}
