package zahir;
import java.Map;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Linked.HashMap;

public class frequency{
    private String mesazhi;
    private HashMap<Character, Integer> letterFrequencyMap = new HashMap<>();
    public FrequencyInspector(String mesazhi) {
           this.mesazhi = mesazhi;
     }
	
      public void fillHashMap() {
        mesazhi = mesazhi.replaceAll("\\s+", ""); //largo te gjitha hapesirat e zbrazeta
        for (int i = 0; i < mesazhi.length(); i++) {
            if (letterFrequencyMap.containsKey(mesazhi.charAt(i))) {
                Integer count = letterFrequencyMap.get(mesazhi.charAt(i));
                letterFrequencyMap.put(mesazhi.charAt(i), ++count);
            } else {
                letterFrequencyMap.put(mesazhi.charAt(i), 1);
            }
        }
       Map<Character,Integer> sortedMap=sortByComparator(letterFrequencyMap);
       printMap(sortedMap);
         }
	
        //metodat jane te bazuara ne kete link https://stackoverflow.com/questions/8119366/sorting-hashmap-by-values
       private  Map<Character, Integer> sortByComparator(Map<Character, Integer> unsortMap) {
             List<Entry<Character, Integer>> list = new LinkedList<>(unsortMap.entrySet());
        // Sortimi ne baze te vleres
        Collections.sort(list, new Comparator<Entry<Character, Integer>>()
        {
            public int compare(Entry<Character, Integer> o1,
                               Entry<Character, Integer> o2)
            {
		    return o2.getValue().compareTo(o1.getValue());
            }
        });
	Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Entry<Character, Integer> entry : list)
        {sortedMap.put(entry.getKey(), entry.getValue());}
	         return sortedMap;
       }

    
	private  void printMap(Map<Character, Integer> map){
        System.out.println("Total: "+mesazhi.length());
           for (Entry<Character, Integer> entry : map.entrySet()){
            float percentage= ((float) entry.getValue() / mesazhi.length()) * 100;
            System.out.println(entry.getKey() + ": "+ entry.getValue()+" ("+percentage+"%)");
            }
		
	System.out.println("ASCII BAR-I");
        
	for (Entry<Character, Integer> entry : map.entrySet()){
            float percentage= ((float) entry.getValue() / mesazhi.length()) * 100;
            System.out.print(entry.getKey()+": [");

            for(int i=0;i<mesazhi.length();i++){
                  if(i<entry.getValue())
		  {
			  System.out.print("#");
		  }
                else 
		{
                    System.out.print(" ");
                }
	    }
            System.out.println("] "+percentage+"%");

        }
    }
}
