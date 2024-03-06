package com.wf.ProfileBestMatch.contoller;

import com.wf.ProfileBestMatch.exception.FileFormatUnSupportedException;
import com.wf.ProfileBestMatch.request.ProfileUploadRequest;
import com.wf.ProfileBestMatch.service.ProfileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;

@RestController
@RequestMapping("/wf/profileMatch/")
public class ProfileUploadController {

    @Autowired
    private ProfileUploadService uploadService;

    @GetMapping(value = "/allJdFiles")
    public ResponseEntity<Object> getAllJDFileList() {
        return new ResponseEntity<>(uploadService.getAllUploadedProfiles(null), HttpStatus.OK);
    }

    @GetMapping(value = "/jdFileList/{jdId}")
    public ResponseEntity<Object> getJdFiles(@PathVariable(required = true) Integer jdId) {
        return new ResponseEntity<>(uploadService.getAllUploadedProfiles(jdId), HttpStatus.OK);
    }

    @GetMapping(value = "/singleJDResumeFile/{resumeId}")
    public ResponseEntity<Object> getSingleJDploadedProfile(@PathVariable(required = true) Integer resumeId) {
        return new ResponseEntity<>(uploadService.getSingleUploadedProfile(resumeId), HttpStatus.OK);
    }

    @PostMapping(value = "/uploadJDProfile")
    public ResponseEntity<?> uploadFile(@RequestBody ProfileUploadRequest request) throws IOException {
//        FileNameMap fileNameMap = URLConnection.getFileNameMap();
//        String mimeType = fileNameMap.getContentTypeFor(request.getFile().getName());
        return new ResponseEntity<>(uploadService.uploadProfileFile(request), HttpStatus.OK);
//        if(mimeType.contains("xlsx") || mimeType.contains("xls") || mimeType.contains("pdf") || mimeType.contains("txt")) {
//            return new ResponseEntity<>(uploadService.uploadProfileFile(request), HttpStatus.OK);
//        }
//        throw new FileFormatUnSupportedException("Unsupported File format");
    }

//    @GetMapping("/{fileName}")
//    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
//        byte[] imageData = null;//service.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);
//    }

}
