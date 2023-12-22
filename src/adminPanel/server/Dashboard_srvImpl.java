package adminPanel.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dashboard_srvImpl {

    public String[] getSalesBarChartData() {
        String[] salesArrayForBarChart = new String[12];
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = " select * from dashboardSales";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                salesArrayForBarChart[0] = rs.getString("jan");
                salesArrayForBarChart[1] = rs.getString("feb");
                salesArrayForBarChart[2] = rs.getString("mar");
                salesArrayForBarChart[3] = rs.getString("apr");
                salesArrayForBarChart[4] = rs.getString("may");
                salesArrayForBarChart[5] = rs.getString("jun");
                salesArrayForBarChart[6] = rs.getString("jul");
                salesArrayForBarChart[7] = rs.getString("aug");
                salesArrayForBarChart[8] = rs.getString("sep");
                salesArrayForBarChart[9] = rs.getString("oct");
                salesArrayForBarChart[10] = rs.getString("nov");
                salesArrayForBarChart[11] = rs.getString("dece");

            }
            con.close();
            st.close();
        } catch (Exception e) {

        }
        return salesArrayForBarChart;

    }

    public void save(String[] array) {
        try {
            Connection con = getConnection();
            Statement st1 = con.createStatement();
            String query1 = "truncate table dashboardSales";
            int i1 = st1.executeUpdate(query1);
            if (i1 >= 0) {
                Statement st = con.createStatement();
                String query = "INSERT INTO dashboardSales(jan, feb, mar, apr, "
                        + "may, jun, jul, aug, sep, oct, nov, dece) VALUES ('" + array[0] + "','" + array[1] + "','" + array[2] + "',"
                        + "'" + array[3] + "','" + array[4] + "','" + array[5] + "','" + array[6] + "'"
                        + ",'" + array[7] + "','" + array[8] + "','" + array[9] + "','" + array[10] + "','" + array[11] + "') ";
                int i = st.executeUpdate(query);
                if (i > 0) {
                    // Do something if the insertion is successful
                }
                con.close();
                st.close();
            }
        } catch (Exception l) {
            l.printStackTrace(); // Print the exception stack trace for debugging
        }
    }

    public String[] getPurchaseBarChartData() {
        String[] salesArrayForBarChart = new String[12];
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = " select * from dashboardPurchase";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                salesArrayForBarChart[0] = rs.getString("jan");
                salesArrayForBarChart[1] = rs.getString("feb");
                salesArrayForBarChart[2] = rs.getString("mar");
                salesArrayForBarChart[3] = rs.getString("apr");
                salesArrayForBarChart[4] = rs.getString("may");
                salesArrayForBarChart[5] = rs.getString("jun");
                salesArrayForBarChart[6] = rs.getString("jul");
                salesArrayForBarChart[7] = rs.getString("aug");
                salesArrayForBarChart[8] = rs.getString("sep");
                salesArrayForBarChart[9] = rs.getString("oct");
                salesArrayForBarChart[10] = rs.getString("nov");
                salesArrayForBarChart[11] = rs.getString("dece");

            }
            con.close();
            st.close();
        } catch (Exception e) {

        }
        return salesArrayForBarChart;

    }

    public void savePurchase(String[] array) {
        try {
            Connection con = getConnection();
            Statement st1 = con.createStatement();
            String query1 = "truncate table dashboardPurchase";
            int i1 = st1.executeUpdate(query1);
            if (i1 >= 0) {
                Statement st = con.createStatement();
                String query = "INSERT INTO dashboardPurchase(jan, feb, mar, apr, "
                        + "may, jun, jul, aug, sep, oct, nov, dece) VALUES ('" + array[0] + "','" + array[1] + "','" + array[2] + "',"
                        + "'" + array[3] + "','" + array[4] + "','" + array[5] + "','" + array[6] + "'"
                        + ",'" + array[7] + "','" + array[8] + "','" + array[9] + "','" + array[10] + "','" + array[11] + "') ";
                int i = st.executeUpdate(query);
                if (i > 0) {
                    // Do something if the insertion is successful
                }
                con.close();
                st.close();
            }
        } catch (Exception l) {
            l.printStackTrace(); // Print the exception stack trace for debugging
        }
    }

    public Connection getConnection() {
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
