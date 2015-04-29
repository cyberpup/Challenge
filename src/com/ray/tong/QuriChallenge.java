package com.ray.tong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given:
 * (1) a String representing the contents of a text document
 * (2) an integer providing the number of items to return
 * 
 * Returns: 
 * a list of Strings ordered by word frequency, 
 * the most frequently occurring word first. 
 * 
 * 
 * @author Raymond Tong
 * Date: April 29th, 2015
 *
 */

public class QuriChallenge {
	
	DocumentParser parser;
	RayTongBST bst;
	
	List<String> results;
	
	
	public QuriChallenge(){
		parser = new DocumentParser();
		bst = new RayTongBST();
		results = new ArrayList<String>();
	}
	/**
	 * 
	 * @param text
	 * @param numOfItems
	 * @return a list of Strings ordered by word frequency, 
	 * 			the most frequently occurring word first.
	 */
	
	public List<String> quriThis(String text, int numOfItems){
		
		
		Map<String, Integer> words = new HashMap<String,Integer>();
		// Map words & frequency
		parser.parseDocument(text);
		
		// Point to Map
		words = parser.mWords;
		
		// Get keys	
		Set<String> keys = words.keySet();
		
		// Insert words into BST (switch keys to values and vice-versa)
		for(String word:keys){
			int frequency = words.get(word);

			// key = frequency, value = key in BST
			bst.insert(frequency, word);
		}
		
		bst.reverseInOrder();
		
		if (numOfItems<=bst.countNodes() && numOfItems > -1){
			
			
			List<String> allResult = bst.getReverseInOrderList();
				
			return allResult.subList(0,numOfItems);
			
		}else {
			throw new ArrayIndexOutOfBoundsException("Requested number of items is invalid.");
		}
	
	}
}
