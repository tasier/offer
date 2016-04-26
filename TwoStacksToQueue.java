package stackandqueue;
import java.util.LinkedList;
import java.util.Scanner;

//用两个栈实现队列 

public class TwoStacksToQueue {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			//n组操作
			int n = in.nextInt();
			MyQueue<Integer> queue = new MyQueue<Integer>();
			for(int i=0; i<n; i++){
				String op = in.next();
				if(op.equals("PUSH")){
					int e = in.nextInt();
					queue.push(e);
				}else{
					Integer e = queue.pop();
					if(e != null){
						System.out.println(e);
					}else{
						System.out.println(-1);
					}
				}
			}
		}
	}
}

class MyQueue<T>{
	private LinkedList<T> stack1 = new LinkedList<T>();
	private LinkedList<T> stack2 = new LinkedList<T>();
	
	public void push(T element){
		stack1.push(element);
	}
	
	public T pop(){
		if(stack2.isEmpty()){
			if(!stack1.isEmpty()){
				while(!stack1.isEmpty()){
					stack2.push(stack1.pop());
				}
			}else{
				return null;
			}
		}
		return stack2.pop();
	}
}
