package com.uditagarwal;

/**
 * Created by uditagarwal on 1/29/16.
 */
public class FixedXOR {
    public static String binaryXOR(String binary1, String binary2) {
        assert binary1.length() == binary2.length();
        String result = "";

        for (int i = 0; i < binary1.length(); i++) {
            result += binary1.charAt(i) == binary2.charAt(i) ? "0" : "1";
        }

        return result;
    }
}
