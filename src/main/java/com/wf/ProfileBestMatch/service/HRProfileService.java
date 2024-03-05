package com.wf.ProfileBestMatch.service;

import com.wf.ProfileBestMatch.entity.HRProfileEntity;
import com.wf.ProfileBestMatch.exception.ResourceExsitsExeption;
import com.wf.ProfileBestMatch.exception.ResourceNotFoundException;
import com.wf.ProfileBestMatch.repository.HRProfileRepository;
import com.wf.ProfileBestMatch.request.HrProfileRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class HRProfileService {

    private static final Logger LOG = LoggerFactory.getLogger(HRProfileService.class);

    @Autowired
    private HRProfileRepository hrProfileRepository;

    public Object getAllHrProfiles(Integer hrId) {
        LOG.info("HR Profile - Get API Call");
        if(hrId != null && hrId > 0) {
            HRProfileEntity hrEntity = hrProfileRepository.findByHrId(hrId);
            if(hrEntity == null) {
                throw new ResourceNotFoundException("HR Profile not found with id : " + hrId);
            }
            return hrEntity;
        } else {
            return hrProfileRepository.findAll();
        }
    }

    @Transactional
    public HRProfileEntity saveHrProfile(HrProfileRequest request) {
        LOG.info("HR Profile - Save API Call");

        HRProfileEntity hrEntity = hrProfileRepository.findByEmail(request.getEmailId());

        if(hrEntity != null) {
            throw new ResourceExsitsExeption("HR Profile already exists with this Email ID: " + request.getEmailId());
        }

        hrEntity = new HRProfileEntity();
        hrEntity.setCreatedBy(request.getCreatedBy());
        hrEntity.setCreatedDate(new Date());
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

    @Transactional
    public HRProfileEntity updateHrProfile(HrProfileRequest request) {
        LOG.info("HR Profile - Save API Call");

        HRProfileEntity hrEntity = hrProfileRepository.findByHrId(request.getHrId());

        if(hrEntity == null) {
            throw new ResourceNotFoundException("HR Profile not found with id : " + request.getHrId());
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

    @Transactional
    public void deleteHrProfile(Integer hrId) {
        HRProfileEntity hrProfileList = hrProfileRepository.findByHrId(hrId);
        if(hrProfileList == null) {
            throw new ResourceNotFoundException("HR Profile does not exists with id : " + hrId);
        }
        hrProfileRepository.deleteByHrId(hrId);
    }

}
