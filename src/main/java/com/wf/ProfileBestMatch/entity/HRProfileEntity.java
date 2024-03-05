package com.wf.ProfileBestMatch.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "HR_Profile") //, schema = "wf_hackathon_2024"
public class HRProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer hrId;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
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
