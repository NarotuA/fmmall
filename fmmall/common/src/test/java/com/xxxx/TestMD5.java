package com.xxxx;

import com.qfedu.fmmall.utils.Base64Utils;
import org.junit.jupiter.api.Test;
import sun.security.provider.MD5;

public class TestMD5 {

    public static void main(String[] args) {
        String decode = Base64Utils.decode("eyJhbGciOiJIUzI1NiJ9.eyJrZXkxIjoidmFsdWUxIiwia2V5MiI6InZhbHVlMiIsImV4cCI6MTY3MDEyNjE0OX0.jpoPDD4gPeJs1Gtn2I3VZKkiD-vkO8Re_kdOksZ5Sa4");
        System.out.println(decode);
    }
}
