import java.util.Arrays;
import java.util.EmptyStackException;
public class ArrayQueue<T> implements Queue<T>{
	protected T[]a;
	int head;
	int n;
	int tail;

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		a = (T[]) (new Object[11]);
		head=0 ;
		n=0;
		tail=0;
	}

	public boolean empty(){
		if ( head == tail)
			return true;
		return false;
	}

	public T dequeue(){
		if(empty()){
			throw new EmptyStackException();
		}
		T item = a[head];
		n--;
		head = (head+1)% a.length;
		return item;
	}
	public void enqueue (T item){
		if(tail ==(head+1)%a.length){
			growarray();
		}
		a[tail++]=item;
		tail=tail%a.length;
		n++;
	}
	private void growarray(){
		@SuppressWarnings("unchecked")
		T[] larger = (T[]) new Object[a.length*2];
		
	 	for (int index=head; index <= tail; index++)
	 		larger[index-head] = a[index%a.length];

      	a = larger;
      	head =0;
      	tail = n;
      	
	}
} 