package zahir;

public class vigenere {
	
	    private final String qelsi;
	    private final String text;
	
	    public vigenere(String qelsi, String text) {
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
		     char p = text.charAt(i);
		     if (p < 'A' || p > 'Z')
	        	{continue;}
	            encryptedMsg[i] = (char) (((msg[i] + key[i]) % 26) + 'A');
	        }
	
	
	
	        System.out.println(String.valueOf(encryptedMsg));
	    }
	
	   public void dekripto(){
	        //Numeron totalin e karakterve
	        char msg[] = text.toCharArray();
	        int msglen = msg.length;
	        int i, j;
	
	
	        char key[] = new char[msglen];
	        char decryptedMsg[] = new char[msglen];
	        for (i = 0, j = 0; i < msglen; ++i, ++j) {
	            if (j == qelsi.length()) {
	                j = 0;
	            }
	            key[i] = qelsi.charAt(j);
	        }
	
	        //Pi = (Ci – Ki + 26) mod 26
	        for (i = 0; i < msglen; ++i) {
	           char p = text.charAt(i);
	           if (p < 'A' || p > 'Z')
	        	{continue;}
                    decryptedMsg[i] = (char) ((((msg[i] - key[i])+26) % 26) + 'A');
	        }
		   
	        System.out.println(String.valueOf(decryptedMsg));

	
	    }
	
	}
