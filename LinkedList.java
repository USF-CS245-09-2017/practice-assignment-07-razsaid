public class  LinkedList<T> implements List<T> {
	private Node<T> head;
	private int size;

	// this class gives us access to node constructs

	private class Node <T>{
		T data;
		Node next;
		public Node (T element){
			data = element;
			next= null;
		}
		T get(){
			return data;
		}
		Node getNext(){
			return next;
		}
		void setNext(Node next){
			this.next = next;
		}
	}

	// default constructor
	public LinkedList(){
		head = null;
		size=0;
	}

	// updates and returns the size of the linked list
	public int size(){
		return size;
	}

	// get an the element from specified position in the Linked List
	public T get(int pos){
		Node current = head;
		if (pos<0 || pos>size()){
			return null;
		}
		for (int i=0; i<pos;i++){ 
			current = current.getNext();
		}
		return (T) current.get();
	}

	//remove element from specified position in the Linked List
	public T remove(int pos){
		if (pos<0 || pos>=size()){
			return null;
		}
		if (pos == 0){
			// here we remove our first element by setting the head to start from the next element
			Node temp = head;
			head = head.getNext();
			size--;
			return (T)temp.get();
		} 
		else{
			/*
			here we are trying to reach a point before our selected position to be removed
			we then remove the element by setting the element after position to be what 
			follows prev, dropping the node at the specified position
			*/
			Node prev = head, current= prev.getNext();
			for (int i =0;i<pos-1;i++ ) {
				prev= prev.getNext();
				current = current.getNext();
			}
			prev.setNext(current.getNext());
			size--;
			return (T)current.get();
		}
	}

	// add node to the last position in the Linked List
	public void add(T item){
		if (head == null){
			// create our head with the new item node if linked list has no elements
			head= new Node(item);
			size++;
		} 
		else{
			// else we iterate until we can se the node's next, before null, to the new node
			Node node = new Node (item);
			Node prev = head, current= prev.getNext();
			while(current != null) {

				prev = prev.getNext();
				current = current.getNext();
			}
			prev.setNext(node);
			size++;

		}
		

	}

	// add node to selected position in the Array List
	public void add(int pos, T item){
		if (pos>=0 && pos<=size){
			Node node = new Node(item);
			if (pos == 0){
				// set our head to be the new node object and increment the size
				node.setNext(head);
				head = node;
				size++;
			}
			else{
				/*here we select our node in reached position to be the next node for our new node
				then we set this combination to be the starting node that follows the previous node*/
				Node prev = head, current= prev.getNext();
				for (int i=0;i<pos-1;i++){
					prev = prev.getNext();
					current= current.getNext();
				}

				node.setNext(current);
				prev.setNext(node);
				size++;
			}
		}

	}

	// display the data that the Nodes in the Linked List contains
	public void Display(){
		Node current = head;
		while(current!= null){
			System.out.println(current.get());
			current = current.getNext();
		}

	}




}
