package com.stackoverflow.ques;

import java.util.ArrayList;
import java.util.List;

import com.yahoo.algos.MyQueue;

/*
 * Snakes and Ladders is a directed cyclic graph. Create the graph and do BFS 
 */
public class SnakesLadders {
	private static final int N = 30;
	private static final int[] moves = new int[N];
	
	static {
		//Default everything
//		http://www.geeksforgeeks.org/snake-ladder-problem-2/
		for (int i = 0 ; i < N ; i ++){
			moves[i]  = -1;
		}
		
		  // Ladders
	    moves[2] = 21;
	    moves[4] = 7;
	    moves[10] = 25;
	    moves[19] = 28;
	 
	    // Snakes
	    moves[26] = 0;
	    moves[20] = 8;
	    moves[16] = 3;
	    moves[18] = 6;
		
	}
	
	
	//BFS
	public static void findBestPath(){
		MyQueue<QueueEntry<Integer, Integer>> queue = new MyQueue<QueueEntry<Integer,Integer>>();
		List<Integer> visitedNodes = new ArrayList<Integer>();
		QueueEntry<Integer, Integer> firstEntry = new QueueEntry<Integer, Integer>(0, 0);
		queue.enqueue(firstEntry);
		visitedNodes.add(1);
		QueueEntry<Integer, Integer> entry =null;
		while (!queue.isEmpty()){
			entry = queue.dequeue();
			int v = entry.val;
			
			if(v==N-1){
				break;
			}
			for(int i = v+1 ;i<(v+6)&& i<N; i++){
				
				if(!visitedNodes.contains(i)){
					visitedNodes.add(i);
					
					QueueEntry<Integer, Integer> nodeToQueue ; 
					
					if(moves[i]!=-1){
						nodeToQueue = new QueueEntry<Integer, Integer>(entry.dist+1, moves[i] );
					}else{
						nodeToQueue = new QueueEntry<Integer, Integer>(entry.dist+1, i );
					}
					
					queue.enqueue(nodeToQueue);
				}
			}
		}
		System.out.println(entry.dist);
	}
	
	private static class QueueEntry<D,V>{
		D dist;
		V val;
		public QueueEntry(D dist, V val){
			this.dist = dist;
			this.val = val;
		}
		@Override
		public String toString() {
			return val.toString();
		}
	}

	
	
	public static void main(String[] args) {
		findBestPath();
	}
	
	
}

