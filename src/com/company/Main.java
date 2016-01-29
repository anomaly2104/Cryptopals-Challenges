package com.company;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String hexString = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";

        Base64Encoder encoder = new Base64Encoder();
        System.out.println("Base 64: " + encoder.base64EncodingFromHex(hexString));
    }
}
