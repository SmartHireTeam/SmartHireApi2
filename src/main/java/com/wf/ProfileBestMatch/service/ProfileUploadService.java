package com.wf.ProfileBestMatch.service;

import com.wf.ProfileBestMatch.entity.ProfileUploadEntity;
import com.wf.ProfileBestMatch.exception.ResourceNotFoundException;
import com.wf.ProfileBestMatch.repository.ProfileUploadRepository;
import com.wf.ProfileBestMatch.request.ProfileUploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ProfileUploadService {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileUploadService.class);

    @Autowired
    private ProfileUploadRepository profileUploadRepository;

    public Object getAllJD(Integer jdId) {
        LOG.info("JD - Get API Call");
        if(jdId != null && jdId > 0) {
            ProfileUploadEntity jdEntity = profileUploadRepository.findByReqId(jdId);
            if(jdEntity == null) {
                throw new ResourceNotFoundException("JD Profile does not exists with this Id: " + jdId);
            }
            return jdEntity;
        } else {
            return profileUploadRepository.findAll();
        }
    }

    @Transactional
    public ProfileUploadEntity uploadProfileFile(ProfileUploadRequest request) {
        LOG.info("JD - Save API Call");

        //HRProfileEntity hrEntity = hrProfileRepository.findByEmail(request.getEmailId());

//        if(hrEntity != null) {
//            throw new ResourceExsitsExeption("HR Profile already exists with this Email ID: " + request.getEmailId());
//        }

        ProfileUploadEntity jdEntity = new ProfileUploadEntity();
        jdEntity.setCreatedBy(request.getCreatedBy());
        jdEntity.setCreatedDate(new Date());
        jdEntity.setModifiedBy(request.getModifiedBy());
        jdEntity.setModifiedDate(new Date());

        profileUploadRepository.save(jdEntity);
        return jdEntity;
    }

    @Transactional
    public ProfileUploadEntity updateJD(ProfileUploadRequest request) {
        LOG.info("JD - Update API Call");

        ProfileUploadEntity jdEntity = profileUploadRepository.findByReqId(request.getJdId());

        if(jdEntity == null) {
            throw new ResourceNotFoundException("JD does not exists with id : " + request.getJdId());
        }

        jdEntity.setModifiedBy(request.getModifiedBy());
        jdEntity.setModifiedDate(new Date());

        profileUploadRepository.save(jdEntity);
        return jdEntity;

    }

    @Transactional
    public void deleteJD(Integer jdId) {
        ProfileUploadEntity jdEntity = profileUploadRepository.findByReqId(jdId);
        if(jdEntity == null) {
            throw new ResourceNotFoundException("JD does not exists with id : " + jdId);
        }
        profileUploadRepository.deleteByReqId(jdId);
    }

}
