import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuerry01 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
                Class.forName("org.postgresql.Driver");
               Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
              Statement st = con.createStatement();
    }
}
