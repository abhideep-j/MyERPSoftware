package adminPanel.shared;

import adminPanel.client.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Requisition_Vld extends AdminPanel_Dsg {

    public boolean chkVld(JTextField area) {
        boolean isValid = true;

        if (area.isEnabled() && area.getText().isEmpty() && area.getText().length() >= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Remark", "REMARK ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
      

        return isValid;
    }
}
