package array;
import java.math.BigInteger;
import java.util.Scanner;

//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
//请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

public class CoverRectangle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			if(n == 1){
				System.out.println(1);
			}else if(n == 2){
				System.out.println(2);
			}else{
				BigInteger  res = new BigInteger("0");
				BigInteger first = new BigInteger("1");
				BigInteger second = new BigInteger("2");
				for(int i=0; i<n-2; i++){
					res = first.add(second);
					first = second;
					second = new BigInteger(res.toString());
				}
				System.out.println(res.toString());
			}
			
		}
	}
}
