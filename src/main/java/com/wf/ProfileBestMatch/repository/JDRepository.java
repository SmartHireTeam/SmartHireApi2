package com.wf.ProfileBestMatch.repository;


import com.wf.ProfileBestMatch.entity.JDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface JDRepository extends JpaRepository<JDEntity, Id> {

    JDEntity findByJdId(Integer jdId);

    void deleteByJdId(Integer jdId);

}
