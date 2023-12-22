package adminPanel.server;

import adminPanel.shared.AdminPanelModel;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class AdminPanel_srvImpl {

    public boolean Authenticate(AdminPanelModel model) {
        String password = "", username = "", user = "";
        boolean lo = false;
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = "Select username, password,user from credentials";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    username = rs.getString("username");
                    password = rs.getString("password");
                    user = rs.getString("user");
                    if (model.getTxtUsername().equals(username) && model.getTxtPassword().equals(password)) {
                        model.setStatus(true);
                        lo = true;
                        if (lo) {
                            break;
                        }
                    } else {
                        model.setStatus(false);
                    }
                }
                rs.close();
                st.close();
                con.close();
            } catch (Exception e) {

            }
            model.setConnection(true);

        } else {
            model.setConnection(false);
        }
        return lo;
    }

    private Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpsoft", "root", "1234");
            return cn;
        } catch (Exception e) {
            return cn;
        }
    }

}
