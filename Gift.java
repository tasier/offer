package array;


import java.util.Arrays;

//微信红包中其中有一个面值的金额大于红包总数的一半
public class Gift {
     public int getValue(int[] gifts, int n) {
            return arrayMove(gifts, n);     
     }
     
     private int arrayUnmove(int[] gifts, int n){
         if(gifts==null || n<=0){
             return -1;
         }
         if(gifts.length != n){
             return -1;
         }
         
         int count = 1;
         int res = gifts[0];
         
         for(int i=1; i<n; i++){
             if(count == 0){
                 count = 1;
                 res = gifts[i];
             }
             else if(gifts[i]==res){
                 count++;
             }else{
                 count--;
             }
         }
         
         if(!checkMoreThanHalf(gifts, n, res)){
             return 0;
         }
         
         return res;
     }
     
     private int arrayMove(int[] gifts, int n){
         int middle = n>>1;
         int start =0;
         int end = n-1;
         int index = partiton(gifts, start, end);
         
         while(index != middle){
             if(index > middle){
                 end = index - 1;
                 index = partiton(gifts, start, end);
             }else if(index < middle){
                 start = index + 1;
                 index = partiton(gifts, start, end);
             }
         }
         
         if(!checkMoreThanHalf(gifts, n, gifts[index])){
             return 0;
         }
       
         return gifts[index];
     }
     
     private int partiton(int[] gifts, int start, int end){
         int i = start;
         int j = end;
         
         int pivot = gifts[i];
         
         while(i < j){
             while(i < j&&gifts[j] > pivot){
                 j--;
             }
             gifts[i] = gifts[j];
             while(i < j&&gifts[i] <= pivot){
                 i++;
             }
             gifts[j] = gifts[i];
         }
         
         gifts[i] = pivot;
         
         return i;
     }
     
     private boolean checkMoreThanHalf(int[] gifts,int n,int number){
         int count = 0;
         for(int i=0; i<n; i++){
             if(gifts[i]==number){
                 count++;
             }
         }
         if(count*2>n){
             return true;
         }else{
             return false;
         }
     }
     
     
     public static void main(String[] args) {
        Gift g = new Gift();
        int[] a = new int[]{6,5,5,5,7};
        g.partiton(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}