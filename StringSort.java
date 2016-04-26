package permutation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Collections;

/*
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *  结果请按字母顺序输出。
 *  
 *  输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
输入描述:
 * */

public class StringSort {
      
    private HashSet<String> set = new HashSet<String>();
    
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0){
            return new ArrayList<String>();
        }
        
    	char[] charStr = str.toCharArray();
        permutationCore(charStr,0);
    	ArrayList<String> res = new ArrayList<String>(set);
        Collections.sort(res);
        
        return res;
    }
    
    private void swap(char[] str ,int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
    
    private void permutationCore(char[] str, int start){
        if(start == str.length-1){
            set.add(new String(str));
        }else{
            for(int i=start; i<str.length; i++){
            		swap(str,start,i);
                	permutationCore(str,start+1);
                	swap(str,start,i);
                
            }
        }
    }
    public static void main(String[] args) {
		//ArrayList<String> res = new Solution().Permutation("abc");
		ArrayList<String> res = new StringSort().Permutation("aaa");
		System.out.println(res);
	}
}