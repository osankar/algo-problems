package sankar.ojili.java.algos.fbleet;

public class AtoI {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.myAtoi("-2147483647"));
	}
}

class Solution {
    public int myAtoi(String s) {
        if(s== null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        boolean  isNegative = false;
        int MAX = Integer.MAX_VALUE/10;
        int lastDigitMax = Integer.MAX_VALUE %10;
        while(i<s.length() && s.charAt(i) == ' '){
            i++;
        }
        if(i<s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if(s.charAt(i) == '-') {
                isNegative= true;
                MAX = Integer.MIN_VALUE/-10;
                lastDigitMax = -1 * (Integer.MIN_VALUE%10);
            }
            i++;
        }
        
        int result = 0;
        for(; i< s.length(); i++) {
            char c = s.charAt(i);
            if(c-'0' >=0 && c-'0'<=9) {
                if(result > MAX  || (result == MAX && (c-'0') >lastDigitMax)) {
                    return isNegative? Integer.MIN_VALUE: Integer.MAX_VALUE;
                }        
                result = result*10+c-'0';
            } else {
               break;
            }
        }
         return isNegative ? result*-1 : result;
    }
}
