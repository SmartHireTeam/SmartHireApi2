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
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class ProfileUploadService {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileUploadService.class);

    @Autowired
    private ProfileUploadRepository profileUploadRepository;

    public Object getAllUploadedProfiles(Integer jdId) {
        LOG.info("JD - Get API Call");
        if(jdId != null && jdId > 0) {
            List<ProfileUploadEntity> uploadedProfiles = profileUploadRepository.findByJdId(jdId);
            if(uploadedProfiles == null || uploadedProfiles.size() == 0) {
                throw new ResourceNotFoundException("Profiles does not exists under this JD Id: " + jdId);
            }
            return uploadedProfiles;
        } else {
            return profileUploadRepository.findAll();
        }
    }

    public Object getSingleUploadedProfile(Integer reqId) {
        LOG.info("JD - Get API Call");
        if(reqId != null && reqId > 0) {
            ProfileUploadEntity uploadedProfiles = profileUploadRepository.findByReqId(reqId);
            if(uploadedProfiles == null) {
                throw new ResourceNotFoundException("Profile does not exists under this Req Id: " + reqId);
            }
            return uploadedProfiles;
        } else {
            return profileUploadRepository.findAll();
        }
    }

    @Transactional
    public ProfileUploadEntity uploadProfileFile(ProfileUploadRequest request) {
        LOG.info("JD - Save API Call");
        ProfileUploadEntity uploadEntity = new ProfileUploadEntity();
        uploadEntity.setJdId(request.getJdId());

        uploadEntity.setCreatedBy(request.getCreatedBy());
        uploadEntity.setCreatedDate(new Date());
        uploadEntity.setModifiedBy(request.getModifiedBy());
        uploadEntity.setModifiedDate(new Date());

        uploadEntity.setFileType(request.getFileType());
        uploadEntity.setFileName(request.getFileName());
        uploadEntity.setFilePath(request.getFilePath());

//        uploadEntity.setFileType(request.getFile().getContentType());
//        uploadEntity.setFileName(request.getFile().getOriginalFilename());
//        uploadEntity.setFilePath(request.getFile().getName());

        profileUploadRepository.save(uploadEntity);
        return uploadEntity;
    }


}
