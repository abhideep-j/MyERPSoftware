package adminPanel.shared;

public class Requisition_Model {

    private String txtRequisitionType;
    private String txtRequisitionNo;
    private String txtRequisitionBy;
    private String txtDepartmentTo;
    private String txtDepartmentBy;
    private String txtDate;
    private String txtRemark;

    private boolean Status;
    private String createdOn;
    private String modifiedOn;
    private String code;

    public String getTxtRequisitionType() {
        return txtRequisitionType;
    }

    public void setTxtRequisitionType(String txtRequisitionType) {
        this.txtRequisitionType = txtRequisitionType;
    }

    public String getTxtRequisitionNo() {
        return txtRequisitionNo;
    }

    public void setTxtRequisitionNo(String txtRequisitionNo) {
        this.txtRequisitionNo = txtRequisitionNo;
    }

    public String getTxtRequisitionBy() {
        return txtRequisitionBy;
    }

    public void setTxtRequisitionBy(String txtRequisitionBy) {
        this.txtRequisitionBy = txtRequisitionBy;
    }

    public String getTxtDepartmentTo() {
        return txtDepartmentTo;
    }

    public void setTxtDepartmentTo(String txtDepartmentTo) {
        this.txtDepartmentTo = txtDepartmentTo;
    }

    public String getTxtDepartmentBy() {
        return txtDepartmentBy;
    }

    public void setTxtDepartmentBy(String txtDepartmentBy) {
        this.txtDepartmentBy = txtDepartmentBy;
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
