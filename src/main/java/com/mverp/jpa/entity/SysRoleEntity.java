package com.mverp.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="sys_role")
public class SysRoleEntity {

    @Id
    @NonNull
    private String id;
    @NonNull
    private String name;
}
