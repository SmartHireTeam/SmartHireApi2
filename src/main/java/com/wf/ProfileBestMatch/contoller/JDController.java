package com.wf.ProfileBestMatch.contoller;

import com.wf.ProfileBestMatch.request.JDRequest;
import com.wf.ProfileBestMatch.service.JDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wf/profileMatch/")
public class JDController {

    @Autowired
    private JDService jdService;

    @GetMapping(value = {"/jd", "/jd/{jdId}"})
    public ResponseEntity<Object> getAllJDs(@PathVariable(required = false) Integer jdId) {
        return new ResponseEntity<>(jdService.getAllJD(jdId), HttpStatus.OK);
    }

    @PostMapping(value = "/jd")
    public ResponseEntity<Object> saveJD(@Validated @RequestBody JDRequest request) {
        return new ResponseEntity<>(jdService.saveJD(request), HttpStatus.OK);
    }

    @PutMapping(value = "/jd")
    public ResponseEntity<Object> updateJD(@Validated @RequestBody JDRequest request) {
        return new ResponseEntity<>(jdService.updateJD(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/jd/{jdId}")
    public ResponseEntity<Object> deleteJD(@PathVariable(required = true) Integer jdId) {
        jdService.deleteJD(jdId);
        return new ResponseEntity<>("Job Description with ID " + jdId + " Deleted Successfully", HttpStatus.OK);
    }

}
