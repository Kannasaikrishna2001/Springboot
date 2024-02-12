package com.isteer.dcm.repository;

import com.isteer.dcm.entity.DcmUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DcmUsersRepository extends JpaRepository<DcmUsers,Long> {

}
