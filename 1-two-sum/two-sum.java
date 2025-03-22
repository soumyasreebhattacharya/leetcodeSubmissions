class Solution {
    public int[] twoSum(int[] nums, int target) {
    //     HashMap<Integer,Integer> visitedNumbers = new HashMap<>();
         
    //     for(int i=0; i<nums.length; i++){
    //         int delta = target - nums[i];
    //         if(visitedNumbers.containsKey(delta))
    //         {
    //             return new int[]{i,visitedNumbers.get(delta)};
    //         }
    //         visitedNumbers.put(nums[i],i);
    //     }
    //    return new int[] {-1,-1};

    //2 pointers approach

    int[][] numsWithIndex = new int[nums.length][];
    
    int n = nums.length;

    for(int i =0 ; i<n; i++){
        numsWithIndex[i] = new int[] {nums[i], i};
    }

    Arrays.sort(numsWithIndex, (a,b) -> Integer.compare(a[0],b[0]));

    int left =0;
    int right = n-1;
    while(left<right){

        int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
        if(sum == target){
            return new int[]{numsWithIndex[left][1],numsWithIndex[right][1]};
        }
        else if(sum > target){
            right--;
        }
        else{
            left++;
        }

        
    }
      return new int[2];
    }
}