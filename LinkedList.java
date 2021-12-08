package main;

import java.util.Scanner;

public class LinkedList {
	private Node head; 
	
	public LinkedList() {
		head = new Node(); 
	}
	
	public LinkedList(Node n) {
		head = n; 
	}
	
	public boolean isEmpty() {
		return head == null; 
	}
	
	public void print() {
		Node current = head; 
		int counter = 1; 
		
		System.out.println(String.format("Node Head has data: %s and points to: %s " , current.getData(), current.getNext())); 
		
		while(current.getNext() != null) {
			current = current.getNext(); 
			System.out.println(String.format("Node %s has data: %s and points to: %s " , counter++, current.getData(), current.getNext()));

		}
	}

	public void insertAtFront(Node n) {
		n.setNext(head);
		head = n; 
	}
	
	public void addNodeEnd(Node n) {
		Node end = head; 
		
		while(end.getNext() != null) {
			end = end.getNext(); 
		}
		
		end.setNext(n);
		
	}
	
	public void removeHead() {
		if(head.getNext()==null) {
			return;
		} 
		head = head.getNext(); 
	}
	
	public void removeEnd() {
		Node current = head; //current == snaker
		
		if(current.getNext() == null) {
			return; 
		}
		
		while(current.getNext().getNext() != null) {
			current = current.getNext(); 
		}
		
		current.setNext(null);
	}
	
	public int countNodes() {
		int nodes = 1; 
		
		Node counter = head;
		while(counter.getNext()!= null) {
			counter = counter.getNext(); 
			nodes++; 
		}
		
		return nodes; 
	}
	
	public void removeByValue(int value) {
		Node snaker = head; 
		Node backer = head; 
		
		while(snaker.getNext() != null) {
			backer = snaker; 
			snaker = snaker.getNext(); 
			
			if(snaker.getData() == value) {
				backer.setNext(snaker.getNext());
				return;
			}
		}
	}
	
	public void insertInOrder(int value) {
		Node snaker = head; 
		Node backer = snaker; 
		
		while(snaker.getNext() != null) {
			backer = snaker; 
			snaker = snaker.getNext();
			
			if(backer.getData() <= value && value <= snaker.getData()) {
				backer.setNext(new Node(value, snaker));
				return; 
			}
		}
		
		snaker.setNext(new Node(value, null));
	}
	
	public static void main(String[] args) {
		LinkedList my_ll = new LinkedList(); 
		
		boolean wants_to_add = true; 
		Scanner keyboard = new Scanner(System.in);
		
		while(wants_to_add) {
			my_ll.print(); 
			System.out.println("Integer data to add: ");
			
			my_ll.addNodeEnd(new Node(keyboard.nextInt(), null));
			
			System.out.println("Want to add another Node to end? [Yes/No]: ");
			
			wants_to_add = keyboard.next().contentEquals("Yes"); 	
		}
		
		my_ll.removeEnd();
		my_ll.print(); 
		
		System.out.println("Removing 5");
		my_ll.removeByValue(5);
		my_ll.print(); 

		System.out.println("Inserting 3");
		my_ll.insertInOrder(3);
		my_ll.print(); 
		
		keyboard.close(); 
	}
}