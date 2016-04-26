package tree;
import java.util.ArrayList;
import java.util.LinkedList;;
/*
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
*/ 

public class FindTreePath {
	private class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private LinkedList<Integer> path = new LinkedList<Integer>();
    private int count = 0;
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return res;
        }
        findPathCore(root,target);
        return res;
     	   
    }
    private void findPathCore(TreeNode root, int target){
        //根结点不能为null,不然会发生空指针异常
        if(root != null){
            //到了叶子结点开始统计，不然路径会重复
        	if(root.left == null&&root.right == null){	
	            if(count+root.val == target){
	                path.add(root.val);
	                //注意：这里必须新建一个实例对象，不能直接把path放入结果中
	                //因为path的值是在不断变化的
	                //当函数调用结束之后，path结合为空，但path的引用不为空
	                res.add(new ArrayList<Integer>(path));
	                path.pollLast();
	            }
	        }else{
	        	count += root.val;
	        	path.add(root.val);
	            findPathCore(root.left,target);    
	        	findPathCore(root.right,target);        	
	        	count -= root.val;
	        	path.pollLast();    
	        }    
        }      
    }
}
