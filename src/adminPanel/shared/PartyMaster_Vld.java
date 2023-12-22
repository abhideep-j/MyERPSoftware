package adminPanel.shared;

import adminPanel.client.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import myLibrary.shared.MyLibrary;

public class PartyMaster_Vld extends AdminPanel_Dsg {

    MyLibrary myLi = new MyLibrary();

    public boolean chkVld(JTextField party, JTextField legalName, JTextField DisplayName, JTextField address, JTextField mobile, JTextField gstin, JTextField PAN, JTextField remark) {
        boolean isValid = true;

        if (party.isEnabled() && party.getText().isEmpty() && party.getText().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Party", "PARTY ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (legalName.isEnabled() && legalName.getText().isEmpty() && legalName.getText().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid legal Name", "LEGAL NAME ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (DisplayName.isEnabled() && DisplayName.getText().isEmpty() && DisplayName.getText().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Display Name", "DISPLAY NAME ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (address.isEnabled() && address.getText().isEmpty() && address.getText().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid address(<250)", " ADDRESS ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (mobile.isEnabled() && mobile.getText().isEmpty() && mobile.getText().length() == 10) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid mobile number", "MOBILE ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (remark.isEnabled() && remark.getText().isEmpty() && remark.getText().length() == 10) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid mobile number", "MOBILE ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        boolean pan = myLi.validatePanCard(PAN.getText());
        if (!pan) {
            isValid = false;
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid PAN", "PAN ERROR", JOptionPane.ERROR_MESSAGE);

        }

        return isValid;
    }
}
