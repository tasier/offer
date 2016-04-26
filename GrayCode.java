package bit;

import java.util.*;

//递归地生成格雷码
public class GrayCode {
  public String[] getGray(int n) {
      if(n==1){
          return new String[]{"0","1"};
      }else{
          String[] strs = getGray(n-1);
          String[] res = new String[strs.length*2];
          for(int i=0; i<strs.length; i++){
              res[i] = "0"+strs[i];
          }
          for(int i=0; i<strs.length; i++){
              res[strs.length+i] = "1"+strs[strs.length-1-i];
          }
          return res;
      }
  }
 
  public static void main(String[] args) {
      GrayCode g = new GrayCode();
      System.out.println(Arrays.toString(g.getGray(3)));
  }
}