package adminPanel.shared;

import adminPanel.client.AdminPanel_Dsg;
import javax.swing.*;

public class DepartmentMast_Vld extends AdminPanel_Dsg{

    public boolean chkVld(JTextField department, JTextField departmentShortName) {
        boolean isValid = true;

        if (department.isEnabled() && department.getText().isEmpty() && department.getText().length()<=50) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Department", "DEPARTMENT ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        if (departmentShortName.isEnabled() && departmentShortName.getText().isEmpty()&& departmentShortName.getText().length()<=20) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Department ShortName", "DEPARTMENT SHORT NAME ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        
        return isValid;
    }
}
