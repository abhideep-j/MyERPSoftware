package adminPanel.shared;

import java.util.ArrayList;

public class Enquiry_Model {

    private String txtEnquiryType;
    private String txtEnquiryNo;
    private String txtDepartment;
    private String txtIndent;
    private String txtDate;
    private String txtRemark;
        private ArrayList<Object[]> supplierListRec;


    private boolean Status;
    private String createdOn;
    private String modifiedOn;
    private String code;
    
    
    public ArrayList<Object[]> getSupplierListRec() {
        return supplierListRec;
    }

    public void setSupplierListRec(ArrayList<Object[]> supplierListRec) {
        this.supplierListRec = supplierListRec;
    }

    public String getTxtEnquiryType() {
        return txtEnquiryType;
    }

    public void setTxtEnquiryType(String txtEnquiryType) {
        this.txtEnquiryType = txtEnquiryType;
    }

    public String getTxtEnquiryNo() {
        return txtEnquiryNo;
    }

    public void setTxtEnquiryNo(String txtEnquiryNo) {
        this.txtEnquiryNo = txtEnquiryNo;
    }

    public String getTxtDepartment() {
        return txtDepartment;
    }

    public void setTxtDepartment(String txtDepartment) {
        this.txtDepartment = txtDepartment;
    }

    public String getTxtIndent() {
        return txtIndent;
    }

    public void setTxtIndent(String txtIndent) {
        this.txtIndent = txtIndent;
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
