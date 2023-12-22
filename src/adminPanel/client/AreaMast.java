package adminPanel.client;

import adminPanel.server.AreaMast_srvImpl;
import adminPanel.shared.AreaMaster_Vld;
import adminPanel.shared.Area_MastModel;
import adminPanel.shared.DepartmentMast_Vld;
import adminPanel.shared.Department_MastModel;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AreaMast extends AdminPanel_Dsg {

    private boolean flag1;
    AreaMaster_Vld vld = new AreaMaster_Vld();
    AreaMast_srvImpl srv = new AreaMast_srvImpl();

    public AreaMast() {

    }

    public ArrayList getParentArea() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.parentAreaList());
        return recievedList;
    }

    public boolean chkVld(JTextField area, JComboBox<String> parentArea) {
        boolean noterror = vld.chkVld(area, parentArea);
        return noterror;
    }

    public void areaMastInitialize(JTextField area, JComboBox parentArea) {
        AreaModel.setTxtArea(myLib.sNull(area.getText()));
        AreaModel.setTxtParentArea(myLib.sNull(parentArea.getSelectedItem().toString()));
        flag1 = true; // if no error in model set
    }

    public void saveRecord(JTextField area, JComboBox parentArea, String moverecCodeforAreaM, boolean addButtonFlag) {

        if (flag) {
            areaMastInitialize(area, parentArea);
            if (flag1) {
                if (addButtonFlag) {
                    duplicate = srv.save(AreaModel);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }

                } else {
                    AreaModel.setCode(moverecCodeforAreaM);
                    duplicate = srv.save(AreaModel);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                }
                if (AreaModel.isConnection()) {
                    if (AreaModel.isStatus()) {
                        area.requestFocus(true);

                    } else {
                        JOptionPane.showMessageDialog(areaMasterFrame, "Invalid Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(areaMasterFrame, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void moverec(String searchString, int searchtype, Area_MastModel model) {
        if (searchtype == 1) {
            srv.searchByTxt(searchString, model);
            if (model.isStatus()) {

            } else {
                JOptionPane.showMessageDialog(areaMasterFrame, "No Record Found", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void deleteRecord(String moverecCodeforAreaM) {
        AreaModel.setCode(moverecCodeforAreaM);
        srv.delete(AreaModel);

    }

    public void prnRecord(String moverecCodeforAreaM) {
        AreaModel.setCode(moverecCodeforAreaM);
        srv.print(AreaModel);
    }

}
