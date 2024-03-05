package com.wf.ProfileBestMatch.repository;


import com.wf.ProfileBestMatch.entity.HRProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface HRProfileRepository extends JpaRepository<HRProfileEntity, Id> {

    List<HRProfileEntity> findAllByHrId(Integer id);

}
