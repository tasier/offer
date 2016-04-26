package array;
import java.util.Scanner;

//最大子向量和（连续子数组的最大和） 

//测试用例：
//输入：
//4
//-1 -2 0 5
//输出：5 2 3; 不是5  3 3 
	
//输入：	
//	4
//	1 -1 1 8
//输出：
//9 0 3

public class GreatestSumOfSubarray {
	
	private static class Tuple{
		int max;
		int start;
		int end;
	}
	
	//循环解法
	public static Tuple findGreatestSumOfSubarray(int[] array){
		Tuple res = new Tuple();
		res.max = Integer.MIN_VALUE;
		res.start = 0;
		res.end = 0;
		int curSum = -1;

		int count = 0;
		for(int i=0; i<array.length; i++){
			if(curSum < 0){
				curSum = array[i];
				count = 0; //只有这里会是“和最大的子数组”的start
			}else{
				curSum += array[i];
			}
			count++;
			if(curSum > res.max){
				res.max = curSum;
				res.end = i; //这里可能是“和最大的子数组”的end，因为值还有增大的可能
				res.start = res.end - count+1; //通过count计算出start
			}
		}
		return res;
	} 
	
	//动态规划的递归解法
	private static int count = 0;
	public static int dynamicMethod(int[] array, int n, Tuple max){
		int res;
		
		if(n == 0){
			res = array[n];
			count = 0;
		}else{
			int v = dynamicMethod(array, n-1,max);
			if(v<0){
				res = array[n];
				count = 0;
			}else{
				res = array[n]+v;
			}
		}
		count++;
		if(res > max.max){
			max.max = res;
			max.end = n;
			max.start = n - count +1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			if(n == 0){
				System.exit(0);
			}
			int[] array = new int[n];
			for(int i=0; i<n; i++){
				array[i] = in.nextInt();
			}
			Tuple res = GreatestSumOfSubarray.findGreatestSumOfSubarray(array);
			System.out.println(res.max+" "+res.start+" "+res.end);
			
	/*		res = new Tuple();
			res.max = Integer.MIN_VALUE;
			dynamicMethod(array, n-1,res);
			System.out.println(res.max+" "+res.start+" "+res.end);*/
		}	
	}
}
