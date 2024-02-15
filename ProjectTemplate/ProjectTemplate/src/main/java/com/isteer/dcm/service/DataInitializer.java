package com.isteer.dcm.service;

import com.isteer.dcm.entity.DcmUsers;
import com.isteer.dcm.entity.UserRoles;
import com.isteer.dcm.model.OnStartupDataLoader;
import com.isteer.dcm.repository.DcmUsersRepository;
import com.isteer.dcm.repository.UserRolesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private DcmUsersRepository dcmUsersRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

  OnStartupDataLoader onStartupDataLoader = new OnStartupDataLoader();

    @PostConstruct
    public void init() {

        onStartupDataLoader.setUserRoles(userRolesRepository.findAll());
        onStartupDataLoader.setDcmUsers( dcmUsersRepository.findAll());

    }

    public List<UserRoles> getUserRoles(){

        return onStartupDataLoader.getUserRoles();
    }
    public List<DcmUsers> getDcmUsersList(){
        return onStartupDataLoader.getDcmUsers();
    }



}
