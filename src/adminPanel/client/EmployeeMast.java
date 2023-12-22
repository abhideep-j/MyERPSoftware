package adminPanel.client;

import adminPanel.server.EmployeeMast_srvImpl;
import adminPanel.shared.EmployeeMaster_Vld;
import adminPanel.shared.Employee_MastModel;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EmployeeMast extends AdminPanel_Dsg {

    private boolean flag1;
    EmployeeMaster_Vld vld = new EmployeeMaster_Vld();
    EmployeeMast_srvImpl srv = new EmployeeMast_srvImpl();

    public EmployeeMast() {

    }

    public String getCountry(String city) {
        String country = srv.getCountry(city);
        return country;
    }

    public ArrayList getCityList() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.cityList());
        return recievedList;
    }

    public ArrayList getDesignationList() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.designationList());
        return recievedList;
    }

    public ArrayList getDepartmentList() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.departmentList());
        return recievedList;
    }

    public boolean chkVld(JTextField name, JTextField displayname, JComboBox<String> gender, JComboBox<String> martialStatus, JComboBox<String> nature, JComboBox<String> designation,
            JComboBox<String> department, JTextField mobile, JTextField adhar, JTextField address, JComboBox<String> city, JTextField country, JTextField pin) {

        boolean noterror = vld.chkVld(name, displayname, gender, martialStatus, nature, designation, department, mobile, adhar, address, city, country, pin);
        return noterror;
    }

    public void employeeMastInitialize(JComboBox<String> mrmrs, JTextField name, JTextField displayname, JComboBox<String> gender,
            JComboBox<String> martialStatus, JTextField spouse, JComboBox<String> religion, JComboBox<String> nature, JComboBox<String> designation,
            JComboBox<String> department, JTextField fatherName, JTextField phonenumber, JTextField mobile, JTextField adhar, JTextField address, JComboBox<String> city,
            JTextField country, JTextField pin, JTextField taddress, JComboBox<String> tcity, JTextField tcountry, JTextField tpin, JTextField DOB, JTextField DOJ,
            JTextField resignation, JComboBox<String> bloodgroup, JTextField PAN, JTextField bankAcc, JTextField pfAcc, JTextField license,
            JTextField passport, JTextField qualification, JComboBox<String> tds, JComboBox<String> active, JTextField remark) {

        employeeModel.setTxtmrmrs(myLib.sNull(mrmrs.getSelectedItem().toString()));
        employeeModel.setTxtGender(myLib.sNull(gender.getSelectedItem().toString()));
        employeeModel.setTxtMaritalStatus(myLib.sNull(martialStatus.getSelectedItem().toString()));
        employeeModel.setTxtReligion(myLib.sNull(religion.getSelectedItem().toString()));
        employeeModel.setTxtNature(myLib.sNull(nature.getSelectedItem().toString()));
        employeeModel.setTxtDesignation(myLib.sNull(designation.getSelectedItem().toString()));
        employeeModel.setTxtDepartment(myLib.sNull(department.getSelectedItem().toString()));
        employeeModel.setTxtCity(myLib.sNull(city.getSelectedItem().toString()));
        employeeModel.setTxtTempCity(myLib.sNull(tcity.getSelectedItem().toString()));
        employeeModel.setTxtBloodGroup(myLib.sNull(bloodgroup.getSelectedItem().toString()));
        employeeModel.setTxtTDS(myLib.sNull(tds.getSelectedItem().toString()));
        employeeModel.setTxtActive(myLib.sNull(active.getSelectedItem().toString()));
        employeeModel.setTxtName(myLib.sNull(name.getText()));
        employeeModel.setTxtDisplayName(myLib.sNull(displayname.getText()));
        employeeModel.setTxtSpouse(myLib.sNull(spouse.getText()));
        employeeModel.setTxtFatherName(myLib.sNull(fatherName.getText()));
        employeeModel.setTxtPhone(myLib.sNull(phonenumber.getText()));
        employeeModel.setTxtMobile(myLib.sNull(mobile.getText()));
        employeeModel.setTxtAdhar(myLib.sNull(adhar.getText()));
        employeeModel.setTxtAddress(myLib.sNull(address.getText()));
        employeeModel.setTxtCountry(myLib.sNull(country.getText()));
        employeeModel.setTxtpinCode(myLib.sNull(pin.getText()));
        employeeModel.setTxtTempAddress(myLib.sNull(taddress.getText()));
        employeeModel.setTxtTempCountry(myLib.sNull(tcountry.getText()));
        employeeModel.setTxtTempPincode(myLib.sNull(tpin.getText()));
        employeeModel.setTxtDOB(myLib.sNull(DOB.getText()));
        employeeModel.setTxtDOJ(myLib.sNull(DOJ.getText()));
        employeeModel.setTxtResignation(myLib.sNull(resignation.getText()));
        employeeModel.setTxtPan(myLib.sNull(PAN.getText()));
        employeeModel.setTxtBank(myLib.sNull(bankAcc.getText()));
        employeeModel.setTxtPF(myLib.sNull(pfAcc.getText()));
        employeeModel.setTxtLicense(myLib.sNull(license.getText()));
        employeeModel.setTxtPassport(myLib.sNull(passport.getText()));
        employeeModel.setTxtQualification(myLib.sNull(qualification.getText()));
        employeeModel.setTxtRemark(myLib.sNull(remark.getText()));

        flag1 = true; // if no error in model set
    }

    public void saveRecord(JComboBox<String> mrmrs, JTextField name, JTextField displayname, JComboBox<String> gender,
            JComboBox<String> martialStatus, JTextField spouse, JComboBox<String> religion, JComboBox<String> nature, JComboBox<String> designation,
            JComboBox<String> department, JTextField fatherName, JTextField phonenumber, JTextField mobile, JTextField adhar, JTextField address, JComboBox<String> city,
            JTextField country, JTextField pin, JTextField taddress, JComboBox<String> tcity, JTextField tcountry, JTextField tpin, JTextField DOB, JTextField DOJ,
            JTextField resignation, JComboBox<String> bloodgroup, JTextField PAN, JTextField bankAcc, JTextField pfAcc, JTextField license,
            JTextField passport, JTextField qualification, JComboBox<String> tds, JComboBox<String> active, JTextField remark, File empImage, String moverecCodeforEmpM,
            boolean addButtonFlag) {

        if (flag) {
            employeeMastInitialize(mrmrs, name, displayname, gender, martialStatus, spouse, religion, nature, designation,
                    department, fatherName, phonenumber, mobile, adhar, address, city,
                    country, pin, taddress, tcity, tcountry, tpin, DOB, DOJ,
                    resignation, bloodgroup, PAN, bankAcc, pfAcc, license,
                    passport, qualification, tds, active, remark);
            if (flag1) {
                if (addButtonFlag) {
                    duplicate = srv.save(employeeModel, empImage);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }

                } else {
                    employeeModel.setCode(moverecCodeforEmpM);
                    duplicate = srv.save(employeeModel, empImage);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                }
                if (employeeModel.isConnection()) {
                    if (employeeModel.isStatus()) {
                    } else {
                        JOptionPane.showMessageDialog(areaMasterFrame, "Invalid Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(areaMasterFrame, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void moverec(String searchString, int searchtype, Employee_MastModel model) {
        if (searchtype == 1) {
            srv.searchByTxt(searchString, model);
            if (model.isStatus()) {

            } else {
                JOptionPane.showMessageDialog(rootpanel, "No Record Found", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        } else if (searchtype == 2) {
            srv.searchByCode(searchString, model);
            if (model.isStatus()) {

            } else {
                JOptionPane.showMessageDialog(rootpanel, "No Record Found", "Not Found", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public void deleteRecord(String moverecCodeforEmpM) {
        employeeModel.setCode(moverecCodeforEmpM);
        srv.delete(employeeModel);

    }

    public void prnRecord(String moverecCodeforAreaM) {
//        AreaModel.setCode(moverecCodeforAreaM);
//        srv.print(AreaModel);
    }

}
