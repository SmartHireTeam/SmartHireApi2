package com.wf.ProfileBestMatch.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JDResponse {

    private Integer jdId;
    private String jdCode;
    private String jdName;
    private String jdDescription;
    private byte[] jdFile;
    private String fileName;
    private String fileType;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;

}
