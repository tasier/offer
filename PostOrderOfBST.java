package tree;

//给定一个二叉树的后序遍历序列，判断这个序列是否是二叉搜索树的后序遍历序列
public class PostOrderOfBST {
	public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null){
            return false;
        }
        if(sequence.length == 0){
            return false;
        }
        
        return verifyBST(sequence,0,sequence.length-1);
    }
    private boolean verifyBST(int[] sequence, int start,int end){
        //只有一个结点
        if(start == end){
            return true;
        }
        //只有两个结点
        if(start+1 == end){
            return true;
        }
        int i=start;
        while(sequence[i]<sequence[end]){
            i++;
        }
        int mid = i-1;
        
        while(sequence[i]>sequence[end]){
            i++;
        }
        
        if(i==end){
            if(start<=mid){
                if(mid+1<=end-1){
            		return verifyBST(sequence,start,mid)&&verifyBST(sequence,mid+1,end-1);            
                }else{
                    return verifyBST(sequence,start,mid);
                }
            }else{
                if(mid+1<=end-1){
                    return verifyBST(sequence,mid+1,end-1);
                }else{
                    return false;
                }
            }
          	
        }else{
            return false;
        }    
     }
}
