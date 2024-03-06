package com.wf.ProfileBestMatch.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Upload_Profile")
public class ProfileUploadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Req_ID")
    private Integer reqId;
    @Column(name = "JD_ID")
    private Integer jdId;
    @Column(name = "File_Name")
    private String fileName;
    @Column(name = "File_Type")
    private String fileType;
    @Column(name = "File_Path")
    private String filePath;
    //@Column(name)
    //private byte[] file;
    @Column(name = "Created_Date")
    private Date createdDate;
    @Column(name = "Created_By")
    private String createdBy;
    @Column(name = "Modified_Date")
    private Date modifiedDate;
    @Column(name = "Modified_By")
    private String modifiedBy;

}
