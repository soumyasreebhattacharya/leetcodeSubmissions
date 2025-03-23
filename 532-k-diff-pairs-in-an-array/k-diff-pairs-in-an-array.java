class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);  
        int i = 0;
        int j = 1;
        int n = nums.length;
        int count = 0;
        while(i<n && j< n){
            if(i==j && j<n-1){
                j++;
            }
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