package com.wf.ProfileBestMatch.service;

import com.wf.ProfileBestMatch.entity.JDEntity;
import com.wf.ProfileBestMatch.exception.FileEmptyException;
import com.wf.ProfileBestMatch.exception.FileFormatUnSupportedException;
import com.wf.ProfileBestMatch.exception.ResourceNotFoundException;
import com.wf.ProfileBestMatch.repository.JDRepository;
import com.wf.ProfileBestMatch.request.JDRequest;
import com.wf.ProfileBestMatch.response.JDResponse;
import com.wf.ProfileBestMatch.utillity.FileCompressDecompressUtillity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class JDService {

    private static final Logger LOG = LoggerFactory.getLogger(JDService.class);

    @Autowired
    private JDRepository jdRepository;

    public Object getAllJD(Integer jdId) {
        LOG.info("JD - Get API Call");
        if(jdId != null && jdId > 0) {
            JDEntity jdEntity = jdRepository.findByJdId(jdId);
            JDResponse response = null;
            if(jdEntity == null) {
                throw new ResourceNotFoundException("JD Profile does not exists with this Id: " + jdId);
            } else {
                response = JDResponse.builder()
                        .jdId(jdEntity.getJdId())
                        .jdCode(jdEntity.getJdCode())
                        .jdName(jdEntity.getJdName())
                        .jdDescription(jdEntity.getJdDescription())
                        .fileName(jdEntity.getFileName())
                        .fileType(jdEntity.getFileType())
                        .createdBy(jdEntity.getCreatedBy())
                        .modifiedBy(jdEntity.getModifiedBy())
                        .createdDate(jdEntity.getCreatedDate())
                        .modifiedDate(jdEntity.getModifiedDate())
                        .jdFile(FileCompressDecompressUtillity.decompressFile(jdEntity.getJdFile()))
                        .build();
            }
            return response;
        } else {
            List<JDEntity> jdEntityList = jdRepository.findAll();
            List<JDResponse> response = new LinkedList<>();

            jdEntityList.forEach(jd -> {
                response.add(JDResponse.builder()
                        .jdId(jd.getJdId())
                        .jdCode(jd.getJdCode())
                        .jdName(jd.getJdName())
                        .jdDescription(jd.getJdDescription())
                        .fileName(jd.getFileName())
                        .fileType(jd.getFileType())
                        .createdBy(jd.getCreatedBy())
                        .modifiedBy(jd.getModifiedBy())
                        .createdDate(jd.getCreatedDate())
                        .modifiedDate(jd.getModifiedDate())
                        .jdFile(FileCompressDecompressUtillity.decompressFile(jd.getJdFile()))
                        .build());

            });

            return response;

        }
    }

    @Transactional
    public JDEntity saveJD(JDRequest request) throws IOException {
        LOG.info("JD - Save API Call");

        //Validate file format
        validateFile(request);

        Integer topId = jdRepository.findTopID() + 1;

        JDEntity jdEntity = new JDEntity();
        jdEntity.setJdCode("Req_ID_" + topId);
        jdEntity.setCreatedBy(request.getCreatedBy());
        jdEntity.setCreatedDate(new Date());

        return saveUpdateJD(jdEntity, request);
    }

    @Transactional
    public JDEntity updateJD(JDRequest request) throws IOException {
        LOG.info("JD - Update API Call");

        //Validate file format
        validateFile(request);

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
        jdEntity.setJdFile(FileCompressDecompressUtillity.compressFile(request.getJdFile().getBytes()));
        jdEntity.setFileName(request.getJdFile().getOriginalFilename());
        jdEntity.setFileType(request.getJdFile().getContentType());

        jdEntity.setJdDescription(request.getJdDescription());
        jdEntity.setJdName(request.getJdName());

        jdRepository.save(jdEntity);

        jdEntity.setJdFile(FileCompressDecompressUtillity.decompressFile(jdEntity.getJdFile()));
        return jdEntity;
    }

    private void validateFile(JDRequest request) {
        if (request.getJdFile() == null || request.getJdFile().isEmpty()) {
            throw new FileEmptyException("File should not be empty");
        }
        if (!request.getJdFile().getContentType().endsWith("pdf")) {
            throw new FileFormatUnSupportedException("File format un-supported... Supporting media type is .pdf");
        }
    }

}
