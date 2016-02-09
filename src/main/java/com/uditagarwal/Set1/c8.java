package com.uditagarwal.Set1;

import com.uditagarwal.ArrayHelpers;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by uditagarwal on 2/9/16.
 */
public class c8 {
    public static void solve() {
        try {
            _solve();
        } catch (DecoderException e) {
            e.printStackTrace();
        }
    }

    public static void _solve() throws DecoderException {
        ArrayList<String> hexData = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/uditagarwal/Set1/8.txt"));
            String x;
            while ( (x= br.readLine()) != null ) {
                hexData.add(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[][] data = new byte[hexData.size()][];

        for (String aHexData : hexData) {
            String[] chunks = ArrayHelpers.chunkStringArray(aHexData, 16);
            int count = countRepeatingStrings(chunks);

            if (count > 0) {
                System.out.println(count);
                System.out.println(aHexData);
            }
        }
    }

    public static int countRepeatingStrings(String[] strings){
        int count = 0;

        for (int i = 0; i < strings.length; i++) {
            Map<String, Boolean> map = new HashMap<String, Boolean>();

            String str = strings[i];
            if (map.get(str) == null) {
//                System.out.println(str);

                for (int j = i + 1; j < strings.length; j++) {
                    if (str.equals(strings[j])) {
                        count ++;
                    }
                }

                map.put(str, true);
            }
        }

        return count;
    }
}
