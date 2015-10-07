class Queue<T> {
	Node<T> front;
  	Node<T> rear;
  	int count = 0;
	public void enQueue(T element) {
		Node<T> newNode = new Node<T>();
		newNode.setElement(element);
		if (front == null) {
			front = newNode;
			rear = newNode;
			count++;
		} else {
			rear.setNextElement(newNode);
      		rear = newNode;
      		count++;
		}
	}
	
	public T deQueue(){
		T deQueueElement = front.getElement();
    	front = front.getNextElement();
    	count--;
    	return deQueueElement;
	}
	
	public boolean isEmpty(){
		if (front == null) {
			return true;
		}
		return false;
	}

	public T getFront(){
		return front.getElement();
	}

	public void print() {
		Node<T> printNode = front;
		int p = 0;
		if (!isEmpty()) {
			 while (p < count) {
		      System.out.println(printNode.getElement());
		      printNode = printNode.getNextElement();
		      p++;
		    }
		} else {
			System.out.println("Queue is empty");
		}
	   
	}
}