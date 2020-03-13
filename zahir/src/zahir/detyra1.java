package zahir;

import java.util.Scanner;

public class detyra1 {

	public static void main(String[] args) {
		String s; 
		Scanner sc = new Scanner(System.in);
 		System.out.print("Stringu:"); 
 		 
 		s = sc.nextLine();  
 	   int count = 0;    
       
       //Numeron totalin e karakterve perveq hapesires   
       for(int i = 0; i < s.length(); i++) {    
           if(s.charAt(i) != ' ')    
               count++;    
       }  
       System.out.println("Total:"+count);
       sc.close();
       }
}
	
	




