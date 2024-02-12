package com.isteer.dcm.repository;

import com.isteer.dcm.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles,Long> {
}
