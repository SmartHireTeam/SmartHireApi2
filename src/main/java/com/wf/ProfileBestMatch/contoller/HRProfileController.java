package com.wf.ProfileBestMatch.contoller;

import com.wf.ProfileBestMatch.service.HRProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wf/profileMatch/")
public class HRProfileController {

//    @Autowired
//    private HRProfileService hrProfileService;

    @GetMapping(value = {"/hrProfiles", "/hrProfiles/{hrId}"})
    public ResponseEntity<Object> getAllHRProfiles(@PathVariable(required = false) Integer hrId) {
        return new ResponseEntity<>("Hello HR", HttpStatus.OK);
    }

}
