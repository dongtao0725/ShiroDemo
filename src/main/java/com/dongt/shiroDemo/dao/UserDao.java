package com.dongt.shiroDemo.dao;

import com.dongt.shiroDemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserDao {

    User findByUsername(String username);// 根据用户名查找用户
    Set<String> findRoles(String username);// 根据用户名查找其角色
    Set<String> findPermissions(String username); //根据用户名查找其权限

}
