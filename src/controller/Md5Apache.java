package controller;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Apache {
    public String encryptText(String st) {
        String md5Hex = DigestUtils.md5Hex(st);
        return md5Hex;
    }

}
