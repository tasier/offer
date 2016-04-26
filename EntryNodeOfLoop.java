package list;

public class EntryNodeOfLoop {
	private class ListNode {
		   int val;
		   ListNode next = null;

		   ListNode(int val) {
		       this.val = val;
		   }
		}
	
   //首先判断是否有环存在，如果有环则返回环的长度，如果没有则返回-1
   private int loopLength(ListNode pHead){
  		//每次走一步
       ListNode pSlow = pHead.next;
       
       //只有一个结点且不成环
       if(pSlow == null){
           return -1;
       }
       //每次走两步
       ListNode pFast = pSlow.next;
       
       while(pFast!=null){
       	if(pFast == pSlow){//存在环
               break;
           }else{
               pSlow = pSlow.next;
               pFast = pFast.next;
               if(pFast == null){
                   break;
               }
               pFast = pFast.next;
           }    
       }
       //链表不存在环
       if(pFast==null){
           return -1;
       }
       int loopOfLen = 1;
       ListNode p = pFast.next;
       while(p != pFast){
           loopOfLen++;
           p = p.next;
       }
       return loopOfLen;
   }
   
   
   public ListNode entryNodeOfLoop(ListNode pHead)
   {
       if(pHead == null){
           return null;
       }
       
       int loopOfLen = loopLength(pHead);
       if(loopOfLen == -1){
           return null;
       }
       
       ListNode pSlow = pHead;
       ListNode pFast = pHead;
       
       int i = 0;
       //pFast向先走一个环长
       while(i < loopOfLen){
           pFast = pFast.next;
           i++;
       }
       while(pSlow != pFast){
           pSlow = pSlow.next;
           pFast = pFast.next;
       }
       return pSlow;
   }
}