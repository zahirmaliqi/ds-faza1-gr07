        package zahir;
        public class ds {
		
	      public static void main(String[] args) {
	       
		 if(args.length==0){
	            System.out.println("Nuk eshte dhene ndonje argument");
	            System.exit(1);
	            }
		      
	        if (!args[0].equals("frequency")&&!args[0].equals("four-square")&&!args[0].equals("vigenere")&&!args[0].equals("create-user")
		    &&!args[0].equals("delete-user")&&!args[0].equals("export-key")&&!args[0].equals("import-key")&&!args[0].equals("write-message") 
		   &&!args[0].equals("read-message")&&!args[0].equals("login")&&!args[0].equals("status")){
	            System.out.println("Vlerat e lejuara jane [frequency,four-square,vigenere,create-user,delete-user,export-key,import-key,read-message,write-message,login,status]");
	            System.exit(1);
	            }
		      
		if (args[0].equals("frequency")) {
                   if(args.length!=2 || args[1].equals("")){
                      System.out.println("Argumenti i dyte duhet te jete mesazhi me gjatesi>0");
                      System.exit(1);
                      }
                    frequency frequencyInspector = new frequency(args[1]);
                    frequencyInspector.fillHashMap();
		    }
		      
		      
		if (args[0].equals("four-square")){
                  if(args.length!=5){
                       System.out.println("Argumentet encrypt|decrypt <key1> <key2> <plaintext|ciphertext>");
                       System.exit(1);
		  }
                 if(!args[1].equals("encrypt")&&!args[1].equals("decrypt")){
                       System.out.println("Argumentet e lejuara  encrypt|decrypt");
                       System.exit(1);
                  }
            switch (args[1]){
                case "encrypt":
                    FourSquare fourSquare=new FourSquare(args[2],args[3],args[4],true);
                    fourSquare.EncDec();
                    break;
                case "decrypt":
                    FourSquare fourSquare1=new FourSquare(args[2],args[3],args[4],false);
                    fourSquare1.EncDec();
                    break;
                    }
                  }
		     
		      
		     if (args[0].equals("vigenere")) {
			if (args.length != 4) {
			    System.out.println("Argumentet encrypt|decrypt <key> <plaintext|ciphertext>");
			    System.exit(1);
			    }
		         if (!args[1].equals("encrypt") && !args[1].equals("decrypt")) {
			     System.out.println("Argumentet e lejuara  encrypt|decrypt");
			     System.exit(1);
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
		      
		   if (args[0].equals("create-user")) {
	 		if (args.length != 2) {
	 		    System.out.println("Argumentet emri");
	 		    System.exit(1);
	 		    }
			 if (args[1].contains(" ")) {
			     System.out.println("Nuk lejohen hapesirat.");
			     System.exit(1);
			    }
			creat createt = new creat(args[1]);
	 		createt.file();
                         }
		      
		      
		      if (args[0].equals("delete-user")) {
		 		if (args.length != 2) {
		 		    System.out.println("Argumentet emri.");
		 		    System.exit(1);
		 		    }
			      if (args[1].contains(" ")) {
				     System.out.println("Nuk lejohen hapesirat");
				     System.exit(1);
			          }
		 		delete del = new delete(args[1]);
		 		del.delete_file();
		 	   }
		      
		      
		      if (args[0].equals("export-key")) {
		 	 if (args.length == 3) {
		 	             excport exc=new excport(args[2], null);
		        switch (args[1]){
		 	    case "public":
		                exc.mungon_argumentipub();
		                break;
		            case "private":
		               exc.mungon_argumentipriv();
		               break;
		           }
		 	    System.exit(1);
		       }
		        if (args.length == 4) {
		 	       excport exc1=new excport(args[2],args[3]);
		 	switch (args[1]){
		 	    case "public":
		               exc1.ex_compub();
		               break;
		           case "private":
		               exc1.ex_compriv();
		               break;
		               }
		 		 System.exit(1);
		 	     }
		 		
		 	  if(args.length != 4 || args.length != 3)
		 		{
		 			System.out.println("Argumenti <public|private> <name> [file]");
		 			System.exit(1);
		 		}
		        }
		      
		      
		      if (args[0].equals("import-key")) {
		 		if (args.length != 3) {
		 		    System.out.println("Argumentet import-key <name> <path>");
		 		    System.exit(1);
		 		    }
			      
			      if (args.length == 3) {
		 			import1 imp=new import1(args[1],args[2]);
		 			if(args[2].endsWith(".pub.xml"))
		 			{
		 				imp.importkeypub();
		 				
		 			}else (args[2].endsWith(".xml"))
		 			{
		 				imp.importkeypriv();
	 				    imp.importkeypriv1();
		 			}
	     
		               }
			      
	         if (args[0].equals("write-message")) {
	    		if (args.length == 5) {
		 			writemessage Wm=new writemessage(args[1], args[2],null,args[3],args[4]);
		 			Wm.enc();
		 		        System.exit(1);
		 		               }
	    		
	    		if (args.length == 6) {
		 			writemessage Wm=new writemessage(args[1], args[2],args[3],args[4],args[5]);
		 			Wm.ruaje();
		 		        System.exit(1);
		 		                 }
	    		
	    		if(args.length != 6 || args.length != 5)
		 		{
		 			System.out.println("Argumenti <name> <message> destinacioni eshte opscional  sender <tokeni>");
		 			System.exit(1);
		 		}
		 	 }
			      
			      
	       if (args[0].equals("read-message")) {
	    	     if(args.length == 2) {
	    	         readmessage read = new readmessage(args[1]);
	    	      if(args[1].endsWith(".txt")) {
	    	    	 read.txtfile();  
	    	         }else {
	    	    	  read.decry();
	    	          }
	    	              System.exit(1);
		 	   }
	    	     if(args.length != 2)
		 		{
		 			System.out.println("Argumenti <encrypted-message>");
		 			System.exit(1);
		 		}
	              }
			      
			      
	        if (args[0].equals("login")) {
                      if(args.length == 2) {
                         login lg1 = new login(args[1]);
                         lg1.krijimi_i_tokenit();
                         System.exit(1);
                     }
               if(args.length != 2)
                              {
                                       System.out.println("Argumenti <name>");
                                       System.exit(1);
                              }
                    }
			      
	       if (args[0].equals("status")) {
                      if(args.length == 2) {
                           status st1 = new status(args[1]);
                           st1.info_rreth_tokenit();
                           System.exit(1);
                        }
               if(args.length != 2)
                               {
                                       System.out.println("Argumenti <tokeni>");
                                       System.exit(1);
                               }
                     }
		 		
            }
	
   }
