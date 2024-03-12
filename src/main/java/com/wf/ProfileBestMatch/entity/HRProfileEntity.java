package com.wf.ProfileBestMatch.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "HR_Profile", schema = "SmartHire")
public class HRProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer hrId;

    @JsonIgnore
    @NotNull(message = "Password filed must be entered")
    @Column(name = "Password")
    private String password;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @NotNull(message = "Email ID must be entered")
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone")
    private Long phone;
    @Column(name = "City")
    private String city;
    @Column(name = "Created_Date")
    private Date createdDate;
    @Column(name = "Created_By")
    private String createdBy;
    @Column(name = "Modified_Date")
    private Date modifiedDate;
    @Column(name = "Modified_By")
    private String modifiedBy;

}
