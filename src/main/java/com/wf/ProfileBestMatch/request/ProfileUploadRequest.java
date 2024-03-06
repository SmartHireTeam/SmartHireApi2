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

    private Integer reqId;
    private Integer jdId;
    private String fileName;
    private String fileType;
    private String filePath;
    private MultipartFile file;
    private String createdBy;
    private String modifiedBy;

}
