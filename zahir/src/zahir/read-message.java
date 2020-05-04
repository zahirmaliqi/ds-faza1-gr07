package zahir;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


	public class readmessage {
		
	    private final String mesazhi;

	    public readmessage(String mesazhi) {
	        this.mesazhi=mesazhi;
	    }
	
	
	
  public void decry() throws Exception {
	  String str1 = mesazhi.replace(".", ",");
      String[] parts = str1.split(",");
      String part1 = parts[0]; 
      String part2 = parts[1];
      byte[] decodedBytes = Base64.getDecoder().decode(part1);
      String decodedString = new String(decodedBytes);
      File xmlFile = new File("C:\\Users\\lenovo\\eclipse-workspace\\final\\"+decodedString+".xml");
      if(xmlFile.exists()) {
      
   
      File myObj = new File("C:\\Users\\lenovo\\eclipse-workspace\\final\\"+decodedString+".txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String fjla = data.replace(".", ",");
        String[] p = fjla.split(",");
        String p1 = p[0]; 
        String p2 = p[1];
        String p3 = p[2];
        String p4=parts[3];
        
  
        byte[] decodedBytes1 = Base64.getDecoder().decode(p1);
        String decodedString1 = new String(decodedBytes1);
        System.out.println("Marresi:"+decodedString1);
        Random random1 = ThreadLocalRandom.current();
		byte[] randomBytes1 = new byte[8];
		random1.nextBytes(randomBytes1);
		String key1= Base64.getUrlEncoder().encodeToString(randomBytes1);
        String ciphertext = encrypt(key1,p4);
        String decrypted = decrypt(key1, ciphertext.trim());
        String encrypted = encrypt(key1, decrypted.trim());
        System.out.println("Mesazhi:"+decrypted);
        
         
  
      }
      }else {
	  System.out.println("Gabim: Celesi privat \'"+decodedString+".xml \' nuk ekziston");
  }
  }
  
  public static String encrypt(String key1, String part4)
          throws GeneralSecurityException {
      DESKeySpec desKeySpec = new DESKeySpec(key1.getBytes(StandardCharsets.UTF_8));
      SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
      SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
      byte[] dataBytes = part4.getBytes(StandardCharsets.UTF_8);
      Cipher cipher = Cipher.getInstance("DES");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      return Base64.getEncoder().encodeToString(cipher.doFinal(dataBytes));
  }

  public static String decrypt(String key1, String part4)
          throws GeneralSecurityException {
      byte[] dataBytes = Base64.getDecoder().decode(part4);
      DESKeySpec desKeySpec = new DESKeySpec(key1.getBytes(StandardCharsets.UTF_8));
      SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
      SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
      Cipher cipher = Cipher.getInstance("DES");
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      byte[] dataBytesDecrypted = (cipher.doFinal(dataBytes));
      return new String(dataBytesDecrypted);
  }
}
