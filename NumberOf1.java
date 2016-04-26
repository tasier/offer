package bit;
import java.util.Scanner;

public class NumberOf1{
	//一个int型的整数有32位，需要循环32次
	public static int methodOne(int n){
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if((n&flag) != 0){
				count++;
			}
			//左移运算，低位补0
			flag = flag<<1;
		}
		return count;
	}
	
	public static int methodTwo(int n){
		int  count = 0;
		while(n != 0){
			count++;
			//一个数减去1之后，再和原来的数进行位与元算，可以消去最右边的1
			n = (n-1)&n;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0; i<n; i++){
			System.out.println(methodTwo(in.nextInt()));
		}
	}
}