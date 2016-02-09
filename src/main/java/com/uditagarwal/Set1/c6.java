package com.uditagarwal.Set1;

import com.sun.org.apache.regexp.internal.StreamCharacterIterator;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.uditagarwal.Helpers;
import com.uditagarwal.RepeatingKeyXOR;
import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.Security;
import java.util.Arrays;

/**
 * Created by uditagarwal on 2/3/16.
 */
public class c6 {
    static public void solve() {
        String text1 = "this is a test";
        String text2 = "wokka wokka!!!";

//        System.out.println("Hamming distance is: " + Helpers.hammingBitsDistance(text1.getBytes(), text2.getBytes()));

        String base64Data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/uditagarwal/Set1/6.txt"));
            String x;
            while ( (x = br.readLine()) != null ) {
                base64Data += x;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(base64Data);

        byte[] ciphertextInBytes = Base64.decode(base64Data);
//        System.out.println(Hex.encodeHex(ciphertextInBytes));

        int finalKeySize = -1;
        float minHammingDistance = 876248724;
        for (int keysize = 2; keysize <= 40; keysize ++) {
            byte[] block1 = Arrays.copyOf(ciphertextInBytes, keysize);
            byte[] block2 = Arrays.copyOfRange(ciphertextInBytes, keysize, 2 * keysize);

            byte[] block3 = Arrays.copyOfRange(ciphertextInBytes, 2 * keysize, 3 * keysize);
            byte[] block4 = Arrays.copyOfRange(ciphertextInBytes, 3 * keysize, 4 * keysize);

            float hammingBitsDistance1 = Helpers.hammingBitsDistance(block1, block2) / keysize;
            float hammingBitsDistance2 = Helpers.hammingBitsDistance(block1, block3) / keysize;
            float hammingBitsDistance3 = Helpers.hammingBitsDistance(block1, block4) / keysize;
            float hammingBitsDistance4 = Helpers.hammingBitsDistance(block2, block3) / keysize;
            float hammingBitsDistance5 = Helpers.hammingBitsDistance(block2, block4) / keysize;
            float hammingBitsDistance6 = Helpers.hammingBitsDistance(block3, block4) / keysize;

            float hammingBitsDistance = (hammingBitsDistance1 + hammingBitsDistance2
                    + hammingBitsDistance3 + hammingBitsDistance4
                    + hammingBitsDistance5 + hammingBitsDistance6);

            if (hammingBitsDistance < minHammingDistance) {
                finalKeySize = keysize;
                minHammingDistance = hammingBitsDistance;
            }

//            System.out.println(keysize + ":" + hammingBitsDistance);
        }

//        System.out.println(finalKeySize + ":" + minHammingDistance);
//        System.out.println(ciphertextInBytes.length);

        byte[][] chunks = new byte[1000][];
        int current = 0;
        byte[] cipherCopy = ciphertextInBytes.clone();

        while(cipherCopy.length >= finalKeySize) {
            chunks[current] = Arrays.copyOf(cipherCopy, finalKeySize);
            cipherCopy = Arrays.copyOfRange(cipherCopy, finalKeySize, cipherCopy.length);
//            System.out.println(Hex.encodeHex(chunks[current]));
            current ++;
        }

        int numChunks = current;
//        System.out.println(numChunks);

        byte[][] transposedChunks = new byte[finalKeySize][numChunks];

        for (int i = 0; i < finalKeySize; i++) {
            for (int j = 0; j < numChunks; j++) {
                transposedChunks[i][j] = chunks[j][i];
            }
//            System.out.println(Hex.encodeHex(transposedChunks[i]));
        }
//        System.out.println();
//        System.out.println();

        byte[] resultKey = new byte[finalKeySize];
        for (int i = 0; i < finalKeySize; i++) {
            int maxChar = 0;
            resultKey[i] = -1;

            for(int j = 0; j < 256; j++) {
                byte[] key = new byte[1];
                key[0] = (byte)j;
                String result = new String(RepeatingKeyXOR.repeatingKeyXOR(transposedChunks[i], key));
                int charFreq = characterFrequency(result);
//                System.out.println((char)j + ":" + result + ":" + charFreq);

                if (charFreq > maxChar) {
                    resultKey[i] = (byte)j;
                    maxChar = charFreq;
                }
            }
        }
        System.out.println(Character.isLetter(','));
        System.out.println(new String(resultKey));
        System.out.println(new String(RepeatingKeyXOR.repeatingKeyXOR(ciphertextInBytes, resultKey)));
    }

    static public int characterFrequency(String text) {
        int freq = 0;

        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == ' ') {
                freq ++;
            }
        }
        return freq;
    }
}
