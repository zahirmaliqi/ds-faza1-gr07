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
        
            for (int i = 0; i < pEncryptText.length; i++) {
            int column_a = 0;
            int row_a = 0;
            int column_b = 0;
            int row_b = 0;

            
            pairs[0] = pEncryptText[i].charAt(0);
            pairs[1] = pEncryptText[i].charAt(1);

            
            for (int j = 0; j < plot[0].length; j++) {
               
                if(pairs[0] == plot[1][j]) {
                    //Gjene rreshtin dhe konverton ne 5X5
                    row_a = (j / 5) * 5;
                    // Kolona me mod te 5
                    column_a = j % 5;
                }

                
                if(pairs[1] == plot[2][j]) {
                    row_b = (j / 5) * 5;
                    column_b = j % 5;
                }
            }

            
            plainText += plot[0][row_a + column_b];
            plainText += plot[0][row_b + column_a];  
        }

        
        System.out.println("Decrypted Text: " + plainText);
    }

    private  void encrypt(char[][] plot, String plainText) {
        char[] pairs = new char[2];
        String encryptedText = "";
        String[] pEncryptText = new String[plainText.length() / 2];

        int cursor = 0;
        for (int i = 0; i < pEncryptText.length; i++) {
            pEncryptText[i] = "" + plainText.charAt(cursor) + plainText.charAt(cursor + 1);
            // shtyhet per dy
            cursor = cursor + 2;
        }

        
        System.out.println("Pairs: " + Arrays.toString(pEncryptText));  
        
        for (int i = 0; i < pEncryptText.length; i++) {
            int column_a = 0;
            int row_a = 0;
            int column_b = 0;
            int row_b = 0;

            
            pairs[0] = pEncryptText[i].charAt(0);
            pairs[1] = pEncryptText[i].charAt(1);

            
            for (int j = 0; j < plot[0].length; j++) {
               
                if(pairs[0] == plot[0][j]) {
                    
                    row_a = (j / 5) * 5;
                 
                    column_a = j % 5;
                }

              
                if(pairs[1] == plot[0][j]) {
                    row_b = (j / 5) * 5;
                    column_b = j % 5;
                }
            }

            
            encryptedText += plot[1][row_a + column_b]; 
            encryptedText += plot[2][row_b + column_a];  
        }

       
        System.out.println("Encrypted Text: " + encryptedText);
    }

    
    private static void plotAlphabets(char[] plot, char remove) {
        int cursor = 0;
        for (int i = 0; i < plot.length; i++) {
            if ((char) ('a' + i) != remove) {
                plot[i] = (char) ('a' + cursor);
            } else {
                cursor++;
                plot[i] = (char) ('a' + cursor);
            }
            cursor++;
        }
    }
    
    private static String removeDuplicates(String string) {
        char[] characters = string.toCharArray();
        String filterd = "";
        for (int i = 0; i < characters.length; i++) {
            
            boolean isReapeated = false;
            for (int j = 0; j < i; j++) {
              
                if(characters[i] == characters[j]) {
                    isReapeated = true;
                    break;
                }
            }

            if(!isReapeated) { 
                filterd += characters[i];
            }
        }
        return filterd; 
    }
    private static void plotKey(char[] plot, String key, char remove) {
        int cursor = 0;
        char[] ckey = key.toCharArray();

       
        for (int i = 0; i < ckey.length; i++) {
            plot[i] = ckey[i];
        }

        for (int i = ckey.length; i < plot.length; i++) {

            if((char) ('a' + cursor) == remove) {
                
                cursor++;
            }

            int checks = 2;
            for (int j = 0; j < checks; j++) {
                for (int k = 0; k < ckey.length; k++) {
               
                    if(ckey[k] == (char) ('a' + cursor)) {
                        cursor++;
                        break;
                    }
                }
            }

            if((char) ('a' + cursor) == remove) {
                
                cursor++;
            }

            plot[i] = (char) ('a' + cursor);
            cursor++;

        }
    }
}
     
   
     
     
     
     
     
