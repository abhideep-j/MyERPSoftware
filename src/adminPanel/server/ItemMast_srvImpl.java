package adminPanel.server;

import adminPanel.shared.Item_MastModel;
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
import myLibrary.shared.UniqueCodeGenerator8ForItemMaster;
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

public class ItemMast_srvImpl {

    MyLibrary myLib = new MyLibrary();

    public ArrayList<String> parentItemCatList() {
        try {
            ArrayList<String> recievedList = new ArrayList<String>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select itemCategory from itemcategorymast";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                recievedList.add(rs.getString("itemcategory"));
            }
            return recievedList;
        } catch (Exception f) {

            return null;
        }

    }

    public boolean save(Item_MastModel model) {

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
                    String query1 = "select itemname from itemmast where itemname='" + model.getTxtItem() + "'";
                    ResultSet rs = st1.executeQuery(query1);
                    while (rs.next()) {
                        rec = rs.getString("itemname");
                    }
                    if (model.getTxtItem().equals(rec)) {
                        return true;
                    }
                    UniqueCodeGenerator8ForItemMaster code = new UniqueCodeGenerator8ForItemMaster();
                    model.setCode(Integer.toString(code.generateCodeforItemMaster()));

                    String ItemCode = model.getTxtCategory().substring(0, 2) + model.getCode();

                    Statement st = con.createStatement();
                    String query = "INSERT INTO itemmast(code,itemname,itemcode,description,properties,itemcategory,hsn_sac,indentrequired,porequired,returnable,"
                            + "gstnature,gstbasedon,gsttype,sku,purchaseunit,salesunit,itemactive,remark,created_on) VALUES('" + model.getCode() + "'"
                            + ",'" + model.getTxtItem() + "','" + ItemCode + "','" + model.getTxtDescription() + "','" + model.getTxtProperties() + "'"
                            + ",'" + model.getTxtCategory() + "'"
                            + ",'" + model.getTxtHSN_SAC() + "','" + model.getTxtIndentReq() + "','" + model.getTxtPOReq() + "','" + model.getTxtReturnable() + "'"
                            + ",'" + model.getTxtGSTNature() + "','" + model.getTxtGSTbasedOn() + "','" + model.getTxtGSTType() + "','" + model.getTxtSKU() + "'"
                            + ",'" + model.getTxtpurchaseUnit() + "','" + model.getTxtSalesUnit() + "','" + model.getTxtActive() + "','" + model.getTxtRemark() + "'"
                            + ",'" + formattedDate + "')";
                    int i = st.executeUpdate(query);
                    if (i > 0) {
                        model.setCode("");
                        model.setStatus(true);
                    }
                    st.close();
                    con.close();
                } else {
                    Statement st = con.createStatement();
                    String query = "UPDATE itemmast SET "
                            + "itemname = '" + model.getTxtItem() + "', "
                            + "description = '" + model.getTxtDescription() + "', "
                            + "properties = '" + model.getTxtProperties() + "', "
                            + "itemcategory = '" + model.getTxtCategory() + "', "
                            + "hsn_sac = '" + model.getTxtHSN_SAC() + "', "
                            + "indentrequired = '" + model.getTxtIndentReq() + "', "
                            + "porequired = '" + model.getTxtPOReq() + "', "
                            + "returnable = '" + model.getTxtReturnable() + "', "
                            + "gstnature = '" + model.getTxtGSTNature() + "', "
                            + "gstbasedon = '" + model.getTxtGSTbasedOn() + "', "
                            + "gsttype = '" + model.getTxtGSTType() + "', "
                            + "sku = '" + model.getTxtSKU() + "', "
                            + "purchaseunit = '" + model.getTxtpurchaseUnit() + "', "
                            + "salesunit = '" + model.getTxtSalesUnit() + "', "
                            + "itemactive = '" + model.getTxtActive() + "', "
                            + "remark = '" + model.getTxtRemark() + "', "
                            + "modified_on = '" + formattedDate + "' "
                            + "WHERE code = '" + model.getCode() + "'";

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

    public void searchByTxt(String item, Item_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " select * from itemMast where itemname='" + item + "'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    model.setCode(myLib.sNull(rs.getString("code")));
                    model.setTxtItem(myLib.sNull(rs.getString("itemname")));
                    model.setTxtItemCode(myLib.sNull(rs.getString("itemcode")));
                    model.setTxtDescription(myLib.sNull(rs.getString("description")));
                    model.setTxtProperties(myLib.sNull(rs.getString("properties")));
                    model.setTxtCategory(myLib.sNull(rs.getString("itemcategory")));
                    model.setTxtHSN_SAC(myLib.sNull(rs.getString("HSN_SAC")));
                    model.setTxtIndentReq(myLib.sNull(rs.getString("indentrequired")));
                    model.setTxtPOReq(myLib.sNull(rs.getString("porequired")));
                    model.setTxtReturnable(myLib.sNull(rs.getString("returnable")));
                    model.setTxtGSTNature(myLib.sNull(rs.getString("gstnature")));
                    model.setTxtGSTbasedOn(myLib.sNull(rs.getString("gstbasedon")));
                    model.setTxtGSTType(myLib.sNull(rs.getString("gsttype")));
                    model.setTxtSKU(myLib.sNull(rs.getString("sku")));
                    model.setTxtpurchaseUnit(myLib.sNull(rs.getString("purchaseunit")));
                    model.setTxtSalesUnit(myLib.sNull(rs.getString("salesunit")));
                    model.setTxtActive(myLib.sNull(rs.getString("itemactive")));
                    model.setTxtRemark(myLib.sNull(rs.getString("remark")));
                    
                    
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
    public void searchByCode(String code, Item_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " select * from itemMast where itemcode='" + code + "'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    model.setCode(myLib.sNull(rs.getString("code")));
                    model.setTxtItem(myLib.sNull(rs.getString("itemname")));
                    model.setTxtItemCode(myLib.sNull(rs.getString("itemcode")));
                    model.setTxtDescription(myLib.sNull(rs.getString("description")));
                    model.setTxtProperties(myLib.sNull(rs.getString("properties")));
                    model.setTxtCategory(myLib.sNull(rs.getString("itemcategory")));
                    model.setTxtHSN_SAC(myLib.sNull(rs.getString("HSN_SAC")));
                    model.setTxtIndentReq(myLib.sNull(rs.getString("indentrequired")));
                    model.setTxtPOReq(myLib.sNull(rs.getString("porequired")));
                    model.setTxtReturnable(myLib.sNull(rs.getString("returnable")));
                    model.setTxtGSTNature(myLib.sNull(rs.getString("gstnature")));
                    model.setTxtGSTbasedOn(myLib.sNull(rs.getString("gstbasedon")));
                    model.setTxtGSTType(myLib.sNull(rs.getString("gsttype")));
                    model.setTxtSKU(myLib.sNull(rs.getString("sku")));
                    model.setTxtpurchaseUnit(myLib.sNull(rs.getString("purchaseunit")));
                    model.setTxtSalesUnit(myLib.sNull(rs.getString("salesunit")));
                    model.setTxtActive(myLib.sNull(rs.getString("itemactive")));
                    model.setTxtRemark(myLib.sNull(rs.getString("remark")));
                    
                    
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

    public void delete(Item_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " delete from itemmast where code='" + model.getCode() + "'";
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

    public void print(Item_MastModel model) {
        try {

//            BasicConfigurator.configure();
//            PropertyConfigurator.configure("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare8\\src\\reports\\master\\log4j.xml");
////            System.out.println("Current directory: " + System.getProperty("user.dir"));
////            System.out.println("Classpath: " + System.getProperty("java.class.path"));
//
//            DBConnect conn = new DBConnect();
//            Connection dbConnection = conn.getConnection(); // Obtain a valid Connection object
//
//            JasperDesign jasdi = JRXmlLoader.load("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare8\\src\\reports\\master\\areaReport.jrxml"); // Specify your JasperDesign XML file path
//            String sql = "SELECT COALESCE(UPPER(area), '') as area,\n"
//                    + "       COALESCE(UPPER(parentarea), '') as parentarea,\n"
//                    + "       COALESCE(UPPER(created_on), '') as createdon,\n"
//                    + "       COALESCE(UPPER(modified_on), '') as modifiedon\n"
//                    + "FROM areamast where code ='" + model.getCode() + "'"; // Your SQL query here
//
//            JRDesignQuery newQuery = new JRDesignQuery();
//            newQuery.setText(sql);
//            jasdi.setQuery(newQuery);
//
//            JasperReport js = JasperCompileManager.compileReport(jasdi);
//            JasperPrint jp = JasperFillManager.fillReport(js, null, dbConnection); // Pass the Connection object
//
//            JasperViewer jasperViewer = new JasperViewer(jp, false); // Create a JasperViewer object with your JasperPrint
//            jasperViewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Set the default close operation
//
//            jasperViewer.setVisible(true); // Show the viewer

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
