package tree;

//判断树结点是否相等，是判断他们的值是否相等，不是结点指针是否相同
/*
 * 思路：
 * 首相判断当前两颗树的结点是否相等（如果相等，则比较两颗子树是否相等，如果子树也相等，则子树结构成立，否则不是）
 * 判断左子树中是否存在子树结构
 * 判断右子树中是否存在子树结构
 * 
 * */

public class HasSubTree {
	private class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	
	
    //空树不是另外一颗非空树的子树
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null){
            return false;
        }
        if(root2==null){
            return false;
        }
        return hasSubtreeCore(root1,root2);
    }
    private boolean hasSubtreeCore(TreeNode root1,TreeNode root2) {
        if(root1==null){
            if(root2==null){
                return true;
            }
            return false;
        }
        if(root2==null){
            return true;
        }
        
		if(root1.val == root2.val){
            if(hasSubtreeCore(root1.left,root2.left)&&hasSubtreeCore(root1.right,root2.right)){
                return true;
            }
        }
        if(hasSubtreeCore(root1.left,root2)){
                return true;
        }
        if(hasSubtreeCore(root1.right,root2)){
                return true;
         }
        
        return false;
        
    }
}
}