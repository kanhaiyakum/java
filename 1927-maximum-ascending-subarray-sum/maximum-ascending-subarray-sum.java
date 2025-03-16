class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans=0;
        int len=nums.length;
        if(len==1)
        {
            return nums[0];
        }
        for(int l=0;l<len-1;l++)
        {
            int ps=nums[l];
            for(int r=l+1;r<len;r++)
            {
                if(nums[r-1]>=nums[r])
                {
                    break;
                }
                ps+=nums[r];
            }
            ans=Math.max(ps,ans);
        }
        return ans;
    }
}