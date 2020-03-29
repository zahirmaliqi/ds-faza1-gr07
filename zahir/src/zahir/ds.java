        package zahir;
        public class ds {
		
	      public static void main(String[] args) {
	       
		 if(args.length==0){
	            System.out.println("Nuk eshte dhene ndonje argument");
	            System.exit(0);
	            }
		      
	        if (!args[0].equals("frequency")&&!args[0].equals("four-square")&&!args[0].equals("vigenere")){
	            System.out.println("Vlerat e lejuara jane [frequency,four-square,vigenere]");
	            System.exit(0);
	            }
		      
		if (args[0].equals("frequency")) {
                   if(args.length!=2 || args[1].equals("")){
                      System.out.println("Argumenti i dyte duhet te jete mesazhi me gjatesi>0");
                      System.exit(0);
                      }
                    frequency frequencyInspector = new frequency(args[1]);
                    frequencyInspector.fillHashMap();
		    }
		     
		      
		     if (args[0].equals("vigenere")) {
			if (args.length != 4) {
			    System.out.println("Argumentet encrypt|decrypt <key> <plaintext|ciphertext>");
			    System.exit(0);
			    }
		         if (!args[1].equals("encrypt") && !args[1].equals("decrypt")) {
			     System.out.println("Argumentet e lejuara  encrypt|decrypt");
			     System.exit(0);
			     }
			vigenere vigenere = new vigenere(args[2].toUpperCase(), args[3].toUpperCase());
			switch (args[1]) {
			case "encrypt":
				vigenere.enkripto();
				break;
			case "decrypt":
				vigenere.dekripto();
				break;
			                }
		                 }
                           }
	             }
	

