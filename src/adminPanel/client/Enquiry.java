package adminPanel.client;

import adminPanel.server.Enquiry_srvImpl;
import adminPanel.server.Indent_srvImpl;
import adminPanel.shared.Enquiry_Model;
import adminPanel.shared.Indent_Model;
import adminPanel.shared.Indent_Vld;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Enquiry extends AdminPanel_Dsg {

    private boolean flag1;
    Indent_Vld vld = new Indent_Vld();
    Enquiry_srvImpl srv = new Enquiry_srvImpl();

    public Enquiry() {

    }

    
    public String[] getItem(String item) {
        String[] recievedArray = srv.getArray(item);
        return recievedArray;
    }

    public ArrayList getPartyList() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.partyList());
        return recievedList;
    }
    
    public String getPartyCity( String DisplayName) {
        String city= "";
        city =(srv.partyCity(DisplayName));
        return city;
    }

    public ArrayList getItemList() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.ItemList());
        return recievedList;
    }

    public ArrayList getDepartmentList() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.departmentList());
        return recievedList;
    }

    public ArrayList getIndent() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.indentList());
        return recievedList;
    }

    public ArrayList<Object[]> getIndentDetailsAll(String indent, Enquiry_Model model) {
        ArrayList<Object[]> recievedList = new ArrayList<Object[]>();
        recievedList.addAll(srv.searchByIndent(indent, model));
        return recievedList;
    }

    public boolean chkVld(JTextField remark) {

        boolean noterror = vld.chkVld(remark);
        return noterror;
    }

    public void employeeMastInitialize(JComboBox<String> enquiryType, JComboBox<String> department, JComboBox<String> indentCode,
            JTextField date, JTextField remark) {

        enquiryModel.setTxtEnquiryType(myLib.sNull(enquiryType.getSelectedItem().toString()));
        enquiryModel.setTxtDepartment(myLib.sNull(department.getSelectedItem().toString()));
        enquiryModel.setTxtIndent(myLib.sNull(indentCode.getSelectedItem().toString()));
        enquiryModel.setTxtRemark(myLib.sNull(remark.getText()));
        enquiryModel.setTxtDate(myLib.sNull(date.getText()));

        flag1 = true; // if no error in model set
    }

    public void saveRecord(JComboBox<String> enquiryType, JComboBox<String> department, JComboBox<String> indentCode,
            JTextField date, JTextField remark, String moverecCodeforEnquiry, boolean addButtonFlag, ArrayList<Object[]> itemList,ArrayList<Object[]> supplierList) {

        if (flag) {
            employeeMastInitialize(enquiryType, department, indentCode, date, remark);
            if (flag1) {
                if (addButtonFlag) {
                    duplicate = srv.save(enquiryModel,itemList,supplierList );
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }

                } else {
                    enquiryModel.setCode(moverecCodeforEnquiry);
                    duplicate = srv.save(enquiryModel,itemList,supplierList );
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                }
                if (enquiryModel.isConnection()) {
                    if (enquiryModel.isStatus()) {
                    } else {
                        JOptionPane.showMessageDialog(enquiryFrame, "Invalid Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(enquiryFrame, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public ArrayList<Object[]> moverec(String searchString, int searchtype, Enquiry_Model model) {
        ArrayList<Object[]> list;
        if (searchtype == 1) {
            list = srv.searchByCode(searchString, model);
            if (model.isStatus()) {
                return list;
            } else {
                JOptionPane.showMessageDialog(rootpanel, "No Record Found", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public void deleteRecord(String moverecCodeforEnquiry) {
        enquiryModel.setCode(moverecCodeforEnquiry);
        srv.delete(enquiryModel);

    }

    public void prnRecord(String moverecCodeforAreaM) {
//        AreaModel.setCode(moverecCodeforAreaM);
//        srv.print(AreaModel);
    }

}
