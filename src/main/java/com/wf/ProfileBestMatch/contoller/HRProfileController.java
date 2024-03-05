package com.wf.ProfileBestMatch.contoller;

import com.wf.ProfileBestMatch.request.HrProfileRequest;
import com.wf.ProfileBestMatch.service.HRProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wf/profileMatch/")
public class HRProfileController {

    @Autowired
    private HRProfileService hrProfileService;

    @GetMapping(value = {"/hrProfiles", "/hrProfiles/{hrId}"})
    public ResponseEntity<Object> getAllHRProfiles(@PathVariable(required = false) Integer hrId) {
        return new ResponseEntity<>(hrProfileService.getAllHrProfiles(hrId), HttpStatus.OK);
    }

    @PostMapping(value = "/hrProfiles")
    public ResponseEntity<Object> saveHrProfile(@Validated @RequestBody HrProfileRequest request) {
        return new ResponseEntity<>(hrProfileService.saveOrUpdateHrProfile(request), HttpStatus.OK);
    }
}
