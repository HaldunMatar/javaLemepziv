import java.util.HashMap;

public class WithDictionaryLZ {

public static void main(String[] args) {

//start  Entropy test -------------------------------------------------------------------------------------------------------------------------------
	String[] sample= {"0001000000","0010010000" ,"0001001010" , "0100101010", "0010110101" , "1110111111", "1101101111",
			"1110110101","1011010101"  ,"1101001010"  } ;
	int n=1;
	
	 for(String temp : sample ) {
		 
		 
		String stream ="" ;
		 for(int j = 0 ; j<10 ; j++) {
			 stream=stream+temp ;
 		 }
	
		  System.out.println(" ***** test : "+ (n) +"*************************"); 
		  
		  
		   //System.out.println("                    the    Stream       is  : " +  "   size " +  stream.length());
		    System.out.println("                    the    Stream       is  : " + stream  + "   size " +  stream.length());
	        
			Encode  encode = new Encode(stream);	
			
			HashMap<Integer, String> dictionaryMap = encode.enCodeStage1(stream); 
		    System.out.println("                    the  first stage    is   : " + " size " + dictionaryMap.size());
		   //System.out.println("                    the  first stage    is   : " + dictionaryMap.values().toString()  + " size " + dictionaryMap.size());
			   
			   
			HashMap<Integer, String> numericalMap = 	encode.enCodeStage2(dictionaryMap);
			System.out.println("                    the  seconde stage  is   : " +  " size " + numericalMap.size() );
		   //System.out.println("                    the  seconde stage  is   : " + numericalMap.values().toString()  + " size " + numericalMap.size() );
			   
			   
			   
			HashMap<Integer, String> binaryEncodedBlocksMap = 	encode.enCodeStage3(numericalMap);	
			
			  int size = binaryEncodedBlocksMap.size();
			
			
			//double sizecode= (( binaryEncodedBlocksMap.size()) *( binaryEncodedBlocksMap.get(binaryEncodedBlocksMap.size()).length()) ) - 2 * (binaryEncodedBlocksMap.get(size).length()-1) ;
			
			double sizecode= (( binaryEncodedBlocksMap.size()) *( binaryEncodedBlocksMap.get(binaryEncodedBlocksMap.size()).length())) ;
			
		   System.out.println("                    the  third stage    is   : " 	+ " size " + sizecode   );
			//System.out.println("                    the  third stage    is   : " + binaryEncodedBlocksMap.values().toString()  + " size " + sizecode   );
				
			
		
			
			double  compressionraito = sizecode/stream.length();
			
			System.out.println(" output/input raito is  =  "+  compressionraito  );
			 
			 
			 
			 
		  
	      	n++;  
		 
		 
	 }
	
	//end   Entropy test -------------------------------------------------------------------------------------------------------------------------------	
	
// start  random ****************************************************   *******************************************************************	
	
	/*
	
	int numberOfSample= 10 ;
		
	int maximumLength= 1000;
	
	int minimumLength = 10;
	
	
	
	int step = 10 ;
	
	
	
	
	
	
	
	//int startLength=10 ;
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

		  

	        //System.out.println("                    the    Stream       is  : " +  "   size " +  stream.length());
		    System.out.println("                    the    Stream       is  : " + stream  + "   size " +  stream.length());
	        
			Encode  encode = new Encode(stream);	
			
			HashMap<Integer, String> dictionaryMap = encode.enCodeStage1(stream); 
		    System.out.println("                    the  first stage    is   : " + " size " + dictionaryMap.size());
		   //System.out.println("                    the  first stage    is   : " + dictionaryMap.values().toString()  + " size " + dictionaryMap.size());
			   
			   
			HashMap<Integer, String> numericalMap = 	encode.enCodeStage2(dictionaryMap);
			System.out.println("                    the  seconde stage  is   : " +  " size " + numericalMap.size() );
		   //System.out.println("                    the  seconde stage  is   : " + numericalMap.values().toString()  + " size " + numericalMap.size() );
			   
			   
			   
			   HashMap<Integer, String> binaryEncodedBlocksMap = 	encode.enCodeStage3(numericalMap);		
			System.out.println("                    the  third stage    is   : "
			//System.out.println("                    the  third stage    is   : " + binaryEncodedBlocksMap.values().toString()
					+ " size " + binaryEncodedBlocksMap.size()* binaryEncodedBlocksMap.get(1).length()    );
			
			double sizecode= binaryEncodedBlocksMap.size() * binaryEncodedBlocksMap.get(1).length() ;
			
			double  compressionraito = sizecode/stream.length();
			
			System.out.println(" output/input raito is  =  "+  compressionraito  );
			 
			 
			 
		  
		  
		  
			stringLength=stringLength + step;
		  
		}*/

	
		
	// end   random ****************************************************   *******************************************************************	    
		
		
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


