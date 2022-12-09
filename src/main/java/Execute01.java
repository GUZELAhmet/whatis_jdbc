import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/Techpro","postgres","1234");
        Statement st = con .createStatement();
        System.out .println ("Connection Succes");


        String sql1="create table workers(worker_id varchar(50),worker_name varchar(50),worker_salary int);";
       st.execute(sql1);

       String sql2="Alter table workers add worker_adress varchar(80);";
       st.execute(sql2);

    String sql3="drop table workers;";
    //st.execute(sql3);


        con.close();
        st.close();


    }
}
