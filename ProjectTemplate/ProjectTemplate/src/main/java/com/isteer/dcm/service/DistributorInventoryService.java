package com.isteer.dcm.service;

import com.isteer.dcm.entity.DistributorInventory;
import com.isteer.dcm.entity.UserRoles;
import com.isteer.dcm.model.DistributorInv;
import com.isteer.dcm.repository.DistributorInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isteer.dcm.model.Response;

import java.util.*;
import java.util.stream.Collectors;

import com.isteer.dcm.constants.DCMConstants;


@Service
public class DistributorInventoryService {
    @Autowired
    DistributorInventoryRepository distributorInventoryRepository;

    @Autowired
    OnstartupDataInitializer dataInitializer;

    public Response getDistributorById(Long distributorId) {

        Response response=new Response();
        List<DistributorInv> responseList  = new ArrayList<>();

        List<UserRoles> roles = dataInitializer.getUserRoles();
        List<UserRoles> filteredUsers = roles.stream().filter(p -> p.getRoleId() == distributorId)
                .collect(Collectors.toList());


        boolean isUserValid = !filteredUsers.isEmpty();
        if (isUserValid) {
            UserRoles user = filteredUsers.get(0);

            // Get roleId from the user
            int roleId = user.getRoleId();

            // Filter UserRoles based on roleId
            List<UserRoles> filteredRoles = roles.stream().filter(p -> p.getRoleId() == roleId)
                    .collect(Collectors.toList());

            // Check if there is a role with the specified roleId
            if (!filteredRoles.isEmpty()) {
                UserRoles userRole = filteredRoles.get(0);

                // Check if view_rating_and_review is 'Y'
                if ("Y".equals(userRole.isCheckInventorySize())) {
                    //logger.info(DCMConstants.VALID_MANUFACTURER)

                    List<DistributorInventory> distributorInventories = distributorInventoryRepository.findByDistributorId(distributorId);
                    if(!distributorInventories.isEmpty()){
                        for (DistributorInventory dis : distributorInventories) {
                            DistributorInv distributorInv = new DistributorInv();
                            distributorInv.setUpc(dis.getUpc());
                            distributorInv.setInventory_size(dis.getInventorySize());
                            distributorInv.setUpc_name(dis.getUpcName());
                            distributorInv.setStock_status(dis.getStockStatus());

                            responseList.add(distributorInv);
                        }
                        response.setResponseCode("Success");
                        response.setResponseMessage("DistributorId validation successful");
                        response.setDistributorInvs(responseList);
                    }else {
                        response.setResponseCode("Not Found");
                        response.setResponseMessage("No products found for the istributor");
                        return (response);
                    }
                } else {
                    //logger.info(DCMConstants.ACCESS_DENIED);
                    response.setResponseCode("Access Denied");
                    response.setResponseMessage(DCMConstants.ACCESS_DENIED);
                }
            } else {
                // Role not found for the specified roleId
                //logger.info(DCMConstants.ROLE_NOT_FOUND);
                response.setResponseCode("Role Not Found");
                response.setResponseMessage(DCMConstants.ROLE_NOT_FOUND);
            }
        } else {
            //logger.info(DCMConstants.INVALID_MANUFACTURER);
            response.setResponseCode("Invalid Manufacturer");
            response.setResponseMessage(DCMConstants.INVALID_MANUFACTURER);
        }

        return (response);
    }
}
