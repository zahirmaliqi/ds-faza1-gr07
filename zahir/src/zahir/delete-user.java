import java.io.File;

public class delete-user{
    private final String emri_key;
   
    public delete-user(String emri_key) {
        this.emri_key=emri_key;
    }


    public void delete_file()throws Exception{	
    	try{
    		
    		File file = new File("C:\\Users\\lenovo\\eclipse-workspace\\final\\"+emri_key+".xml");
    		
        	
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){
    		
    		e.printStackTrace();
    		
    	}
    	
    }
}
