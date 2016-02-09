package com.uditagarwal.Set1;

import com.uditagarwal.Helpers;

import java.security.Security;
/**
 * Created by uditagarwal on 2/3/16.
 */
public class c6 {
    static public void solve() {
        String text1 = "this is a test";
        String text2 = "wokka wokka!!!";

        System.out.println("Hamming distance is: " + Helpers.hammingBitsDistance(text1.getBytes(), text2.getBytes()));
    }
}
