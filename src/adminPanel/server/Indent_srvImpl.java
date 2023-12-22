package adminPanel.server;

import adminPanel.shared.Employee_MastModel;
import adminPanel.shared.Indent_Model;
import adminPanel.shared.Requisition_Model;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.WindowConstants;
import myLibrary.shared.DBConnect;
import myLibrary.shared.MyLibrary;
import myLibrary.shared.UniqueCodeGenerator8ForIndent;
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

public class Indent_srvImpl {

    MyLibrary myLib = new MyLibrary();

    public ArrayList<String> employeeList() {
        try {
            ArrayList<String> recievedList = new ArrayList<String>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select employeename from employeemast";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                recievedList.add(rs.getString("employeename"));
            }
            return recievedList;
        } catch (Exception f) {

            return null;
        }

    }

    public ArrayList<String> departmentList() {
        try {
            ArrayList<String> recievedList = new ArrayList<String>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select department from departmentmast";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                recievedList.add(rs.getString("department"));
            }
            return recievedList;
        } catch (Exception f) {

            return null;
        }

    }

    public ArrayList<String> requisitionList() {
        try {
            ArrayList<String> recievedList = new ArrayList<String>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select requisitionCode from requisition where indentstatus='no'";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                recievedList.add(rs.getString("requisitionCode"));
            }
            return recievedList;
        } catch (Exception f) {

            return null;
        }

    }

    public String[] getArray(String item) {
        try {
            String[] array = new String[2];
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select properties,sku from itemmast where itemname='" + item + "' ";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                array[0] = rs.getString("properties");
                array[1] = rs.getString("sku");
            }
            return array;
        } catch (Exception f) {

            return null;
        }

    }

    public ArrayList<String> ItemList() {
        try {
            ArrayList<String> recievedList = new ArrayList<String>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select itemname from itemmast";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                recievedList.add(rs.getString("itemname"));
            }
            return recievedList;
        } catch (Exception f) {

            return null;
        }

    }

    public ArrayList<Object[]> searchByRequisition(String Requistion, Indent_Model model) {
        Connection con = getConnection();
        ArrayList<Object[]> retrievedData = new ArrayList<>();

        if (con != null) {

            try {
                Statement st = con.createStatement();
                String query = " select code from requisition where requisitionCode='" + Requistion + "'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    model.setCode(myLib.sNull(rs.getString("code")));
                }
                rs.close();
                st.close();

                String query1 = "select * from requisition_Detail where code = '" + model.getCode() + "'";
                try (PreparedStatement preparedStatement = con.prepareStatement(query1);
                        ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        retrievedData.add(new Object[]{resultSet.getString("item"), resultSet.getString("Property"), resultSet.getString("sku"),
                            resultSet.getString("quantity"), resultSet.getString("remark")});
                    }
                }
                model.setCode("");
                con.close();
            } catch (Exception e) {

            }
            model.setConnection(true);

        } else {
            model.setConnection(false);
        }
        return retrievedData;
    }

    public boolean save(Indent_Model model, ArrayList<Object[]> list) {

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd & HH:mm:ss");
        String formattedDate = dateFormat.format(now);
        boolean blnAdd = false;
        String rec = "";
        String rec2 = "";
//        byte[] empImagebyte = empImageCode;

        Connection con = getConnection();
        if (con != null) {
            try {
                if (myLib.sNull(model.getCode()).equals("") || model.getCode().equals(null)) {
                    blnAdd = true;
                }

                if (blnAdd) {
                    Statement st1 = con.createStatement();
                    String query1 = "select * from Indent where IndentCode='" + myLib.sNull(model.getTxtIndentNo()) + "'";
                    ResultSet rs = st1.executeQuery(query1);
                    while (rs.next()) {
                        rec = rs.getString("IndentCode");
                        if (rec == model.getTxtIndentNo()) {
                            return true;
                        }
                    }

                    UniqueCodeGenerator8ForIndent code = new UniqueCodeGenerator8ForIndent();
                    String generatedCode = Integer.toString(code.generateCodeforIndent());
                    model.setCode(generatedCode);
                    String indentCode = model.getTxtDate().substring(5, 7) + model.getTxtIndentType().substring(0, 3) + model.getTxtDate().substring(0, 4) + "P" + generatedCode;

                    Statement st = con.createStatement();
                    String query = "INSERT INTO indent (code ,indentCode ,indenttype ,indentor \n"
                            + ",department ,\n"
                            + "requisitionCode ,Date ,remark \n"
                            + ",created_on ,enquiryStatus ) "
                            + "VALUES "
                            + "('" + model.getCode() + "','" + indentCode + "','" + model.getTxtIndentType() + "','" + model.getTxtIndentor() + "',"
                            + "'" + model.getTxtIndentDepartment() + "','" + model.getTxtRequiition() + "','" + model.getTxtDate() + "',"
                            + "'" + model.getTxtRemark() + "','" + formattedDate + "','no'  );";

                    int i = st.executeUpdate(query);

                    if (i > 0) {
                        st.close();
                        model.setStatus(true);
                    }
                } else {
                    Statement st = con.createStatement();

                    String query = "UPDATE indent "
                            + "SET indenttype = '" + model.getTxtIndentType() + "', "
                            + "indentor = '" + model.getTxtIndentor() + "', "
                            + "department = '" + model.getTxtIndentDepartment() + "', "
                            + "requisitionCode = '" + model.getTxtRequiition() + "', "
                            + "Date = '" + model.getTxtDate() + "', "
                            + "remark = '" + model.getTxtRemark() + "', "
                            + "modified_on = '" + formattedDate + "' "
                            + "WHERE code = '" + model.getCode() + "';";

                    int i = st.executeUpdate(query);

                    if (i > 0) {
                        {
                            model.setStatus(true);
                        }
                    }
                }
                Statement st1 = con.createStatement();
                String query14 = "delete from indent_Detail where code='" + model.getCode() + "'";
                int it = st1.executeUpdate(query14);

                if (it > 0 || it == 0) {
                    String query12 = "INSERT INTO indent_Detail (code ,item ,property ,sku \n"
                            + ",quantity ,remark ) VALUES (?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = con.prepareStatement(query12)) {
                        // Insert each row into the database
                        for (Object[] row : list) {
                            // Assuming your model is accessible and has a method like getTxtCode()
                            // Adjust the following line according to your actual model structure
                            String codeValue = model.getCode();

                            // Set the values for other columns
                            preparedStatement.setString(1, codeValue);
                            preparedStatement.setString(2, (String) row[0]);
                            preparedStatement.setString(3, (String) row[1]);
                            preparedStatement.setString(4, (String) row[2]);
                            preparedStatement.setString(5, (String) row[3]);
                            preparedStatement.setString(6, (String) row[4]);

                            preparedStatement.executeUpdate();
                        }
                    }
                    Statement st2 = con.createStatement();
                    String query15 = "update requisition set indentstatus='yes' where requisitionCode='"+model.getTxtRequiition().trim()+"'";
                    int i1 = st2.executeUpdate(query15);

                    model.setCode("");
                    model.setStatus(true);
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.setConnection(true);

        } else {
            model.setConnection(false);
        }

        return false;
    }

    public ArrayList<Object[]> searchByCode(String code, Indent_Model model) {
        Connection con = getConnection();
        ArrayList<Object[]> retrievedData = new ArrayList<>();

        if (con != null) {

            try {
                Statement st = con.createStatement();
                String query = " select * from indent where indentCode='" + code + "'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    model.setCode(myLib.sNull(rs.getString("code")));
                    model.setTxtIndentDepartment(myLib.sNull(rs.getString("department")));
                    model.setTxtIndentor(myLib.sNull(rs.getString("indentor")));
                    model.setTxtIndentType(myLib.sNull(rs.getString("indenttype")));
                    model.setTxtRequiition(myLib.sNull(rs.getString("requisitioncode")));
                    model.setTxtDate(myLib.sNull(rs.getString("date")));
                    model.setTxtIndentNo(myLib.sNull(rs.getString("indentCode")));
                    model.setTxtRemark(myLib.sNull(rs.getString("remark")));
                    model.setModifiedOn(myLib.sNull(rs.getString("modified_on")));
                    model.setCreatedOn(myLib.sNull(rs.getString("created_on")));
                    model.setStatus(true);
                }
                rs.close();
                st.close();

                String query1 = "select * from indent_Detail where code = '" + model.getCode() + "'";
                try (PreparedStatement preparedStatement = con.prepareStatement(query1);
                        ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Loop through the result set and add rows to the data list
                    while (resultSet.next()) {
                        retrievedData.add(new Object[]{resultSet.getString("item"), resultSet.getString("Property"), resultSet.getString("sku"),
                            resultSet.getString("quantity"), resultSet.getString("remark")});
                    }
                }

                con.close();
            } catch (Exception e) {

            }
            model.setConnection(true);

        } else {
            model.setConnection(false);
        }
        return retrievedData;
    }

    public void delete(Indent_Model model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " delete from indent where code='" + model.getCode() + "'";
                int i = st.executeUpdate(query);
                st.close();

                Statement st1 = con.createStatement();
                String query1 = "delete from indent_detail where code ='" + model.getCode() + "'";
                int i1 = st1.executeUpdate(query1);
                if (i1 > 0) {
                    model.setStatus(true);
                } else {
                    model.setStatus(false);
                }
                con.close();
            } catch (Exception e) {

            }
            model.setConnection(true);

        } else {
            model.setConnection(false);
        }

    }

    public void print(Employee_MastModel model) {
        try {

            BasicConfigurator.configure();
            PropertyConfigurator.configure("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare8\\src\\reports\\master\\log4j.xml");
//            System.out.println("Current directory: " + System.getProperty("user.dir"));
//            System.out.println("Classpath: " + System.getProperty("java.class.path"));

            DBConnect conn = new DBConnect();
            Connection dbConnection = conn.getConnection(); // Obtain a valid Connection object

            JasperDesign jasdi = JRXmlLoader.load("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare8\\src\\reports\\master\\areaReport.jrxml"); // Specify your JasperDesign XML file path
            String sql = "SELECT COALESCE(UPPER(area), '') as area,\n"
                    + "       COALESCE(UPPER(parentarea), '') as parentarea,\n"
                    + "       COALESCE(UPPER(created_on), '') as createdon,\n"
                    + "       COALESCE(UPPER(modified_on), '') as modifiedon\n"
                    + "FROM areamast where code ='" + model.getCode() + "'"; // Your SQL query here

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
