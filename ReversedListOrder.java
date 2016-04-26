package list;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ReversedListOrder {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner( System.in);
		while(in.hasNext()){
			LinkedList< Integer> list = new LinkedList<Integer>();
			int i = in.nextInt();
			while(i != -1){
				list.add(i);
				i = in.nextInt();
			}
			Integer[] numbers = new Integer[0];
			numbers = list.toArray(numbers);
			//System.out.println(Arrays.toString(numbers));
			MyLinkedList myList = new MyLinkedList();
			myList.createList(numbers);
			//myList.reversed();
			//myList.printList();
			myList.printReversedOrderWithoutStack();
		}		
	}
}

class Node{
	public int value;
	public Node next;
	
	public Node(){
		value = -1;
		next = null;
	}
	
	public Node(int value, Node next){
		this.value = value;
		this.next = next;
	}
}

class MyLinkedList{
	private Node head;
	
	public MyLinkedList(){
		head = null;
	}
	
	public  MyLinkedList(Node head){
		this.head = head;
	}
	
	//从无到有创建一个链表
	public void createList(Integer[] numbers){
		if(head == null && numbers!=null && numbers.length!=0){
			head = new Node(numbers[0], null);
			Node p = head;
			for(int i=1; i<numbers.length; i++){
				Node q = new Node(numbers[i], null);
				p.next = q;
				p = q;
			}
		}
	}
	
	//反转链表(会改变原来链表的结构)
	public void reversed(){
		Node p = head;
		
		//链表不为空
		if(p != null){
			Node q = p.next;
			while(q != null){
				Node tmp = q.next;
				q.next = p;
				p = q;
				q = tmp;
			}
			head.next = null;
			head = p;
		}
	}
	
	//以正常的顺序去打印链表
	public void printList(){
		Node p = head;
		while(p != null){
			System.out.println(p.value);
			p = p.next;
		}
	}
	
	//通过借助辅助栈的方式去逆序打印链表
	public void printReversedOrderWithStack(){
		Node p = head;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while(p != null){
			stack.push(p.value);
			p = p.next;
		}
		while( !stack.isEmpty() ){
			System.out.println(stack.pop());
		}
	}
	
	//采用递归的方式去逆序打印一个链表
	public void printReversedOrderWithoutStack(){
		printReversedOrderWithoutStackCore(head);
	}
	
	private void printReversedOrderWithoutStackCore(Node p){
		if(p.next == null){
			System.out.println(p.value);
		}else{
			printReversedOrderWithoutStackCore(p.next);
			System.out.println(p.value);
		}
	}
}