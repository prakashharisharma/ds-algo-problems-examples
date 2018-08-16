package com.tutorialsdesk.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TopologicalSort_Iterative {

	// L <- Empty list that will contain the sorted elements
	List<Node> L = new ArrayList<Node>();

	// S <- Set of all nodes with no incoming edges
	Set<Node> S = new HashSet<Node>();

	Node[] allNodes;

	TopologicalSort_Iterative(Node[] allNodes) {
		this.allNodes = allNodes;
	}

	static class Node {

		public final int data;
		public final Set<Edge> inEdges;
		public final Set<Edge> outEdges;

		public Node(int data) {
			this.data = data;
			inEdges = new HashSet<Edge>();
			outEdges = new HashSet<Edge>();
		}

		public Node addEdge(Node node) {
			Edge e = new Edge(this, node);
			outEdges.add(e);
			node.inEdges.add(e);
			return this;
		}

		@Override
		public String toString() {
			return data + "";
		}
	}

	static class Edge {
		public final Node from;
		public final Node to;

		public Edge(Node from, Node to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public boolean equals(Object obj) {
			Edge e = (Edge) obj;
			return e.from == from && e.to == to;
		}
	}

	public void toplogicalSort() {

		for (Node n : allNodes) {
			if (n.inEdges.size() == 0) {
				S.add(n);
			}
		}

		// while S is non-empty do
		while (!S.isEmpty()) {
			// remove a node n from S
			Node n = S.iterator().next();

			S.remove(n);

			// insert n into L
			L.add(n);

			// for each node m with an edge e from n to m do
			for (Iterator<Edge> it = n.outEdges.iterator(); it.hasNext();) {
				// remove edge e from the graph
				Edge e = it.next();
				Node m = e.to;
				it.remove();// Remove edge from n
				m.inEdges.remove(e);// Remove edge from m

				// if m has no other incoming edges then insert m into S
				if (m.inEdges.isEmpty()) {
					S.add(m);
				}
			}
		}

		// Check to see if all edges are removed
		boolean cycle = false;

		for (Node n : allNodes) {
			if (!n.inEdges.isEmpty()) {
				cycle = true;
				break;
			}
		}
		if (cycle) {
			System.out.println("Cycle present, topological sort not possible");
		} else {
			System.out.println("Topological Sort: " + Arrays.toString(L.toArray()));
		}
	}

	public static void main(String[] args) {

		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		node40.addEdge(node10).addEdge(node20);

		node10.addEdge(node30);

		node20.addEdge(node10).addEdge(node30).addEdge(node60).addEdge(node50);

		node30.addEdge(node60);

		node60.addEdge(node70);

		node50.addEdge(node70);

		Node[] allNodes = { node40, node10, node20, node30, node60, node50, node70 };

		TopologicalSort_Iterative tsi = new TopologicalSort_Iterative(allNodes);

		tsi.toplogicalSort();
		
	}
}
