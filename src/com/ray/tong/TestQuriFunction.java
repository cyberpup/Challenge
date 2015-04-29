package com.ray.tong;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestQuriFunction {
	
	RayTongBST bst;
	DocumentParser parser;
	Map<String, Integer> words;
	
	
	@Before
	public void setUp() throws Exception {
		
		parser = new DocumentParser();
		bst = new RayTongBST();
		words = new HashMap<String,Integer>();
	}

	@Test
	public void testFrequencyWords(){
		
		
		String text = "Synchronization is built around an internal entity "
				+ "known as the intrinsic lock or monitor lock. "
				+ "(The API specification often refers to this entity "
				+ "simply as a monitor.) Intrinsic locks play a role "
						+ "in both aspects of synchronization: enforcing "
						+ "exclusive access to an object's state and "
						+ "establishing happens-before relationships "
						+ "that are essential to visibility. 's '' I's"
						+ "Every object has an intrinsic lock associated "
						+ "with it. By convention, a thread that needs "
						+ "exclusive and consistent access to an object's "
						+ "fields has to acquire the object's intrinsic "
						+ "lock before accessing them, and then release the "
						+ "intrinsic lock when it's done with them. A thread "
						+ "is said to own the intrinsic lock between the time "
						+ "it has acquired the lock and released the lock. "
						+ "As long as a thread owns an intrinsic lock, no "
						+ "other thread can acquire the same lock. The other "
						+ "thread will block when it attempts to acquire the "
						+ "lock.";
		
		
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
	}


}
