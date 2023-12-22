package adminPanel.client;

import adminPanel.server.AreaMast_srvImpl;
import adminPanel.server.PartyMast_srvImpl;
import adminPanel.shared.AreaMaster_Vld;
import adminPanel.shared.Area_MastModel;
import adminPanel.shared.DepartmentMast_Vld;
import adminPanel.shared.Department_MastModel;
import adminPanel.shared.PartyMaster_Vld;
import adminPanel.shared.Party_MastModel;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PartyMast extends AdminPanel_Dsg {

    private boolean flag1;
    PartyMaster_Vld vld = new PartyMaster_Vld();
    PartyMast_srvImpl srv = new PartyMast_srvImpl();

    public PartyMast() {

    }

    public ArrayList getPartyList() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.partyList());
        return recievedList;
    }

    public ArrayList getCityList() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.cityList());
        return recievedList;
    }

    public String getCountry(String city) {
        String country = srv.getCountry(city);
        return country;
    }

    public ArrayList getArea() {
        ArrayList<String> recievedList = new ArrayList<String>();
        recievedList.addAll(srv.AreaList());
        return recievedList;
    }

    public boolean chkVld(JTextField party, JTextField legalName, JTextField DisplayName, JTextField address, JTextField mobile, JTextField gstin, JTextField PAN, JTextField remark) {
        boolean noterror = vld.chkVld(party, legalName, DisplayName, address, mobile, gstin, PAN, remark);
        return noterror;
    }

    public void areaMastInitialize(JTextField party,
            JTextField partyLegal,
            JTextField partyDisplay,
            JTextField partyCode,
            JTextField partyGSTIN,
            JTextField partyPAN,
            JTextField partyAdhar,
            JTextField partyAddress,
            JTextField partyCountry,
            JTextField partyPin,
            JTextField partyPhoneNumber,
            JTextField partyMobileNumber,
            JTextField partyRemark,
            JComboBox<String> partyNature,
            JComboBox<String> partyTCSActive,
            JComboBox<String> partyTCScategory,
            JComboBox<String> partyTDScategory,
            JComboBox<String> partyReferredTo,
            JComboBox<String> partyMSMEType,
            JComboBox<String> partyGSTType,
            JComboBox<String> partyCity,
            JComboBox<String> partyArea,
            JComboBox<String> partyActive) {
        partyMasterModel.setParty(myLib.sNull(party.getText()));
        partyMasterModel.setPartyLegal(myLib.sNull(partyLegal.getText()));
        partyMasterModel.setPartyDisplay(myLib.sNull(partyDisplay.getText()));
        partyMasterModel.setPartyCode(myLib.sNull(partyCode.getText()));
        partyMasterModel.setPartyGSTIN(myLib.sNull(partyGSTIN.getText()));
        partyMasterModel.setPartyPAN(myLib.sNull(partyPAN.getText()));
        partyMasterModel.setPartyAdhar(myLib.sNull(partyAdhar.getText()));
        partyMasterModel.setPartyAddress(myLib.sNull(partyAddress.getText()));
        partyMasterModel.setPartyCountry(myLib.sNull(partyCountry.getText()));
        partyMasterModel.setPartyPin(myLib.sNull(partyPin.getText()));
        partyMasterModel.setPartyPhoneNumber(myLib.sNull(partyPhoneNumber.getText()));
        partyMasterModel.setPartyMobileNumber(myLib.sNull(partyMobileNumber.getText()));
        partyMasterModel.setPartyRemark(myLib.sNull(partyRemark.getText()));
        partyMasterModel.setPartyNature(myLib.sNull(partyNature.getSelectedItem().toString()));
        partyMasterModel.setPartyTCSActive(myLib.sNull(partyTCSActive.getSelectedItem().toString()));
        partyMasterModel.setPartyTCScategory(myLib.sNull(partyTCScategory.getSelectedItem().toString()));
        partyMasterModel.setPartyTDScategory(myLib.sNull(partyTDScategory.getSelectedItem().toString()));
        partyMasterModel.setPartyReferredTo(myLib.sNull(partyReferredTo.getSelectedItem().toString()));
        partyMasterModel.setPartyMSMEType(myLib.sNull(partyMSMEType.getSelectedItem().toString()));
        partyMasterModel.setPartyGSTType(myLib.sNull(partyGSTType.getSelectedItem().toString()));
        partyMasterModel.setPartyCity(myLib.sNull(partyCity.getSelectedItem().toString()));
        partyMasterModel.setPartyArea(myLib.sNull(partyArea.getSelectedItem().toString()));
        partyMasterModel.setPartyActive(myLib.sNull(partyActive.getSelectedItem().toString()));
        flag1 = true; // if no error in model set
    }

    public void saveRecord(JTextField party,
            JTextField partyLegal,
            JTextField partyDisplay,
            JTextField partyCode,
            JTextField partyGSTIN,
            JTextField partyPAN,
            JTextField partyAdhar,
            JTextField partyAddress,
            JTextField partyCountry,
            JTextField partyPin,
            JTextField partyPhoneNumber,
            JTextField partyMobileNumber,
            JTextField partyRemark,
            JComboBox<String> partyNature,
            JComboBox<String> partyTCSActive,
            JComboBox<String> partyTCScategory,
            JComboBox<String> partyTDScategory,
            JComboBox<String> partyReferredTo,
            JComboBox<String> partyMSMEType,
            JComboBox<String> partyGSTType,
            JComboBox<String> partyCity,
            JComboBox<String> partyArea,
            JComboBox<String> partyActive, String moverecCodeforPartyM, boolean addButtonFlag) {

        if (flag) {
            areaMastInitialize(party, partyLegal, partyDisplay, partyCode, partyGSTIN, partyPAN, partyAdhar, partyAddress, partyCountry, partyPin, partyPhoneNumber, partyMobileNumber,
                    partyRemark, partyNature, partyTCSActive, partyTCScategory, partyTDScategory, partyReferredTo, partyMSMEType, partyGSTType, partyCity, partyArea,
                    partyActive);
            if (flag1) {
                if (addButtonFlag) {
                    duplicate = srv.save(partyMasterModel);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }

                } else {
                    partyMasterModel.setCode(moverecCodeforPartyM);
                    duplicate = srv.save(partyMasterModel);
                    if (duplicate) {
                        JOptionPane.showMessageDialog(rootpanel, "Data already exists", " DUPLICATE", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                }
                if (partyMasterModel.isConnection()) {
                    if (partyMasterModel.isStatus()) {
                        party.requestFocus(true);

                    } else {
                        JOptionPane.showMessageDialog(partyMasterFrame, "Invalid Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(partyMasterFrame, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void moverec(String searchString,String nature, int searchtype, Party_MastModel model) {
        if (searchtype == 1) {
            srv.searchByTxt(searchString, nature, model);
            if (model.isStatus()) {

            } else {
                JOptionPane.showMessageDialog(partyMasterFrame, "No Record Found", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (searchtype == 2) {
            srv.searchByCode(searchString, model);
            if (model.isStatus()) {

            } else {
                JOptionPane.showMessageDialog(partyMasterFrame, "No Record Found", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void deleteRecord(String moverecCodeforPartyM) {
        partyMasterModel.setCode(moverecCodeforPartyM);
        srv.delete(partyMasterModel);

    }

    public void prnRecord(String moverecCodeforAreaM) {
        AreaModel.setCode(moverecCodeforAreaM);
        srv.print(AreaModel);
    }

}
