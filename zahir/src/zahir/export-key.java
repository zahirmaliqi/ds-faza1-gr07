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
   
    public excport(String emri_key) {
        this.emri_key=emri_key;
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
    }
  public  void mungon_argumentipriv() throws ParserConfigurationException, SAXException, IOException {
            
            // our XML file for this exampl
            File xmlFile1 = new File("C:\\Users\\lenovo\\eclipse-workspace\\final\\");
            
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
            }
       
              
}
