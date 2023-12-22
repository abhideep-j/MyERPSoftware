package adminPanel.client;

import adminPanel.server.AreaMast_srvImpl;
import adminPanel.server.ItemMast_srvImpl;
import adminPanel.shared.AreaMaster_Vld;
import adminPanel.shared.Area_MastModel;
import adminPanel.shared.ItemMaster_Vld;
import adminPanel.shared.Item_MastModel;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ItemMast extends AdminPanel_Dsg {

    private boolean flag1;
    ItemMaster_Vld vld = new ItemMaster_Vld();
    ItemMast_srvImpl srv = new ItemMast_srvImpl();

    public ItemMast() {

    }

    public ArrayList getItemCatList() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.parentItemCatList());
        return recievedList;
    }

    public boolean chkVld(JTextField item, JTextField remark, JTextArea properties, JTextArea description) {
        boolean noterror = vld.chkVld(item, remark, properties, description);
        return noterror;
    }

    public void areaMastInitialize(JTextField item, JTextArea description, JTextArea properties, JComboBox category, JComboBox hsn_sac, JComboBox indentReq, JComboBox poReq, JComboBox returnable,
            JComboBox gstnature, JComboBox gstBasedOn, JComboBox gstType, JComboBox sku, JComboBox purchaseUnit, JComboBox salesUnit, JComboBox active, JTextField remark) {
        itemMasterModel.setTxtItem(myLib.sNull(item.getText()));
        itemMasterModel.setTxtDescription(myLib.sNull(description.getText()));
        itemMasterModel.setTxtProperties(myLib.sNull(properties.getText()));
        itemMasterModel.setTxtRemark(myLib.sNull(remark.getText()));
        itemMasterModel.setTxtCategory(myLib.sNull(category.getSelectedItem().toString()));
        itemMasterModel.setTxtHSN_SAC(myLib.sNull(hsn_sac.getSelectedItem().toString()));
        itemMasterModel.setTxtIndentReq(myLib.sNull(indentReq.getSelectedItem().toString()));
        itemMasterModel.setTxtPOReq(myLib.sNull(poReq.getSelectedItem().toString()));
        itemMasterModel.setTxtReturnable(myLib.sNull(returnable.getSelectedItem().toString()));
        itemMasterModel.setTxtGSTNature(myLib.sNull(gstnature.getSelectedItem().toString()));
        itemMasterModel.setTxtGSTbasedOn(myLib.sNull(gstBasedOn.getSelectedItem().toString()));
        itemMasterModel.setTxtGSTType(myLib.sNull(gstBasedOn.getSelectedItem().toString()));
        itemMasterModel.setTxtSKU(myLib.sNull(sku.getSelectedItem().toString()));
        itemMasterModel.setTxtpurchaseUnit(myLib.sNull(purchaseUnit.getSelectedItem().toString()));
        itemMasterModel.setTxtSalesUnit(myLib.sNull(salesUnit.getSelectedItem().toString()));
        itemMasterModel.setTxtActive(myLib.sNull(active.getSelectedItem().toString()));
        flag1 = true; // if no error in model set
    }

    public void saveRecord(JTextField item, JTextArea description, JTextArea properties, JComboBox category, JComboBox hsn_sac, JComboBox indentReq, JComboBox poReq, JComboBox returnable,
            JComboBox gstnature, JComboBox gstBasedOn, JComboBox gstType, JComboBox sku, JComboBox purchaseUnit, JComboBox salesUnit, JComboBox active, JTextField remark,
            String moverecCodeforItemM, boolean addButtonFlag) {

        if (flag) {
            areaMastInitialize(item, description, properties, category, hsn_sac, indentReq, poReq, returnable,
                    gstnature, gstBasedOn, gstType, sku, purchaseUnit, salesUnit, active, remark);
            if (flag1) {
                if (addButtonFlag) {
                    duplicate = srv.save(itemMasterModel);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }

                } else {
                    itemMasterModel.setCode(moverecCodeforItemM);
                    duplicate = srv.save(itemMasterModel);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                }
                if (itemMasterModel.isConnection()) {
                    if (itemMasterModel.isStatus()) {

                    } else {
                        JOptionPane.showMessageDialog(itemMasterFrame, "Invalid Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(itemMasterFrame, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void moverec(String searchString, int searchtype, Item_MastModel model) {
        if (searchtype == 1) {
            srv.searchByTxt(searchString, model);
            if (model.isStatus()) {

            } else {
                JOptionPane.showMessageDialog(itemMasterFrame, "No Record Found", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
       else if (searchtype == 2) {
            srv.searchByCode(searchString, model);
            if (model.isStatus()) {
            } else {
                JOptionPane.showMessageDialog(itemMasterFrame, "No Record Found", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void deleteRecord(String moverecCodeforItemM) {
        itemMasterModel.setCode(moverecCodeforItemM);
        srv.delete(itemMasterModel);

    }

    public void prnRecord(String moverecCodeforItemM) {
        itemMasterModel.setCode(moverecCodeforItemM);
        srv.print(itemMasterModel);
    }

}
