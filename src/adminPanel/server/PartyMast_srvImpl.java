package adminPanel.server;

import adminPanel.shared.Area_MastModel;
import adminPanel.shared.Party_MastModel;
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
import myLibrary.shared.UniqueCodeGenerator8ForPartyMaster;
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

public class PartyMast_srvImpl {

    MyLibrary myLib = new MyLibrary();

    public ArrayList<String> AreaList() {
        try {
            ArrayList<String> recievedList = new ArrayList<String>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select area from areamast";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                recievedList.add(rs.getString("area"));
            }
            return recievedList;
        } catch (Exception f) {

            return null;
        }

    }

    public ArrayList<String> cityList() {
        try {
            ArrayList<String> recievedList = new ArrayList<String>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select cityname from indiancities";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                recievedList.add(rs.getString("cityname"));
            }
            return recievedList;
        } catch (Exception f) {

            return null;
        }

    }

    public ArrayList<String> partyList() {
        try {
            ArrayList<String> recievedList = new ArrayList<String>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select party from partymast";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                recievedList.add(rs.getString("party"));
            }
            return recievedList;
        } catch (Exception f) {

            return null;
        }

    }

    public String getCountry(String city) {
        try {
            String country = "";
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select country from indiancities where cityname='" + city + "' ";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                country = rs.getString("country");
            }
            return country;
        } catch (Exception f) {

            return null;
        }

    }

    public boolean save(Party_MastModel model) {

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
                    UniqueCodeGenerator8ForPartyMaster code = new UniqueCodeGenerator8ForPartyMaster();
                    model.setCode(Integer.toString(code.generateCodeforPartyMaster()));
                }

                if (blnAdd) {
                    Statement st1 = con.createStatement();
                    String query1 = "select party,nature from partymast where party='" + model.getParty() + "'AND nature='" + model.getPartyNature() + "'";
                    ResultSet rs = st1.executeQuery(query1);
                    while (rs.next()) {
                        rec = rs.getString("party");
                    }
                    if (model.getParty().equals(rec)) {
                        return true;
                    }
                    
                    
                    String partyCode = model.getPartyNature().substring(0, 3) + model.getCode();

                    Statement st = con.createStatement();
                    String query = "INSERT INTO partymast (code, party, LegalName, DisplayName, partyCode, nature, address, city, country, pincode, partyarea, phone, mobile, "
                            + "gstType, gstIN, PAN, Adhar, TCS_Active, TCSCategory, TDSCategory, referredTo, msme_Type, active, remark, created_on)\n"
                            + "VALUES('" + model.getCode() + "','" + model.getParty() + "','" + model.getPartyLegal() + "','" + model.getPartyDisplay() + "','"+partyCode+"','" + model.getPartyNature() + "',"
                            + "'" + model.getPartyAddress() + "','" + model.getPartyCity() + "','" + model.getPartyCountry() + "','" + model.getPartyPin() + "','" + model.getPartyArea() + "',"
                            + "'" + model.getPartyPhoneNumber() + "','" + model.getPartyMobileNumber() + "','" + model.getPartyGSTType() + "','" + model.getPartyGSTIN() + "',"
                            + "'" + model.getPartyPAN() + "','" + model.getPartyAdhar() + "','" + model.getPartyTCSActive() + "','" + model.getPartyTCScategory() + "','" + model.getPartyTDScategory() + "',"
                            + "'" + model.getPartyReferredTo() + "','" + model.getPartyMSMEType() + "','" + model.getPartyActive() + "','" + model.getPartyRemark() + "','" + formattedDate + "')";
                    int i = st.executeUpdate(query);
                    if (i > 0) {
                        model.setCode("");
                        model.setStatus(true);
                    }
                    st.close();
                    con.close();
                } else {
                    Statement st = con.createStatement();
                    String query = "UPDATE partymast\n"
                            + "SET \n"
                            + "    LegalName = '" + model.getPartyLegal() + "',,\n"
                            + "    DisplayName = '" + model.getPartyDisplay() + "',\n"
                            + "    party = '" + model.getParty() + "',\n"
                            + "    partyCode = '" + model.getPartyCode() + "',\n"
                            + "    nature = '" + model.getPartyNature() + "',\n"
                            + "    address = '" + model.getPartyAddress() + "',\n"
                            + "    city = '" + model.getPartyCity() + "',\n"
                            + "    country = '" + model.getPartyCountry() + "',\n"
                            + "    pincode = '" + model.getPartyPin() + "',\n"
                            + "    partyarea = '" + model.getPartyArea() + "',\n"
                            + "    phone = '" + model.getPartyPhoneNumber() + "',\n"
                            + "    mobile = '" + model.getPartyMobileNumber() + "',\n"
                            + "    gstType = '" + model.getPartyGSTType() + "',\n"
                            + "    gstIN = '" + model.getPartyGSTIN() + "',\n"
                            + "    PAN = '" + model.getPartyPAN() + "',\n"
                            + "    Adhar = '" + model.getPartyAdhar() + "',\n"
                            + "    TCS_Active = '" + model.getPartyTCSActive() + "',\n"
                            + "    TCSCategory = '" + model.getPartyTCScategory() + "',\n"
                            + "    TDSCategory = '" + model.getPartyTDScategory() + "',\n"
                            + "    referredTo = '" + model.getPartyReferredTo() + "',\n"
                            + "    msme_Type = '" + model.getPartyMSMEType() + "',\n"
                            + "    active = '" + model.getPartyActive() + "',\n"
                            + "    remark = '" + model.getPartyRemark() + "',\n"
                            + "    modified_on = '" + formattedDate + "'\n"
                            + " where code ='" + model.getCode() + "'";
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

    public void searchByTxt(String party,String nature, Party_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " select * from partymast where party='" + party + "' and nature='"+nature+"'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    model.setCode(myLib.sNull(rs.getString("code")));
                    model.setParty(myLib.sNull(rs.getString("party")));
                    model.setPartyLegal(myLib.sNull(rs.getString("legalname")));
                    model.setPartyDisplay(myLib.sNull(rs.getString("DisplayName")));
                    model.setPartyCode(myLib.sNull(rs.getString("partyCode")));
                    model.setPartyNature(myLib.sNull(rs.getString("nature")));
                    model.setPartyAddress(myLib.sNull(rs.getString("address")));
                    model.setPartyCity(myLib.sNull(rs.getString("city")));
                    model.setPartyCountry(myLib.sNull(rs.getString("country")));
                    model.setPartyPin(myLib.sNull(rs.getString("pincode")));
                    model.setPartyArea(myLib.sNull(rs.getString("partyarea")));
                    model.setPartyPhoneNumber(myLib.sNull(rs.getString("phone")));
                    model.setPartyMobileNumber(myLib.sNull(rs.getString("mobile")));
                    model.setPartyGSTType(myLib.sNull(rs.getString("gstType")));
                    model.setPartyGSTIN(myLib.sNull(rs.getString("gstIN")));
                    model.setPartyPAN(myLib.sNull(rs.getString("PAN")));
                    model.setPartyAdhar(myLib.sNull(rs.getString("Adhar")));
                    model.setPartyTCSActive(myLib.sNull(rs.getString("TCS_Active")));
                    model.setPartyTCScategory(myLib.sNull(rs.getString("TCSCategory")));
                    model.setPartyTDScategory(myLib.sNull(rs.getString("TDSCategory")));
                    model.setPartyReferredTo(myLib.sNull(rs.getString("referredTo")));
                    model.setPartyMSMEType(myLib.sNull(rs.getString("msme_Type")));
                    model.setPartyActive(myLib.sNull(rs.getString("active")));
                    model.setPartyRemark(myLib.sNull(rs.getString("remark")));
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
       public void searchByCode(String code, Party_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " select * from partyMast where partycode='" + code + "'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    model.setCode(myLib.sNull(rs.getString("code")));
                    model.setCode(myLib.sNull(rs.getString("code")));
                    model.setParty(myLib.sNull(rs.getString("party")));
                    model.setPartyLegal(myLib.sNull(rs.getString("legalname")));
                    model.setPartyDisplay(myLib.sNull(rs.getString("DisplayName")));
                    model.setPartyCode(myLib.sNull(rs.getString("partyCode")));
                    model.setPartyNature(myLib.sNull(rs.getString("nature")));
                    model.setPartyAddress(myLib.sNull(rs.getString("address")));
                    model.setPartyCity(myLib.sNull(rs.getString("city")));
                    model.setPartyCountry(myLib.sNull(rs.getString("country")));
                    model.setPartyPin(myLib.sNull(rs.getString("pincode")));
                    model.setPartyArea(myLib.sNull(rs.getString("partyarea")));
                    model.setPartyPhoneNumber(myLib.sNull(rs.getString("phone")));
                    model.setPartyMobileNumber(myLib.sNull(rs.getString("mobile")));
                    model.setPartyGSTType(myLib.sNull(rs.getString("gstType")));
                    model.setPartyGSTIN(myLib.sNull(rs.getString("gstIN")));
                    model.setPartyPAN(myLib.sNull(rs.getString("PAN")));
                    model.setPartyAdhar(myLib.sNull(rs.getString("Adhar")));
                    model.setPartyTCSActive(myLib.sNull(rs.getString("TCS_Active")));
                    model.setPartyTCScategory(myLib.sNull(rs.getString("TCSCategory")));
                    model.setPartyTDScategory(myLib.sNull(rs.getString("TDSCategory")));
                    model.setPartyReferredTo(myLib.sNull(rs.getString("referredTo")));
                    model.setPartyMSMEType(myLib.sNull(rs.getString("msme_Type")));
                    model.setPartyActive(myLib.sNull(rs.getString("active")));
                    model.setPartyRemark(myLib.sNull(rs.getString("remark")));
                    model.setCreatedOn(myLib.sNull(rs.getString("created_on")));
                    model.setModifiedOn(myLib.sNull(rs.getString("modified_on")));
                    
                    
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


    public void delete(Party_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " delete from partyMast where code='" + model.getCode() + "'";
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

    public void print(Area_MastModel model) {
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
