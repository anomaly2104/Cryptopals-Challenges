package com.uditagarwal;

import java.util.ArrayList;

/**
 * Created by uditagarwal on 2/9/16.
 */
public class ArrayHelpers {
    public static byte[][] chunkByteArray(byte[] array, int chunkSize) {
        int numOfChunks = (int)Math.ceil((double)array.length / chunkSize);
        byte[][] output = new byte[numOfChunks][];

        for(int i = 0; i < numOfChunks; ++i) {
            int start = i * chunkSize;
            int length = Math.min(array.length - start, chunkSize);

            byte[] temp = new byte[length];
            System.arraycopy(array, start, temp, 0, length);
            output[i] = temp;
        }

        return output;
    }

    public static String[] chunkStringArray(String originalString, int chunkSize) {
        ArrayList<String> output = new ArrayList<String>();

        for(int i = 0; i < originalString.length(); i += chunkSize) {
            output.add(originalString.substring(i, i + chunkSize));
        }

        String[] outputArr = new String[output.size()];

        output.toArray(outputArr);
        return outputArr;
    }
}
