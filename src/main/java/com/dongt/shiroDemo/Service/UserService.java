package com.dongt.shiroDemo.Service;

import com.dongt.shiroDemo.domain.User;

import java.util.Set;

public interface UserService {

    User findByUsername(String username);// 根据用户名查找用户
    Set<String> findRoles(String username);// 根据用户名查找其角色
    Set<String> findPermissions(String username); //根据用户名查找其权限
}
