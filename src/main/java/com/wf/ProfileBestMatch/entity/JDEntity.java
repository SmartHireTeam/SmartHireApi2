package com.wf.ProfileBestMatch.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "JOB_DESCRIPTION_UPLOAD", schema = "SmartHire")
public class JDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JD_ID")
    private Integer jdId;
    @Column(name = "JD_Code")
    private String jdCode;
    @Column(name = "JD_Name")
    private String jdName;
    @Column(name = "JD_Description")
    private String jdDescription;

    @JsonIgnore
    @Lob
    @Column(name = "JD_FILE", length = 1000)
    private byte[] jdFile;

    @Column(name = "File_Name")
    private String fileName;
    @Column(name = "File_Type")
    private String fileType;

    @Column(name = "Created_Date")
    private Date createdDate;
    @Column(name = "Created_By")
    private String createdBy;
    @Column(name = "Modified_Date")
    private Date modifiedDate;
    @Column(name = "Modified_By")
    private String modifiedBy;

}
