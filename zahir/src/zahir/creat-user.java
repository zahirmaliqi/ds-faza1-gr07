package zahir;
import java.io.*;

public class creat-user{
	
    private final String emri_key;
  

    
    public creat-user(String emri_key) {
    
        this.emri_key=emri_key;
       
    }

	public  void file() {
		//Krijojm nja objekt File
		File stockFile = new File("C:\\Users\\lenovo\\siguria\\"+emri+".xml");
		File stockFile1 = new File("C:\\Users\\lenovo\\siguria\\"+emri+".pub.xml");

		try {
		    stockFile.createNewFile();
		    stockFile1.createNewFile();
		} catch (IOException ioe) {
		     System.out.println("Error" + ioe);
		}

		System.out.println("Eshte krijuar celsi privat \'keys/" + stockFile.getPath()+"\'");
		System.out.println("Eshte krijuar celsi publik \'keys/" + stockFile1.getPath()+"\'");
		

		}

}
