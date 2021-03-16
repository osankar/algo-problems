package sankar.ojili.java.algos.fbleet;

import java.net.Inet6Address;

public class ValidateIP {
	public static void main(String[] args) {
		ValidateIPSol sol = new ValidateIPSol();
		sol.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
	}
	
}

class ValidateIPSol {
    public String validIPAddress(String IP) {
        if(isIPv4(IP)) {
            return "IPv4";
        }
         if(isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }
    
    boolean isIPv4(String IP) {
        String[] components = IP.split("//.");
        if(IP.startsWith(".")||IP.endsWith("//.") ||components.length != 4) {
            return false;
        }
        for(String component : components) {
            if(component.startsWith("0")){
                return false;
            }
            try {
                int value = Integer.valueOf(component);
                if(value < 1 || value > 255) {
                    return false;
                }
                
            } catch(NumberFormatException e) {
                return false;
            }
        }
        
        return true;
    }
    
     boolean isIPv6(String IP) {
        String[] components = IP.split(":");
        if(IP.startsWith(":")|| IP.endsWith(":") ||components.length != 8) {
            return false;
        }
        for(String component : components) {
           if(component.length() < 1 || component.length() > 4) {
               return false;
           }
           for(int i=0; i< component.length(); i++) {
               if(!Character.isLetterOrDigit(component.charAt(i))) {
                   return false;
               }
           }
        }
        
        return true;
    }
}