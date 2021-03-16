package sankar.ojili.java.algos.fbleet;

public class NextPermutation {
	public static void main(String[] args) {
		NPSolution sol = new NPSolution();
		var nums = new int[] {1,3,2,4, 6, 5};
		sol.nextPermutation(nums);
		/*1,3,2,5,6,4
		1,3,2,5,4,6*/
		for(int num : nums) {
			System.out.print(num);
		}
	}
}

class NPSolution {
    public void nextPermutation(int[] nums) {
        
        //find replaceable index
        int replaceableIndex = -1;
        int i = nums.length-1;
        while(i>0) {
            if(nums[i] > nums[i-1]) {
                replaceableIndex = i-1;
                break;
            }
            i--;
        }
        //if replaceable index >=0; find the replacement and swap
        if(replaceableIndex >= 0) {
            i = nums.length-1;
            while(i>replaceableIndex) {
                if(nums[i] > nums[replaceableIndex]){
                    int temp = nums[i];
                    nums[i] = nums[replaceableIndex];
                    nums[replaceableIndex] = temp;
                   break;     
                }      
                i--;
            }
        }
        
         i = nums.length-1;
         //reverse between the replaceable index and the end;  
          while(i>replaceableIndex) {
              int temp = nums[i];
              nums[i] = nums[++replaceableIndex];
              nums[replaceableIndex] = temp;
              i--; 
          }        
        
    }
}