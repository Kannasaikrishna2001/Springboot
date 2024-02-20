package com.isteer.dcm.service;

import com.isteer.dcm.constants.DCMConstants;
import com.isteer.dcm.entity.DcmUsers;
import com.isteer.dcm.entity.Products;
import com.isteer.dcm.entity.UserRoles;
import com.isteer.dcm.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewAndRating {

    Logger logger = LoggerFactory.getLogger(ReviewAndRating.class);
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    OnstartupDataInitializer dataInitializer;

    public Products sellerValidation(int sellerid) {

        List<DcmUsers> userData = dataInitializer.getDcmUsersList();
        List<UserRoles>roles=dataInitializer.getUserRoles();
        List<DcmUsers> filteredUsers = userData.stream().filter(p ->p.getUser_id() == sellerid)
                .collect(Collectors.toList());

        boolean isUserValid = !filteredUsers.isEmpty();
        if (isUserValid) {
            DcmUsers user = filteredUsers.get(0);

            // Get roleId from the user
            int roleId = user.getUser_role();

            // Filter UserRoles based on roleId
            List<UserRoles> filteredRoles = roles.stream().filter(p ->p.getRoleId() == roleId)
                    .collect(Collectors.toList());

            // Check if there is a role with the specified roleId
            if (!filteredRoles.isEmpty()) {
                UserRoles userRole = filteredRoles.get(0);

                // Check if view_rating_and_review is 'Y'
                if ("Y".equals(userRole.isViewRatingandReview())) {
                    logger.info(DCMConstants.VALID_MANUFACTURER);
                    return productsRepository.findBysellerid(sellerid)
                            .orElse(null);
                } else {
                    logger.info(DCMConstants.ACCESS_DENIED);
                }
            } else {
                // Role not found for the specified roleId
                logger.info(DCMConstants.ROLE_NOT_FOUND);
            }
        } else {
            logger.info(DCMConstants.INVALID_MANUFACTURER);
        }
        return null;
    }


     /*   boolean isUserValid = userData.stream().anyMatch(p -> p.getUser_id() == sellerid);
        if (isUserValid) {
            logger.info(DCMConstants.VALID_MANUFACTURER);
            return productsRepository.findBysellerid(sellerid)
                    .orElse(null);
        } else {
            logger.info(DCMConstants.INVALID_MANUFACTURER);
        }
        return null;*/
    }


   /* public Products getProductBySellerId(BigDecimal sellerid) {
        return productsRepository.findBysellerid(sellerid)
                .orElse(null);
    }*/
//}
