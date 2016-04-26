package array;

import java.util.Arrays;

//将所有的奇数放到所有的偶数前面，并且奇数和奇数，偶数和偶数之间的相对位置不变
public class ReOrderArray {
    
    public void reOrderArray(int [] array) {
        if(array==null){
            return;
        }
        int len = array.length;
        if(len<=0){
            return;
        }
        
        int[] tmp = new int[len];
        int oddCount = 0;
        for(int i=0; i<len; i++){
            tmp[i] = array[i];
            if((array[i]&0x1)==1){
                oddCount++;
            }
        }
        //全部为偶数或者奇数
        if(oddCount==0||oddCount==len){
            return;
        }
        int evenStart = oddCount;
        int oddStart = 0;
        for(int i=0; i<len; i++){
            if((tmp[i]&0x1)==0){
                array[evenStart++] = tmp[i];
            }else{
                array[oddStart++] = tmp[i];
            }
        }
        
    }
    
    private boolean isEven(int num){
    	if((num&0x1)==0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void reOrderArrayPartition(int[] array){
    	if(array==null||array.length<=0){
    		return;
    	}
    	int i = 0;
    	int j = array.length-1;
    	
    	while(i<j){
    		while(i<j && !isEven(array[i])){
    			i++;
    		}
    		while(i<j && isEven(array[j])){
    			j--;
    		}
    		if(i<j){
    			int tmp = array[i];
    			array[i] = array[j];
    			array[j] = tmp;
    		}
    	}
    }
    
    public void reOrderArrayPartition2(int[] array){
    	if(array==null||array.length<=0){
    		return;
    	}
    	int i = -1;
    	int j = 0;
    	int len = array.length;
    	while(j < len){
    		if(!isEven(array[j])){
    			i++;
    			int tmp = array[i];
    			array[i] = array[j];
    			array[j] = tmp;
    		}
    		j++;
    	}
	}
    
    public static void main(String[] args) {
		int[] array = new int[]{1,2,3,7,4,6,9,10};
		new ReOrderArray().reOrderArrayPartition2(array);
		//new ReOrderArray().reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
    
}
