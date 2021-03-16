package sankar.ojili.java.algos.fbleet;

public class MultiplyString {
 public static void main(String[] args) {
	
}
}

class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] resArray = new int[m+n];
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                int product = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum = resArray[i+j+1]+product;
                resArray[i+j+1] = sum%10;
                resArray[i+j] =  resArray[i+j]+sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< resArray.length; i++) {
            if(sb.length()==0 && resArray[i] == 0) {
                continue;
            }
            sb.append(resArray[i]);
        }
        return sb.length()==0 ? "0" : sb.toString();
    }
}
