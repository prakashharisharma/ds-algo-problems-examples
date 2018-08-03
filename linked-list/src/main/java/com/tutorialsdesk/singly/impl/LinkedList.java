package com.tutorialsdesk.singly.impl;

public class LinkedList<E> {

	private Node<E> head;
	
	public void addFirst(E data) {
		if(head==null) {
			head = new Node<E>(data);
		}else {
			head = new Node<E>(data, head);
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("LinkedList [");
		Node<E> tempHead = this.head;
		sb.append(" ");
		
		while(tempHead!=null) {
			sb.append(tempHead.getData());
			sb.append(" ");
			tempHead= tempHead.getNext();
		}
		
		sb.append("]");
		
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<>();
		
		ll.addFirst("First");
		ll.addFirst("Second");
		
		System.out.println(ll);
	}
}
