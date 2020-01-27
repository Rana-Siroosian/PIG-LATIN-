import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 
 * @author >>Rana.Siroosian<<
 * 
 */
public class PigLatin {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner (System.in);
		
		System.out.println("Welcome to the Pig Latin Translator!");
		System.out.println();
		String anOtherLine="";
		
		do {
			System.out.println("Please enter a sentence: ");
			String word = scnr.nextLine();
			
			while (word.isBlank()) {
				
				System.out.println("Please enter a sentence: ");
				word = scnr.nextLine();
			}
			
			pigLatin(word);
			System.out.println(pigLatin(word));
		
			System.out.println("\nDo you want to translate another line? ");
			anOtherLine = scnr.nextLine();
			System.out.println();
		
		} while (anOtherLine.equals("Y") || anOtherLine.equals("y"));
		
		System.out.println("Thank you,Goodbye.");
		scnr.close();
	}
	private static String pigLatin(String s) {
		
	    String latin = "";
	    int i = 0;


	    if (isNumOrSym(s)) {
	    	return s;
	    } 
	    else {
	    	
	    	while (i<s.length()) {
	 
	    		while (i<s.length() && !isLetter(s.charAt(i))) {
	    			
	    			latin = latin + s.charAt(i);
	    			i++;
	    		}
	 
	      if (i>=s.length()) break;
	 
	      int begin = i;
	      
	      while (i<s.length() && isLetter(s.charAt(i))) {
	    	  
	        i++;
	      }
	 
	      int end = i;
	      latin = latin + pigWord(s.substring(begin, end));
	      
	    	}
	   	}
	    
	    return latin;
	}
	
	private static int firstVowel(String word) {
		
	    word = word.toLowerCase();
	    
	    for (int i=0; i<word.length(); i++)
	    	
	      if (word.charAt(i)=='a' || word.charAt(i)=='e' ||
	          word.charAt(i)=='i' || word.charAt(i)=='o' ||
	          word.charAt(i)=='u')
	    	  
	        return i;
	    
	    return 0;
	  }
	
	private static Boolean isVowel(char ch) {
		
		if (ch == 'a')
			return true;
		if (ch == 'e')
			return true;
		if (ch == 'i')
			return true;
		if (ch == 'o')
			return true;
		if (ch == 'u')
			return true;
		return false;
	}
	
	private static boolean isLetter(char c) {
		
	    return ( (c >='A' && c <='Z') || (c >='a' && c <='z') ||(c=='\''));
	  }
	
	private static String pigWord(String word) {
		
	    int split = firstVowel(word);
	    String finalText="";
	    
	    if ((isVowel(word.toLowerCase().charAt(0)))) {
	    	
	    	finalText = word + "way";
	  	    
	    }
	    else {
	    	
		    finalText= word.substring(split)+word.substring(0, split)+"ay";
	    }
	    
	  return finalText;
	}
	
	private static Boolean isNumOrSym(String str1) {
		
		Pattern p = Pattern.compile("(?U)[\\p{Punct}&&[^:?.!',]]");
		Pattern r = Pattern.compile("\\d");

		Matcher r2 = r.matcher(str1);
		Matcher s1 = p.matcher(str1);
	
		if ( ( s1.find()) || (r2.find()))
			
			return true;
		
		return false;
	}

}
