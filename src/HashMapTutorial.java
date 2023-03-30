import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class HashMapTutorial {

	public static void main(String[] args) {
		 
		   HashMap<Integer,String> hm=new HashMap<Integer,String>();    
		      
		   	hm.put(100,"Amit");    
		      hm.put(101,"Vijay");    
		      hm.put(102,"Rahul"); 
		      hm.put(103,"Vijay"); 
		      
		      System.out.println(hm.containsKey(101));
		      System.out.println(hm.containsValue("Vijay"));
		     
		      System.out.println("Initial list of elements:" + hm);  
		      
		      for(Map.Entry<Integer, String> m:hm.entrySet())  
			     {  System.out.println("m -->" + m);
			        System.out.println(m.getKey()+" "+m.getValue());   
			     }  
		      
		      System.out.println(hm.values());
		     
		      
		      
		      for(Integer m:hm.keySet())  
		     {  System.out.println(m); 
		     }
		      
		      for(String m:hm.values())  
			     {  System.out.println(m); 
			     }  
		       

	}

}
























