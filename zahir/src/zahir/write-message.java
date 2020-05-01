package zahir;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class writemessage{
	
    private final String emri_i_perdoruesit;
    private final String text;

    
    public writemessage(String emri_i_perdoruesit, String text) {
    	
        this.emri_i_perdoruesit=emri_i_perdoruesit;
        this.text=text;
    }
    public void enc() throws Exception {
    	String originalInput = emri_i_perdoruesit;
    	String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
    	
    	Random random = ThreadLocalRandom.current();
		byte[] randomBytes = new byte[8];
		random.nextBytes(randomBytes);
		String encoded = Base64.getUrlEncoder().encodeToString(randomBytes);
        System.out.print(encodedString+"."+encoded);
       
         
    }
        
    
	    
	    
	 
 
}
