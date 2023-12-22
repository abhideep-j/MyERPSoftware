
package myLibrary.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBConnect {
   
     public Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpsoft", "root", "1234");
            return cn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "print connection error" );
            return cn;
        }
    }
}
