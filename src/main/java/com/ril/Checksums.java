package com.ril;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;

public class Checksums {

    public static void main(String[] args) {
        String key = "ZYJqLYoWSZv+nwn+PhvZFw==";
        String generic = "RURPTDEA0001007"+"100002000000577";
        String checkSumCreated = "";
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            mac.init(secretKey);
            checkSumCreated = Base64.encodeBase64String(mac.doFinal(generic.getBytes()));
        } catch (Exception ex) {
        }
        System.out.println(checkSumCreated);
    }
}