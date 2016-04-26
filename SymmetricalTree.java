package tree;

//判断一颗二叉树是否对称
//从左右子树开始同时遍历

public class SymmetricalTree {
	private class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public boolean isSymmetrical(TreeNode pRoot){
		//空树也是对称的
        if(pRoot==null){
            return true;
        }
        return order(pRoot.left,pRoot.right);
    }
	//同时遍历两颗树
	private boolean order(TreeNode pRoot1, TreeNode pRoot2){
        if(pRoot1==null&&pRoot2==null){
            return true;
        }else if(pRoot1!=null&&pRoot2!=null){
            if(pRoot1.val==pRoot2.val&&order(pRoot1.left,pRoot2.right)&&order(pRoot1.right,pRoot2.left)){
                return true;
            }else{
                return false;
            }            
        }else{
            return false;
        }
    }
}
