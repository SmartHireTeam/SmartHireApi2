package com.wf.ProfileBestMatch.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



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
    private String createdBy;
    private String modifiedBy;

}
