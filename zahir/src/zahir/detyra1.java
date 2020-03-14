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
	char[] str=s.toCharArray();               
       int sz=str.length;
       int i=0,j=0,count1=0;
       for( i =0;i<sz;i++) {
    	   count1=0;
    	   for(j =0;j<sz;j++)
    	   {
            if(s.charAt(i) != ' ') {
    	        if(j <i && str[i] == str[j]) {
    			   break;}
		   
    		 if(str[j] == str[i] ) {
    			   count1++;}
    		    
    		  if(j==sz-1) {
    			   
    			   System.out.println(str[i]); }
    	   }}
                           }
       sc.close();
       }
}
	
	




