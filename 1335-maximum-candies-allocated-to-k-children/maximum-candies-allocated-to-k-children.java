class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxPileSize = 0;
        for(int candy:candies){
            maxPileSize = Math.max(candy, maxPileSize);
        }
        int l=1,r=maxPileSize,mid,ans=0;
        while(l<=r){
            mid = (l+r)/2;
            if(isPossibleToDistribute(candies, k, mid)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
    public boolean isPossibleToDistribute(int[] candies, long k, int distributeCandies){
        int numberOfChildren;
        for(int candiesInPile:candies){
            numberOfChildren = candiesInPile/distributeCandies;
            k -= numberOfChildren;
            if(k<=0){
                return true;
            }
        }
        return false;
    }
}