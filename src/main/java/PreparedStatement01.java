import java.beans.PropertyEditorSupport;
import java.sql.*;


public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
PreparedStatement interface, birden çok kez çalıştırılabilen önceden derlenmiş bir SQL kodunu temsil eder.
Paremetrelendirilmiş SQL sorguları(query) ile çalışır. Bur sorguyu 0 veya daha fazla parametre ile kullanabiliriz.
 */
      //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro","postgres","1234");
        Statement st= con.createStatement();
//1. adım : Prepared statement query sini oluştur
        String sql1="update companies set number_of_employees=? where company=?";
        //2. Adım: PreparedStatement objesini oluştur.
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //3. Adım: setInt(), setString(), ... methodlarını kullanarak soru işaretleri yerlerine değer gir.
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        //4. adım Query yi çalıştır
        int guncellenenSatirSayisi=pst1.executeUpdate();
        System.out.println("guncellenenSatirSayisi = " + guncellenenSatirSayisi);
        String sql2="select * from companies";
        ResultSet rs1 = st.executeQuery(sql2);
        while (rs1.next()){
            System.out.println(rs1.getInt(1)
                    +"--"+rs1.getString(2)
                    +"--"+ rs1.getInt(3));

        }
        //2. Örnek: Prepared statement kullanarak company adı GOOGLE olan number_of_employees değerini 5555 olarak güncelleyin.
pst1.setInt(1,5555);
        pst1.setString(2,"GOOGLE");

        pst1.executeUpdate();
        con.close();
        rs1.close();

        pst1.close();


    }
}
