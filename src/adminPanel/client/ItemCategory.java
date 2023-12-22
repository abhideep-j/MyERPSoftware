package adminPanel.client;

import adminPanel.server.ItemCategoryMast_srvImpl;
import adminPanel.shared.ItemCategoryMaster_Vld;
import adminPanel.shared.ItemCategory_MastModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ItemCategory extends AdminPanel_Dsg {

    private boolean flag1;
    ItemCategoryMaster_Vld vld = new ItemCategoryMaster_Vld();
    ItemCategoryMast_srvImpl srv = new ItemCategoryMast_srvImpl();

    public ItemCategory() {

    }

    public boolean chkVld(JTextField itemCategory, JTextField shortName) {
        boolean noterror = vld.chkVld(itemCategory, shortName);
        return noterror;
    }

    public void areaMastInitialize(JTextField itemCategory, JTextField shortName) {
        iCategoryModel.setTxtItemCategory(myLib.sNull(itemCategory.getText()));
        iCategoryModel.setTxtItemCategoryShortName(myLib.sNull(shortName.getText()));
        flag1 = true; // if no error in model set
    }

    public void saveRecord(JTextField itemCategory, JTextField shortname, String moverecCodeforiCategory, boolean addButtonFlag) {

        if (flag) {
            areaMastInitialize(itemCategory, shortname);
            if (flag1) {
                if (addButtonFlag) {
                  duplicate=  srv.save(iCategoryModel);
                  if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                } else {
                    iCategoryModel.setCode(moverecCodeforiCategory);
                     duplicate = srv.save(iCategoryModel);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                    if (iCategoryModel.isConnection()) {
                        if (iCategoryModel.isStatus()) {
                            itemCategory.requestFocus(true);

                        } else {
                            JOptionPane.showMessageDialog(iCategoryMasterFrame, "Invalid Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(iCategoryMasterFrame, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    public void moverec(String searchString, int searchtype, ItemCategory_MastModel model) {
        if (searchtype == 1) {
            srv.searchByTxt(searchString, model);
            if (model.isStatus()) {

            } else {
                JOptionPane.showMessageDialog(iCategoryMasterFrame, "No Record Found", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void deleteRecord(String moverecCodeforiCategory) {
        iCategoryModel.setCode(moverecCodeforiCategory);
        srv.delete(iCategoryModel);

    }

    public void prnRecord(String moverecCodeforiCategory) {
        iCategoryModel.setCode(moverecCodeforiCategory);
        srv.print(iCategoryModel);
    }

}
