package com.mverp.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="sys_user")
public class SysUserEntity implements Serializable {

        @Id
        @NonNull
        private String id;


        @NonNull
        private String username;
        @NonNull
        private String password;
        @NonNull
        private String salt;
        @NonNull
        private String locked;
        @NonNull
        private String emloyeeid;

}
