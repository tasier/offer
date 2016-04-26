package array;
import java.util.ArrayList;
public class PrintMatrixClockwise {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
    	if(matrix==null){
    		return null;
    	}
    	if(matrix.length <= 0){
    		return null;
    	}
    	if(matrix[0].length <= 0){
    		return null;
    	}
    	
       	ArrayList<Integer> res = new ArrayList<Integer>();
        
       	int num = 1;
        int count = matrix[0].length*matrix.length;
       	int r = 0, c = 0;
		int right=matrix[0].length, down=matrix.length, left=-1, up=0;
		
		while(num<=count){
            if(c == right){
                break;
            }
			for(int i=c; i<right; i++){
				res.add(matrix[r][i]);
				num++;
			}
			c = right-1;
			right--;
			if(r+1 == down){
				break;
			}
			for(int i=r+1; i<down; i++){
				res.add(matrix[i][c]);
				num++;
			}
			r = down - 1; 
			down--;
            if(c-1 == left){
                break;
            }
			for(int i=c-1; i>left; i--){
				res.add(matrix[r][i]);
				num++;
			}
			c = left+1;
			left++;
			if(r-1 == up){
                break;
            }
			for(int i=r-1; i>up; i--){
				res.add(matrix[i][c]);
				num++;
			}
			r = up+1;
			c++;
			up++;
		}
		return res;
    }
    
    public static void main(String[] args) {
		ArrayList<Integer> res = new PrintMatrixClockwise().printMatrix(
				new int[][]{{1},{2},{3},{4},{5}									
									});
		System.out.println(res);
	}
}