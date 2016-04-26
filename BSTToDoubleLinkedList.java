package tree;

public class BSTToDoubleLinkedList {
	
	private class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	    
	   //代表双向链表的头结点，在convertCore当中会用到
		    private TreeNode head = null;
		    public TreeNode Convert(TreeNode pRootOfTree) {
		        if(pRootOfTree == null){
		            return null;
		        }
		        
		        head = null;
		        convertCore(pRootOfTree);
		        
		        return head;
		    }
		    
		    //采用先右再中后左的遍历方式
		    //比采用中序遍历要少一次从尾部到头部的时间
		    private void convertCore(TreeNode root){
		        if(root != null){
		            if(root.right != null){
		            	convertCore(root.right);    
		            }
		            //这个块的代码是最漂亮也是最核心的
		            //在串联起两个结点的同时，确定当前双向链表的头结点
		            root.right = head;
		            if(head != null){
		            	head.left = root;    
		            }
		            head = root;
		            if(root.left != null){
		            	convertCore(root.left);
		            }      
		        }
		    }
		}
	}
