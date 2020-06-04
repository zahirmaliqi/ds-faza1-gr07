package zahir ;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.Scanner;

public class login {
           private final String emri;

           public login(String emri) {
                 this.emri=emri;
    }
    public void krijimi_i_tokenit() throws Exception {

        File privat = new File("C:\\Users\\lenovo\\IdeaProjects\\jjwt-example\\out\\artifacts\\jjwt_example_jar\\"+emri+".xml");

        Scanner sc = new Scanner(System.in);
        System.out.print("Jep fjalkalimin: ");
        String password = sc.nextLine();

        if (privat.exists()){
        String salt = "hash_algoritmi_dhe_salting";
        String hash = md5(password + salt);

        File myObj = new File("C:\\Users\\lenovo\\IdeaProjects\\jjwt-example\\out\\artifacts\\jjwt_example_jar\\"+emri+".txt");
        Scanner myReader = new Scanner(myObj);
            String hashi_i_pass = myReader.nextLine();




        if( hash.equals(hashi_i_pass)) {
            String celese_priv = getPrivKey(privat);
            byte[] secret = Base64.getDecoder().decode(celese_priv);
            Instant now = Instant.now();
            String jwt = Jwts.builder()
                    .setSubject(emri)
                    //.setAudience(password)
                    .setAudience(hashi_i_pass)
                    .setIssuedAt(Date.from(now))
                    .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(20).toInstant()))
                    .signWith(Keys.hmacShaKeyFor(secret))
                    .compact();
                    System.out.println(jwt);
            Jws<Claims> result = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(secret))
                    .parseClaimsJws(jwt);
        } else{
            System.out.println("Gabim: Shfrytezuesi ose fjalekalimi i gabuar.");
                }
        }
  }

}
