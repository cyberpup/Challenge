package com.ray.tong;

import java.util.HashMap;
import java.util.Map;

/**
 * Parses a text document and maps words and their occurrences
 * by key-value pairs. Where key = word and value = occurrences
 * 
 * A word is defined as follows:
 * 
 * Any sequence of chars beginning with either an upper or lower case letter
 * (i.e. the set {a - z, A-Z} followed immediately by a space or a letter
 * 
 * Edge cases: Contractions are not counted (i.e. in the sentence 'I'm having fun.' 
 * only 'I', 'having', 'fun' will be counted)
 * 
 * Time Complexity: N time 
 * 
 * @author: Raymond Tong
 * Date: April 29th, 2015
 */

public class DocumentParser {

		Map<String, Integer> mWords;
	
		boolean mIsContraction;
		
		public DocumentParser(){
			mWords = new HashMap<String, Integer>();
			mIsContraction = false;
		}

		public void parseDocument(String text){
			
			int ascii=0;
			StringBuffer word = new StringBuffer();
			
			for(int i=0; i<text.length(); i++){
				char letter = text.charAt(i);
				ascii=(int)letter;
				
				// contraction ends if a space is encountered
				if(mIsContraction){
					if(ascii == 32)
						mIsContraction = false;
					continue;
				}
				
				// Find words
				if (isLowerCase(ascii)){
					word.append(letter);
				}else if (isUpperCase(ascii)){
					word.append(letter);	
				}else if(word.length()!=0){
					
					if(ascii == 39){
						mIsContraction = true;
						// Save current word
						saveWord(word.toString());
						
						// clear String buffer to start a new word
						word.delete(0, word.length());
						continue;
					}
					// Save current word
					saveWord(word.toString());
					System.out.println(word);
					
					// clear String buffer to start a new word
					word.delete(0,  word.length());

				}

			}
		}
		
		// Store the word and update frequency of the word
		void saveWord(String word){
			int frequency=1;
			if(mWords.containsKey(word)){
				frequency = mWords.get(word);
				mWords.put(word, ++frequency);
			}else
				mWords.put(word,frequency);
		
		}
		
		// Ascii 97 to 122 (lower case)
		public static boolean isLowerCase(int ascii){
			if(ascii>96 && ascii<123){

				return true;
			}
			
			return false;
		}
		
		// Ascii 65 to 90 (upper case)
		public static boolean isUpperCase(int ascii){
			if(ascii>64 && ascii<91){
				return true;
			}
			
			return false;
		}
}
