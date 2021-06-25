package sample;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionUtil {
    public static void writeToDatabase(String userName, String userEmail, String userPassword) {
           String pgDriver="org.postgresql.Driver";

        String url = "jdbc:postgresql://localhost:5432/ODS_TECHNIQUE?useSSL=false";
        String user = "postgres";
        String password = "Vds@2019";
        String name = userName;
        String email= userEmail;
        String pass = userPassword;

        // query
        String nom = "jdbc:postgresql://localhost:5432/ODS_TECHNIQUE?user=postgres&password=Vds@2019&ssl=true";


        String query = "INSERT INTO worker(name, email, password) VALUES(?, ?, ?)";
        String driverClass_tDBRow_1 = "com.mysql.cj.jdbc.Driver";


        String url_tDBRow_1 ="jdbc:postgresql://localhost:5432/ODS_TECHNIQUE?user=postgres&password=Vds@2019";

        try (Connection con = DriverManager.getConnection(url_tDBRow_1);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, pass);
            pst.executeUpdate();
            System.out.println("Sucessfully created.");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(ConnectionUtil.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
}
