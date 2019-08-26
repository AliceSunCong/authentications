package com.shiro.authentications.mapper;

import com.shiro.authentications.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleMapper {
    List<Role> findByUsername(String username);
}
