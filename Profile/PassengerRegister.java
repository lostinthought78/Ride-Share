import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PassengerRegister {
	public static void registPassenger(Passenger p){
        
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
         
        //判断登陆名是否已经存在
        Statement s = null;
        ResultSet rs = null;
        String sql_ck = "Select uName FROM passenger";
        try {
            conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement(sql);
            pst.setString(1, p.getuName());
            pst.setString(2, p.getfName());
            pst.setString(3, p.getlName());
            pst.setBoolean(4, p.getsmoker());
            pst.setInt(5, p.getgender());
            pst.setString(6, p.getemail());
            pst.setString(7, p.getpassword());
            //判断登陆名是否已经存在
            s = conn.createStatement();
            rs = s.executeQuery(sql_ck);
            while(rs.next()){//为什么用 rs.getString(2)会提示 无效的索引呢
                if( rs.getString("uName").equals(p.getuName()) ){
                    System.out.println("The username is existed. Please change another one");
                    break;
                }else{
                    pst.executeUpdate();
                    System.out.println("Successfully sign in");
                    break;
                }
            }   
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
         
         
    }
}
