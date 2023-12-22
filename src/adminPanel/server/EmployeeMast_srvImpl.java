package adminPanel.server;

import adminPanel.shared.Employee_MastModel;
import java.io.File;
import java.io.FileInputStream;
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
import myLibrary.shared.UniqueCodeGenerator8ForEmployeeMaster;
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

public class EmployeeMast_srvImpl {

    MyLibrary myLib = new MyLibrary();

    public ArrayList<String> cityList() {
        try {
            ArrayList<String> recievedList = new ArrayList<String>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select cityname,country from indiancities";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                recievedList.add(rs.getString("cityname"));
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

    public ArrayList<String> designationList() {
        try {
            ArrayList<String> recievedList = new ArrayList<String>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select designation from designationmast";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                recievedList.add(rs.getString("designation"));
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

    public boolean save(Employee_MastModel model, File empImage) {

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
                    String query1 = "select employeename,fathername from employeemast where employeename='" + model.getTxtName() + "'";
                    ResultSet rs = st1.executeQuery(query1);
                    while (rs.next()) {
                        rec = rs.getString("employeename");
                        rec2 = rs.getString("fathername");
                    }
                    if (model.getTxtName().equals(rec) && model.getTxtFatherName().equals(rec2)) {
                        return true;
                    }
                    UniqueCodeGenerator8ForEmployeeMaster code = new UniqueCodeGenerator8ForEmployeeMaster();
                    String generatedCode = Integer.toString(code.generateCodeforEmployeeMaster());
                    model.setCode(generatedCode);
                    String empid = "EMP_" + generatedCode;

                    Statement st = con.createStatement();
                    String query = "INSERT INTO EmployeeMast (code, mrmrs, EmployeeName, DisplayName, Gender, empId, Designation, Department, "
                            + "MaritalStatus, spouse, FatherName, PhoneNo, MobileNo, Adhar, City, country, Address, Pincode, tAddress, tCity, "
                            + "tcountry, tPincode, Dob, Doj, Resignation, Pan, BankAcc, PFAcc, License, Passport, Qualification, Religion, "
                            + "Nature, bloodgroup, TDS, Active, Remark, created_on) "
                            + "VALUES "
                            + "('" + model.getCode() + "','" + model.getTxtmrmrs() + "','" + model.getTxtName() + "','" + model.getTxtDisplayName() + "',"
                            + "'" + model.getTxtGender() + "','" + empid + "','" + model.getTxtDesignation() + "','" + model.getTxtDepartment() + "',"
                            + "'" + model.getTxtMaritalStatus() + "','" + model.getTxtSpouse() + "','" + model.getTxtFatherName() + "',"
                            + "'" + model.getTxtPhone() + "','" + model.getTxtMobile() + "','" + model.getTxtAdhar() + "','" + model.getTxtCity() + "',"
                            + "'" + model.getTxtCountry() + "','" + model.getTxtAddress() + "','" + model.getTxtpinCode() + "','" + model.getTxtTempAddress() + "',"
                            + "'" + model.getTxtTempCity() + "','" + model.getTxtTempCountry() + "','" + model.getTxtTempPincode() + "',"
                            + "'" + model.getTxtDOB() + "','" + model.getTxtDOJ() + "','" + model.getTxtResignation() + "','" + model.getTxtPan() + "','" + model.getTxtBank() + "',"
                            + "'" + model.getTxtPF() + "','" + model.getTxtLicense() + "','" + model.getTxtPassport() + "','" + model.getTxtQualification() + "',"
                            + "'" + model.getTxtReligion() + "','" + model.getTxtNature() + "','" + model.getTxtBloodGroup() + "','" + model.getTxtTDS() + "',"
                            + "'" + model.getTxtActive() + "','" + model.getTxtRemark() + "','" + formattedDate + "');";

                    int i = st.executeUpdate(query);
                    

                    if(empImage != null){
                    FileInputStream fis = new FileInputStream(empImage);
                    PreparedStatement ps = con.prepareStatement("UPDATE EmployeeMast SET employeeimage = ? WHERE code = ?");
                    ps.setBinaryStream(1, fis, (int) empImage.length());
                    ps.setString(2, model.getCode());
                    ps.executeUpdate();
                    ps.close();
                    fis.close();
                    }

                    st.close();
                    con.close();
                    if (i > 0) {
                        model.setCode("");
                        model.setStatus(true);
                    }
                } else {
                    Statement st = con.createStatement();

                    String query = "UPDATE EmployeeMast "
                            + "SET "
                            + "mrmrs = '" + model.getTxtmrmrs() + "', "
                            + "EmployeeName = '" + model.getTxtName() + "', "
                            + "DisplayName = '" + model.getTxtDisplayName() + "', "
                            + "Gender = '" + model.getTxtGender() + "', "
                            + "Designation = '" + model.getTxtDesignation() + "', "
                            + "Department = '" + model.getTxtDepartment() + "', "
                            + "MaritalStatus = '" + model.getTxtMaritalStatus() + "', "
                            + "spouse = '" + model.getTxtSpouse() + "', "
                            + "FatherName = '" + model.getTxtFatherName() + "', "
                            + "PhoneNo = '" + model.getTxtPhone() + "', "
                            + "MobileNo = '" + model.getTxtMobile() + "', "
                            + "Adhar = '" + model.getTxtAdhar() + "', "
                            + "City = '" + model.getTxtCity() + "', "
                            + "country = '" + model.getTxtCountry() + "', "
                            + "Address = '" + model.getTxtAddress() + "', "
                            + "Pincode = '" + model.getTxtpinCode() + "', "
                            + "tAddress = '" + model.getTxtTempAddress() + "', "
                            + "tCity = '" + model.getTxtTempCity() + "', "
                            + "tcountry = '" + model.getTxtTempCountry() + "', "
                            + "tPincode = '" + model.getTxtTempPincode() + "', "
                            + "Dob = '" + model.getTxtDOB() + "', "
                            + "Doj = '" + model.getTxtDOJ() + "', "
                            + "Resignation = '" + model.getTxtResignation() + "', "
                            + "Pan = '" + model.getTxtPan() + "', "
                            + "BankAcc = '" + model.getTxtBank() + "', "
                            + "PFAcc = '" + model.getTxtPF() + "', "
                            + "License = '" + model.getTxtLicense() + "', "
                            + "Passport = '" + model.getTxtPassport() + "', "
                            + "Qualification = '" + model.getTxtQualification() + "', "
                            + "Religion = '" + model.getTxtReligion() + "', "
                            + "Nature = '" + model.getTxtNature() + "', "
                            + "bloodgroup = '" + model.getTxtBloodGroup() + "', "
                            + "TDS = '" + model.getTxtTDS() + "', "
                            + "Active = '" + model.getTxtActive() + "', "
                            + "Remark = '" + model.getTxtRemark() + "', "
                            + "created_on = '" + formattedDate + "' "
                            + "WHERE code = '" + model.getCode() + "';";

                    int i = st.executeUpdate(query);

                   if(empImage != null){
                    FileInputStream fis = new FileInputStream(empImage);
                    PreparedStatement ps = con.prepareStatement("UPDATE EmployeeMast SET employeeimage = ? WHERE code = ?");
                    ps.setBinaryStream(1, fis, (int) empImage.length());
                    ps.setString(2, model.getCode());
                    ps.executeUpdate();
                    ps.close();
                    fis.close();
                    }
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

    public void searchByCode(String code, Employee_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
//            code, mrmrs, EmployeeName, DisplayName, Gender, empId, Designation,
// Department, MaritalStatus, spouse, FatherName, PhoneNo, MobileNo, Adhar, City, country, Address, Pincode, tAddress, 
// tCity, tcountry, tPincode, Dob, Doj, Resignation, Pan, BankAcc, PFAcc, License, Passport, Qualification, Religion, Nature
// , bloodgroup, TDS, Active, Remark, employeeimage, created_on
            try {
                Statement st = con.createStatement();
                String query = " select * from employeemast where empid='" + code + "'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    model.setEmpImage((rs.getBytes("employeeimage")));
//                    model.setEmpImage((rs.getBytes("employeeimage")));

                    model.setTxtRemark(myLib.sNull(rs.getString("remark")));
                    model.setTxtActive(myLib.sNull(rs.getString("Active")));
                    model.setTxtTDS(myLib.sNull(rs.getString("tds")));
                    model.setTxtBloodGroup(myLib.sNull(rs.getString("bloodgroup")));
                    model.setTxtNature(myLib.sNull(rs.getString("nature")));
                    model.setTxtReligion(myLib.sNull(rs.getString("religion")));
                    model.setTxtQualification(myLib.sNull(rs.getString("Qualification")));
                    model.setTxtPassport(myLib.sNull(rs.getString("passport")));
                    model.setTxtLicense(myLib.sNull(rs.getString("license")));
                    model.setTxtPF(myLib.sNull(rs.getString("PFAcc")));
                    model.setTxtBank(myLib.sNull(rs.getString("bankacc")));
                    model.setTxtPan(myLib.sNull(rs.getString("pan")));
                    model.setCode(myLib.sNull(rs.getString("code")));
                    model.setTxtmrmrs(myLib.sNull(rs.getString("mrmrs")));
                    model.setTxtName(myLib.sNull(rs.getString("employeename")));
                    model.setTxtGender(myLib.sNull(rs.getString("displayname")));
                    model.setTxtGender(myLib.sNull(rs.getString("empid")));
                    model.setTxtDesignation(myLib.sNull(rs.getString("designation")));
                    model.setTxtDepartment(myLib.sNull(rs.getString("department")));
                    model.setTxtMaritalStatus(myLib.sNull(rs.getString("maritalstatus")));
                    model.setTxtSpouse(myLib.sNull(rs.getString("spouse")));
                    model.setTxtFatherName(myLib.sNull(rs.getString("fathername")));
                    model.setTxtPhone(myLib.sNull(rs.getString("phoneno")));
                    model.setTxtMobile(myLib.sNull(rs.getString("mobileno")));
                    model.setTxtAdhar(myLib.sNull(rs.getString("Adhar")));
                    model.setTxtCity(myLib.sNull(rs.getString("City")));
                    model.setTxtCountry(myLib.sNull(rs.getString("country")));
                    model.setTxtAddress(myLib.sNull(rs.getString("address")));
                    model.setTxtpinCode(myLib.sNull(rs.getString("pincode")));
                    model.setTxtTempAddress(myLib.sNull(rs.getString("taddress")));
                    model.setTxtTempCity(myLib.sNull(rs.getString("tcity")));
                    model.setTxtTempCountry(myLib.sNull(rs.getString("tcountry")));
                    model.setTxtTempPincode(myLib.sNull(rs.getString("tpincode")));
                    model.setTxtDOB(myLib.sNull(rs.getString("dob")));
                    model.setTxtDOJ(myLib.sNull(rs.getString("doj")));
                    model.setTxtResignation(myLib.sNull(rs.getString("resignation")));
                    model.setModifiedOn(myLib.sNull(rs.getString("modified_on")));
                    model.setCreatedOn(myLib.sNull(rs.getString("created_on")));
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

    public void searchByTxt(String employeename, Employee_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
//            code, mrmrs, EmployeeName, DisplayName, Gender, empId, Designation,
// Department, MaritalStatus, spouse, FatherName, PhoneNo, MobileNo, Adhar, City, country, Address, Pincode, tAddress, 
// tCity, tcountry, tPincode, Dob, Doj, Resignation, Pan, BankAcc, PFAcc, License, Passport, Qualification, Religion, Nature
// , bloodgroup, TDS, Active, Remark, employeeimage, created_on
            try {
                Statement st = con.createStatement();
                String query = " select * from employeemast where employeename='" + employeename + "'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    model.setEmpImage((rs.getBytes("employeeimage")));
                    model.setTxtRemark(myLib.sNull(rs.getString("remark")));
                    model.setTxtActive(myLib.sNull(rs.getString("Active")));
                    model.setTxtTDS(myLib.sNull(rs.getString("tds")));
                    model.setTxtBloodGroup(myLib.sNull(rs.getString("bloodgroup")));
                    model.setTxtNature(myLib.sNull(rs.getString("nature")));
                    model.setTxtReligion(myLib.sNull(rs.getString("religion")));
                    model.setTxtQualification(myLib.sNull(rs.getString("Qualification")));
                    model.setTxtGender(myLib.sNull(rs.getString("gender")));
                    model.setTxtPassport(myLib.sNull(rs.getString("passport")));
                    model.setTxtLicense(myLib.sNull(rs.getString("license")));
                    model.setTxtPF(myLib.sNull(rs.getString("PFAcc")));
                    model.setTxtBank(myLib.sNull(rs.getString("bankacc")));
                    model.setTxtPan(myLib.sNull(rs.getString("pan")));
                    model.setCode(myLib.sNull(rs.getString("code")));
                    model.setTxtmrmrs(myLib.sNull(rs.getString("mrmrs")));
                    model.setTxtName(myLib.sNull(rs.getString("employeename")));
                    model.setTxtDisplayName(myLib.sNull(rs.getString("displayname")));
                    model.setTxtEmpID(myLib.sNull(rs.getString("empid")));
                    model.setTxtDesignation(myLib.sNull(rs.getString("designation")));
                    model.setTxtDepartment(myLib.sNull(rs.getString("department")));
                    model.setTxtMaritalStatus(myLib.sNull(rs.getString("maritalstatus")));
                    model.setTxtSpouse(myLib.sNull(rs.getString("spouse")));
                    model.setTxtFatherName(myLib.sNull(rs.getString("fathername")));
                    model.setTxtPhone(myLib.sNull(rs.getString("phoneno")));
                    model.setTxtMobile(myLib.sNull(rs.getString("mobileno")));
                    model.setTxtAdhar(myLib.sNull(rs.getString("Adhar")));
                    model.setTxtCity(myLib.sNull(rs.getString("City")));
                    model.setTxtCountry(myLib.sNull(rs.getString("country")));
                    model.setTxtAddress(myLib.sNull(rs.getString("address")));
                    model.setTxtpinCode(myLib.sNull(rs.getString("pincode")));
                    model.setTxtTempAddress(myLib.sNull(rs.getString("taddress")));
                    model.setTxtTempCity(myLib.sNull(rs.getString("tcity")));
                    model.setTxtTempCountry(myLib.sNull(rs.getString("tcountry")));
                    model.setTxtTempPincode(myLib.sNull(rs.getString("tpincode")));
                    model.setTxtDOB(myLib.sNull(rs.getString("dob")));
                    model.setTxtDOJ(myLib.sNull(rs.getString("doj")));
                    model.setTxtResignation(myLib.sNull(rs.getString("resignation")));
                    model.setModifiedOn(myLib.sNull(rs.getString("modified_on")));
                    model.setCreatedOn(myLib.sNull(rs.getString("created_on")));
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

    public void delete(Employee_MastModel model) {
        Connection con = getConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                String query = " delete from employeemast where code='" + model.getCode() + "'";
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
