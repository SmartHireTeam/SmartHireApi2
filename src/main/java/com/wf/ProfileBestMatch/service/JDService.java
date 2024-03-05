package com.wf.ProfileBestMatch.service;

import com.wf.ProfileBestMatch.entity.JDEntity;
import com.wf.ProfileBestMatch.exception.ResourceNotFoundException;
import com.wf.ProfileBestMatch.repository.JDRepository;
import com.wf.ProfileBestMatch.request.JDRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public JDEntity saveJD(JDRequest request) {
        LOG.info("JD - Save API Call");

        //HRProfileEntity hrEntity = hrProfileRepository.findByEmail(request.getEmailId());

//        if(hrEntity != null) {
//            throw new ResourceExsitsExeption("HR Profile already exists with this Email ID: " + request.getEmailId());
//        }

        JDEntity jdEntity = new JDEntity();
        jdEntity.setCreatedBy(request.getCreatedBy());
        jdEntity.setCreatedDate(new Date());
        jdEntity.setModifiedBy(request.getModifiedBy());
        jdEntity.setModifiedDate(new Date());

        jdEntity.setJdDescription(request.getJdDescription());
        jdEntity.setJdName(request.getJdName());
        jdEntity.setJdKeywords(request.getJdKeywords());
        jdEntity.setJdField1(request.getJdField1());
        jdEntity.setJdField2(request.getJdField2());
        jdEntity.setJdField3(request.getJdField3());
        jdEntity.setJdField4(request.getJdField4());
        jdEntity.setJdField5(request.getJdField5());
        jdEntity.setPublish("N");

        jdRepository.save(jdEntity);
        return jdEntity;
    }

    @Transactional
    public JDEntity updateJD(JDRequest request) {
        LOG.info("JD - Update API Call");

        JDEntity jdEntity = jdRepository.findByJdId(request.getJdId());

        if(jdEntity == null) {
            throw new ResourceNotFoundException("JD does not exists with id : " + request.getJdId());
        }

        jdEntity.setModifiedBy(request.getModifiedBy());
        jdEntity.setModifiedDate(new Date());

        jdEntity.setJdDescription(request.getJdDescription());
        jdEntity.setJdName(request.getJdName());
        jdEntity.setJdKeywords(request.getJdKeywords());
        jdEntity.setJdField1(request.getJdField1());
        jdEntity.setJdField2(request.getJdField2());
        jdEntity.setJdField3(request.getJdField3());
        jdEntity.setJdField4(request.getJdField4());
        jdEntity.setJdField5(request.getJdField5());
        jdEntity.setPublish("N");

        jdRepository.save(jdEntity);
        return jdEntity;

    }

    @Transactional
    public void deleteJD(Integer jdId) {
        JDEntity jdEntity = jdRepository.findByJdId(jdId);
        if(jdEntity == null) {
            throw new ResourceNotFoundException("JD does not exists with id : " + jdId);
        }
        jdRepository.deleteByJdId(jdId);
    }

}
