package com.uditagarwal.Set1;

import com.uditagarwal.BaseConverter;
import com.uditagarwal.FixedXOR;

/**
 * Created by uditagarwal on 1/29/16.
 */
public class c2 {
    static public void solve() {
        String hexString1 = "1c0111001f010100061a024b53535009181c";
        String hexString2 = "686974207468652062756c6c277320657965";

        System.out.println("XOR Hex string: " + BaseConverter.binToHex(FixedXOR.binaryXOR(BaseConverter.hexToBin(hexString1), BaseConverter.hexToBin(hexString2))));
    }
}
