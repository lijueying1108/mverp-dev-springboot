package com.mverp.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="employee")
public class EmployeeEntity {

    @Id
    @Column(name="ID")
    private String id;

    @Column(name="성명")
    private String name;

    private String residRegistrNum;

    private String mobileNum;

    private String emailAddress;

    private String certification;

    private String specialNote;

    private Date hiredate;

    private String depart;

    private String position;

    private String level;

    private Date resignationDate;

    private String officeStatus;

    private String homeAddress;

    private Byte deletestatus;
}
