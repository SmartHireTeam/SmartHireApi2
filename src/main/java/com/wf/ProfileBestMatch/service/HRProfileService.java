package com.wf.ProfileBestMatch.service;

import com.wf.ProfileBestMatch.entity.HRProfileEntity;
import com.wf.ProfileBestMatch.repository.HRProfileRepository;
import com.wf.ProfileBestMatch.request.HrProfileRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class HRProfileService {

    private static final Logger LOG = LoggerFactory.getLogger(HRProfileService.class);

    @Autowired
    private HRProfileRepository hrProfileRepository;

    public List<HRProfileEntity> getAllHrProfiles(Integer hrId) {
        LOG.info("HR Profile - Get API Call");
        List<HRProfileEntity> hrProfileList = new LinkedList<>();
        if(hrId != null && hrId > 0) {
            hrProfileList = hrProfileRepository.findAllByHrId(hrId);
        } else {
            hrProfileList = hrProfileRepository.findAll();
        }
        return hrProfileList;
    }

    public HRProfileEntity saveOrUpdateHrProfile(HrProfileRequest request) {
        LOG.info("HR Profile - Save API Call");

        HRProfileEntity hrEntity = null;

        try {
            List<HRProfileEntity> hrProfileList = new LinkedList<>();
            hrProfileList = hrProfileRepository.findAllByHrId(request.getHrId());
            if(hrProfileList != null && hrProfileList.size() > 0) {
                hrEntity = hrProfileList.get(0);
            }
        } catch(Exception e) {
            LOG.error("Exception to fetch HR Profile: " + e.getMessage());
            e.printStackTrace();
        }

        if(hrEntity == null) {
            hrEntity = new HRProfileEntity();
            hrEntity.setCreatedBy(request.getCreatedBy());
            hrEntity.setCreatedDate(new Date());
        }

        hrEntity.setFirstName(request.getFirstName());
        hrEntity.setLastName(request.getLastName());
        hrEntity.setEmail(request.getEmailId());
        hrEntity.setPhone(request.getPhone());
        hrEntity.setCity(request.getCity());
        hrEntity.setModifiedBy(request.getModifiedBy());
        hrEntity.setModifiedDate(new Date());

        hrProfileRepository.save(hrEntity);
        return hrEntity;
    }
}
