package com.isteer.dcm.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "userRoles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    @Column(name="roleId")
    private int roleId;

    @Column(name="roleName")
    private String roleName;

    @Column(name="exportSalesFile")
    private String exportSalesFile;

    @Column(name="placeOrder")
    private String placeOrder;

    @Column(name="acceptOrder")
    private String acceptOrder;

    @Column(name="rejectOrder")
    private String rejectOrder;

    @Column(name="uploadCollectedData")
    private String uploadCollectedData;

    @Column(name="viewRatingandReview")
    private String viewRatingandReview;

    @Column(name="checkInventorySize")
    private boolean checkInventorySize;

    @Column(name="alterUsers")
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
