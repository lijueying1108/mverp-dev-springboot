package com.mverp.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {

    private @Getter @Setter String msg;
    private @Getter @Setter Object data;
    private @Getter @Setter boolean status;
    private @Getter @Setter String code;

    public ResponseBean(String code,Object data){
        this.code = code;
        if ( data != null) {
            this.data = data;
            this.status = true;
        } else {
            this.status= false;
            this.msg = "서버가 문제 있습니다.";
        }
    }

    public ResponseBean(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

}
