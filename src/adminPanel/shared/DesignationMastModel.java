package adminPanel.shared;

public class DesignationMastModel {

    private String txtDesignation;
    private String txtDesignationCode;
    private String txtDesignationShortName;
    private boolean Status;
    private String createdOn;
    private String modifiedOn;
    private String code;

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

    public String getTxtDesignation() {
        return txtDesignation;
    }

    public void setTxtDesignation(String txtDesignation) {
        this.txtDesignation = txtDesignation;
    }

    public String getTxtDesignationCode() {
        return txtDesignationCode;
    }

    public void setTxtDesignationCode(String txtDesignationCode) {
        this.txtDesignationCode = txtDesignationCode;
    }

    public String getTxtDesignationShortName() {
        return txtDesignationShortName;
    }

    public void setTxtDesignationShortName(String txtDesignationShortName) {
        this.txtDesignationShortName = txtDesignationShortName;
    }

}
