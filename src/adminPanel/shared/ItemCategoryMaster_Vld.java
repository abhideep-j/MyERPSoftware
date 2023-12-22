package adminPanel.shared;

import adminPanel.client.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ItemCategoryMaster_Vld extends AdminPanel_Dsg {

    public boolean chkVld(JTextField category,JTextField shortname) {
        boolean isValid = true;

        if (category.isEnabled() && category.getText().isEmpty() && category.getText().length() <= 50) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Item Category (<50)", "ITEM CATEGORY ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (shortname.isEnabled() && shortname.getText().isEmpty() && shortname.getText().length() <= 20) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Short Name (<20)", "SHORT NAME ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
      

        return isValid;
    }
}
