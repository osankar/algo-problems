package sankar.ojili.java.algos.fbleet;

public class IntToString {
	public static void main(String[] args) {
		IntToStringSol sol = new  IntToStringSol();
		System.out.println(sol.numberToWords(5680068));
	}
}

class IntToStringSol {
    private final int MILLION = 1000000;
    private final int BILLION = 1000000000;
    private final int THOUSAND = 1000;
    private final int HUNDRED = 100;
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
       if(num >= BILLION) {
           int billions = num/BILLION;
           sb.append(" ").append(threeDigits(billions).trim()).append(" Billion");
           num = num - billions*BILLION;
       }
        
        if(num >= MILLION) {
           int millions = num/MILLION;
           sb.append(" ").append(threeDigits(millions).trim()).append(" Million");
           num = num - millions*MILLION;
       }
        
        if(num >= THOUSAND) {
           int thousands = num/THOUSAND;
           sb.append(" ").append(threeDigits(thousands).trim()).append(" Thousand");
           num = num - thousands*THOUSAND;
       }
        
        sb.append(" ").append(threeDigits(num));
        return sb.toString().trim();
    }
    
    private String threeDigits(int num) {
        StringBuilder sb = new StringBuilder();
        if(num >= HUNDRED) {
            int hundreds = num/HUNDRED;
            sb.append(" ").append(ones(hundreds).trim()).append(" Hundred");
            num = num-hundreds*HUNDRED;
        }
        sb.append(" ").append(twoDigits(num));
        return sb.toString();
    }
    
    private String twoDigits(int num) {
        if(num == 0){
            return "";
        }
        if(num >= 20) {
            String tens  = tens(num);
            return (num%10)> 0? tens+" "+ones(num%10) : tens;
        } 
        return num<10?  ones(num) : lessThan20(num);
    }
    
    private String tens(int num) {
        int ten = num/10;
       switch(ten) {
           case  2: return "Twenty ";
           case  3: return "Thirty ";
           case  4: return "Forty ";
           case  5: return "Fifty ";
           case  6: return "Sixty ";
           case  7: return "Seventy ";
           case  8: return "Eighty ";
           case 9: return "Ninety ";
       }
        return "";
    }
    
     private String lessThan20(int num) {
       switch(num) {
           case  10: return "Ten";
           case  11: return "Eleven";
           case  12: return "Twelve";
           case  13: return "Thirteen";
           case  14: return "Fourteen";
           case  15: return "Fifteen";
           case  16: return "Sixteen";
           case 17: return "Seventeen";
           case 18: return "Eighteen";
           case 19: return "Nineteen";
               
       }
        return "";
    }
    
    private String ones(int num) {
        switch(num) {
            case  1: return "One";
           case  2: return "Two";
           case  3: return "Three";
           case  4: return "Four";
           case  5: return "Five";
           case  6: return "Six";
           case  7: return "Seven";
           case  8: return "Eight";
           case 9: return "Nine";
       }
    return "";
    }
}