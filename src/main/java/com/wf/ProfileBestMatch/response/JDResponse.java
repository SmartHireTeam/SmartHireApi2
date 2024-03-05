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

    private Integer id;
    private String empId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phone;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;

}
