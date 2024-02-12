package com.isteer.dcm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dcmUsers")
public class DcmUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="userId")
    private int userId;

    @Column(name="userName")
    private String userName;

    @Column(name="userRole")
    private String userRole;

    @Column(name="userStatus")
    private String userStatus;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
