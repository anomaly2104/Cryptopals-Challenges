package com.uditagarwal.Set1;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by uditagarwal on 1/29/16.
 */
public class c4 {
    public static void solve() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/com/uditagarwal/Set1/4.txt"));
            String x;
            while ( (x = br.readLine()) != null ) {
                String text = c3.guessedTextForSingleByteXORCipher(x);
                int freq = c3.characterFrequency(text);
                if (freq == 24) {
                    System.out.println(x + " : " + text + freq);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
