package adminPanel.shared;

public class ItemCategory_MastModel {

    private String txtItemCategory;
    private String txtItemCategoryShortName;

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

    public String getTxtItemCategory() {
        return txtItemCategory;
    }

    public void setTxtItemCategory(String txtItemCategory) {
        this.txtItemCategory = txtItemCategory;
    }

    public String getTxtItemCategoryShortName() {
        return txtItemCategoryShortName;
    }

    public void setTxtItemCategoryShortName(String txtItemCategoryShortName) {
        this.txtItemCategoryShortName = txtItemCategoryShortName;
    }

   



}
