package com.wf.ProfileBestMatch.contoller;

import com.wf.ProfileBestMatch.exception.FileFormatUnSupportedException;
import com.wf.ProfileBestMatch.request.JDRequest;
import com.wf.ProfileBestMatch.request.ProfileUploadRequest;
import com.wf.ProfileBestMatch.service.ProfileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;

@RestController
@RequestMapping("/wf/profileMatch/")
public class ProfileUploadController {

    @Autowired
    private ProfileUploadService uploadService;

    @GetMapping(value = "/profileUpload")
    public ResponseEntity<Object> getAllJDProfiles() {
        return new ResponseEntity<>(uploadService.getAllUploadedProfiles(null), HttpStatus.OK);
    }

    @GetMapping(value = "/profileUpload/{jdId}")
    public ResponseEntity<Object> getSingleJdAllProfiles(@PathVariable(required = true) Integer jdId) {
        return new ResponseEntity<>(uploadService.getAllUploadedProfiles(jdId), HttpStatus.OK);
    }

    @GetMapping(value = "/singleProfile/{profileId}")
    public ResponseEntity<Object> getSingleJDploadedProfile(@PathVariable(required = true) Integer profileId) {
        return new ResponseEntity<>(uploadService.getSingleUploadedProfile(profileId), HttpStatus.OK);
    }

    @PostMapping(value = "/profileUpload")
    public ResponseEntity<?> saveProfile(@ModelAttribute ProfileUploadRequest request, Model model) throws IOException {
        return new ResponseEntity<>(uploadService.saveProfile(request), HttpStatus.OK);
    }

    @PutMapping(value = "/profileUpload")
    public ResponseEntity<?> updateProfile(@ModelAttribute ProfileUploadRequest request, Model model,
                                         RedirectAttributes redirectAttributes) throws IOException {
        return new ResponseEntity<>(uploadService.updateProfile(request), HttpStatus.OK);
    }


}
