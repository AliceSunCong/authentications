package com.shiro.authentications.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Date createTime;
    private String status;
}
