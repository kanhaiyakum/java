class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] k = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            k[i] = queries[i];
        }
        Arrays.sort(k);
        Queue<node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        int i = 0;
        int s = 0;
        int[] ans = new int[k.length];
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        pq.add(new node(grid[0][0],0,0));
        vis[0][0] = true;
        while(!pq.isEmpty()&&i<k.length){
            if(k[i]>pq.peek().val){
                node temp = pq.poll();
                s++;
                if(temp.i>0&&!vis[temp.i-1][temp.j]){
                    vis[temp.i-1][temp.j] = true;
                    pq.add(new node(grid[temp.i-1][temp.j],temp.i-1,temp.j));
                }
                if(temp.i<grid.length-1&&!vis[temp.i+1][temp.j]){
                    pq.add(new node(grid[temp.i+1][temp.j],temp.i+1,temp.j));
                    vis[temp.i+1][temp.j] = true;
                }if(temp.j>0&&!vis[temp.i][temp.j-1]){
                    vis[temp.i][temp.j-1] = true;
                    pq.add(new node(grid[temp.i][temp.j-1],temp.i,temp.j-1));
                }if(temp.j<grid[0].length-1&&!vis[temp.i][temp.j+1]){
                    pq.add(new node(grid[temp.i][temp.j+1],temp.i,temp.j+1));
                    vis[temp.i][temp.j+1] = true;
                }
            }else{
                ans[i] = s;
                i++;
            }
        }
        for(;i<k.length;i++){
            ans[i] = s;
        }
        int[] ret = new int[k.length];
        for(i = 0;i<queries.length;i++){
            int index = Arrays.binarySearch(k,queries[i]);
            ret[i] = ans[index];
        }
        return ret;
    }
}
class node{
    int val;
    int i;
    int j;
    node(int val, int i, int j){
        this.val = val;
        this.i = i;
        this.j = j;
    }
}