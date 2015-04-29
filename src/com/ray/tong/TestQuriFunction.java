package com.ray.tong;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestQuriFunction {
	
	RayTongBST bst;
	DocumentParser parser;
	Map<String, Integer> words;
	List<String> temp;
	
	QuriChallenge quri;
	
	String text;
	
	
	@Before
	public void setUp() throws Exception {
		
		parser = new DocumentParser();
		bst = new RayTongBST();
		words = new HashMap<String,Integer>();
		quri = new QuriChallenge();
		temp = new ArrayList<String>();
		
		text = "Synchronization is built around an internal entity "
				+ "known as the intrinsic lock or monitor lock. "
				+ "(The API specification often refers to this entity "
				+ "simply as a monitor.) Intrinsic locks play a role "
						+ "in both aspects of synchronization: enforcing "
						+ "exclusive access to an object's state and "
						+ "establishing happens-before relationships "
						+ "that are essential to visibility."
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
	}

	
	@Test
	public void testFrequencyWords(){
		
		// Map words & frequency
		parser.parseDocument(text);
		
		// Point to Map
		words = parser.mWords;
		
		// Get keys	
		Set<String> keys = words.keySet();
		
		// Insert words into BST (switch keys to values and vice-versa)
		for(String word:keys){
			int frequency = words.get(word);
			// System.out.println("key: "+word+" freq: "+frequency);
			// key = frequency, value = key in BST
			bst.insert(frequency, word);
		}
		
		assertEquals(1, words.get("owns").intValue());
		assertEquals(2, words.get("that").intValue());
		assertEquals(11, words.get("lock").intValue());
		assertNull(words.get("s"));

	}
	
	@Test
	public void testQuriFunction(){
		
		int numOfItems = 6;
		
		String[] expecteds = {"lock","the","to","intrinsic","an","thread"};
	
		List<String> results = quri.quriThis(text, numOfItems);
		String[] actuals = new String[results.size()];
		actuals = results.toArray(actuals);
		
		assertArrayEquals(expecteds, actuals);
		
	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testLowerBounds(){
		int numOfItems = -1;
		List<String> results = quri.quriThis(text, numOfItems);
	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testUpperBounds(){
		int numOfItems = 100000;
		List<String> results = quri.quriThis(text, numOfItems);
	}
	


}
