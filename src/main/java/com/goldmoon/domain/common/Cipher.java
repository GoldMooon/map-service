package com.goldmoon.domain.common;

import org.apache.commons.codec.binary.Hex;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Cipher {

    private static String sKey = "VVPsvMDC4drHdKazHSEzGfrNcSjvDa5a";
    private static Key secretKeySpec = new SecretKeySpec(sKey.getBytes(), "AES");

    public static String encrypt(String origin) {
        if (StringUtils.isEmpty(origin)) {
            return null;
        }

        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");
            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] encryptedData = cipher.doFinal(origin.getBytes());

            return Hex.encodeHexString(encryptedData);
        } catch (Exception exception) {
            return null;
        }
    }

    public static String decrypt(String encrypted) {
        if (StringUtils.isEmpty(encrypted)) {
            return null;
        }

        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] decryptedData = cipher.doFinal(Hex.decodeHex(encrypted));
            return new String(decryptedData);
        } catch (Exception exception) {
            return null;
        }
    }
}
