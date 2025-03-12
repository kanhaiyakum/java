class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;

        if (nums[0] > 0) return n;
        if (nums[n - 1] < 0) return n;

        int cp = 0, cn = 0; 
        
        int fp = first(nums);
        if (fp != -1) cp = n - fp; 

        int ln = last(nums);
        if (ln != -1) cn = ln + 1;

        return Math.max(cp, cn);
    }

    private int first(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = -1; 
        while (l <= r) {
            int mid = l + (r - l) / 2; 
            if (nums[mid] > 0) { 
                ans = mid;
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }
        return ans;
    }

    private int last(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < 0) { 
                ans = mid;
                l = mid + 1; 
            } else {
                r = mid - 1; 
            }
        }
        return ans;
    }
}