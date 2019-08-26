package com.shiro.authentications.mapper;

import com.shiro.authentications.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PermissionMapper {
    List<Permission> findByUsername(String username);
}
