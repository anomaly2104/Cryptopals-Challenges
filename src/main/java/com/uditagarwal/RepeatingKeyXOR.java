package com.uditagarwal;

/**
 * Created by uditagarwal on 2/3/16.
 */
public class RepeatingKeyXOR {
    public static byte[] repeatingKeyXOR(byte[] text, byte[] key) {
        byte[] result = new byte[text.length];

        int currentKeyIndex = 0;
        for (int i = 0; i < text.length; i++) {
            result[i] = (byte)(text[i] ^ key[currentKeyIndex]);

            currentKeyIndex += 1;
            currentKeyIndex %= key.length;
        }

        return result;
    }
}
