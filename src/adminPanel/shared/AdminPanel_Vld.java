package adminPanel.shared;

import adminPanel.client.*;


public class AdminPanel_Vld extends AdminPanel_Dsg {
public boolean vldNext(){
if(username.getText().equals("")|| username.getText() == null || password.getText().equals("") || password.getText()==null){
    return false;
}
return true;
        }
}
