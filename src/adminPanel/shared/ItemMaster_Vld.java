package adminPanel.shared;

import adminPanel.client.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ItemMaster_Vld extends AdminPanel_Dsg {

    public boolean chkVld(JTextField item ,JTextField remark ,JTextArea properties ,JTextArea description ) {
        boolean isValid = true;

        if (item.isEnabled() && item.getText().isEmpty() && item.getText().length() <= 50) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Item", "AREA ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (remark.isEnabled()  && !(remark.getText().length() <= 250)) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid length remark (250)", "AREA ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (properties.isEnabled()  && !(properties.getText().length() <= 500)) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid length Properties (500)", "AREA ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (description.isEnabled()  && !(description.getText().length() <= 1000)) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid length Properties (1000)", "AREA ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
      

        return isValid;
    }
}
