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
		current = head;
		while (current != null){
			if (current.getId() == id){
				if (current == head && current == tail){
					head = null;
					tail = null; 
				}
				else if (current == head){
					current.getNext() = head;
					current.getNext().setPrevious(null);
				}
				else if (current == tail){
					current.getPrevious() = tail;
					current.getPrevious().setNext(null);
				}
				else{
					current.getNext().setPrevous(current.Prevous);
					current.getPrevous().setNext(current.Next);
				}
			}
			current = current.getNext();
		}
	}
	
	
}