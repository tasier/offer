package stackandqueue;
import java.util.*;

//给定一个压栈序列，判断出栈的序列是否合法
//压栈的元素没有重复的

//思路：模拟压栈出栈的过程
public class StackPushAndPop {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null || popA==null){
            return false;
        }
        if(pushA.length != popA.length){
            return false;
        }
        //两个大小为0的数组
        if(pushA.length == 0){
            return false;
        }
        
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int pushStart = 0;
        int popStart = 0;
        while(popStart < popA.length){
            if(stack.isEmpty() || stack.peek()!=popA[popStart]){
                if(pushStart >= pushA.length){
                    break;
                }
                stack.push(pushA[pushStart]);
                pushStart++;
            }else{
            	stack.pop();
                popStart++;
            }
        }
        
        if(pushStart == popStart && pushStart == pushA.length){
            return true;
        }else{
            return false;
        }
    }
}