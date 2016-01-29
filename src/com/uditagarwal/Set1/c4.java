package com.uditagarwal.Set1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by uditagarwal on 1/29/16.
 */
public class c4 {
    public static void solve() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./4.txt"));
            String x;
            while ( (x = br.readLine()) != null ) {
                System.out.println(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
