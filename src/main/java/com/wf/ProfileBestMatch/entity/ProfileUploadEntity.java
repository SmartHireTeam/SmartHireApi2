package com.wf.ProfileBestMatch.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Profile_Upload", schema = "SmartHire")
public class ProfileUploadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer profileId;
    @Column(name = "JD_ID")
    private Integer jdId;

    @Lob
    @Column(name = "Resume_FILE", length = 1000)
    private byte[] resumeFile;

    @Column(name = "File_Name")
    private String fileName;
    @Column(name = "File_Type")
    private String fileType;
    @Column(name = "Expected_CTC")
    private String expectedCtc;
    @Column(name = "Experience")
    private String experience;
    @Column(name = "Created_Date")
    private Date createdDate;
    @Column(name = "Created_By")
    private String createdBy;
    @Column(name = "Modified_Date")
    private Date modifiedDate;
    @Column(name = "Modified_By")
    private String modifiedBy;

}
