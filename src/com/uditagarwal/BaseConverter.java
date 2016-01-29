package com.uditagarwal;

/**
 * Created by uditagarwal on 1/29/16.
 */
public class BaseConverter {
    static private String hexToBin(char hex) {
        int i = Integer.parseInt(Character.toString(hex), 16);
        return String.format("%04d", Integer.parseInt(Integer.toBinaryString(i)));
    }

    static public String hexToBin(String s) {
        String bin = "";
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            bin += hexToBin(c);
        }
        return bin;
    }

    static public String binToHex(String bin) {
        int blockLength = 4;
        assert bin.length() % blockLength == 0;
        String result = "";
        for(int i = 0; i < bin.length(); i += blockLength) {
            String block = bin.substring(i, i + blockLength);
            int decimal = Integer.parseInt(block, 2);
            result += Integer.toHexString(decimal);
        }
        return result;
    }
}
