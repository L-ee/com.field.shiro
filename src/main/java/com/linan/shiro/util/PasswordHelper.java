package com.linan.shiro.util;

import com.linan.shiro.model.SysUser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码管理工具
 * Created by lee on 2016/2/26.
 */
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new
            SecureRandomNumberGenerator();

    private static String algorithName = "md5";

    private static final int hashIterations = 2;

    public static String encryptPassword(String password){
       SimpleHash simpleHash = new SimpleHash(algorithName,password,
                ByteSource.Util.bytes("qwerty".getBytes()),hashIterations);
        return simpleHash.toHex().toString();
    }


    public static void main(String[] args) {
        SysUser user = new SysUser();

    }



}
