package adminPanel.client;

import adminPanel.server.DepartmentMast_srvImpl;
import adminPanel.shared.DepartmentMast_Vld;
import adminPanel.shared.Department_MastModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DepartmentMast extends AdminPanel_Dsg {

    private boolean flag1;
    DepartmentMast_Vld vld = new DepartmentMast_Vld();
    DepartmentMast_srvImpl srv = new DepartmentMast_srvImpl();

    public DepartmentMast() {

    }

    public boolean chkVld(JTextField department, JTextField departmentShortname) {
        boolean noterror = vld.chkVld(department, departmentShortname);
        return noterror;
    }

    public void designationMastInitialize(JTextField department, JTextField departmentShortname, JComboBox<String> nature, JComboBox<String> active, JTextField depCode) {
        Departmentmodel.setTxtDepartment(myLib.sNull(department.getText()));
        Departmentmodel.setTxtDepartmentShortName(myLib.sNull(departmentShortname.getText()));

        Departmentmodel.setTxtActive(myLib.sNull(active.getSelectedItem().toString()));
        Departmentmodel.setTxtNature(myLib.sNull(nature.getSelectedItem().toString()));
        flag1 = true; // if no error in model set
    }

    public void saveRecord(JTextField department, JTextField departmentShortname, JComboBox nature, JComboBox active, JTextField depCode, String moverecCodeforDepM, boolean addButtonFlag) {

        if (flag) {
            designationMastInitialize(department, departmentShortname, nature, active, depCode);
            if (flag1) {
                if (addButtonFlag) {
                    duplicate=srv.save(Departmentmodel);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                } else {
                    Departmentmodel.setCode(moverecCodeforDepM);
                    duplicate=srv.save(Departmentmodel);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                }
                if (Departmentmodel.isConnection()) {
                    if (Departmentmodel.isStatus()) {
                        clear(department, departmentShortname, nature, active, depCode);
                        department.requestFocus(true);
                        depMasterClear();

                    } else {
                        JOptionPane.showMessageDialog(depMasterFrame, "Invalid Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(depMasterFrame, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void moverec(String searchString, int searchtype, Department_MastModel model) {
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

    public void deleteRecord(String moverecCodeforDesM) {
        Departmentmodel.setCode(moverecCodeforDesM);
        srv.delete(Departmentmodel);
    }

    private void clear(JTextField department, JTextField departmentShortname, JComboBox nature, JComboBox active, JTextField depCode) {
        department.setText("");
        departmentShortname.setText("");
        depCode.setText("");
        nature.setSelectedIndex(0);
        active.setSelectedIndex(0);
        Departmentmodel.setCode("");
    }

    public void prnRecord(String moverecCodeforDepM) {
        Departmentmodel.setCode(moverecCodeforDepM);
        srv.print(Departmentmodel);
    }

}
