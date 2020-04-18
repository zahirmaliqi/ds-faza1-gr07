package zahir;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.Base64;


public class create-user{

    static final String KEY_ALGORITHM = "RSA";
    static final int KEY_LENGTH = 1024;
    private final String XML_PRIVATE_FILENAME;
   
    
    public create-user(String XML_PRIVATE_FILENAME) {
        this.XML_PRIVATE_FILENAME=XML_PRIVATE_FILENAME;
      
        
    }

    static final String NL = System.getProperty("line.separator");


    public  void file() throws Exception {

       
        KeyPair keyPair = createKeyPair(KEY_LENGTH);
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

       
        String privateKeyAsXml = getPrivateKeyAsXml(privateKey);
        System.out.println("Private:" +XML_PRIVATE_FILENAME);
        writeFile(privateKeyAsXml, XML_PRIVATE_FILENAME+".xml");

        String publicKeyAsXml = getPublicKeyAsXml(publicKey);
        System.out.print("Public:"  + XML_PRIVATE_FILENAME);
        writeFile(publicKeyAsXml, XML_PRIVATE_FILENAME+".pub.xml");

       
    }

    static KeyPair createKeyPair(int keyLength) throws NoSuchAlgorithmException {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keygen.initialize(keyLength, new SecureRandom());
        KeyPair keyPair = keygen.generateKeyPair();
        return keyPair;
    }

    static String getPrivateKeyAsEncoded(PrivateKey privateKey){
        byte[] privateKeyEncodedBytes = privateKey.getEncoded();
        return Base64.getEncoder().encodeToString(privateKeyEncodedBytes);
    }

    static String getPublicKeyAsEncoded(PublicKey publicKey){
        byte[] publicKeyEncoded = publicKey.getEncoded();
        return Base64.getEncoder().encodeToString(publicKeyEncoded);
    }

    static String getPrivateKeyAsXml(PrivateKey privateKey) throws Exception{
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPrivateCrtKeySpec spec = keyFactory.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class);
        StringBuilder sb = new StringBuilder();

        sb.append("<RSAKeyValue>" + NL);
        sb.append(getElement("Modulus", spec.getModulus()));
        sb.append(getElement("Exponent", spec.getPublicExponent()));
        sb.append(getElement("P", spec.getPrimeP()));
        sb.append(getElement("Q", spec.getPrimeQ()));
        sb.append(getElement("DP", spec.getPrimeExponentP()));
        sb.append(getElement("DQ", spec.getPrimeExponentQ()));
        sb.append(getElement("InverseQ", spec.getCrtCoefficient()));
        sb.append(getElement("D", spec.getPrivateExponent()));
        sb.append("</RSAKeyValue>");

        return sb.toString();
    }

    static String getPublicKeyAsXml(PublicKey publicKey) throws Exception{
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPublicKeySpec spec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
        StringBuilder sb = new StringBuilder();

        sb.append("<RSAKeyValue>" + NL);
        sb.append(getElement("Modulus", spec.getModulus()));
        sb.append(getElement("Exponent", spec.getPublicExponent()));
        sb.append("</RSAKeyValue>");

        return sb.toString();
    }

    static String getElement(String name, BigInteger bigInt) throws Exception {
        byte[] bytesFromBigInt = getBytesFromBigInt(bigInt);
        String elementContent = Base64.getEncoder().encodeToString(bytesFromBigInt);
        return String.format("  <%s>%s</%s>%s", name, elementContent, name, NL);
    }

    static byte[] getBytesFromBigInt(BigInteger bigInt){
        byte[] bytes = bigInt.toByteArray();
        int length = bytes.length;
        if(length % 2 != 0 && bytes[0] == 0) {
            bytes = Arrays.copyOfRange(bytes, 1, length);
        }

        return bytes;
    }

   

    static void writeFile(String text, String filename) throws Exception{
        try(PrintWriter writer = new PrintWriter(filename)){
            writer.write(text);
        }
    }


   
}
