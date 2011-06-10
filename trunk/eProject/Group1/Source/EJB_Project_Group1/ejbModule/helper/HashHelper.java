package helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashHelper {
    //convert a normal string to a md5 hashed string
    public static String hashMD5(String plainText) {
        //String plaintext = 'your text here'; 
        MessageDigest m;
        String hashtext = "";
        try {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(plainText.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            hashtext = bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hashtext;
        // Now we need to zero pad it if you actually want the full 32 chars. 
        //        while(hashtext.length() < 32 ){ 
        //          hashtext = "0"+hashtext;
        //        }
    }
}
