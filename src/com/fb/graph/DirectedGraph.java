package com.fb.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DirectedGraph <T> implements Iterable<T>{

	HashMap<T, TreeSet<T>> graph = new HashMap<T,TreeSet<T>>();
	
	public boolean addNode(T node){
		if (graph.containsKey(node)){
			return false;
		}else {
			graph.put(node, new TreeSet<T>());
			return true;
		}
	}
	
	
	public boolean addEdge(T src, T dest){
		if(!graph.containsKey(src) || !graph.containsKey(dest)){
			throw new IllegalArgumentException();
		}
		
		graph.get(src).add(dest);
		return true;
	}
	
	public int outDegree(T node){
		if(!graph.containsKey(node) ){
			throw new IllegalArgumentException();
		}
		
		return graph.get(node).size();
	}

	//Get all the Nodes
	@Override
	public Iterator<T> iterator(){
		return graph.keySet().iterator();
	}
	
	//Total Nodes in Graph
	public int size(){
		return graph.keySet().size();
	}
	
	public Set<T> getAdjacentNodes(T node){
		if(!graph.containsKey(node)){
			throw new IllegalArgumentException();
		}
		
		return graph.get(node);
	}
	
	public DirectedGraph<T> reverseGraph(){
		DirectedGraph<T> revGraph = new DirectedGraph<T>();
		for(T node : this){
			revGraph.addNode(node);
		}
		for(T node : this){
			for( T nodesEdgeTo: this.graph.get(node)){
				revGraph.addEdge(nodesEdgeTo,node);
			}
		}
		return revGraph;
	}
}
