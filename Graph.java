package com.main;

import java.util.*;

public class Graph {

	private int V;   // No. of vertices
	private LinkedList<AdjListNode> adj[]; // Adjacency List
	
	//AdjListNode adj[];
	Stack<AdjListNode> st = new Stack<AdjListNode>();
	
	Graph(int V) // Constructor
	{
	    this.V = V;
	     adj = new LinkedList[V];
	     for (int i=0; i<V; ++i)
	         adj[i] = new LinkedList();
	}
	
	// function to add an edge to graph
	void addEdge(int u, int v, int weight) {
		adj[u].add(new AdjListNode(v,weight));
	}
	
	 // A recursive function used by topologicalSort
	 void topologicalSortUtil(int v, boolean visited[],Stack<Integer> stack)
	 {
	     // Mark the current node as visited.
	     visited[v] = true;
	     AdjListNode i;

	     // Recur for all the vertices adjacent to this
	     // vertex
	     Iterator<AdjListNode> it = adj[v].iterator();
	     while (it.hasNext())
	     {
	         i = it.next();
	         if (!visited[i.getV()])
	             topologicalSortUtil(i.getV(), visited, stack);
	     }

	     // Push current vertex to stack which stores result
	     stack.push(new Integer(v));
	 }
	 
	// The function to find longest distances from a given vertex.
	// It uses recursive topologicalSortUtil() to get topological 
	// sorting.
	void longestPath(int s)
	{
	    Stack<Integer> st = new Stack<Integer>();
	    
	    int[] dist = new int[V];
	    
	    int maxTime = 0;
	    	 
	    // Mark all the vertices as not visited
	    boolean[] visited = new boolean[V];
	    	    
	    for (int i = 0; i < V; i++)
	        visited[i] = false;
	 
	    // Call the recursive helper function to store Topological
	    // Sort starting from all vertices one by one
	    for (int i = 0; i < V; i++)
	        if (visited[i] == false)
	            topologicalSortUtil(i, visited, st);
	 
	    // Initialize distances to all vertices as infinite and
	    // distance to source as 0
	    for (int i = 0; i < V; i++)
	        dist[i] = Integer.MIN_VALUE;
	    dist[s] = 0;
	 
	    // Process vertices in topological order
	    while (!st.empty())
	    {
	        // Get the next vertex from topological order
	        int u = st.peek();
	        st.pop();
	
	        AdjListNode i;

		     // Recur for all the vertices adjacent to this
		     // vertex
		     Iterator<AdjListNode> it = adj[u].iterator();
	        // Update distances of all adjacent vertices	     
		     if (dist[u] != Integer.MIN_VALUE) {
		    	 while(it.hasNext()) {
		    		 i = it.next();
		    		 if(dist[i.getV()] < dist[u] + i.getWeight())
		    			 dist[i.getV()] = dist[u] + i.getWeight();
		    	 }
		     }
	    } 
	    // Print the calculated longest distances
	    for (int i = 0; i < V; i++)
	        if(dist[i] == Integer.MIN_VALUE) {  System.out.println("Infinite ......."); }
	        else {
	        	System.out.println(dist[i] + " ");
	        	if(dist[i] > maxTime) {
	        		maxTime = dist[i];
	        	}
	        }
	    System.out.println("\nETA to finish the job in mins - " + maxTime);
	}
	
}
