package com.wf.ProfileBestMatch.repository;


import com.wf.ProfileBestMatch.entity.HRProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface HRProfileRepository extends JpaRepository<HRProfileEntity, Id> {

    HRProfileEntity findByHrId(Integer hrId);

    void deleteByHrId(Integer hrId);

    HRProfileEntity findByEmail(String emailId);
}
