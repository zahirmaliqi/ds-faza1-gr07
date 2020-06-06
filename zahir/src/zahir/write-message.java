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
    private final String sender;
    private final String token;

    
    public writemessage(String emri_i_perdoruesit, String text, String file ,String sender,String token) {
    	
        this.emri_i_perdoruesit=emri_i_perdoruesit;
        this.text=text;
	this.file=file;
	this.sender=sender;
        this.token=token;
    }
    public void enc() throws Exception {
    	String originalInput = emri_i_perdoruesit;
    	String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
	File xmlFile = new File("C:\\Users\\lenovo\\eclipse-workspace\\final\\"+emri_i_perdoruesit+".pub.xml");
	    
	String token_sender = sender;
        String encodeSender = Base64.getEncoder().encodeToString(token_sender.getBytes());
	    
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
	KeyPair pair = generateKeyPair();
        
	//Des Message nenshkruhet me celesin private 
	String signature = sign(encrypted, pair.getPrivate());
   
        //String zahir=encodedString;
        String zahir=encodedString+"."+encoded+"."+ xml2String+"."+encrypted + "."+encodeSender+"."+signature;
        
        System.out.print(zahir);
     	}else {
     		System.out.println("Gabim: Celesi publik \'"+emri_i_perdoruesit+"\' nuk ekziston.");
     	}
       
         
    }
  public static String sign(String plainText, PrivateKey privateKey) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes());

        byte[] signature = privateSignature.sign();
         return Base64.getEncoder().encodeToString(signature);
    }
	
	
	
	public static KeyPair getKeyPairFromKeyStore() throws Exception {

        InputStream ins = writemessage.class.getResourceAsStream("/keystore.jks");

        KeyStore keyStore = KeyStore.getInstance("JCEKS");
        keyStore.load(ins, "s3cr3t".toCharArray());
        KeyStore.PasswordProtection keyPassword =
                new KeyStore.PasswordProtection("s3cr3t".toCharArray());

        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("mykey", keyPassword);

        java.security.cert.Certificate cert = keyStore.getCertificate("mykey");
        PublicKey publicKey = cert.getPublicKey();
        PrivateKey privateKey = privateKeyEntry.getPrivateKey();

        return new KeyPair(publicKey, privateKey);
    }
	

	
	public void ruaje() throws Exception{
    	String originalInput = emri_i_perdoruesit;
    	String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
    	
    	Random random = ThreadLocalRandom.current();
		byte[] randomBytes = new byte[8];
		random.nextBytes(randomBytes);
		String encoded = Base64.getUrlEncoder().encodeToString(randomBytes);
		//Random random1 = ThreadLocalRandom.current();
		//byte[] randomBytes1 = new byte[8];
		//random1.nextBytes(randomBytes1);
		//String key1= Base64.getUrlEncoder().encodeToString(randomBytes1);
		String key1 = "zahirzah";
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
        String zahir=encodedString+"."+encoded+"."+ xml2String+"."+encrypted;
   
       
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
	
	 public static String decrypt(String key1, String text)
	            throws GeneralSecurityException {
	        byte[] dataBytes = Base64.getDecoder().decode(text);
	        DESKeySpec desKeySpec = new DESKeySpec(key1.getBytes(StandardCharsets.UTF_8));
	        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
	        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
	        Cipher cipher = Cipher.getInstance("DES");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
	        byte[] dataBytesDecrypted = (cipher.doFinal(dataBytes));
	        return new String(dataBytesDecrypted);
	    }
	
	public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024, new SecureRandom());
        KeyPair pair = generator.generateKeyPair();

        return pair;
    }

	
 
}
		
        
       
         
   
