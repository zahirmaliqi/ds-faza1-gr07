package zahir;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class detyra1 {

	public static void main(String[] args)throws IOException
	{
		BufferedReader sc=new BufferedReader(new InputStreamReader(new ByteArrayInputStream())));
		System.out.println("Stringu:");
		String s = sc.readLine();
	        int count1 = 0;    
       
       //Numeron totalin e karakterve perveq hapesires   
       for(int i = 0; i < s.length(); i++) {    
           if(s.charAt(i) != ' ') {   
               count1++; }   
       }  
       System.out.println("Total:"+count1);
		
         HashMap<Character,Integer> counts = new HashMap<>();
        for(char c : s.toCharArray()) {
        	if(c != ' ') {
        		Integer count = counts.get(c);
                if (count == null) {
                    count = 0;
                }
                counts.put(c, ++count);
        	}
            
        }
	List<Entry<Character,Integer>> list = new ArrayList<>(counts.entrySet());
        Collections.sort(list, new Comparator<Entry<Character,Integer>>() {
            @Override
            public int compare(Entry<Character, Integer> o1,
                    Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
          for(Entry<Character,Integer> entry : list) {
             System.out.println(entry.getKey() +": "+ entry.getValue()+ " ("+entry.getValue()*100/count1+"%)" );
        }
		 for(Entry<Character,Integer> entry : list) {
			 for(int j = 0; j<entry.getValue(); j++) {
				 System.out.print(entry.getKey() + ": [");
				 for(int i = 0; i<((entry.getValue()*100/count1)*26)/100; i++) {
            		             System.out.print("#");
            		                }
				 	System.out.print("]");
            	                        System.out.println();
            	
            }
	}
    }
}
	
	




