package com.wf.ProfileBestMatch.service;

import com.wf.ProfileBestMatch.entity.HRProfileEntity;
import com.wf.ProfileBestMatch.repository.HRProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class HRProfileService {

//    @Autowired
//    private HRProfileRepository hrProfileRepository;

    public List<HRProfileEntity> getAllHrProfiles(Integer hrId) {
        List<HRProfileEntity> hrProfileList = new LinkedList<>();
        if(hrId != null && hrId > 0) {
            //hrProfileList = hrProfileRepository.
        } else {

        }
        return null;
    }

}
