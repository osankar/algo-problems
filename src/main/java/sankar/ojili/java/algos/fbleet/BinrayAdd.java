package sankar.ojili.java.algos.fbleet;

public class BinrayAdd {

}
class BinrayAddSol {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        int maxLength = m >n ? m: n;
        int[] res = new int[maxLength+1];
        int i = a.length()-1, j = b.length()-1;
        while(maxLength-1 >=0) { //O(n)
            int aBit = 0, bBit = 0;
            if(i >= 0) {
                aBit = a.charAt(i) - '0';
            }
            if(j >= 0) {
            bBit = b.charAt(j) - '0';
            }
            int sum = res[maxLength]+aBit+bBit;
            res[maxLength] = sum%2;
            res[maxLength-1] = res[maxLength-1]+sum/2;
            i--; j--;maxLength--;
        }
        StringBuilder sb = new StringBuilder();
        for(i =0; i<res.length; i++ ) { //O(n)
            if(sb.length() == 0 && res[i]==0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0": sb.toString();
    }
}