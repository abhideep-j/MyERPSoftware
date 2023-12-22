package adminPanel.shared;

import adminPanel.client.AdminPanel_Dsg;
import javax.swing.*;

public class DesignationMast_Vld extends AdminPanel_Dsg {

    public boolean chkVld(JTextField designation, JTextField designationShortName, JTextField designationCode) {
        boolean isValid = true;

        if (designation.isEnabled() && designation.getText().isEmpty() && designation.getText().length()<=50) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Designation", "DESIGNATION ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        if (designationShortName.isEnabled() && designationShortName.getText().isEmpty()&& designationShortName.getText().length()<=20) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Designation ShortName", "DESIGNATION SHORT NAME ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        if (designationCode.isEnabled() && designationCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter Designation Code", "DESIGNATION CODE ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        return isValid;
    }
}
