package cl.ubb.spring.web.administracionalumnosts.encodepass;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by w7600PC on 24/06/2014.
 */
public class EncodeUBB implements PasswordEncoder {
    static Logger log = Logger.getLogger(EncodeUBB.class.getName());

    @Override
    public String encode(CharSequence charSequence) {
        String pass=charSequence.toString();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String hash = "";
        byte[] bytes;
        try {
            bytes = pass.getBytes("UTF-8");
            md.update(bytes);
            byte[] digest = md.digest();
            hash = Base64.encodeBase64String(digest);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.info("pass "+hash);
        return hash;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        //log.info("matches "+s+" coincide con "+encode(charSequence.toString()));
        return encode(charSequence).equals(s);
    }
}
