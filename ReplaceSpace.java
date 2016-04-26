package string;
import java.util.Arrays;
import java.util.Scanner;

//替换空格
//We Are Happy
//We%20Are%20Happy

public class ReplaceSpace {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			String str = in.nextLine();
			
			char[] chars = str.toCharArray();
			int sum = 0;
			for(char ch : chars){
				if(ch==' '){
					sum++;
				}
			}
			char[] replace = new char[chars.length+sum*2];
			
			int j = replace.length-1;
			for(int i=chars.length-1; i>=0; i--){
				if(chars[i] != ' '){
					replace[j] = chars[i];
					j--;
				}else{
					replace[j--] = '0';
					replace[j--] = '2';
					replace[j--] = '%';
				}
			}
			System.out.println(new String(replace));
		}
	}
}
