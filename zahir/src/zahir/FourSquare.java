package zahir;
import java.util.Arrays;

public class FourSquare {

    private final String key1;
    private final String key2;
    private final String text;
    private final Boolean toEncrypt;

    public FourSquare(String key1, String key2, String text,Boolean toEncrypt) {
        this.key1=key1;
        this.key2=key2;
        this.text=text;
        this.toEncrypt=toEncrypt;
    }
    public  void EncDec() {
        char[][] plot = new char[3][25];
        char remove = 'q';
        // fshin duplikatet nga qelesi
        String filtered_key_1 = removeDuplicates(key1);
        String filtered_key_2 = removeDuplicates(key2);
        plotAlphabets(plot[0], remove);
        plotKey(plot[1], filtered_key_1, remove);
        plotKey(plot[2], filtered_key_2, remove);

        if (toEncrypt){
            encrypt(plot,text);
        }
        else {
            decrypt(plot,text);
        }

    }
    
 private  void decrypt(char[][] plot, String encryptedText) {
        char[] pairs = new char[2];
        String plainText = "";
        String[] pEncryptText = new String[encryptedText.length() / 2];

        int cursor = 0;
        for (int i = 0; i < pEncryptText.length; i++) {
            pEncryptText[i] = "" + encryptedText.charAt(cursor) + encryptedText.charAt(cursor + 1);
            
            cursor = cursor + 2;
        }

        System.out.println("Pairs: " + Arrays.toString(pEncryptText));
