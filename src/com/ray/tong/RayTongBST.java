package com.ray.tong;

import java.util.ArrayList;
import java.util.List;

/**
 * Barebone BST
 * 
 * Main Functions: insert, countNodes, reverseInOrder
 * 
 * @author Raymond Tong
 * Date: April 29th, 2015
 *
 */

public class RayTongBST{
	
	private Node root;
	private List<String> reverseInOrderList;
	
	public RayTongBST(){
		reverseInOrderList = new ArrayList();
	}
	
	public int countNodes(){
			return countNodes(root);
	}
	
	
	/**
	 * 
	 * Inserts key-value into BST
	 * 
	 * @param key = frequency
	 * @param value = word
	 * 
	 */
	
	public void insert(int key, String value){
		root = insert(root, key, value);
		//System.out.println("insert complete!\n");
	}
	
	private Node insert(Node node, int key, String value){
		
		if (node == null){
			//System.out.println("Node: "+value+" created.");
			node = new Node(key,value);
		}else{
			
			//System.out.println("@ node: "+node.getWord());
			if (key <= node.getKey()){
				//go left
				//System.out.println("moving left");
				node.leftChild = insert(node.leftChild, key, value);

			}else{
				// go right	
				//System.out.println("moving right");
				node.rightChild = insert(node.rightChild, key, value);
			}	
		}

		return node;
		
	}
	
	public List<String> getReverseInOrderList(){
		return reverseInOrderList;
	}
	
	public void reverseInOrder(){
		
		reverseInOrder(root);
	}
	
	// Reverse IN-ORDER traversal
	private void reverseInOrder(Node node){

		if (node != null){
			
			reverseInOrder(node.getRightChild());
			//System.out.println(node.getWord());
			reverseInOrderList.add(node.getWord());			
			reverseInOrder(node.getLeftChild());
			
		}
		
	}
	
	// Recursively count number of nodes
	private int countNodes(Node node){
		if (node == null){
			return 0;
		}
		else{
			int count = 1;
			count += countNodes(node.getRightChild());
			count += countNodes(node.getLeftChild());
			return count;
		}
	}
	
	private class Node {
		
		private Node leftChild;
		private Node rightChild;
		
		private int frequency; //Key	
		private String word; //Value
	
		
		Node(int key, String value){
			leftChild=null;
			rightChild=null;
			word = value;	
			frequency = key;
		}
		
		public int getKey(){
			return frequency;
		}
		
		public String getWord(){
			return word;
		}
		
		public Node getRightChild(){
			return rightChild;
		}
		
		public Node getLeftChild(){
			return leftChild;
		}
		
	
	}
	

}
