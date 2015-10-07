class Node<T> {
	T element;
	Node<T> nextElement;

	public void setElement(T element) {
		this.element = element;
	}

	public T getElement() {
		return this.element;
	}

	public void setNextElement(Node<T> nextElement) {
		this.nextElement = nextElement;
	}

	public Node<T> getNextElement() {
		return this.nextElement;
	}
}