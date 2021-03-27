package ds;

public class BasicQueue<X> {

	private X[] data;
	private int front;
	private int end;
	public BasicQueue() {
		this(1000);
	}
	public BasicQueue(int size) {
		this.front = -1;
		this.end = -1;
		data = (X[])new Object[size];
	}
	
	public int size() {
		if(front == -1 && end == -1)
			return 0;
		else
		return end - front+1;
	}
	
	public void enQueue(X item) {
		if((end+1) % data.length == front) {
			throw new IllegalStateException("Queue is full");
		}
		else if(size() == 0)
		{
			front++;
			end++;
			data[front] = item;
		}
		else {
			end++;
			data[end] = item;
		}
			
	}
	
	public X deQueue() {
		X item = null;
		if(size() == 0)
			throw new IllegalStateException("Cant dequeue because queue is empty");
		
		else if(front==end) {
			item = data[front];
			data[front] = null;
			front = -1;
			end = -1;	
	}	
		else {
			item = data[front];
			data[front] = null;
			front++;
		}
		return item;
	}
}
