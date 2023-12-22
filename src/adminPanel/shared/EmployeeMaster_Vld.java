package adminPanel.shared;

import adminPanel.client.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EmployeeMaster_Vld extends AdminPanel_Dsg {

    public boolean chkVld(JTextField name, JTextField displayname, JComboBox<String> gender, JComboBox<String> martialStatus, JComboBox<String> nature, JComboBox<String> designation,
            JComboBox<String> department, JTextField mobile, JTextField adhar, JTextField address, JComboBox<String> city, JTextField country, JTextField pin) {
        boolean isValid = true;

        if (name.isEnabled() && name.getText().isEmpty() && name.getText().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Name (<50)", "NAME ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (displayname.isEnabled() && displayname.getText().isEmpty() && displayname.getText().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Display Name (<20)", "DISPLAY NAME ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (gender.isEnabled() && gender.getSelectedItem().toString().isEmpty() && gender.getSelectedItem().toString().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Gender", "GENDER ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (martialStatus.isEnabled() && martialStatus.getSelectedItem().toString().isEmpty() && martialStatus.getSelectedItem().toString().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Martial STatus ", "MARTIAL STATUS ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (designation.isEnabled() && designation.getSelectedItem().toString().isEmpty() && designation.getSelectedItem().toString().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Designation ", "DESIGNATION ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (department.isEnabled() && department.getSelectedItem().toString().isEmpty() && department.getSelectedItem().toString().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid Department ", "DEPARTMENT ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (mobile.isEnabled() && mobile.getText().isEmpty() && mobile.getText().length() == 10) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter mobile (10)", "MOBILE ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (adhar.isEnabled() && adhar.getText().isEmpty() && adhar.getText().length() == 16) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter Adhar (16)", "ADHAR ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (address.isEnabled() && address.getText().isEmpty() && address.getText().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter Address", "COUNTRY ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (city.isEnabled() && city.getSelectedItem().toString().isEmpty() && city.getSelectedItem().toString().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter valid City ", "CITY ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (country.isEnabled() && country.getText().isEmpty() && country.getText().length() <= 250) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter Valid Country", "COUNTRY ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        if (address.isEnabled() && pin.getText().isEmpty() && pin.getText().length() == 6) {
            JOptionPane.showMessageDialog(rootpanel, "Please enter Pincode", "PINCODE ERROR", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
      
        return isValid;
    }
}
