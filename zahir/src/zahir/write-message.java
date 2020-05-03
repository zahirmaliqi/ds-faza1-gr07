package zahir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private final String file;

    
    public writemessage(String emri_i_perdoruesit, String text, String file) {
    	
        this.emri_i_perdoruesit=emri_i_perdoruesit;
        this.text=text;
	this.file=file;
    }
    public void enc() throws Exception {
    	String originalInput = emri_i_perdoruesit;
    	String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
	File xmlFile = new File("C:\\Users\\lenovo\\eclipse-workspace\\final\\"+emri_i_perdoruesit+".pub.xml");
	    
    	if (xmlFile.exists()) {
    	Random random = ThreadLocalRandom.current();
	byte[] randomBytes = new byte[8];
	random.nextBytes(randomBytes);
	String encoded = Base64.getUrlEncoder().encodeToString(randomBytes);
	Random random1 = ThreadLocalRandom.current();
	byte[] randomBytes1 = new byte[8];
	random1.nextBytes(randomBytes1);
	String key1= Base64.getUrlEncoder().encodeToString(randomBytes1);
        String ciphertext = encrypt(key1,text);
        String decrypted = decrypt(key1, ciphertext.trim());
        String encrypted = encrypt(key1, decrypted.trim());
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
        
        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while( line != null){
            sb.append(line).append("");
            line = bufReader.readLine();
		
	}
	String xml2String = sb.toString();
        xml2String = xml2String.replaceAll("\\<.*?\\>", "");
        bufReader.close();
   
        //String zahir=encodedString;
        String zahir=encodedString+"."+encoded+"."+ xml2String+"."+encrypted;
        
        System.out.print(zahir);
     	}else {
     		System.out.println("Gabim: Celesi publik \'"+emri_i_perdoruesit+"\' nuk ekziston.");
     	}
       
         
    }
	
	public void ruaje() throws Exception{
    	String originalInput = emri_i_perdoruesit;
    	String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
    	
    	Random random = ThreadLocalRandom.current();
		byte[] randomBytes = new byte[8];
		random.nextBytes(randomBytes);
		String encoded = Base64.getUrlEncoder().encodeToString(randomBytes);
		Random random1 = ThreadLocalRandom.current();
		byte[] randomBytes1 = new byte[8];
		random1.nextBytes(randomBytes1);
		String key1= Base64.getUrlEncoder().encodeToString(randomBytes1);
        String ciphertext = encrypt(key1,text);
        String decrypted = decrypt(key1, ciphertext.trim());
        String encrypted = encrypt(key1, decrypted.trim());
        String zahir=encodedString+"."+encoded+"."+encrypted;
        
       
    String path = "C:\\Users\\lenovo\\eclipse-workspace\\final\\"+ file+".txt";

    try {
        Files.writeString(Paths.get(path), zahir);

    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println("Mesazhi i enkriptuar u ruajt ne fajllin \'"+file+"\'.");
    }
	
	public static String encrypt(String key1, String text)
	            throws GeneralSecurityException {
	        DESKeySpec desKeySpec = new DESKeySpec(key1.getBytes(StandardCharsets.UTF_8));
	        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
	        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
	        byte[] dataBytes = text.getBytes(StandardCharsets.UTF_8);
	        Cipher cipher = Cipher.getInstance("DES");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(dataBytes));
	    }
		
        
       
         
   
