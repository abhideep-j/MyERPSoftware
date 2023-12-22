package adminPanel.shared;

public class Department_MastModel {

    private String txtDepartment;
    private String txtDepartmentShortName;
    private String txtNature;
    private String txtActive;
    private String txtDepCode;
    private boolean Status;
    private String createdOn;
    private String modifiedOn;
    private String code;

    public String getTxtDepCode() {
        return txtDepCode;
    }

    public void setTxtDepCode(String txtDepCode) {
        this.txtDepCode = txtDepCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    private boolean connection;

    public boolean isConnection() {
        return connection;
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }

    public String getTxtDepartment() {
        return txtDepartment;
    }

    public void setTxtDepartment(String txtDepartment) {
        this.txtDepartment = txtDepartment;
    }

    public String getTxtDepartmentShortName() {
        return txtDepartmentShortName;
    }

    public void setTxtDepartmentShortName(String txtDepartmentShortName) {
        this.txtDepartmentShortName = txtDepartmentShortName;
    }

    public String getTxtNature() {
        return txtNature;
    }

    public void setTxtNature(String txtNature) {
        this.txtNature = txtNature;
    }

    public String getTxtActive() {
        return txtActive;
    }

    public void setTxtActive(String txtActive) {
        this.txtActive = txtActive;
    }

}
