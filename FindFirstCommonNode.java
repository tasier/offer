package list;

public class FindFirstCommonNode {
	
	private class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		if(pHead1==null || pHead2==null){
            return null;
        }
        
        int len1 = 0;
        int len2 = 0;
        ListNode p = pHead1;
        ListNode q = pHead2;
        
        while(p!=null){
            len1++;
            p = p.next;
        }
        while(q!=null){
            len2++;
            q = q.next;
        }
        p = pHead1;
        q = pHead2;
        
        while(len1 > len2){
            p = p.next;
            len1--;
        }
        while(len2 > len1){
            q = q.next;
            len2--;
        }
        
        while(p!=null && q!=null){
            if(p.val==q.val){
                return p;
            }else{
                p = p.next;
                q = q.next;
            }
        }
        return null;
    }
}