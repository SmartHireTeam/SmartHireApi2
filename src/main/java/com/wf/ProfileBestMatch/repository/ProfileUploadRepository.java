package com.wf.ProfileBestMatch.repository;


import com.wf.ProfileBestMatch.entity.ProfileUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface ProfileUploadRepository extends JpaRepository<ProfileUploadEntity, Id> {

    List<ProfileUploadEntity> findByJdId(Integer jdId);

    void deleteByReqId(Integer reqId);

    ProfileUploadEntity findByReqId(Integer reqId);
}
