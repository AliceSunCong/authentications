package com.shiro.authentications.mapper;

import com.shiro.authentications.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
}
