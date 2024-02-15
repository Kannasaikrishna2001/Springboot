package com.isteer.dcm.model;

import com.isteer.dcm.entity.DcmUsers;
import com.isteer.dcm.entity.UserRoles;

import java.util.List;

public class OnStartupDataLoader {

    List<UserRoles> userRoles;
    List<DcmUsers> dcmUsers;

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    public List<DcmUsers> getDcmUsers() {
        return dcmUsers;
    }

    public void setDcmUsers(List<DcmUsers> dcmUsers) {
        this.dcmUsers = dcmUsers;
    }
}
