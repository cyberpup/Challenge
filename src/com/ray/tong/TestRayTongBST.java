package com.ray.tong;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestRayTongBST {
	
	RayTongBST bst;
	@Before
	public void setUp() throws Exception {
		bst = new RayTongBST();
	}
	
	@Test
	public void testRayTongBST(){
		
		Map<String, Integer> words = new HashMap<String,Integer>();
		
		words.put("I", 7);
		words.put("car", 3);
		words.put("am", 1);
		words.put("walking",1);
		words.put("to", 8);
		
		Set<String> keys = words.keySet();
		
		for(String word:keys){
			int frequency = words.get(word);
			System.out.println("key: "+word+" freq: "+frequency);
			//for clarity: word is now value and frequency becomes the key in BST
			bst.insert(frequency, word);
		}
		
		// Count nodes and assert
		Assert.assertEquals(5, bst.countNodes());
		
		bst.reverseInOrder();
		
	}
}
