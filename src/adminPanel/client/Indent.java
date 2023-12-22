package adminPanel.client;

import adminPanel.server.Indent_srvImpl;
import adminPanel.shared.Indent_Model;
import adminPanel.shared.Indent_Vld;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Indent extends AdminPanel_Dsg {

    private boolean flag1;
    Indent_Vld vld = new Indent_Vld();
    Indent_srvImpl srv = new Indent_srvImpl();

    public Indent() {

    }

    public String[] getItem(String item) {
        String[] recievedArray = srv.getArray(item);
        return recievedArray;
    }

    public ArrayList getCityList() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.employeeList());
        return recievedList;
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

    public ArrayList getRequisition() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.requisitionList());
        return recievedList;
    }

    public ArrayList<Object[]> getRequisitionDetailsAll(String Requistion, Indent_Model model) {
        ArrayList<Object[]> recievedList = new ArrayList<Object[]>();
        recievedList.addAll(srv.searchByRequisition(Requistion, model));
        return recievedList;
    }

    public boolean chkVld(JTextField remark) {

        boolean noterror = vld.chkVld(remark);
        return noterror;
    }

    public void employeeMastInitialize(JComboBox<String> indentType, JComboBox<String> indentor, JComboBox<String> department, JComboBox<String> requisitonCode,
            JTextField date, JTextField remark) {

        indentModel.setTxtIndentType(myLib.sNull(indentType.getSelectedItem().toString()));
        indentModel.setTxtIndentor(myLib.sNull(indentor.getSelectedItem().toString()));
        indentModel.setTxtIndentDepartment(myLib.sNull(department.getSelectedItem().toString()));
        indentModel.setTxtRequiition(myLib.sNull(requisitonCode.getSelectedItem().toString()));
        indentModel.setTxtRemark(myLib.sNull(remark.getText()));
        indentModel.setTxtDate(myLib.sNull(date.getText()));

        flag1 = true; // if no error in model set
    }

    public void saveRecord(JComboBox<String> indentType, JComboBox<String> indentor, JComboBox<String> department, JComboBox<String> requisitonCode,
            JTextField date, JTextField remark, String moverecCodeforIndent, boolean addButtonFlag, ArrayList<Object[]> list) {

        if (flag) {
            employeeMastInitialize(indentType, indentor, department, requisitonCode, date, remark);
            if (flag1) {
                if (addButtonFlag) {
                    duplicate = srv.save(indentModel, list);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }

                } else {
                    indentModel.setCode(moverecCodeforIndent);
                    duplicate = srv.save(indentModel, list);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                }
                if (indentModel.isConnection()) {
                    if (indentModel.isStatus()) {
                    } else {
                        JOptionPane.showMessageDialog(indentFrame, "Invalid Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(indentFrame, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public ArrayList<Object[]> moverec(String searchString, int searchtype, Indent_Model model) {
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

    public void deleteRecord(String moverecCodeforIndent) {
        indentModel.setCode(moverecCodeforIndent);
        srv.delete(indentModel);

    }

    public void prnRecord(String moverecCodeforAreaM) {
//        AreaModel.setCode(moverecCodeforAreaM);
//        srv.print(AreaModel);
    }

}
