package com.wf.ProfileBestMatch.service;

import com.wf.ProfileBestMatch.entity.JDEntity;
import com.wf.ProfileBestMatch.exception.FileEmptyException;
import com.wf.ProfileBestMatch.exception.FileFormatUnSupportedException;
import com.wf.ProfileBestMatch.exception.ResourceNotFoundException;
import com.wf.ProfileBestMatch.repository.JDRepository;
import com.wf.ProfileBestMatch.request.JDRequest;
import com.wf.ProfileBestMatch.utillity.FileCompressDecompressUtillity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;

@Service
public class JDService {

    private static final Logger LOG = LoggerFactory.getLogger(JDService.class);

    @Autowired
    private JDRepository jdRepository;

    public Object getAllJD(Integer jdId) {
        LOG.info("JD - Get API Call");
        if(jdId != null && jdId > 0) {
            JDEntity jdEntity = jdRepository.findByJdId(jdId);
            if(jdEntity == null) {
                throw new ResourceNotFoundException("JD Profile does not exists with this Id: " + jdId);
            }
            return jdEntity;
        } else {
            return jdRepository.findAll();
        }
    }

    @Transactional
    public JDEntity saveJD(JDRequest request) throws IOException {
        LOG.info("JD - Save API Call");

        JDEntity jdEntity = new JDEntity();
        jdEntity.setCreatedBy(request.getCreatedBy());
        jdEntity.setCreatedDate(new Date());

        return saveUpdateJD(jdEntity, request);
    }

    @Transactional
    public JDEntity updateJD(JDRequest request) throws IOException {
        LOG.info("JD - Update API Call");

        JDEntity jdEntity = jdRepository.findByJdId(request.getJdId());

        if(jdEntity == null) {
            throw new ResourceNotFoundException("JD does not exists with id : " + request.getJdId());
        }

        return saveUpdateJD(jdEntity, request);
    }

    @Transactional
    public void deleteJD(Integer jdId) {
        JDEntity jdEntity = jdRepository.findByJdId(jdId);
        if(jdEntity == null) {
            throw new ResourceNotFoundException("JD does not exists with id : " + jdId);
        }
        jdRepository.deleteByJdId(jdId);
    }


    private JDEntity saveUpdateJD(JDEntity jdEntity, JDRequest request) throws IOException {
        jdEntity.setModifiedBy(request.getModifiedBy());
        jdEntity.setModifiedDate(new Date());

        //File to Upload
        if (request.getJdFile().isEmpty()) {
            throw new FileEmptyException("File should not be empty");
        }

        if (!request.getJdFile().getContentType().contains(".pdf") ||
                !request.getJdFile().getContentType().contains(".docx")) {
            throw new FileFormatUnSupportedException("File format un-supported... Supporting media type is .pdf and .docx");
        }


        jdEntity.setJdFile(FileCompressDecompressUtillity.compressImage(request.getJdFile().getBytes()));
        jdEntity.setFileName(request.getJdFile().getOriginalFilename());
        jdEntity.setFileType(request.getJdFile().getContentType());

        jdEntity.setJdDescription(request.getJdDescription());
        jdEntity.setJdName(request.getJdName());
        jdEntity.setJdCode(request.getJdCode());

        jdRepository.save(jdEntity);
        return jdEntity;
    }

}
