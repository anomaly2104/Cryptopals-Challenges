package com.uditagarwal.Set1;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by uditagarwal on 2/9/16.
 */
public class c7 {
    static public void solve() {
        String base64Data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/uditagarwal/Set1/7.txt"));
            String x;
            while ( (x = br.readLine()) != null ) {
                base64Data += x;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] ciphertext = Base64.decode(base64Data);
        System.out.println(Hex.encodeHex(ciphertext));

        Key key = new SecretKeySpec("YELLOW SUBMARINE".getBytes(), "AES");
        try {
            Cipher aes = Cipher.getInstance("AES");
            aes.init(Cipher.DECRYPT_MODE, key);

            byte[] plaintext = aes.doFinal(ciphertext);
            System.out.println(new String(plaintext));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
