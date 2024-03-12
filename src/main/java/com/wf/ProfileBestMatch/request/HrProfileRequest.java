package com.wf.ProfileBestMatch.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HrProfileRequest {

    private Integer hrId;
    private String firstName;
    private String lastName;
    private String emailId;
    private Long phone;
    private String password;
    private String city;
    private String createdBy;
    private String modifiedBy;
}
