package array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class PickMinK {
	
	public static int[] pickMinKWithHeap(int[] nums, int k){
		if(nums.length <= k){
			return nums;
		}
		if(k <= 0){
			return null;
		}
		int[] res = new int[k];
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, 
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						int i1 = o1, i2 = o2;
						if(i1>i2){
							return -1;
						}else if(i1 == i2){
							return 0;
						}else{
							return 1;
						}
					}
		});
		for(int i=0; i<k; i++){
			maxHeap.add(nums[i]);
		}
		for(int i=k; i<nums.length; i++){
			if(nums[i] < maxHeap.peek()){
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
		}
		for(int i=k-1; i>=0; i--){
			res[i] = maxHeap.poll();
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int k = in.nextInt();
			int [] nums = new int[n];
			for(int i=0; i<n; i++){
				nums[i] = in.nextInt();
			}
			int[] res = pickMinKWithHeap(nums, k);
			if(res == null){
				System.out.println();
			}else{
				StringBuilder strBuilder = new StringBuilder();
				for(int i=0; i<res.length-1;  i++){
					strBuilder.append(res[i]+" ");
				}
				strBuilder.append(res[res.length-1]);
				System.out.println(strBuilder.toString());
			}
		}		
	}

}
