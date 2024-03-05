package com.wf.ProfileBestMatch.repository;


import com.wf.ProfileBestMatch.entity.ProfileUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface ProfileUploadRepository extends JpaRepository<ProfileUploadEntity, Id> {

    ProfileUploadEntity findByReqId(Integer reqId);

    void deleteByReqId(Integer reqId);

}
