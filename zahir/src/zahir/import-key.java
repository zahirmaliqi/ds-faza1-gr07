package zahir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class import1{
    private final String emri_key;
    private final String emri_i_file;
    public import1(String emri_key,String emri_i_file) {
        this.emri_key=emri_key;
        this.emri_i_file=emri_i_file;
    }

    public  void importkeypub() throws IOException {
		
		File dir1 = new File("C:\\Users\\lenovo\\eclipse-workspace\\final");
 
		
		String source = dir1.getCanonicalPath() + File.separator + emri_i_file;
		String dest = dir1.getCanonicalPath() + File.separator + emri_key+".pub.xml";
 
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
		System.out.println("Celesi publik u ruajt ne fajllin \'keys/"+emri_i_file+".pub.xml\'.");
	}
	public  void importkeypriv() throws IOException {
    	File dir = new File("C:\\Users\\lenovo\\eclipse-workspace\\final");
 
    	String source = dir.getCanonicalPath() + File.separator + emri_i_file;
		String dest = dir.getCanonicalPath() + File.separator + emri_key+".xml";
 
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
		System.out.println("Celesi privat u ruajt ne fajllin \'keys/"+emri_key+".xml\'");
	}
	public  void importkeypriv1() throws IOException {
    	File dir = new File("C:\\Users\\lenovo\\eclipse-workspace\\final");
 
    	String source = dir.getCanonicalPath() + File.separator + emri_i_file;
		String dest = dir.getCanonicalPath() + File.separator + emri_key+".pub.xml";
 
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
		System.out.println("Celesi publik u ruajt ne fajllin \'keys/"+emri_key+".pub.xml\'");
	}
    

}
