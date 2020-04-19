package zahir;
import java.io.File;

public class delete-user{
    private final String emri_key;
   
    public delete-user(String emri_key) {
        this.emri_key=emri_key;
    }


    public void delete_file()throws Exception{	
    	try{
    		
    		File file = new File("C:\\Users\\lenovo\\eclipse-workspace\\final\\"+emri_key+".xml");
            File file1 = new File("C:\\Users\\lenovo\\eclipse-workspace\\final\\"+emri_key+".pub.xml");
    		
        	
    		if(file.delete() && file1.delete()){
    			System.out.println("Eshte larguar celesi privat \'keys"+file.getName()+"\'");
    			System.out.println("Eshte larguar celesi publik \'keys"+file1.getName()+"\'");
    		}else if(file.delete()){
    			System.out.println("Eshte larguar celesi privat \'keys /"+file.getName()+"\'");
    	
    		}else if(file1.delete()) {
    			
    			System.out.println("Eshte larguar celesi publik \'keys / "+file1.getName()+"\'");
    			
    		}else {
    			System.out.println("Gabim: Celesi \'"+emri_key+"\' nuk ekziston.");
    		}
    	   
    	}catch(Exception e){
    		
    		e.printStackTrace();
    		
    	}
    	
    }
}
