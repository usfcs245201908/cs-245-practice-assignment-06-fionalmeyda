import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class ArrayStack<T> implements Stack<T>{

	protected int top;
	protected T[]stack;


	@SuppressWarnings("unchecked")
	public ArrayStack() {
		stack = (T[]) (new Object[11]);
		top= -1;
	}
	public boolean empty(){
		if(top==-1)
			return true;
		return false;
	}

	public T pop(){
		if(empty()== true){
			throw new EmptyStackException();
		}
		return stack[top--];
	}

	public void push(T item){
		if(stack.length - 1 == top){
			growarray();
		}
		top++;
		stack[top]= item;
	}
	public T peek(){
		if(empty()== true){
			throw new NoSuchElementException();
		}
		return stack[top];
	}

	private void growarray(){
		@SuppressWarnings("unchecked")
		T[] larger = (T[]) (new Object[stack.length*2]);
		
	 	for (int index=0; index < stack.length; index++)
	 		larger[index] = stack[index];

      	stack = larger;
	}


}
