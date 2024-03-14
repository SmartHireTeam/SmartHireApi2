package com.wf.ProfileBestMatch.service;

import com.wf.ProfileBestMatch.entity.JDEntity;
import com.wf.ProfileBestMatch.entity.ProfileUploadEntity;
import com.wf.ProfileBestMatch.exception.FileEmptyException;
import com.wf.ProfileBestMatch.exception.FileFormatUnSupportedException;
import com.wf.ProfileBestMatch.exception.ResourceNotFoundException;
import com.wf.ProfileBestMatch.repository.ProfileUploadRepository;
import com.wf.ProfileBestMatch.request.ProfileUploadRequest;
import com.wf.ProfileBestMatch.utillity.FileCompressDecompressUtillity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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
                throw new ResourceNotFoundException("JD does not exists with this JD Id: " + jdId);
            }
            return uploadedProfiles;
        } else {
            // return all the list of profiles under all JDs
            return profileUploadRepository.findAll();
        }
    }

    public Object getSingleUploadedProfile(Integer profileId) {
        LOG.info("JD - Get API Call");
        if(profileId != null && profileId > 0) {
            ProfileUploadEntity uploadedProfiles = profileUploadRepository.findByProfileId(profileId);
            if(uploadedProfiles == null) {
                throw new ResourceNotFoundException("Profile does not exists under this profile Id: " + profileId);
            }
            return uploadedProfiles;
        } else {
            return profileUploadRepository.findAll();
        }
    }

    @Transactional
    public ProfileUploadEntity saveProfile(ProfileUploadRequest request) throws IOException {
        LOG.info("Profile Upload - Save API Call");

        //Validate file format
        validateFile(request);

        ProfileUploadEntity uploadEntity = new ProfileUploadEntity();
        uploadEntity.setCreatedBy(request.getCreatedBy());
        uploadEntity.setCreatedDate(new Date());

        return saveUpdateProfile(uploadEntity, request);
    }

    @Transactional
    public ProfileUploadEntity updateProfile(ProfileUploadRequest request) throws IOException {
        LOG.info("Profile Upload - Update API Call");

        //Validate file format
        validateFile(request);

        ProfileUploadEntity uploadEntity = profileUploadRepository.findByProfileId(request.getProfileId());

        if(uploadEntity == null) {
            throw new ResourceNotFoundException("Profile does not exists with id : " + request.getProfileId());
        }

        return saveUpdateProfile(uploadEntity, request);
    }

    @Transactional
    public void deleteJD(Integer profileId) {
        ProfileUploadEntity uploadEntity = profileUploadRepository.findByProfileId(profileId);
        if(uploadEntity == null) {
            throw new ResourceNotFoundException("Profile does not exists with id : " + profileId);
        }
        profileUploadRepository.deleteByProfileId(profileId);
    }

    private ProfileUploadEntity saveUpdateProfile(ProfileUploadEntity uploadEntity, ProfileUploadRequest request) throws IOException {
        uploadEntity.setJdId(request.getJdId());
        uploadEntity.setModifiedBy(request.getModifiedBy());
        uploadEntity.setModifiedDate(new Date());
        uploadEntity.setExpectedCtc(request.getExpectedCtc());
        uploadEntity.setExperience(request.getExperience());
        uploadEntity.setFileType(request.getResumeFile().getContentType());
        uploadEntity.setFileName(request.getResumeFile().getOriginalFilename());
        uploadEntity.setResumeFile(FileCompressDecompressUtillity.compressFile(request.getResumeFile().getBytes()));

        profileUploadRepository.save(uploadEntity);
        return uploadEntity;
    }

    private void validateFile(ProfileUploadRequest request) {
        if (request.getResumeFile() == null || request.getResumeFile().isEmpty()) {
            LOG.error("File not found: " + request.getResumeFile());
            throw new FileEmptyException("File should not be null or empty");
        }
        if (!request.getResumeFile().getContentType().endsWith("pdf") &&
                !request.getResumeFile().getContentType().endsWith("docx")) {
            throw new FileFormatUnSupportedException("File format un-supported... Supporting media type is .pdf and .docx");
        }
    }
}
