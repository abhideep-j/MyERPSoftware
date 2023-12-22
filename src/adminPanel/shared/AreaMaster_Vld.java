package adminPanel.shared;

import adminPanel.client.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AreaMaster_Vld extends AdminPanel_Dsg {

    public boolean chkVld(JTextField area,JComboBox<String> parentArea) {
        boolean isValid = true;

        if (area.isEnabled() && area.getText().isEmpty() && area.getText().length() >= 50) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Area", "AREA ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
      

        return isValid;
    }
}
