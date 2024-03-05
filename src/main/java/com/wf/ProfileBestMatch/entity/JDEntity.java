package com.wf.ProfileBestMatch.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "JOB_DESCRIPTION")
public class JDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JD_ID")
    private Integer jdId;
    @Column(name = "JD_Name")
    private String jdName;
    @Column(name = "JD_Description")
    private String jdDescription;
    @Column(name = "JD_Field1")
    private String jdField1;
    @Column(name = "JD_Field2")
    private String jdField2;
    @Column(name = "JD_Field3")
    private String jdField3;
    @Column(name = "JD_Field4")
    private String jdField4;
    @Column(name = "JD_Field5")
    private String jdField5;
    @Column(name = "JD_Keywords")
    private String jdKeywords;
    @Column(name = "Publish")
    private String publish;
    @Column(name = "Created_Date")
    private Date createdDate;
    @Column(name = "Created_By")
    private String createdBy;
    @Column(name = "Modified_Date")
    private Date modifiedDate;
    @Column(name = "Modified_By")
    private String modifiedBy;

}
