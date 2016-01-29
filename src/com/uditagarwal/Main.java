package com.uditagarwal;

public class Main {
    public static void main(String[] args) {
        String hexString1 = "1c0111001f010100061a024b53535009181c";
        String hexString2 = "686974207468652062756c6c277320657965";

        System.out.println("XOR Hex string: " + BaseConverter.binToHex(FixedXOR.binaryXOR(BaseConverter.hexToBin(hexString1), BaseConverter.hexToBin(hexString2))));
    }
}
