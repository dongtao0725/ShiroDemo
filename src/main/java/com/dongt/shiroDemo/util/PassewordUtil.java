package com.dongt.shiroDemo.util;

import com.dongt.shiroDemo.domain.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/** 用来添加用户和修改密码时加密*/
public class PassewordUtil {

    public void Encryption(User user){
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        SimpleHash hash = new SimpleHash("SHA-256", user.getPassword(), user.getUserName() + salt, 2);
        user.setPassword(hash.toString());
        user.setSalt(salt);
        }
}
