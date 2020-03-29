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
            FrequencyInspector frequencyInspector = new FrequencyInspector(args[1]);
            frequencyInspector.fillHashMap();

        }
	
	            }
	

