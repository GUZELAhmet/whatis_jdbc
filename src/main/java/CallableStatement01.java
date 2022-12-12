import java.sql.*;


public class CallableStatement01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro","postgres","1234");
        Statement st= con.createStatement();

    }
}
