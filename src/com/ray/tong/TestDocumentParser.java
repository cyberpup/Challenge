package com.ray.tong;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestDocumentParser {
	
	DocumentParser parser;
	@Before
	public void setUp() throws Exception {
		parser = new DocumentParser();
	}

	@Test
	public void testDocumentParser(){
		
		
		String text1 = "Synchronization is built around an internal entity "
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
				
		String text2 = ". 's '' I's"; // FAILS TODO: tell Quri can't have nonsense text.

		String text3 = "In this example, the addName method needs to synchronize changes to lastName and nameCount, but also needs to avoid synchronizing invocations of other objects' methods. (Invoking other objects' methods from synchronized code can create problems that are described in the section on Liveness.) Without synchronized statements, there would have to be a separate, unsynchronized method for the sole purpose of invoking nameList.add.";
		
		parser.parseDocument(text1);
		
		String key1 = "the";
		String key2 = "As";
		String key3 = "lock";
		int actual1 = parser.mWords.get(key1);
		int actual2 = parser.mWords.get(key2);
		int actual3 = parser.mWords.get(key3);
		Assert.assertEquals(9, actual1);	
		Assert.assertEquals(1, actual2);
		Assert.assertEquals(11, actual3);
		
		
		
	}
	
	
	public void testSaveWord(){
		
		String[] testWords = {"it", "has", "it", "acquire", "it", "it", "attempts", "has"};
		
		for(String word: testWords){
			parser.saveWord(word);
		}
		
		int actual1 = parser.mWords.get("it");
		int actual2 = parser.mWords.get("has");
		int actual3 = parser.mWords.get("acquire");
		Assert.assertEquals(4, actual1 );
		Assert.assertEquals(2, actual2 );
		Assert.assertEquals(1, actual3);
		
	}

}
