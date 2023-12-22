package adminPanel.client;

import adminPanel.server.EmployeeMast_srvImpl;
import adminPanel.server.Requisition_srvImpl;
import adminPanel.shared.EmployeeMaster_Vld;
import adminPanel.shared.Employee_MastModel;
import adminPanel.shared.Requisition_Model;
import adminPanel.shared.Requisition_Vld;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Requisition extends AdminPanel_Dsg {

    private boolean flag1;
    Requisition_Vld vld = new Requisition_Vld();
    Requisition_srvImpl srv = new Requisition_srvImpl();

    public Requisition() {

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

    public boolean chkVld(JTextField remark) {

        boolean noterror = vld.chkVld(remark);
        return noterror;
    }

    public void employeeMastInitialize(JComboBox<String> requisitionType, JComboBox<String> requisitionBy, JComboBox<String> departmentTo, JComboBox<String> departmentBy,
            JTextField date, JTextField remark) {

        reqModel.setTxtRequisitionType(myLib.sNull(requisitionType.getSelectedItem().toString()));
        reqModel.setTxtRequisitionBy(myLib.sNull(requisitionBy.getSelectedItem().toString()));
        reqModel.setTxtDepartmentBy(myLib.sNull(departmentBy.getSelectedItem().toString()));
        reqModel.setTxtDepartmentTo(myLib.sNull(departmentTo.getSelectedItem().toString()));
        reqModel.setTxtRemark(myLib.sNull(remark.getText()));
        reqModel.setTxtDate(myLib.sNull(date.getText()));

        flag1 = true; // if no error in model set
    }

    public void saveRecord(JComboBox<String> requisitionType, JComboBox<String> requisitionBy, JComboBox<String> departmentTo, JComboBox<String> departmentBy,
            JTextField date, JTextField remark, String moverecCodeforReq, boolean addButtonFlag, ArrayList<Object[]> list) {

        if (flag) {
            employeeMastInitialize(requisitionType, requisitionBy, departmentTo, departmentBy, date, remark);
            if (flag1) {
                if (addButtonFlag) {
                    duplicate = srv.save(reqModel,list);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }

                } else {
                    reqModel.setCode(moverecCodeforReq);
                    duplicate = srv.save(reqModel,list);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                }
                if (reqModel.isConnection()) {
                    if (reqModel.isStatus()) {
                    } else {
                        JOptionPane.showMessageDialog(reqFrame, "Invalid Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(reqFrame, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public ArrayList<Object[]> moverec(String searchString, int searchtype, Requisition_Model model) {
        ArrayList<Object[]> list;
        if (searchtype == 1) {
           list=  srv.searchByCode(searchString, model);
            if (model.isStatus()) {
                return list;
            } else {
                JOptionPane.showMessageDialog(rootpanel, "No Record Found", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        } 
        return null;
    }

    public void deleteRecord(String moverecCodeforReq) {
        reqModel.setCode(moverecCodeforReq);
        srv.delete(reqModel);

    }

    public void prnRecord(String moverecCodeforAreaM) {
//        AreaModel.setCode(moverecCodeforAreaM);
//        srv.print(AreaModel);
    }

}
