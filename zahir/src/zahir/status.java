package zahir;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class status {
    private final String tokeni;

    public status(String tokeni) {
        this.tokeni = tokeni;
    }

    public void info_rreth_tokenit() throws Exception {
        decodeJWT(tokeni);
        System.out.println( "User :"+decodeJWT(tokeni).getSubject());
       Date d1=decodeJWT(tokeni).getExpiration();
        java.util.Date date=new java.util.Date();
        if(d1.compareTo(date) > 0) {
            System.out.println("Valid: po");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        String strDate = formatter.format(d1);
        System.out.println("Skadimi:"+strDate);

    }
    
     public static Claims decodeJWT(String jwt) throws IOException, SAXException, ParserConfigurationException {
        File pub = new File("C:\\Users\\lenovo\\IdeaProjects\\jjwt-example\\out\\artifacts\\jjwt_example_jar\\zahir.pub.xml");
        String celese_priv = getPubKey(pub);
        byte[] secret = Base64.getDecoder().decode(celese_priv);
       
        Claims claims = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(secret))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
   

}
