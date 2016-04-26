package tree;
import java.util.Scanner;

//输入二叉树的前序和中序遍历的序列，然后建立一颗二叉数
//输出这颗二叉数的后序遍历序列
//缺点：这样的方式建立二叉树的时候，结点的值不能重复，不然难以重新建立一颗二叉树

class TreeNode<T>{
	public T value;
	public TreeNode<T> left = null;
	public TreeNode<T> right = null;
	
	public TreeNode(){
		value = null;
	}
	public TreeNode(T value){
		this.value = value;
	}
}

class BinaryTree<T>{
	private TreeNode<T> root = null;
	private boolean unSuccess = true; 
	
	public BinaryTree(){}
	public BinaryTree(TreeNode<T> root){
		this.root = root;
	}
	
	//根据前序和中序去建立二叉树
	//返回值表示是否建立成功了二叉树
	public boolean toCreateBinaryTree(T[] preOrder, T[] midOrder){
		
		if(preOrder==null||midOrder==null){
			return false;
		}
		if(preOrder.length != midOrder.length){
			return false;
		}
		root = toCreateBinaryTreeCore(preOrder, midOrder, 0, preOrder.length,0,midOrder.length);
		if(root != null && unSuccess){
			return true;
		}
		return false;		
	}
	
	//建立成功则返回根结点，否则返回null
	//参数说明：
	//preOrder：前序遍历序列
	//midOrder：中序遍历序列
	//pStart, pEnd：前序序列的开始下表和结束下表
	//mStart, mEnd：中序序列的开始下表和结束下表
	private TreeNode<T> toCreateBinaryTreeCore(T[] preOrder, T[] midOrder,int pStart ,int pEnd,int mStart, int mEnd){
		if(pStart >= pEnd||mStart>mEnd){
			return null;
		}else{
			
			int i;
			for(i=mStart; i<mEnd; i++){
				if(midOrder[i] == preOrder[pStart]){
					break;
				}
			}
			//这个是判断前序与中序序列是否合法的关键
			if(i == mEnd){
				unSuccess = false;
				return null;
			}
			TreeNode<T> r = new TreeNode<T>(preOrder[pStart]);
			
			int leftLen = i-mStart;
			r.left = toCreateBinaryTreeCore(preOrder, midOrder, pStart+1, pStart+1+leftLen ,mStart, mStart+leftLen);
			r.right = toCreateBinaryTreeCore(preOrder, midOrder, pStart+1+leftLen, pEnd, mStart+leftLen+1, mEnd);
			
			return r;
		}		
	}
	
	//后序遍历二叉树
	public void postOrder(TreeNode<T> r){
		
		if(r != null){
			postOrder(r.left);
			postOrder(r.right);
			System.out.print(r.value+" ");
		}
	}
	
	public TreeNode<T> getRoot(){
		return root;
	}
} 




public class PreAndMidOrder {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			Integer[] preOrder = new Integer[n];
			Integer[] midOrder =new Integer[n];
			
			for(int i=0; i<n; i++){
				preOrder[i] = in.nextInt();
			}
			for(int i=0; i<n; i++){
				midOrder[i] = in.nextInt();
			}
			
			BinaryTree<Integer> tree = new BinaryTree<Integer>(); 
			if(tree.toCreateBinaryTree(preOrder, midOrder)){
				tree.postOrder(tree.getRoot());
				System.out.println();
			}else{
				System.out.println("No");
			}
		}		
	}
}