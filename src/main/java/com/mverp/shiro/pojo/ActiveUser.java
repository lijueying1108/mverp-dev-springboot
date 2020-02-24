package com.mverp.shiro.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
public class ActiveUser implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    @Setter@Getter
    private String id;
    @Setter@Getter
    private String usercode;
    @Setter@Getter
    private String username;

    @Setter@Getter
    private List<String> roles;
}
