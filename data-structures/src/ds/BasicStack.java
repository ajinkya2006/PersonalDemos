package ds;

public class BasicStack<E> {
	private E[] data;
	private int stackPointer;

	public BasicStack() {
		data = (E[]) new Object[1000];
		stackPointer = 0;
	}

	public void push(E newItem) {
		data[stackPointer++] = newItem;
	}

	public E pop() {
		if (stackPointer == 0)
			throw new IllegalStateException("No more items on the stack");
		return data[--stackPointer];
	}

	public boolean contains(E item) {
		boolean found = false;
		for (int i = 0; i < stackPointer; i++) {
			if (item.equals(data[i])) {
				found = true;
				break;
			}
		}
		return found;
	}

	public E access(E item) {
    	while(stackPointer > 0) {
    		E tmp = pop();
    		if(item.equals(tmp))
    		{
    			return tmp;
    		}
    	}
    	throw new IllegalArgumentException("Could not find this element on the stack" + item);
    }
	
	public int size() {
		return stackPointer;
	}
}
