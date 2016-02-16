package com.uditagarwal.Set2;

import org.apache.commons.codec.binary.Hex;

import java.util.Arrays;

public class c9 {
    public static void solve() {
        byte[] padding = PKCS7Padding("YELLOW SUBMARINE".getBytes(), 20);
        System.out.println(Hex.encodeHex(padding));
    }

    public static int numberOfPKCS7PAddingNeeded(byte[] plainText, int blockSize) {
        return blockSize - (plainText.length % blockSize);
    }

    public static byte[] PKCS7Padding(byte[] plainText, int blockSize) {
        int numPadding = numberOfPKCS7PAddingNeeded(plainText, blockSize);
        byte[] padding = new byte[numPadding];
        Arrays.fill(padding, (byte)numPadding);
        return padding;
    }
}