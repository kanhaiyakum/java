class Solution {
    public boolean helper(int[][] recs,int axis){
        Arrays.sort(recs,(a,b)->a[axis]-b[axis]);
        int preve = recs[0][axis+2];
        int n = recs.length;
        int cnt = 0;
        for(int i = 1;i<n;i++){
            int s = recs[i][axis];
            int e = recs[i][axis+2];
            if(s< preve && e>preve){
                preve = e;
            }
            else if(s>=preve){
                cnt++;
                if(cnt>=2) return true;
                preve = e;
            }
        }
        return false;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return helper(rectangles,0) || helper(rectangles,1);
    }
}