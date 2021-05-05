import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Arrays;
class Encode{
 int  lengthStream =0;
 String dictionary[]  ;
 HashMap<Integer, String> dictionaryMap=new HashMap<Integer, String>();  
 /*  initialization    */
 Encode(String stream)   {
  this.lengthStream=stream.length() ;
  dictionary = new String[lengthStream+3] ;
  dictionary[1]="0" ;
  dictionaryMap.put(Integer.valueOf(1), "0");
  dictionary[2]="1" ;
  dictionaryMap.put(Integer.valueOf(2), "1");
 }
 HashMap  enCodeStage1(String stream ){
  String   result1  = "";
  String   substring ;
  int index1=0 ;
  int index2=0  ;
  int indexdec=3  ;
  while (index2 <= stream.length()-1) {
   if(index1==index2) {
    substring =  stream.charAt(index1) + "";
   }else {
    substring =  stream.substring(index1, index2+1) ; 
   }
   /*   check if sub string is found in dictionary    */
   Set setDec= GFG.convertArrayToSet(dictionary);
       String str = Arrays.toString(dictionary);
      // System.out.println(substring); 
   //if (  setDec.contains(substring)   ) {
       if(  dictionaryMap.containsValue(substring)) {
    index2 = index2 + 1 ;
        }else {
        // dictionary[indexdec] =substring ;
         dictionaryMap.put(Integer.valueOf(indexdec), substring) ;
         index2=index2+1;
          index1=index2;
          indexdec=indexdec+1 ;
   }
  }
  return dictionaryMap ;
 }
 HashMap  enCodeStage2(HashMap<Integer, String> dictionaryMap){
 String result2  = "";
 HashMap<Integer, String>  numericalMap =new HashMap<Integer, String>(); 
    String value = null ;
  dictionaryMap.forEach(       (k, v) -> 
  {
   if(   !k.equals( Integer.valueOf(1))    &&     !k.equals( Integer.valueOf(2) )   )  
   {
       String  temp = v ;
       String  lastchar = v.substring(v.length() - 1).equals("0")  ? "1" : "2";
       String  remain = v.substring(0,v.length() - 1);
       dictionaryMap.values().contains(remain) ;
              getKey(dictionaryMap ,remain) ;
    String  nucell =  getKey(dictionaryMap ,remain) + lastchar ;
       // System.out.println(k + " "     +  nucell +  "   "+    v  + " " + remain  + "  " +  getKey(dictionaryMap ,remain).toString()     +  "   " + dictionaryMap.values().contains(remain) ) ;
        numericalMap.put(Integer.valueOf(k-2), nucell);
   }  
     }
    );
  return numericalMap;  
 }
 public <K, V> K getKey(Map<K, V> map, V value) {
     for (Entry<K, V> entry : map.entrySet()) {
         if (entry.getValue().equals(value)) {
             return entry.getKey();
         }
     }
     return null;
 }
 
 
 HashMap<Integer, String>  enCodeStage3(HashMap<Integer, String>   numericalRep )
 
 {
	 
	 HashMap<Integer, String>  encodeMap =new HashMap<Integer, String>(); 
		
		StringBuilder strbul=new StringBuilder();
		StringBuilder finalResult  = StringBuilder("222");
		ArrayList<String>  resList = new ArrayList();
		
		
		
		  Integer   maxintValue = Integer.valueOf(0)   ;
		 final AtomicInteger DecimalMaxValue = new AtomicInteger(0);
	
	
		
		numericalRep.forEach(      
				
				
				(k, v) -> 
		 
		 {
				
			 
			String  strInt= v.substring(0,v.length()-1);
			int  intoBinary1 =   Integer.valueOf(strInt).intValue();
			 
			 
		
			 
			 if(intoBinary1>DecimalMaxValue.get()) {
				 DecimalMaxValue.set(intoBinary1);
				
				 
			 }
			 			 
		 }
		 	 
	)	;
		
		
		   //maxintValue =  Integer.toBinaryString( DecimalMaxValue.get()).length() ;
		 
		
		 
	
			
			numericalRep.forEach(      
					
					
					(k, v) -> 
			 
			 {
				 
				 
					
				 String  oneOrTowString = v.substring(v.length()-1);
				// System.out.println(oneOrTowString);
				 
			
				
				if (oneOrTowString.equals("1"))
					
					oneOrTowString="0" ;
				else 
					oneOrTowString="1" ;
				
				String  intoBinary2 = v.substring(0,v.length()-1);
				
				   String encodeElemen = intToBinary(Integer.parseInt(intoBinary2)  , Integer.toBinaryString( DecimalMaxValue.get()).length()  ) + oneOrTowString ;
				   
				  String   finalResult1 =encodeElemen +   encodeElemen ;
				  
				  
				  encodeMap.put(Integer.valueOf(k), encodeElemen);
				
				
				  
				  resList.add(encodeElemen) ;
				  
				    strbul.append(encodeElemen) ;
				
				  
	
				
				 			 
			 }
			 	 
		)	;
			
			return  encodeMap ;
		 
		

		
		
		
				
		}
	
	private StringBuilder StringBuilder(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public static String intToBinary (int n, int numOfBits) {
		   String binary = "";
		   for(int i = 0; i < numOfBits; ++i, n/=2) {
		      switch (n % 2) {
		         case 0:
		            binary = "0" + binary;
		         break;
		         case 1:
		            binary = "1" + binary;
		         break;
		      }
		   }

		   return binary;
		}
		
	
	
	
	
}



class GFG { 
	  
 // Generic function to convert an Array to Set 
 public static <T> Set<T> convertArrayToSet(T array[]) 
 { 

     // Create an empty Set 
     Set<T> set = new HashSet<>(); 

     // Iterate through the array 
     for (T t : array) { 
         // Add each element into the set 
         set.add(t); 
     } 

     // Return the converted Set 
     return set; 
 } 
 
 

}