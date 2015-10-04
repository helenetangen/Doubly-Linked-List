public class DoublyLinkedList {

	
	public class Node {
		private int id;
		private Node next;
		private Node previous;
		
		public Node(int id){
			this.id = id;
			this.next = null;
			this.previous = null;
		}
		
		public Node(int id, Node next, Node prevous){
			this.id = id;
			this.next = next;
			this.previous = prevous;
		}
		
		public int getId(){
			return this.id;
		}
		
		public Node getNext(){
			return this.next;
		}
		
		public void setNext(Node newNext){
			this.next = newNext;
		}
		
		public Node getPrevious(){
			return this.previous;
		}
		
		public void setPrevious(Node newPrevious){
			this.previous = newPrevious;
		}
	}
	
	
	private Node head;
	private Node tail;
	
	
	public static void main(String[] args){
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		//Test nodes
		Node nodeOne   = list.new Node(1);
		Node nodeTwo   = list.new Node(2);
		Node nodeThree = list.new Node(3);
		
		//Add nodes
		list.addNode(nodeOne);
		list.addNode(nodeTwo);
		list.addNode(nodeThree);
		list.printLinkedList();
		
		//Remove nodes
		list.removeNode(2);
		list.printLinkedList();
		list.removeNode(1);
		list.printLinkedList();
		list.removeNode(3);
		list.printLinkedList();
	}
	
	
	public DoublyLinkedList(){
		
	}
	
	
	public void addNode(Node node){
		if (head == null){
			head = node;
			tail = node;
		}
		else{
			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;
		}
	}
	
	
	public void removeNode(int id){
		Node current = head;
		while (current != null){
			if (current.getId() == id){
				if (current == head && current == tail){
					head = null;
					tail = null; 
				}
				else if (current == head){
					head = current.getNext();
					current.getNext().setPrevious(null);
				}
				else if (current == tail){
					tail = current.getPrevious();
					current.getPrevious().setNext(null);
				}
				else{
					current.getNext().setPrevious(current.getPrevious());
					current.getPrevious().setNext(current.getNext());
				}
			}
			current = current.getNext();
		}
	}
	
		public void printLinkedList(){
		Node current = head;
		System.out.println("------------");
		System.out.println("Doubly Linked List:");
		while (current != null){
			System.out.println(current.getId());
			current = current.getNext();
		}
		System.out.println("------------");
	}
	
	
}