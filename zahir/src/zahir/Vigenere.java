package zahir;

public class Vigenere {
	
	    private final String qelsi;
	    private final String text;
	
	    public Vigenere(String qelsi, String text) {
	        this.qelsi=qelsi;
	        this.text=text;
	    }
	
	
	    public  void enkripto() {
	        //Numeron totalin e karakterve
	        char msg[] = text.toCharArray();
	        int msglen = msg.length;
	        int i, j;
	
	
	        char key[] = new char[msglen];
	        char encryptedMsg[] = new char[msglen];
	
	
	        for (i = 0, j = 0; i < msglen; ++i, ++j) {
	            if (j == qelsi.length()) {
	                j = 0;
	            }
	            key[i] = qelsi.charAt(j);
	        }
	
	        //Ci = (Pi + Ki) mod 26
	        for (i = 0; i < msglen; ++i) {
	            encryptedMsg[i] = (char) (((msg[i] + key[i]) % 26) + 'A');
	        }
	
	
	
	        System.out.println(String.valueOf(encryptedMsg));
	    }
	   
	
	    }
	
	}
