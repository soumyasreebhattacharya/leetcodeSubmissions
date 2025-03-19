class NumArray {

    private int sum[];
   
    public NumArray(int[] nums) {  
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i]; 
        }
        this.sum = nums;
    }
    
    public int sumRange(int left, int right) {
       int result;
       if(left == 0){
            result = sum[right];
       }
       else{
         result = sum[right] - sum[left -1];
       }
       return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */