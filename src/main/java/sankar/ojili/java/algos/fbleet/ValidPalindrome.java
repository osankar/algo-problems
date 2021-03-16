package sankar.ojili.java.algos.fbleet;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
	public static void main(String[] args) {
		ValidPalindromeSol2 sol = new ValidPalindromeSol2();
		System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
	}
	
}

class ValidPalindromeSol {
    public boolean isPalindrome(String s) {
        List<Character> chars = new ArrayList<>();
        for(int i =0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                chars.add(c);
            }
            if (Character.isLetter(c)) {
                 chars.add(Character.toLowerCase(c));
             }
        }
        
        int start=0, end = chars.size()-1;
        while(start < end) {
            if(chars.get(start++) != chars.get(end--)) {
                return false;
            }
        }
        return true;
    }
}

class ValidPalindromeSol2 {
	public boolean isPalindrome(String s) {
        int start=0, end=s.length()-1;
        
        while(start <= end) {
            Character front = null, rare = null;
            boolean isValidChar = false;
            while(!isValidChar && start <= end) {
                char c = s.charAt(start);
                if(!Character.isLetterOrDigit(c)) {
                    start++;
                    continue;
                }
                isValidChar=true; 
                front = Character.toLowerCase(s.charAt(start++));
            }
           
            isValidChar = false;
            while(!isValidChar && start <= end) {
                char c = s.charAt(end);
                if(!Character.isLetterOrDigit(c)) {
                    end--;
                    continue;
                }
                isValidChar=true; 
                rare = Character.toLowerCase(s.charAt(end--));
            }
            
            if(rare != null && front!= null && rare != front) {
                return false;
            }
        }
        return true;
    }

}