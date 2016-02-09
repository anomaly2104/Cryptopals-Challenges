package com.uditagarwal;

/**
 * Created by uditagarwal on 2/5/16.
 */
public class Helpers {
    public static int hammingBitsDistance(byte[] text1, byte[] text2) {
        int hammingDistance = 0;
        for (int i= 0; i < text1.length; i++) {
            byte hammingByte = (byte)(text1[i] ^ text2[i]);
            hammingDistance += Integer.bitCount(hammingByte);;
        }
        return hammingDistance;
    }
}
