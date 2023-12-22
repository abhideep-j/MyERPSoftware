package adminPanel.shared;

public class AdminPanelModel {

    private String txtUsername;
    private String txtPassword;
    private boolean Status;
    private boolean connection;
    private boolean Authorised;


    public void setAuthorised(boolean x) {
        Authorised = x;
    }

    public boolean isAuthorised() {
        return Authorised;
    }

    public boolean isConnection() {
        return connection;
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }

    public AdminPanelModel() {

    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public String getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }
}
