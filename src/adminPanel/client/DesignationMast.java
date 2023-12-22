package adminPanel.client;

import adminPanel.server.DesignationMast_srvImpl;
import adminPanel.shared.DesignationMastModel;
import adminPanel.shared.DesignationMast_Vld;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DesignationMast extends AdminPanel_Dsg {

    private boolean flag1;
    DesignationMast_Vld vld = new DesignationMast_Vld();
    DesignationMast_srvImpl srv = new DesignationMast_srvImpl();

    public DesignationMast() {

    }

    public boolean chkVld(JTextField designation, JTextField designationShortName, JTextField designationCode) {
        boolean noterror = vld.chkVld(designation, designationShortName, designationCode);
        return noterror;
    }

    public void designationMastInitialize(JTextField designation, JTextField designationShortName, JTextField designationCode) {
        model.setTxtDesignation(myLib.sNull(designation.getText()));
        model.setTxtDesignationShortName(myLib.sNull(designationShortName.getText()));
        model.setTxtDesignationCode(myLib.sNull(designationCode.getText()));
        flag1 = true; // if no error in model set
    }

    public void saveRecord(JTextField designation, JTextField designationShortName, JTextField designationCode, String moverecCodeforDesM, boolean addButtonFlag) {

        if (flag) {
            designationMastInitialize(designation, designationShortName, designationCode);
            if (flag1) {
                if (addButtonFlag) {
                    duplicate=srv.save(model);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                } else {
                    model.setCode(moverecCodeforDesM);
                    duplicate=srv.save(model);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                }
                if (model.isConnection()) {
                    if (model.isStatus()) {
                        clear(designation, designationShortName, designationCode);
                        designation.requestFocus(true);
                        desMasterClear();

                    } else {
                        JOptionPane.showMessageDialog(desMasterFrame, "Invalid Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(desMasterFrame, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void moverec(String searchString, int searchtype, DesignationMastModel model) {
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
        model.setCode(moverecCodeforDesM);
        srv.delete(model);
    }

    private void clear(JTextField designation, JTextField designationShortName, JTextField designationCode) {
        designation.setText("");
        designationCode.setText("");
        designationShortName.setText("");
        model.setCode("");
    }

    public void prnRecord(String moverecCodeforDesM) {
        model.setCode(moverecCodeforDesM);
        srv.print(model);
    }

}
