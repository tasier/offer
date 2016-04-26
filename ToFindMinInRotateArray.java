package search;
import java.util.Scanner;

//旋转数组的最小数字

class RotateArray{
	public int  findMin(int[] array){
		if(array ==  null||array.length==0){
			return -1;
		}
		
		int low = 0;
		int high = array.length-1;
		int mid = low+(high-low)/2;
		if(array[low]<array[high]){
			return array[low];
		}
		
		while(high - low>1){
			if(array[low]==array[mid]&&array[mid]==array[high]){
				return sequenceFinding(array, low, high);
			}
			if(array[mid] >=array[low]){
				low = mid;
			}else if(array[mid] <= array[high]){
				high = mid;
			}
			mid = low + (high - low)/2;
		}
		
		return array[high];
		
	}
	
	private int sequenceFinding(int[] array, int start, int end){
		
		int res = array[start];
		for(int i=start+1; i<= end; i++){
			if(res > array[i]){
				res = array[i];
			}
		}
		
		return res;
	}
}

public class ToFindMinInRotateArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++){
				arr[i] = in.nextInt();
			}
			RotateArray r = new RotateArray();
			System.out.println(r.findMin(arr));
		}
	}
}

