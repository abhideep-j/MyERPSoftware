package adminPanel.shared;

import java.util.ArrayList;

public class Indent_Model {

    private String txtIndentType;
    private String txtIndentNo;
    private String txtIndentor;
    private String txtIndentDepartment;
    private String txtRequiition;
    private String txtDate;
    private String txtRemark;

    private boolean Status;
    private String createdOn;
    private String modifiedOn;
    private String code;


    public String getTxtIndentType() {
        return txtIndentType;
    }

    public void setTxtIndentType(String txtIndentType) {
        this.txtIndentType = txtIndentType;
    }

    public String getTxtIndentNo() {
        return txtIndentNo;
    }

    public void setTxtIndentNo(String txtIndentNo) {
        this.txtIndentNo = txtIndentNo;
    }

    public String getTxtIndentor() {
        return txtIndentor;
    }

    public void setTxtIndentor(String txtIndentor) {
        this.txtIndentor = txtIndentor;
    }

    public String getTxtIndentDepartment() {
        return txtIndentDepartment;
    }

    public void setTxtIndentDepartment(String txtIndentDepartment) {
        this.txtIndentDepartment = txtIndentDepartment;
    }

    public String getTxtRequiition() {
        return txtRequiition;
    }

    public void setTxtRequiition(String txtRequiition) {
        this.txtRequiition = txtRequiition;
    }

    public String getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(String txtDate) {
        this.txtDate = txtDate;
    }

    public String getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(String txtRemark) {
        this.txtRemark = txtRemark;
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

}
