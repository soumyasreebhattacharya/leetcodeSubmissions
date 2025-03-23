class Solution {
    public int findPairs(int[] nums, int k) {

        //take two pointers i and j side by side elements of array from start.
        // when the diff is bigger than k, shift i by 1. Id diff is small shift j by 1.
        //handle duplicate elements in the nested while loop , if j is duplicate, increment j until duplicate element is not there.

        
        Arrays.sort(nums);  
        int i = 0;
        int j = 1;
        int n = nums.length;
        int count = 0;
        while(i<n && j< n){
            //when i and j both becomes equal , increment j by 1
            if(i==j && j<n-1){  
                j++;
            }
            //when i and j both equal and they reach the end of array, then break from loop
            if(i==j && j == n-1){ 
                break;
            }
            int diff = nums[j] - nums[i];
            if(diff == k){
                count++;
                i++;
                j++;
                while(j<n){
                	if(nums[j]==nums[j-1])
                  j++;
                  else
                  break;
                }
            }
            else if(diff>k){
                i++;
            }
            else{
                j++;
            }
           
        }

        return count;
    }
}