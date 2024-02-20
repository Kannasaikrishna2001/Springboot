package com.isteer.dcm.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USERROLES")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ROLE_ID")
    private Integer roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "EXPORT_SALES_FILE")
    private String exportSalesFile;

    @Column(name = "PLACE_ORDER")
    private String placeOrder;

    @Column(name = "ACCEPT_ORDER")
    private String acceptOrder;

    @Column(name = "REJECT_ORDER")
    private String rejectOrder;

    @Column(name = "UPLOAD_COLLECTED_DATA")
    private String uploadCollectedData;

    @Column(name = "VIEW_RATING_AND_REVIEW")
    private String viewRatingandReview;

    @Column(name = "CHECK_INVENTORY_SIZE")
    private boolean checkInventorySize;

    @Column(name = "ALTER_USERS")
    private String alterUsers;


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String isExportSalesFile() {
        return exportSalesFile;
    }

    public void setExportSalesFile(String exportSalesFile) {
        this.exportSalesFile = exportSalesFile;
    }

    public String isPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) {
        this.placeOrder = placeOrder;
    }

    public String isAcceptOrder() {
        return acceptOrder;
    }

    public void setAcceptOrder(String acceptOrder) {
        this.acceptOrder = acceptOrder;
    }

    public String isRejectOrder() {
        return rejectOrder;
    }

    public void setRejectOrder(String rejectOrder) {
        this.rejectOrder = rejectOrder;
    }

    public String isUploadCollectedData() {
        return uploadCollectedData;
    }

    public void setUploadCollectedData(String uploadCollectedData) {
        this.uploadCollectedData = uploadCollectedData;
    }

    public String isViewRatingandReview() {
        return viewRatingandReview;
    }

    public void setViewRatingandReview(String viewRatingandReview) {
        this.viewRatingandReview = viewRatingandReview;
    }

    public boolean isCheckInventorySize() {
        return checkInventorySize;
    }

    public void setCheckInventorySize(boolean checkInventorySize) {
        this.checkInventorySize = checkInventorySize;
    }

    public String isAlterUsers() {
        return alterUsers;
    }

    public void setAlterUsers(String alterUsers) {
        this.alterUsers = alterUsers;
    }
}
