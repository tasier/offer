package list;
import java.util.HashMap;
import java.util.Scanner;


public class CopyComplexList {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			Integer[] values = new Integer[n];
			int[] siblings = new int[n];
			
			for(int i=0; i<n; i++){
				values[i] = in.nextInt();
			}
			for(int i=0; i<n; i++){
				siblings[i] = in.nextInt();
			}
			
			ComplexLinkedList<Integer> list = new ComplexLinkedList<Integer>(n);
			list.init(values, siblings);
			//list.print();
			ComplexLinkedList<Integer> copyList = list.deepCopy();
			copyList.print();
			
		}
	}
}

class ComplexLinkedList<T>{
	private class Node<T>{
		public  T value;
		Node next;
		Node sibling;
	}
	
	private int len = 0; //链表长度
	private Node<T> head = null;
	
	public ComplexLinkedList(){
	}
	
	public ComplexLinkedList(int n){
		this.len = n;
		this.head = new Node();
		Node p = head;
		Node q = null;
		for(int i=1; i<n; i++){
			q = new Node();
			p.next = q;
			p = q;
			q = null;
		}
	}
	
	public void init(T[] values, int[] siblings){
		Node<T> p = head;
		//建立结点编号与结点之间的映射关系，为构建复杂链表提供基础
		HashMap<Integer, Node<T>> noToNode = new HashMap<Integer,Node<T>>();
		
		for(int i=0; i<len; i++){
			p.value = values[i];
			noToNode.put(new Integer(i+1), p);
			
			p = p.next;
		}
		
		p = head;
		for(int i=0; i<len; i++){
			if(siblings[i] != 0){
				p.sibling = noToNode.get(siblings[i]);
			}
			p = p.next;
		}
	}
	
	public ComplexLinkedList<T> deepCopy(){
		ComplexLinkedList<T> res = new ComplexLinkedList<T>();
		
		
		Node<T> p = head;
		Node<T> q = null;
		for(int i=0; i<len; i++){
			//在p与p.next之间插入一个新的结点q
			q = new Node<T>();
			q.value = p.value;
			q.next = p.next;
			p.next = q;
			
			p = q.next;
			q = null;	
		}
		
		//为新插入的结点建立sibling关系
		p = head;
		q = null;
		for(int i=0; i<len; i++){
			q = p.next;
			if(p.sibling != null){
				q.sibling = p.sibling.next;
			}else{
				q.sibling = null;
			}
			
			p = q.next;
			q = null;
		}
		
		//把复制好的链表拆开
		Node<T> newHead = head.next;
		p = head;
		q = head.next;
		for(int i=0; i<len; i++){
			p.next = q.next;
			p = p.next;
			
			
			if(p != null){
				q.next = p.next;
				q = q.next;
			}else{//当复制到最后一个结点的时候
				q.next = null;
				q = null;
			}
		}
		
		res.len = this.len;
		res.head = newHead;
		return res;		
	}
	
	public void print(){
		Node<T> p = head;
		for(int i=0; i<len; i++){
			if(p.sibling != null){
				System.out.println(p.value+" "+p.sibling.value);
			}else{
				System.out.println(p.value+" "+0);
			}
			p = p.next;
		}
	}
}