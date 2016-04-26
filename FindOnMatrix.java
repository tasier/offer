package array;
import java.util.Scanner;

//二维数组中的查找

public class FindOnMatrix {
	private int row; //行数
	private int col;//列数
	private int number; //查找的数
	private int[] matrix; //二维数组
	
	public FindOnMatrix(int m, int n, int t, final int[] matrix){
		row = m;
		col = n;
		number = t;
		this.matrix = matrix; 
	}
	
	public boolean isFound(){
		boolean res = false;
		
		if(row<0||col<0||number<1||matrix==null){
			return res;
		}
		
		int r = 0;
		int c = col-1;
		
		
		while(r<row&&r>=0&&c>=0){
			int index = binarySearch(matrix, r*col, r*col+c, number);
			
			if(index > r*col+c){
				index = r*col+c;
			}
			if(index < r*col){
				index = r*col;
			}
			//System.out.println(index);
			c = index - r*col;
			
			if(matrix[index] == number){
				res = true;
				break;
			}else if(matrix[index] > number){
				c--;
			}else{
				r++;
			}
		}
		
		return res;
	}
	
	//返回下标
	private int binarySearch(int[] array, int low, int high,int number){
		
		int res = -1;
		int middle = low+(high-low)/2;
		
		while(low<=high){
			if(array[middle] == number){
				res = middle;
				break;
			}else if(array[middle] > number){
				high = middle-1;
			}else{
				low = middle+1;
			}
			middle = low+(high-low)/2;
		}
		
		if(low>high){
			res = low;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int m = in.nextInt();
			int n = in.nextInt();
			int t = in.nextInt();
			
			int[] matrix = new int[m*n];
			for(int i=0; i<m; i++){
				for(int j = 0; j<n; j++){
					matrix[i*n+j] = in.nextInt();
				}
			}
			
			FindOnMatrix test = new FindOnMatrix(m, n, t, matrix);
			boolean res = test.isFound();
			if(res){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
}
