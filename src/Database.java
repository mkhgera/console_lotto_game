import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Database {
    Connection con = null;
    //Database connection
    Database() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/endterm", "postgres",    "Aika.2003");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Method to insert users in the table
    public void insertUser(User users) throws SQLException {
        Statement st = con.createStatement();
        String SQL = "INSERT INTO users(name,age,usermoney) " + "VALUES(?,?,?)";
        PreparedStatement ps=con.prepareStatement(SQL);
        ps.setString(1, users.getFirstName());
        ps.setInt(2, users.getAge());
        ps.setInt(3, users.getUserMoney());
        ps.executeUpdate();
        ResultSet rs=st.executeQuery("SELECT * FROM users");
        int id = 0;
        while(rs.next()){
        id=rs.getInt("userid");
        }
        users.setUserID(id);
    }

    //Method to update table with users
    public void updateUser(User users) throws SQLException{
        Statement st = con.createStatement();
        String SQL = "UPDATE users SET usermoney = ?" + " where userid=?";
        PreparedStatement ps=con.prepareStatement(SQL);
        ps.setInt(1, users.getUserMoney());
        ps.setInt(2,users.getUserID());
        ps.executeUpdate();
    }

}



