package com.jiajun.starter.common.utils;

import com.jiajun.starter.common.exception.BusinessException;
import com.jiajun.starter.common.web.RestCode;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * @Author: 影风
 * @Date: 2019-08-09 10:36
 * @Description:
 */
public class TokenUtil {
    public static String createToken() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    private static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    private static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new BusinessException(RestCode.TOKEN_CREATE_FAIL);
        }
    }
}
