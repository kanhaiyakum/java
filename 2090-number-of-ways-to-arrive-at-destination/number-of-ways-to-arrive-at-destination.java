class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads){
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        final int MOD = 1_000_000_007;
        long[] distance = new long[n];
        long[] count = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        count[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()){
            long[] curr = pq.poll();
            long curr_dist = curr[0];
            int u = (int) curr[1];
            if (curr_dist > distance[u]){
                continue;
            }
            for (int[] nei : graph.get(u)){
                int v = nei[0], time = nei[1];
                long new_path = curr_dist + time;
                if (new_path < distance[v]){
                    distance[v] = new_path;
                    count[v] = count[u];
                    pq.add(new long[]{new_path, v});
                }
                else if (new_path == distance[v]){
                    count[v] = (count[v] + count[u]) % MOD;
                }
            }
        }
        return (int) count[n - 1];
    }
}