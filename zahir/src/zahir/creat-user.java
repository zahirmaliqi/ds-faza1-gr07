package zahir;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class creat-user{
      private final String emri_key;
  
      public creat-user(String emri_key)
      {
         this.emri_key=emri_key;
      }

	public  void file() {
	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("RSA");
		doc.appendChild(rootElement);

		
		Element staff = doc.createElement("KeyValue");
		rootElement.appendChild(staff);


		
		Element firstname = doc.createElement("Modulus");
		firstname.appendChild(doc.createTextNode("kNfR475nkjmlk"));
		staff.appendChild(firstname);

		
		Element lastname = doc.createElement("Exponent");
		lastname.appendChild(doc.createTextNode("+EZth9RIOMMMF"));
		staff.appendChild(lastname);

		
		Element nickname = doc.createElement("P");
		nickname.appendChild(doc.createTextNode("zG6WRRR+_AAA"));
		staff.appendChild(nickname);

		
		Element salary = doc.createElement("InverseQ");
		salary.appendChild(doc.createTextNode("kX+VisjsjjTYJ"));
		staff.appendChild(salary);
		  
		   static String getPrivateKeyAsXml(PrivateKey privateKey) throws Exception{
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPrivateCrtKeySpec spec = keyFactory.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class);
        StringBuilder sb = new StringBuilder();

        

		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\Users\\lenovo\\siguria\\"+emri_key+".xml"));
		StreamResult result1 = new StreamResult(new File("C:\\Users\\lenovo\\siguria\\"+emri_key+".pub.xml"));
		

	

		transformer.transform(source, result);
		transformer.transform(source, result1);
		

		System.out.println("Eshte krijuar celesi privat \' keys/"+emri_key+".xml\'");
		System.out.println("Eshte krijuar celesi publik \' keys/"+emri_key+".pub.xml\'");
		
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}
