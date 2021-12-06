package main;

public class Node {
	private int data;
	private Node next; 
	
	public Node() {
		data = 0; 
		next = null; 
	}
	
	public Node(int m, Node n) {
		data = m;
		next = n; 
	}
	
	public Node getNext() {
		return next;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int d) {
		data = d; 
	}
	
	public void setNext(Node n) {
		next = n; 
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(); 
		Node node2 = new Node(2, node1); 
		Node node3 = new Node(3, node2); 
		
		System.out.println(node3.getData()); 
		System.out.println(node3.getNext().getData());
		
	}
	
	
}
