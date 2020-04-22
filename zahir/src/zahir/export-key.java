 package zahir;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
public class excport{
    private final String emri_key;
    private final String emri_i_file;
   
    public excport(String emri_key,String emri_i_file) {
        this.emri_key=emri_key;
        this.emri_i_file=emri_i_file;
    }



    public  void mungon_argumentipub() throws ParserConfigurationException, SAXException, IOException {
        
        File xmlFile = new File("C:\\Users\\lenovo\\eclipse-workspace\\final\\"+emri_key+".pub.xml");
       
        
        if (xmlFile.exists()) {
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
        
        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while( line != null){
            sb.append(line).append("\n");
            line = bufReader.readLine();
        }
        String xml2String = sb.toString();
        System.out.println(xml2String);
        
        bufReader.close();}
        else {
        	System.out.println("Gabim :Celesi publik\'"+emri_key+"\'nuk ekziston");
        }
    }
  public  void mungon_argumentipriv() throws ParserConfigurationException, SAXException, IOException {
            
            // our XML file for this exampl
            File xmlFile1 = new File("C:\\Users\\lenovo\\eclipse-workspace\\final\\"+emri_key+".xml");
            
            if (xmlFile1.exists()) {
            Reader fileReader = new FileReader(xmlFile1);
            BufferedReader bufReader = new BufferedReader(fileReader);
            
            StringBuilder sb = new StringBuilder();
            String line = bufReader.readLine();
            while( line != null){
                sb.append(line).append("\n");
                line = bufReader.readLine();
            }
            String xml2String = sb.toString();
            System.out.println(xml2String);
            
            bufReader.close();}
             else {
            	System.out.println("Gabim :Celesi private\'"+emri_key+"\'nuk ekziston");
            }
            }
 
  public  void ex_compriv() throws IOException {
    		
    		File dir1 = new File("C:\\Users\\lenovo\\eclipse-workspace\\final");
     
    		
    		String source = dir1.getCanonicalPath() + File.separator +emri_key+ ".xml";
    		String dest = dir1.getCanonicalPath() + File.separator + emri_i_file;
     
    		File fin = new File(source);
    		FileInputStream fis = new FileInputStream(fin);
    		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
     
    		FileWriter fstream = new FileWriter(dest, true);
    		BufferedWriter out = new BufferedWriter(fstream);
     
    		String aLine = null;
    		while ((aLine = in.readLine()) != null) {
    			
    			out.write(aLine);
    			out.newLine();
    		}
     
    		
    		in.close();
    		out.close();
    		System.out.println("Celesi privat u ruajt ne fajllin \'"+emri_i_file);
    	}
               public  void ex_compub() throws IOException {
     
                
    		File fin = new File(source);
    		FileInputStream fis = new FileInputStream(fin);
    		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
     
    		FileWriter fstream = new FileWriter(dest, true);
    		BufferedWriter out = new BufferedWriter(fstream);
     
    		String aLine = null;
    		while ((aLine = in.readLine()) != null) {
    			//Process each line and add output to Dest.txt file
    			out.write(aLine);
    			out.newLine();
    		}
     
 
    		in.close();
            out.close();
    		System.out.println("Celesi publik u ruajt ne fajllin \'"+emri_i_file);
    	}



              
}
