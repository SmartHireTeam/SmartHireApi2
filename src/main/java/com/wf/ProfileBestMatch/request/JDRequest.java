package com.wf.ProfileBestMatch.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JDRequest {

    private Integer jdId;
    private String jdName;
    private String jdDescription;
    private String jdField1;
    private String jdField2;
    private String jdField3;
    private String jdField4;
    private String jdField5;
    private String jdKeywords;
    private String publish;
    private String createdBy;
    private String modifiedBy;

}
