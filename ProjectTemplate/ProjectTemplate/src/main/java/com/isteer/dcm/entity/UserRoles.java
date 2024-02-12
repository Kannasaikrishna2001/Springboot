package com.isteer.dcm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "userRoles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="roleId")
    private int roleId;

    @Column(name="roleName")
    private String roleName;

    @Column(name="exportSalesFile")
    private boolean exportSalesFile;

    @Column(name="placeOrder")
    private boolean placeOrder;

    @Column(name="acceptOrder")
    private boolean acceptOrder;

    @Column(name="rejectOrder")
    private boolean rejectOrder;

    @Column(name="uploadCollectedData")
    private boolean uploadCollectedData;

    @Column(name="viewRatingandReview")
    private boolean viewRatingandReview;

    @Column(name="checkInventorySize")
    private boolean checkInventorySize;

    @Column(name="alterUsers")
    private boolean alterUsers;

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

    public boolean isExportSalesFile() {
        return exportSalesFile;
    }

    public void setExportSalesFile(boolean exportSalesFile) {
        this.exportSalesFile = exportSalesFile;
    }

    public boolean isPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(boolean placeOrder) {
        this.placeOrder = placeOrder;
    }

    public boolean isAcceptOrder() {
        return acceptOrder;
    }

    public void setAcceptOrder(boolean acceptOrder) {
        this.acceptOrder = acceptOrder;
    }

    public boolean isRejectOrder() {
        return rejectOrder;
    }

    public void setRejectOrder(boolean rejectOrder) {
        this.rejectOrder = rejectOrder;
    }

    public boolean isUploadCollectedData() {
        return uploadCollectedData;
    }

    public void setUploadCollectedData(boolean uploadCollectedData) {
        this.uploadCollectedData = uploadCollectedData;
    }

    public boolean isViewRatingandReview() {
        return viewRatingandReview;
    }

    public void setViewRatingandReview(boolean viewRatingandReview) {
        this.viewRatingandReview = viewRatingandReview;
    }

    public boolean isCheckInventorySize() {
        return checkInventorySize;
    }

    public void setCheckInventorySize(boolean checkInventorySize) {
        this.checkInventorySize = checkInventorySize;
    }

    public boolean isAlterUsers() {
        return alterUsers;
    }

    public void setAlterUsers(boolean alterUsers) {
        this.alterUsers = alterUsers;
    }
}
