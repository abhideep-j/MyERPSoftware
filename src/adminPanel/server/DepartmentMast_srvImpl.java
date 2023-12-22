package adminPanel.server;

import adminPanel.shared.Department_MastModel;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.WindowConstants;
import myLibrary.shared.DBConnect;
import myLibrary.shared.MyLibrary;
import myLibrary.shared.UniqueCodeGenerator8ForDepartmentMaster;
import myLibrary.shared.UniqueCodeGenerator8ForDesignationMaster;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class DepartmentMast_srvImpl {

    MyLibrary myLib = new MyLibrary();

    public boolean save(Department_MastModel model) {

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd & HH:mm:ss");
        String formattedDate = dateFormat.format(now);
        boolean blnAdd = false;
        String rec = "";

        Connection con = getConnection();
        if (con != null) {
            try {
                if (myLib.sNull(model.getCode()).equals("") || model.getCode().equals(null)) {
                    blnAdd = true;
                }

                if (blnAdd) {
                    Statement st1 = con.createStatement();
                    String query1 = "select department from departmentmast where department='" + model.getTxtDepartment() + "'";
                    ResultSet rs = st1.executeQuery(query1);
                    while (rs.next()) {
                        rec = rs.getString("department");
                    }
                    if (model.getTxtDepartment().equals(rec)) {
                        return true;
                    }
                    UniqueCodeGenerator8ForDepartmentMaster code = new UniqueCodeGenerator8ForDepartmentMaster();
                    model.setCode(Integer.toString(code.generateCodeforDepartmentMaster()));

                    model.setTxtDepCode("DEP" + model.getCode());

                    Statement st = con.createStatement();
                    String query = "INSERT INTO DEPARTMENTMAST(code , department ,shortname ,departmentCode ,\n"
                            + "active ,nature ,created_on ) VALUES ('" + model.getCode() + "','" + model.getTxtDepartment() + "','" + model.getTxtDepartmentShortName() + "',"
                            + "'" + model.getTxtDepCode() + "','" + model.getTxtActive() + "','" + model.getTxtNature() + "','" + formattedDate + "') ";
                    int i = st.executeUpdate(query);
                    if (i > 0) {
                        model.setCode("");
                        model.setStatus(true);
                    }
                    st.close();
                    con.close();
                } else {
                    Statement st = con.createStatement();
                    String query = "Update DEPARTMENTMAST set code='" + model.getCode() + "',department='" + model.getTxtDepartment() + "',"
                            + "shortName='" + model.getTxtDepartmentShortName() + "',departmentcode='" + model.getTxtDepCode() + "',"
                            + "active='" + model.getTxtActive() + "',nature='" + model.getTxtNature() + "',"
                            + "modified_on='" + formattedDate + "' where code ='" + model.getCode() + "'";
                    int i = st.executeUpdate(query);
                    if (i > 0) {
                        model.setCode("");
                        model.setStatus(true);
                    }
                }
            } catch (Exception e) {

            }
            model.setConnection(true);

        } else {
            model.setConnection(false);
        }
        return false;
    }

    public void searchByCode(String code, Department_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " select * from departmentMast where deparmentcode='" + code + "'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    model.setCode(myLib.sNull(rs.getString("code")));
                    model.setTxtDepCode(myLib.sNull(rs.getString("deparmentcode")));
                    model.setTxtDepartment(myLib.sNull(rs.getString("department")));
                    model.setTxtDepartmentShortName(myLib.sNull(rs.getString("shortname")));
                    model.setTxtActive(myLib.sNull(rs.getString("active")));
                    model.setTxtNature(myLib.sNull(rs.getString("nature")));
                    model.setCreatedOn(myLib.sNull(rs.getString("created_on")));
                    model.setModifiedOn(myLib.sNull(rs.getString("modified_on")));
                    model.setStatus(true);

                }

                st.close();
                con.close();
            } catch (Exception e) {

            }
            model.setConnection(true);

        } else {
            model.setConnection(false);
        }
    }

    public void searchByTxt(String department, Department_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " select * from departmentMast where department='" + department + "'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    model.setCode(myLib.sNull(rs.getString("code")));
                    model.setTxtDepCode(myLib.sNull(rs.getString("departmentcode")));
                    model.setTxtDepartment(myLib.sNull(rs.getString("department")));
                    model.setTxtDepartmentShortName(myLib.sNull(rs.getString("shortname")));
                    model.setTxtActive(myLib.sNull(rs.getString("active")));
                    model.setTxtNature(myLib.sNull(rs.getString("nature")));
                    model.setCreatedOn(myLib.sNull(rs.getString("created_on")));
                    model.setModifiedOn(myLib.sNull(rs.getString("modified_on")));
                    model.setStatus(true);
                }
                st.close();
                con.close();
            } catch (Exception e) {

            }
            model.setConnection(true);

        } else {
            model.setConnection(false);
        }
    }

    public void delete(Department_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " delete from departmentMast where code='" + model.getCode() + "'";
                int i = st.executeUpdate(query);
                if (i > 0) {
                    model.setStatus(true);
                } else {
                    model.setStatus(false);
                }
                st.close();
                con.close();
            } catch (Exception e) {

            }
            model.setConnection(true);

        } else {
            model.setConnection(false);
        }

    }

    public void print(Department_MastModel model) {
        try {

            BasicConfigurator.configure();
            PropertyConfigurator.configure("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare8\\src\\reports\\master\\log4j.xml");
//            System.out.println("Current directory: " + System.getProperty("user.dir"));
//            System.out.println("Classpath: " + System.getProperty("java.class.path"));

            DBConnect conn = new DBConnect();
            Connection dbConnection = conn.getConnection(); // Obtain a valid Connection object

            JasperDesign jasdi = JRXmlLoader.load("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare8\\src\\reports\\master\\departmentReport.jrxml"); // Specify your JasperDesign XML file path
            String sql = "SELECT COALESCE(UPPER(department), '') as department,\n"
                    + "       COALESCE(UPPER(departmentcode), '') as code,\n"
                    + "       COALESCE(UPPER(shortname), '') as shortname,\n"
                    + "       COALESCE(UPPER(created_on), '') as createdon,\n"
                    + "       COALESCE(UPPER(modified_on), '') as modifiedon,\n"
                    + "       COALESCE(UPPER(active), '') as active,\n"
                    + "       COALESCE(UPPER(nature), '') as nature\n"
                    + "FROM departmentmast where code ='" + model.getCode() + "'"; // Your SQL query here

            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jasdi.setQuery(newQuery);

            JasperReport js = JasperCompileManager.compileReport(jasdi);
            JasperPrint jp = JasperFillManager.fillReport(js, null, dbConnection); // Pass the Connection object

            JasperViewer jasperViewer = new JasperViewer(jp, false); // Create a JasperViewer object with your JasperPrint
            jasperViewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Set the default close operation

            jasperViewer.setVisible(true); // Show the viewer

        } catch (Exception f) {
            f.printStackTrace();
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
