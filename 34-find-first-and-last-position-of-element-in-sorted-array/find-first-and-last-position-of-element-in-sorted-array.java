class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        if(n==0)
        {
            return new int[]{-1,-1};
        }
        int start = 0;
        int end = n -1;
        int mid = 0;

       while(start<=end){

            mid = start + (end - start)/2;

            if(nums[mid] == target){
                break;
            }
            else if( target > nums[mid]){
                start = mid + 1;
            }

            else if(target < nums[mid]){
                end = mid - 1;
            }

       }

       if(nums[mid] != target){
        return new int[]{-1,-1};
       }

       int left = mid;
       int right = mid;

       while(left>=0 && nums[left] == target){
        left--;
       }

       while(right<=n-1 && nums[right] ==target){
        right++;
       }

       return new int[]{left+1, right-1};
       
    }
}