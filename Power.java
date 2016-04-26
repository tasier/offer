package others;
public class Power {

    public double power(double base, int exponent) {
        if(equals(base, 0.0)){
            if(exponent<=0){
                return 1.0;
            }else{
            	return 0.0;
            }
        }
        boolean tag = false;
        int e;
        if(exponent < 0){
        	e = -exponent;
        	tag = true;
        }else{
        	e = exponent;
        }
        double res;
        res = powerWithUnsignedExponent(base, e);
        
        if(tag){
        	res = 1.0/res;
        }
        return res;
    }
	//判断两个小数是否相等
	private boolean equals(double num1, double num2){
		if(num1-num2<0.0000001&&num1-num2>-0.0000001){
			return true;
		}
		return false;
	}
	//重复平方技术
	//要求exponent>=0
	private double powerWithUnsignedExponent(double base, int exponent){
		if(exponent == 0){
			return 1.0;
		}
		if(exponent == 1){
			return base;
		}
		double res = powerWithUnsignedExponent(base, exponent>>1);
		res *= res;
		if((exponent&0x1)==1){
			res *= base;
		}
		return res;
	} 
	
}