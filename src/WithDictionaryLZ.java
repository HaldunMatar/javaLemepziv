import java.util.HashMap;

public class WithDictionaryLZ {

public static void main(String[] args) {
	
	
	int numberOfSample= 10 ;
		
	int maximumLength= 50;
	
	int minimumLength = 10;
	
	
	
	int step = 20 ;
	
	
	
	
	
	
	
	int startLength=10 ;
	int finalLength=100 ;
	
	int maximum= 2;
	int minimum = 0;
	
	int  randomNumLength = 0 ;
	int   stringLength = minimumLength ;
	
	 
	for(int i=0;i< numberOfSample ;i++){
		
		//randomNumLength = (int) (minimumLength + (Math.random() * (maximumLength - minimumLength)));
		
		 
		
		String stream = "";
		
		  
		  for(int k=0;k<stringLength;k++){
			  
			  
			  int  randomNum = minimum + (int)(Math.random() * maximum);
			  
			  stream=stream+randomNum;
			 
			  
			  
		  }
		  
		
		  System.out.println(" ***** test : "+ (i+1) +"*************************"); 
		  
		  
		  //	String stream = "";	
	        System.out.println("                    the    Stream       is  : " + stream  + "   size " +  stream.length());
		//	 String stream = "00010111001010010101010101";	
	        
			Encode  encode = new Encode(stream);	
			
			HashMap<Integer, String> dictionaryMap = encode.enCodeStage1(stream); 
		    System.out.println("                    the  first stage    is   : " + dictionaryMap.values().toString()  + " size " + dictionaryMap.size());
			   
			   
			   
			HashMap<Integer, String> numericalMap = 	encode.enCodeStage2(dictionaryMap);
			System.out.println("                    the  seconde stage  is   : " + numericalMap.values().toString()  + " size " + numericalMap.size() );
			   
			   
			   
			   
			   HashMap<Integer, String> binaryEncodedBlocksMap = 	encode.enCodeStage3(numericalMap);		
			System.out.println("                    the  third stage    is   : " + binaryEncodedBlocksMap.values().toString() 
					
					+ " size " + binaryEncodedBlocksMap.size()* binaryEncodedBlocksMap.get(1).length()    );
			
			double sizecode= binaryEncodedBlocksMap.size() * binaryEncodedBlocksMap.get(1).length() ;
			
			double  compressionraito = sizecode/stream.length();
			
			System.out.println(" compression raito is  =  "+  compressionraito  );
			 
			 
			 
		  
		  
		  
			stringLength=stringLength + step;
		  
		}
		
     
		
		
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


