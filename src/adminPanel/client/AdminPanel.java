package adminPanel.client;

import adminPanel.server.AdminPanel_srvImpl;
import adminPanel.shared.AdminPanelModel;
import adminPanel.shared.AdminPanel_Vld;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AdminPanel extends AdminPanel_Dsg {

    private boolean flag1;
    AdminPanelModel model = new AdminPanelModel();

    public static void main(String[] args) {
        try {
            loginLoader();
        } catch (Exception e) {

        }
    }

    public static void loginLoader() {
        SwingUtilities.invokeLater(() -> {
            AdminPanel_Dsg loginForm = new AdminPanel_Dsg();
            loginForm.showImagePanel();
        });
    }

    public AdminPanel() {

    }

    public void NextInitialize() {

        model.setTxtUsername(myLib.sNull(username.getText()));
        model.setTxtPassword(myLib.sNull(password.getText()));

        flag1 = true;// agr model set me koi error n ho to
    }

    public boolean NextSave() {

        Boolean flag = chkVldNext();
        boolean lolo=false; ;
        if (flag) {
            AdminPanel_srvImpl srv = new AdminPanel_srvImpl();
            NextInitialize();
            if (flag1) {
             lolo =  srv.Authenticate(model);
                if (model.isConnection()) {
//                    JOptionPane.showMessageDialog(rootpanel, "Connected");
                    if (model.isStatus()) {
                        JOptionPane.showMessageDialog(rootpanel, "Loged In");
                        ////////////////////////////////////////////////////////////////////////////
//                        model.setAuthorised(true);
                        username.setText("****");
                        password.setText("****");

                    } else {
                        JOptionPane.showMessageDialog(rootLoginPanel, "Invalid Login Credentials", "ERROR", JOptionPane.ERROR_MESSAGE);
                        username.setText("Username");
                        password.setText("Password");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootpanel, "Connection Timed Out", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
        }
        return lolo;
    }

    public boolean chkVldNext() {
        AdminPanel_Vld vld = new AdminPanel_Vld();
        boolean flag = vld.vldNext();
        return flag;
    }

    public void designationMastInitialize() {

        model.setTxtUsername(myLib.sNull(designation.getText()));
        model.setTxtPassword(myLib.sNull(designationShortName.getText()));
        model.setTxtPassword(myLib.sNull(designationCode.getText()));

        flag1 = true;// agr model set me koi error n ho to
    }

}
