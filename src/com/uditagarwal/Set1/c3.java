package com.uditagarwal.Set1;

import com.uditagarwal.BaseConverter;
import com.uditagarwal.FixedXOR;

/**
 * Created by uditagarwal on 1/29/16.
 */
public class c3 {
    static public String singleByteXORText(String textBin, String keyBin) {
        int blockLength = 8;
        assert textBin.length() % blockLength == 0;
        String cipher = "";
        for(int j = 0; j < textBin.length(); j += blockLength) {
            String block = textBin.substring(j, j + blockLength);
            String xor = FixedXOR.binaryXOR(block, keyBin);
            char ch = (char) Integer.parseInt(xor, 2);
            cipher += ch;
        }
        return cipher;
    }

    static public void solve() {
        String cipherHex = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        String cipherBin = BaseConverter.hexToBin(cipherHex);
        for (int i = 0; i < 255; i++ ) {
            String keyBin = String.format("%08d",Integer.parseInt(Integer.toBinaryString(i)));
            System.out.println((char) i + " : " + singleByteXORText(cipherBin, keyBin));
        }
    }
}
