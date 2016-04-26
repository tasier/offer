package list;

//此题主要是判断边界条件，以及考验代码的鲁棒性
public class FindTheLastKthNode {
	private class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
    public ListNode FindKthToTail(ListNode head,int k) {
    	//链表为空或者要求的倒数第k个结点小于等于0
		if(head == null || k<=0){
            return null;
        }
        ListNode pFast = head;
        for(int i=1; i<k; i++){
            pFast = pFast.next;
            //k大于了链表的长度
            if(pFast == null){
                return null;
            }
        }
        ListNode pSlow = head;
        while(pFast.next != null){
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        return pSlow;
    }
}