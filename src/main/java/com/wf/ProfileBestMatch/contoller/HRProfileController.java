package com.wf.ProfileBestMatch.contoller;

import com.wf.ProfileBestMatch.request.HrProfileRequest;
import com.wf.ProfileBestMatch.service.HRProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        return new ResponseEntity<>(hrProfileService.saveHrProfile(request), HttpStatus.OK);
    }

    @PutMapping(value = "/hrProfiles")
    public ResponseEntity<Object> updateProfile(@Validated @RequestBody HrProfileRequest request) {
        return new ResponseEntity<>(hrProfileService.updateHrProfile(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/hrProfiles/{hrId}")
    public ResponseEntity<Object> deleteProfile(@PathVariable(required = true) Integer hrId) {
        hrProfileService.deleteHrProfile(hrId);
        return new ResponseEntity<>("HR Profile with ID{} " + hrId + " Deleted Successfully", HttpStatus.OK);
    }

}
