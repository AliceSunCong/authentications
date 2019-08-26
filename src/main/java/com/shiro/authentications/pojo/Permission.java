package com.shiro.authentications.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
public class Permission implements Serializable {
    private Integer id;
    private String url;
    private String name;
}
