import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    String sql = "select * from login where email=? and password=?";
    String url = "jdbc:mysql://localhost:3306/alvin";
    String username = "root";
    String password = "Alvin@99Alex";



    public boolean verfiyUser(User user){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,user.getEmail());
            st.setString(2,user.getPassword());

            ResultSet rs = st.executeQuery();

            if(rs.next()) return true;
        }
        catch (Exception e){
           e.printStackTrace();
        }
        return false;
    }
}
