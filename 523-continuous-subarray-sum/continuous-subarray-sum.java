

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> h=new HashMap<>();
        h.put(0,-1);
        int prefixSum=0,remainder=0;
        for(int i=0;i<nums.length;i++)
        {
            prefixSum+=nums[i];
            remainder=prefixSum%k;
            if(h.containsKey(remainder))
            {
                int index=h.get(remainder);
                if(i-index>1)
                    return true;
            }
            else
                h.put(remainder,i);
        }
        return false;
    }
}