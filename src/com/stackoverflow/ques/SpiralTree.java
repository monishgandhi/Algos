package com.stackoverflow.ques;

import com.fb.graph.GraphNode;
import com.yahoo.algos.Stack;
import com.yahoo.algos.TreeNode;

public class SpiralTree<T> {

	/**
	 * @param args
	 */
	
	public void printTree(TreeNode<T> root){
		Stack<TreeNode<T>> readStack = new Stack<TreeNode<T>>(50);
		Stack<TreeNode<T>> writeStack = new Stack<TreeNode<T>>(50);
		readStack.push(root);
		spiralBfs(readStack, writeStack, false);
	}
	
	public void spiralBfs(Stack<TreeNode<T>> readStack, Stack<TreeNode<T>> writeStack, boolean lr){
		if(readStack.isEmpty() && writeStack.isEmpty()){
			return;
		}
		TreeNode<T> node =  readStack.pop();
		System.out.println(node);
		if(lr){
			if(node.getLeft()!=null) writeStack.push(node.getLeft());
			if(node.getRight()!=null) writeStack.push(node.getRight());
		}else {
			if(node.getRight()!=null) writeStack.push(node.getRight());
			if(node.getLeft()!=null) writeStack.push(node.getLeft());
		}
		if(readStack.isEmpty()){
			spiralBfs(writeStack, new Stack<TreeNode<T>>() , !lr);
		}else{
			spiralBfs(readStack, writeStack, lr);
		}
	}
	
	
	public static void main(String[] args) {
		/*
		 *             0
		 *          /    \
		 *        5        6
		 *      /  \       / \ 
		 *    3     4     7   8
		 *   / \    /\   /\    /\
		 *  9  10 11 12 13 14 15 16
		*/
		
		TreeNode<Integer> root = new TreeNode<Integer>(0); 
		TreeNode<Integer> five = new TreeNode<Integer>(5); 
		TreeNode<Integer> six = new TreeNode<Integer>(6); 
		TreeNode<Integer> three = new TreeNode<Integer>(3); 
		TreeNode<Integer> four = new TreeNode<Integer>(4); 
		TreeNode<Integer> seven = new TreeNode<Integer>(7); 
		TreeNode<Integer> eight = new TreeNode<Integer>(8); 
		TreeNode<Integer> nine = new TreeNode<Integer>(9); 
		TreeNode<Integer> ten = new TreeNode<Integer>(10); 
		TreeNode<Integer> eleven = new TreeNode<Integer>(11); 
		TreeNode<Integer> twelve = new TreeNode<Integer>(12); 
		TreeNode<Integer> thirteen = new TreeNode<Integer>(13); 
		TreeNode<Integer> fourteen = new TreeNode<Integer>(14); 
		TreeNode<Integer> fifteen = new TreeNode<Integer>(15); 
		TreeNode<Integer> sixteen = new TreeNode<Integer>(16); 
		
		
		root.setLeft(five);root.setRight(six);
		five.setLeft(three);five.setRight(four);
		three.setLeft(nine);three.setRight(ten);
		four.setLeft(eleven);four.setRight(twelve);
		
		six.setLeft(seven);six.setRight(eight);
		seven.setLeft(thirteen);seven.setRight(fourteen);
		eight.setLeft(fifteen);eight.setRight(sixteen);
		
		new SpiralTree<Integer>().printTree(root);
	}

}
