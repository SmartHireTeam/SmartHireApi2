package com.wf.ProfileBestMatch.repository;


import com.wf.ProfileBestMatch.entity.JDEntity;
import com.wf.ProfileBestMatch.entity.ProfileUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface ProfileUploadRepository extends JpaRepository<ProfileUploadEntity, Id> {


    List<ProfileUploadEntity> findByJdId(Integer jdId);

    ProfileUploadEntity findByProfileId(Integer profileId);

    void deleteByProfileId(Integer profileId);

    @Query(nativeQuery = true, value = "Select top 1 x.ID from SmartHire.Profile_Upload x order by x.ID desc")
    Integer findTopID();



}
