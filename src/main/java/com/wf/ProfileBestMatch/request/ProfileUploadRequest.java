package com.wf.ProfileBestMatch.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileUploadRequest {

    private Integer profileId;
    private Integer jdId;
    private MultipartFile resumeFile;
    private String expectedCtc;
    private String experience;
    private String createdBy;
    private String modifiedBy;

}
