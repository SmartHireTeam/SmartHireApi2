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
public class JDRequest {

    private Integer jdId;
    private String jdCode;
    private String jdName;
    private String jdDescription;
    private MultipartFile jdFile;
    private String createdBy;
    private String modifiedBy;

}
