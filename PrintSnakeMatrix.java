package array;
import java.util.Scanner;

/*1 2 3 4 
12 13 14 5 
11 16 15 6 
10 9 8 7*/

public class PrintSnakeMatrix {

	public static void printMatrix(int n){
		int num = 1;
		int count = n*n;
		int[][] matrix = new int[n][n];
		int r = 0, c = 0;
		int right=n , down=n, left=-1, up=0;
		
		while(num<=count){
			for(int i=c; i<right; i++){
				matrix[r][i] = num;
				num++;
			}
			c = right-1;
			right--;
			for(int i=r+1; i<down; i++){
				matrix[i][c] = num;
				num++;
			}
			r = down - 1; 
			down--;
			for(int i=c-1; i>left; i--){
				matrix[r][i] = num;
				num++;
			}
			c = left+1;
			left++;
			
			for(int i=r-1; i>up; i--){
				matrix[i][c] = num;
				num++;
			}
			r = up+1;
			c++;
			up++;
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			if(n==0){
				System.out.println("请输入大于0的数");
			}else{
				printMatrix(n);
			}
		}
		
	}
}
