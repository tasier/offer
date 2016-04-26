package array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//把数组拼接成最小的数
public class MinConcatenatedNumber {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int m = in.nextInt();
			
			Integer[] intArr = new Integer[m];
			for(int i=0; i<m; i++){
				intArr[i] = in.nextInt();
			}
			
			Arrays.sort(intArr, new Comparator<Integer>() {

				@Override
				public int compare(Integer i1, Integer i2) {
					String str1 = new StringBuilder().append(i1).append(i2).toString();
					String str2 = new StringBuilder().append(i2).append(i1).toString();
					
					if(str1.compareTo(str2)==0){
						return 0;
					}else if(str1.compareTo(str2)>0){
						return 1;
					}else{
						return -1;
					}
				}
			});
			
			for(int i : intArr){
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
