package adminPanel.shared;

import adminPanel.client.*;
import javax.swing.JTextField;

public class SalesChart_Vld extends AdminPanel_Dsg {

    public boolean chkVld(JTextField salesJan,
            JTextField salesfeb,
            JTextField salesmar,
            JTextField salesApr,
            JTextField salesmay,
            JTextField salesJun,
            JTextField salesJul,
            JTextField salesaug,
            JTextField salessep,
            JTextField salesoct,
            JTextField salesnov,
            JTextField salesdec) {
        if (salesJan.getText().equals("") || salesJan.getText() == null || salesfeb.getText().equals("") || salesfeb.getText() == null) {
            return false;
        }
        if (salesmar.getText().equals("") || salesmar.getText() == null || salesApr.getText().equals("") || salesApr.getText() == null) {
            return false;
        }
        if (salesmay.getText().equals("") || salesmay.getText() == null || salesJun.getText().equals("") || salesJun.getText() == null) {
            return false;
        }
        if (salesJul.getText().equals("") || salesJul.getText() == null || salesaug.getText().equals("") || salesaug.getText() == null) {
            return false;
        }
        if (salessep.getText().equals("") || salessep.getText() == null || salesoct.getText().equals("") || salesoct.getText() == null) {
            return false;
        }
        if (salesnov.getText().equals("") || salesnov.getText() == null || salesdec.getText().equals("") || salesdec.getText() == null) {
            return false;
        }
        return true;
    }
}
